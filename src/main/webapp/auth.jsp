<%@ page import="model.UserLogin" %>
<%

UserLogin userauth = (UserLogin) session.getAttribute("user");
if (userauth == null) {
	response.sendRedirect("login.jsp");
}
%>