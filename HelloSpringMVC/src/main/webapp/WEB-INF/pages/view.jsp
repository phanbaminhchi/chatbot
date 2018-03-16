<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajax with JsonArray return type</title>
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.16/datatables.min.css"/>
 <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/glm-ajax.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.16/datatables.min.js"></script>

<script type="text/javascript">
        $(document).ready(function(){
        	  $('table.display').DataTable();
                $("#tablediv").show();
                        $.ajax({
                                type: "GET",
                                url : "GetAllStudents",
                                success: function(responseJson){
                                        if(responseJson!=null){
                                                $("#studentTable").find("tr:gt(0)").remove();
                                                var table1 = $("#studentTable");
                                                $.each(responseJson, function(key, value){
                                                        var rowNew = $("<tr><td></td><td></td><td></td><td></td><td></td></tr>");
                                                        rowNew.children().eq(0).text(value['studentId']);
                                                        rowNew.children().eq(1).text(value['name']);
                                                        rowNew.children().eq(2).text(value['classA']);
                                                        rowNew.children().eq(3).text(value['age']);
                                                        rowNew.children().eq(4).text(value['sex']);
                                                        rowNew.appendTo(table1);
                                                });             
                                        }
                                }
                        })                      
        });
</script>
</head>
<body class="container">
        <h1>Student in TIJ</h1>
        <div id="tablediv">
         
                <table class="display" cellspacing="0" width="100%" id="studentTable">
                     <thead>
                        <tr>
                                <th scope="col">Student Id</th>
                                <th scope="col">Student Name</th>
                                <th scope="col">Producer</th>
                                <th scope="col">Year Making</th>
                                <th scope="col">Price</th>
                      
                        </tr>
                         </thead>
                </table>
                
        </div>
</body>
</html> 