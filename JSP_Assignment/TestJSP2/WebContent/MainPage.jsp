<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.au.jspex.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String email=request.getParameter("email");  
	String password=request.getParameter("password");  
	HttpSession sess = request.getSession();
	System.out.println(email+" "+password);
	User user = new User(email, password);
	session.setAttribute("Session", user);
	out.println("Session successfully saved");
%>
</body>
</html>