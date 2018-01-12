<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>



</head>
<body>
<%  
 String name=request.getParameter("count");  
 String buffer="<div>";  
 Class.forName("com.mysql.jdbc.Driver").newInstance();  
 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","root");  
 Statement stmt = con.createStatement();  
 ResultSet rs = stmt.executeQuery("Select * from Registration where name LIKE '"+name+"%'");  
   while(rs.next()){
   buffer=buffer+rs.getString(2)+"<br>";  
   }  
 buffer=buffer+"</div>";  
 response.getWriter().println(buffer);  
 %>

</body>
</html>