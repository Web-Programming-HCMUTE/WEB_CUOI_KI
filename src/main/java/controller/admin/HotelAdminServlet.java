package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.IBookDetailDAO;
import dao.JpaEntityManager;
import dao.Impl.BookDetailDAO;
import dao.Impl.HotelDAO;
import dao.Impl.HotelDetailDAO;
import model.HotelDetail;
import util.SendEmail;
import model.Hotel;

/**
 * Servlet implementation class PostServlet
 */
@WebServlet("/HotelAdminServlet")
public class HotelAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BookDetailDAO bookDetailDAO = new BookDetailDAO();
	private HotelDAO postDAO = new HotelDAO();
	private HotelDetailDAO hotelDetailDAO = new HotelDetailDAO();
	private JpaEntityManager jpaEntityManager = new JpaEntityManager();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HotelAdminServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet_Find(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Hotel hotel = postDAO.get(id);
		hotel.setComment(null);
		
		Gson gson = new Gson();
		
		PrintWriter writer = response.getWriter();
		writer.print(gson.toJson(hotel));
		
		writer.flush();
		writer.close();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
		if(null != action && action.equalsIgnoreCase("find")) {
			doGet_Find(request, response);
		}
		
		request.setAttribute("hotels", postDAO.getAll(Hotel.class));
		request.setAttribute("jspName", "hotelAdmin.jsp");
		request.getRequestDispatcher("/admin/template.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		
		String actionString = request.getParameter("action");
		if (actionString.equalsIgnoreCase("create"))
			doPost_Create(request, response);
		else if(actionString.equalsIgnoreCase("delete"))
			doPost_Delete(request, response);
		else if (actionString.equalsIgnoreCase("update")) {
			doPost_Update(request, response);
		}

		doGet(request, response);
	}
	
	protected void doPost_Delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Hotel hotel = postDAO.get(Hotel.class, id);
		HotelDetail hotelDetail = hotelDetailDAO.get(HotelDetail.class, (hotel.getHotelDetail().getId())); 
		postDAO.delete(hotel);
		hotelDetailDAO.delete(hotelDetail);

	}
	
	protected void doPost_Create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String content = (String) request.getParameter("content");
		String image = (String) request.getParameter("image");
		String area = (String) request.getParameter("area");
		String numberRoom = (String) request.getParameter("numberRoom");
		String address = (String) request.getParameter("address");
		String price = (String) request.getParameter("price");
		String desc = (String) request.getParameter("desc");

		Hotel post = new Hotel();
		post.setContent(content);
		post.setCreateDate(new Date());
		post.setImage(image);

		HotelDetail hotelDetail = new HotelDetail();
		hotelDetail.setArea(Integer.parseInt(area));
		hotelDetail.setNumberRoom(Integer.parseInt(numberRoom));
		hotelDetail.setAddress(address);
		hotelDetail.setPrice(BigDecimal.valueOf(Double.parseDouble(price)));
		hotelDetail.setDesc(desc);

		postDAO.savePostAndHotel(post, hotelDetail);
		
		SendEmail sm = new SendEmail();
		 
		boolean test = sm.sendEmail(null);
		 
	}
	
	protected void doPost_Update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Hotel hotel = postDAO.get(id);
		hotel.setContent(request.getParameter("content"));
		hotel.setImage(request.getParameter("image"));
		
		HotelDetail hotelDetail = hotelDetailDAO.get(HotelDetail.class, hotel.getHotelDetail().getId());
		hotelDetail.setArea(Integer.parseInt(request.getParameter("area")));
		hotelDetail.setNumberRoom(Integer.parseInt(request.getParameter("numberRoom")));
		hotelDetail.setAddress(request.getParameter("address"));
		hotelDetail.setPrice(BigDecimal.valueOf(Double.parseDouble(request.getParameter("price"))));
		hotelDetail.setDesc(request.getParameter("desc"));

		postDAO.saveOrUpdate(hotel);
		hotelDetailDAO.saveOrUpdate(hotelDetail);
	}

}
