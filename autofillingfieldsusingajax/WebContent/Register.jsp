<%@page import="autofillingfieldsusingajax.UserDao"%>
<%@page import="autofillingfieldsusingajax.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String email=request.getParameter("eid");
String firstname=request.getParameter("firstName");
String lastname=request.getParameter("lastName");
String no=request.getParameter("no");
String cl=request.getParameter("cl");

User u=new User();
u.setEmail(email);
u.setFirstname(firstname);
u.setLastname(lastname);
u.setNo(no);
u.setCl(cl);

int status=UserDao.Register(u);
if(status>0){
	out.println("Inserted recored Successfully");}
	else{
		out.println("Failed to insert the recored");
	}


%>

</body>
</html>