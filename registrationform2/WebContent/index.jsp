<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- <script type="text/javascript" src=></script>
<script type="text/javascript" src="WebContent/WEB-INF/js/form.js"></script> -->
<style>
body {background-color: #99ffff;}
h1{
color:green;
}

form
{ 
 
    text-align : center;
    text-decoration-color: yellow;
}
.left {
    
   color:brown;
    text-align: center;
}
</style>
</head>
<body >


<script>

function validateform(){  
var name=document.myform.name.value;  
var email=document.myform.email.value; 
var pass=document.myform.pass.value;

if (name==null || name==""){  
  alert("Name can't be blank");  
  return false;  
}else if(pass.length<6){  
  alert("Password must be at least 6 characters long.");  
  return false;  
  }  
/* else if(cpass!=pass){
	alert("password must be same")
} */
else if(email==null || email==""){  
	  alert("email field cannot be blank");  
	  return false;  
	  }   
}  
</script>
<body>
<form name="myform" action="process.jsp" method="post" onsubmit="return validateform()">
<h1 align="center">Student Registration Form!</h1>
<table  border="2" align="center">


<tr><td>Name:</td><td><input type="text" name="name" /></td></tr>
<tr><td>Email:</td><td><input type="text" name="email"></td></tr>
<tr><td>Password:</td><td><input type="password" name="pass" ></td></tr>

<tr><td>Age:</td><td><input type="text" name="age" ></td></tr>
<tr><td>City:</td><td><input type="text" name="city" ></td></tr>
<tr><td>Image:</td><td><input type="file" name="f"></td></tr>

<tr><td colspan="4"><input type="submit" value="register" /> </td></tr> 
</table>
</form>
</body>
