
function validateform1(){  
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
//ajaxprogram
var request;
function sendInfo()
{
var v=document.vinform.t1.value;
var url="loginprocess.jsp?val="+v;

if(window.XMLHttpRequest){
request=new XMLHttpRequest();
}
else if(window.ActiveXObject){
request=new ActiveXObject("Microsoft.XMLHTTP");
}

try
{
request.onreadystatechange=getInfo;
request.open("GET",url,true);
request.send();
}
catch(e)
{
alert("Unable to connect to server");
}
}

function getInfo(){
if(request.readyState==4){
var val=request.responseText;
document.getElementById('amit').innerHTML=val;
}
}
