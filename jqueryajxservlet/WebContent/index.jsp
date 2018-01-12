<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"> </script>
<script type="text/javascript">
/* function save(){
	alert("hi");

	var ajaxdata = $("#country").val();
	var ajaxdata1 = $("#name").val();
	var ajaxdata2 = $("#age").val();
   
     $.ajax({
     url: "./SaveServlet",
     //type: "post",
     //data: "country="+ajaxdata+"&name="+ajaxdata1+"&age="+ajaxdata2,
     cache: false,
     success: function(f) {
alert(f);
     
     }
     });
	}
 */
 $(document).ready(function() {
	  $("#tablediv").hide();
	      $("#showTable").click(function(event){
	            $.get('PopulateTable',function(responseJson) {
	             if(responseJson!=null){
	                 $("#countrytable").find("tr:gt(0)").remove();
	                 var table1 = $("#countrytable");
	                 $.each(responseJson, function(key,value) { 
	                      var rowNew = $("<tr><td></td><td></td></tr>");
	                         rowNew.children().eq(1).text(value['name']); 
	                         rowNew.children().eq(2).text(value['email']); 
	                 
	                         rowNew.appendTo(table1);
	                 });
	                 }
	             });
	             $("#tablediv").show();          
	   });      
	 });
</script>
<style>
#country{
border: 1px solid #8707c2;
}
</style>

</head>
<body class="container">
<input type="button" value="Show Table" id="showTable"/>
<div id="tablediv">
<table cellspacing="0" id="countrytable"> 
    <tr> 
        <th scope="col">Name</th> 
        <th scope="col">Continent</th> 
          
    </tr> 
</table>
</div>
</body>
</html>