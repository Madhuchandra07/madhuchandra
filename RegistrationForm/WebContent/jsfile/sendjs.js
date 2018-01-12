function validateform(){  
var name=document.vinform.name.value;  
var email=document.vinform.email.value; 
var pass=document.vinform.pass.value;

if (name==null || name==""){  
  alert("Name can't be blank");  
  return false;  
}
else if(pass.length<6){  
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
document.vinform.method="post";
document.vinform.action="process.jsp";



}