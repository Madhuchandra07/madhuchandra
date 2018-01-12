<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.registration.User" %>
      <%@page import="com.registration.RegistrationDao" %>
      <%@page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String id=request.getParameter("val");

User u=RegistrationDao.find(Integer.parseInt(id));


 if(u==null){
	 out.print("<a href='index.jsp'>Register New User</a>");

}
else{
	 out.print("<table border='1' width='90%'><tr><th>Id</th><th>Name</th><th>Email</th><th>Password</th><th>Image</th></tr>");
	out.print("<tr><td>"+u.getId()+"</td><td>"+u.getName()+"</td><td>"+u.getEmail()+"</td><td>"+u.getPass()+"</td><td>"+u.getImg()+"</td></tr>");
	out.print("</table"); 
	/* int r=u.getId()m
	String s=u.getName();
	String t=u.getEmail();
	String v=u.getPass();
	String w=u.getImg();
	out.print(r+"  "+s+"   "+t+"  "+v+"  "+w);
	 */
	
} 
%>
<%-- <form name="form">  
<input type="hidden" name="id" value="<%=u.getId() %>"/>  
<table>  
<tr><td>Name:</td><td>  
<input type="text" name="name" value="<%= u.getName()%>"/></td></tr>  
<tr><td>Password:</td><td>  
<input type="password" name="password" value="<%= u.getEmail()%>"/></td></tr>  
<tr><td>Email:</td><td>  
<input type="email" name="email" value="<%= u.getPass()%>"/></td></tr>  

</table>  
</form> --%>

</body>
</html>







<%-- <table border="1" width="90%">  
<tr><th>Id</th><th>Name</th><th>Email</th><th>Password</th>  
<th>Image</th></tr>

<tr><td><%=u.getId()%></td><td><%=u.getName()%></td><td><%=u.getEmail()%></td><td><%=u.getPass()%></td><td><%=u.getImg()%></td></tr>


</table>
 --%>

