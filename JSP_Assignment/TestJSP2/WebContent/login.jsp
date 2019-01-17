<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<hr/>  
  
<h3>Login Form</h3>  
 <br/>  
 <%
         Integer hitsCount = (Integer)application.getAttribute("hitCounter");
         if( hitsCount ==null || hitsCount == 0 ) {
            /* First visit */
            out.println("Welcome to my website!");
            hitsCount = 1;
         } else {
            /* return visit */
            out.println("Welcome back to my website!");
            hitsCount += 1;
         }
         application.setAttribute("hitCounter", hitsCount);
      %>
      <%
      	HttpSession sess = request.getSession();
      	String email = (String) sess.getAttribute("email");
      	String pass = (String) sess.getAttribute("password");
      	if(email!=null && pass!=null){
      		 response.sendRedirect("MainPage.jsp");
      	}
      	System.out.println(email+" "+pass);
      %>
      <center>
         <p>Total number of visits: <%= hitsCount%></p>
      </center>
<form action="MainPage.jsp" method="get">  
Email:<input type="text" name="email"/><br/><br/>  
Password:<input type="password" name="password"/><br/><br/>  
<input type="submit" value="login"/>"  
</form>  
</body>
</html>