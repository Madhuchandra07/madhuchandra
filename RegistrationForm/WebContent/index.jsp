<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- <script type="text/javascript" src=></script>
<script type="text/javascript" src="WebContent/WEB-INF/js/form.js"></script> -->

<script type="text/javascript" src="jsfile/exjs.js"></script>

</head>


<body>
<!-- onkeyup="sendInfo()" -->
<form name="vinform">
ID:<input id="t1" type="text" name="t1" onkeyup="sendInfo()"><br>
Name:<input id="name"  type="text" name="name" /><br/>  
Email:<input id="email" type="text" name="email"  /><br/>  
Password:<input id="pass" type="text" name="pass" /><br/>  
Choose file :<input id="f" type="file" name="f"><br/>
<input type="button" value="register" onclick="validateform();"/>  
</form>
<span id="amit"> </span>
</body>
</html>