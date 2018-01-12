<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%  
       String consultant = request.getParameter("search"); 
       String buff1 = "<div id='hint'>";  
       String buff2 = "<input type='text' name='firstName' value=''>";  
       String buff3 = "<input type='text' name='lastName' value=''>";  
       String buff4 = "<input type='text' name='no' value=''>";  
       String buff5 = "<input type='text' name='cl' value=''>";  
       try {  
         Class.forName("com.mysql.jdbc.Driver");  
         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","root");  
         Statement stmt = conn.createStatement();  
         ResultSet rs = stmt.executeQuery("Select * from person where email_id= '" + consultant + "'");  
         while (rs.next()) {  
           buff1 = "email already exists" + "<br>";  
           buff2 = "<input type='text' name='firstName' value='" + rs.getString(2) + "'>";  
           buff3 = "<input type='text' name='lastName' value='" + rs.getString(3) + "'>";  
           buff4 = "<input type='text' name='no' value='" + rs.getString(4) + "'>";  
           buff5 = "<input type='text' name='cl' value='" + rs.getString(5) + "'>";  
         }  
         buff1 = buff1 + "</div>";  
         buff2 = buff2 + "</input></div>";  
         buff3 = buff3 + "</input>";  
         buff4 = buff4 + "</input>";  
         buff5 = buff5 + "</input>";  
         response.getWriter().println(buff1 + "brk" + buff2 + "brk" + buff3 + "brk" + buff4 + "brk" + buff5);  
       } catch (Exception e) {  
         System.out.println(e);  
       }  
     %>  

</body>
</html>