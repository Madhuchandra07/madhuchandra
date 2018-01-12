function loadDoc() {
  var xhttp = new XMLHttpRequest();
  var v=document.vinform.t1.value;
  var url="loginprocess.jsp?val="+v;
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
     document.getElementById("demo").innerHTML = xhttp.responseText;
    }
  };
  xhttp.open("GET", url, true);
  xhttp.send();
}