package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.Impl.UserDAO;
import dao.Impl.UserLoginDAO;
import model.User;
import model.UserLogin;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDAO userDAO = new UserDAO();
	private UserLoginDAO userLoginDAO = new UserLoginDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet_Find(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		User user = userDAO.get(id);
		user.getUserLogin();
		
		Gson gson = new Gson();
		
		PrintWriter writer = response.getWriter();
		writer.print(gson.toJson(user));
		
		writer.flush();
		writer.close();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(null != action && action.equalsIgnoreCase("find")) {
			doGet_Find(request, response);
		}
		request.setAttribute("users", userDAO.getAll());
		request.setAttribute("jspName", "./userAdmin/user-management.jsp");
		request.getRequestDispatcher("/admin/template.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("UTF-8");
		
		String actionString = request.getParameter("action");
		if (actionString.equalsIgnoreCase("create"))
			doPost_Create(request, response);
		else if(actionString.equalsIgnoreCase("delete"))
			doPost_Delete(request, response);
		else if (actionString.equalsIgnoreCase("update"))
			doPost_Update(request, response);

		doGet(request, response);
	}
	
	protected void doPost_Create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = (String) request.getParameter("name");
		String email = (String) request.getParameter("email");
		String phone = (String) request.getParameter("phone");
		String username = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");
		String role = (String) request.getParameter("role");
		
		User userCheck = userDAO.getByName(username);
		if(userCheck != null) {
			request.setAttribute("message", "Đã tồn tại username này");
			return;
		}

		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPhone(phone);

		UserLogin userlogin = new UserLogin();
		userlogin.setUsername(username);
		userlogin.setPassword(password);
		userlogin.setRole(role);

		userDAO.saveUserAndUserLogin(user, userlogin);
	}

	protected void doPost_Delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		int id = Integer.parseInt(request.getParameter("id"));
		
		User user = userDAO.get(User.class, id);
		UserLogin userLogin = userLoginDAO.get(UserLogin.class, (user.getUserLogin().getId())); 
		userDAO.delete(user);
		userLoginDAO.delete(userLogin);
	}
	
	protected void doPost_Update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		User user = userDAO.get(id);
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setPhone(request.getParameter("phone"));
		
		UserLogin userlogin = userLoginDAO.get(UserLogin.class, user.getUserLogin().getId());
		userlogin.setUsername(request.getParameter("username"));
		userlogin.setPassword(request.getParameter("password"));
		userlogin.setRole(request.getParameter("role"));

		userDAO.saveOrUpdate(user);
		userLoginDAO.saveOrUpdate(userlogin);
	}
}