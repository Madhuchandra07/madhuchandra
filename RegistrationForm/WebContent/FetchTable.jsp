
<%@page import="com.registration.ConnectionProvider"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<h2 align="center"><strong>Retrieve data from database in jsp</strong></h2>
<table align="center" cellpadding="10" cellspacing="10" border="1">
<tr>

</tr>
<tr >
<td><b>id</b></td>
<td><b>user_id</b></td>
<td><b>Password</b></td>
<td><b>Name</b></td>
<td><b>Email</b></td>
</tr>
<%
try{
	connection=com.registration.ConnectionProvider.getCon();

statement=connection.createStatement();
String sql ="SELECT * FROM record";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
	
%>
<tr >

<td><%=resultSet.getString("id") %></td>
<td><%=resultSet.getString("user_id") %></td>
<td><%=resultSet.getString("password") %></td>
<td><%=resultSet.getString("name") %></td>
<td><%=resultSet.getString("email") %></td>

</tr>

<% 
}

} catch (Exception e) {
e.printStackTrace();
}

%>
</table>



</body>
</html>