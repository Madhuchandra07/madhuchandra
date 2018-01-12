<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,java.io.*" %>
<%--   <%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload" %>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory" %>
<%@ page import="org.apache.commons.fileupload.*" %>   --%>
<%@ page import="java.util.*,java.io.*" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.File" %>
<%@ page import="javax.servlet.annotation.MultipartConfig"%>
<%@ page import="com.registration.RegistrationDao,com.registration.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<%-- <%! @SuppressWarnings("serial")
@MultipartConfig(location = "/tmp", fileSizeThreshold = 1024 * 1024,
maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)


%> --%>
<%

String name=request.getParameter("name");
String email=request.getParameter("email");
String pwd=request.getParameter("pass");
 String img=request.getParameter("f");
User u = new User();
u.setName(name);
u.setEmail(email);
u.setPass(pwd);
u.setImg(img); 


int status=RegistrationDao.register(u);
if(status>0){
	out.print("success");
}
else{
	out.print("failed or user already exist");
}
%>
</body>
</html>