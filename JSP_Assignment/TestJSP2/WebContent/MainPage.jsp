<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
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
		if(email!=null && password!=null){
			out.println("Successfully logged In!");
		}else{
			HttpSession sess = request.getSession();
			System.out.println(email+" "+password);
			//User user = new User(email, password);
			sess.setAttribute("email", email);
			sess.setAttribute("password", password);
			out.println("Session successfully saved");
		}
	%>
</body>
</html>