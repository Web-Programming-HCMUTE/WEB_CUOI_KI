package controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Impl.UserDAO;
import dao.Impl.UserLoginDAO;
import model.User;
import model.UserLogin;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserLoginDAO userLoginDAO = new UserLoginDAO();
	private UserDAO userDAO = new UserDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("./login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if(action.equals("login"))
			doPost_Login(request, response);
		if(action.equals("register"))
			doPost_Regiser(request, response);
		//doGet(request, response);
	}
	
	protected void doPost_Login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserLogin userLogin = userLoginDAO.checkLogin(username, password);
		
		if(userLogin != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("user", userLogin);
			response.sendRedirect("HomeServlet");
		}
		else {
			request.setAttribute("message", "Không tìm thấy tài khoản");
			request.getRequestDispatcher("./login.jsp").forward(request, response);
		}
	}
	
	protected void doPost_Regiser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = (String) request.getParameter("name");
		String email = (String) request.getParameter("email");
		String phone = (String) request.getParameter("phone");
		String username = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");

		User user = new User();
		user.setName(username);
		user.setEmail(email);
		user.setPhone(phone);

		UserLogin userlogin = new UserLogin();
		userlogin.setUsername(username);
		userlogin.setPassword(password);
		userlogin.setRole("USER");

		userDAO.saveUserAndUserLogin(user, userlogin);
		
		request.getRequestDispatcher("./login.jsp").forward(request, response);
	
	}

}
