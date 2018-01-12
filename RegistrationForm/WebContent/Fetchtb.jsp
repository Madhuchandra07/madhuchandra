
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"> </script>
<script type="text/javascript">
function save(){
	alert("hi");

     $.ajax({
     url: "./SaveServlet",
     type: "Get",
     //data: "country="+ajaxdata+"&name="+ajaxdata1+"&age="+ajaxdata2,
     cache: false,
     success: function(f) {
    	 
    	               var table1 = $("#countrytable");
    	                 $.each(f, function(key,value) { 
    		 alert(f.length);
    	                      var rowNew = $("<tr><td></td><td></td></tr>");
    	                         rowNew.children().eq(1).text(value['name']); 
    	                         rowNew.children().eq(2).text(value['email']); 
    	                 
    	                         rowNew.appendTo(table1);
    	                 });  
     }
     });
	}

</script>
<style>
#country{
border: 1px solid #8707c2;
}
</style>

</head>
<body class="container">
<input type="button" value="Show Table" id="showTable" onclick="save();"/>
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