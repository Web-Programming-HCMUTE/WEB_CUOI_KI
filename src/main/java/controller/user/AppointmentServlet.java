package controller.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dao.Impl.AppointmentDAO;
import dao.Impl.HotelDAO;
import dao.Impl.UserDAO;
import model.Appointment;
import model.Hotel;
import model.HotelDetail;
import model.User;
import model.UserLogin;
import util.SendEmail;

/**
 * Servlet implementation class AppointmentServlet
 */
@WebServlet("/AppointmentServlet")
public class AppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO = new UserDAO();
	private AppointmentDAO appointmentDAO = new AppointmentDAO();
	private HotelDAO hotelDAO = new HotelDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppointmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet_Find(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Appointment appointment = appointmentDAO.get(Appointment.class,id);
		appointment.setHotel(null);
		appointment.setUserDatLich(null);
		
		Gson gson = new Gson();
		
		PrintWriter writer = response.getWriter();
		writer.print(gson.toJson(appointment));
		
		writer.flush();
		writer.close();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
		if(null != action && action.equalsIgnoreCase("find")) {
			doGet_Find(request, response);
		} 
		
		HttpSession session = request.getSession(true);
		UserLogin userLogin = (UserLogin) session.getAttribute("user");
		if(userLogin == null)
			return;
		if(userLogin.getRole().equals("USER"))
			request.setAttribute("appointments", appointmentDAO.getByUser(userLogin.getUsername()));
		else
			request.setAttribute("appointments", appointmentDAO.getAll(Appointment.class));
		request.setAttribute("jspName", "appointmentAdmin.jsp");
		request.getRequestDispatcher("/admin/template.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String actionString = request.getParameter("action");
		if (actionString.equalsIgnoreCase("create"))
			try {
				doPost_Create(request, response);
			} catch (ServletException | IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else if (actionString.equalsIgnoreCase("delete")) {
			try {
				doPost_Delete(request, response);
			} catch (ServletException | IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (actionString.equalsIgnoreCase("update")) {
			try {
				doPost_Update(request, response);
			} catch (ServletException | IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		doGet(request, response);
	}
	
	protected void doPost_Create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		String id = request.getParameter("id");
		if(id == null) {
			return;
		}
		String date = request.getParameter("date");
		String purpose = (String) request.getParameter("purpose");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date submitDate = sdf.parse(date);
		Appointment appointment = new Appointment();
		appointment.setAppointmentDate(submitDate);
		appointment.setPurpose(purpose);
		appointment.setStatus("CREATE");
		
		
		HttpSession session = request.getSession(true);
		UserLogin userLogin = (UserLogin) session.getAttribute("user");
		if(userLogin == null)
			return;
		User user = userDAO.getByName(userLogin.getUsername());
		if(user == null)
			return;

		appointment.setUserDatLich(user);
		Hotel hotel = hotelDAO.get(Integer.parseInt(id));
		appointment.setHotel(hotel);
		
		appointmentDAO.save(appointment);
		
		return;
	
	}
	
	protected void doPost_Delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		String id = request.getParameter("id");
		if(id == null) {
			return;
		}
		Appointment appointment = appointmentDAO.get(Appointment.class,Integer.parseInt(id));
		appointmentDAO.delete(appointment);
		
		return;
	
	}
	
	
	protected void doPost_Update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String date = request.getParameter("date");
		String purpose = (String) request.getParameter("purpose");
		String content = (String) request.getParameter("content");
		Appointment appointment = appointmentDAO.get(Appointment.class, id);
		appointment.setPurpose(purpose);

		appointmentDAO.saveOrUpdate(appointment);
		
	}
	

}
