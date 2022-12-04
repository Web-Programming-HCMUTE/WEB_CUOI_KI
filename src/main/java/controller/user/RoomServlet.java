package controller.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Impl.CommentDAO;
import dao.Impl.HotelDAO;
import dao.Impl.UserDAO;
import model.Comment;
import model.Hotel;
import model.User;
import model.UserLogin;

/**
 * Servlet implementation class RoomServlet
 */
@WebServlet("/RoomServlet")
public class RoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HotelDAO hotelDAO = new HotelDAO();
	private CommentDAO commentDAO = new CommentDAO();
	private UserDAO userDAO = new UserDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RoomServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String id = request.getParameter("id");
		String actionString = request.getParameter("action");

		if (actionString != null && actionString.equalsIgnoreCase("delete-comment")) {
			doPost_Delete_Comment(request, response);
			Hotel hotel =  hotelDAO.get(Integer.parseInt(id));
			hotel.getHotelDetail();
			hotel.getComment();
			request.setAttribute("hotel",hotel);
			request.getRequestDispatcher("./single-room.jsp").forward(request, response);
			return;
		}
		if (id != null) {
			Hotel hotel =  hotelDAO.get(Integer.parseInt(id));
			hotel.getHotelDetail();
			hotel.getComment();
			request.setAttribute("hotel",hotel);
			request.getRequestDispatcher("./single-room.jsp").forward(request, response);
			return;
		}

		request.setAttribute("hotels", hotelDAO.getAllHotelActive());
		request.getRequestDispatcher("./rooms.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
		String actionString = request.getParameter("action");
		if (actionString.equalsIgnoreCase("create-comment"))
			doPost_Create_Comment(request, response);

		doGet(request, response);
	}

	protected void doPost_Create_Comment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		HttpSession session = request.getSession(true);
		UserLogin userLogin = (UserLogin) session.getAttribute("user");
		if (id != null) {
			String content = request.getParameter("content");
			Comment comment = new Comment();
			comment.setContent(content);
			comment.setCommentDate(new Date());
			if(userLogin != null) {
				User user = userDAO.getByName(userLogin.getUsername());
				comment.setUser(user); // tạm thời
			}else {
				comment.setUser(null); // tạm thời
			}

			commentDAO.createComment(comment);
			Hotel hotel = hotelDAO.get(Integer.parseInt(id));
			if (hotel != null) {
				List<Comment> comments = hotel.getComment();
				comments.add(comment);
				hotel.setComment(comments);
				hotelDAO.saveOrUpdate(hotel);
			}

		}
	}

	protected void doPost_Delete_Comment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String commentId = request.getParameter("comment");
		if (id != null && commentId != null) {

			Comment comment = commentDAO.getCommentnById(Integer.parseInt(commentId));

			Hotel hotel = hotelDAO.get(Integer.parseInt(id));
			if (hotel != null) {
				List<Comment> comments = hotel.getComment();
				List<Comment> newComments = new ArrayList<>();
				for (Comment c : comments) {
					if (c.getId() != comment.getId()) {
						newComments.add(c);
					}

				}
				hotel.setComment(newComments);
				hotelDAO.saveOrUpdate(hotel);
			}
			commentDAO.delete(comment);
		}
	}
}
