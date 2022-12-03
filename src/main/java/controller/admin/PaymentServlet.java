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

import dao.Impl.HotelDAO;
import dao.Impl.PaymentDAO;
import model.Hotel;
import model.HotelDetail;
import model.Payment;

/**
 * Servlet implementation class PaymentServlet
 */
@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PaymentDAO paymentDAO = new PaymentDAO();
	private HotelDAO hotelDAO = new HotelDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PaymentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet_Find(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("id"));

		Payment payment = paymentDAO.getPaymentById(id);
		if (payment != null) {

			Gson gson = new Gson();

			PrintWriter writer = response.getWriter();
			writer.print(gson.toJson(payment));

			writer.flush();
			writer.close();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = request.getParameter("action");
		if (null != action && action.equalsIgnoreCase("find")) {
			doGet_Find(request, response);
		}

		request.setAttribute("hotels", hotelDAO.getAll(Hotel.class));
		request.setAttribute("payments", paymentDAO.getAllPayment());
		request.setAttribute("jspName", "paymentAdmin.jsp");
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
		else if (actionString.equalsIgnoreCase("delete"))
			doPost_Delete(request, response);
		else if (actionString.equalsIgnoreCase("update")) {
			//doPost_Update(request, response);
		}
		doGet(request, response);
	}

	protected void doPost_Create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paymentPrice = (String) request.getParameter("paymentPrice");
		String paymentOption = (String) request.getParameter("paymentOption");
		String hotelId = (String) request.getParameter("hotel");
		String description = (String) request.getParameter("description");
		String user = (String) request.getParameter("userPayment");

		Hotel hotel = hotelDAO.get(Integer.parseInt(hotelId));

		Payment payment = new Payment();
		payment.setPaymentDate(new Date());
		payment.setPaymentOption(paymentOption);
		payment.setPaymentPrice(BigDecimal.valueOf(Double.parseDouble(paymentPrice)));
		payment.setDescription(description);

		payment.setHotel(hotel);
		payment.setUserPayment(user);// tạm thời
		
		hotel.setActivate(true);
		hotelDAO.saveOrUpdate(hotel);

		paymentDAO.save(payment);
	}

	protected void doPost_Delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		Payment payment = paymentDAO.getPaymentById(id);
		if (payment != null) {
			paymentDAO.delete(payment);
		}

	}

}
