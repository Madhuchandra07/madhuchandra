<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<%@ page import="com.registration.User,com.registration.RegistrationDao" %>
<%
String user=request.getParameter("name");
String pass=request.getParameter("pass");
User u= new User();
u.setName(user);
u.setPass(pass);
boolean status=false;
 status=RegistrationDao.userLogin(u);
if(status==true){
	
	out.print("<h2 align='center' style='color:blue'>login success</h2>");
	
}
else{
	response.sendRedirect("loginerror.jsp");
}
%>
</body>
</html>