<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page!</title>
<style>
body{
text-align : center;
background-color: #99ffff;
color:green;
}
form{
color:brown;
}

</style>
</head>
<body>
<script>

function validateform(){  
var name=document.myform.name.value;  
var pass=document.myform.pass.value;

if (name==null || name==""){  
  alert("Name can't be blank");  
  return false;  
}else if(pass==null || pass==""){  
  alert("Password must be at least 6 characters long.");  
  return false;  
  }  
 
}  
</script>
<h1>Registration Success,Please Login</h1>
<form name="myform"  action="loginprocess.jsp" method="post" onsubmit="return validateform()">
<div class="u">Username:<input type="text" name="name"></div>
<div class="u">Password:<input type="password" name="pass"></div>

 <div style="position:absolute; left:525px; top:130px; "><input type="submit" id="s" value="Login"></div>
</form>
</body>
</html>