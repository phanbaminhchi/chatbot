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
  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript"> 
var dataStudent;
         $(document).ready(function(){
        	
         	  $('table.display').DataTable();
                 $("#tablediv").show();
                        $.ajax({
                                type: "POST",
                                 url : "ShowStudentScore",
                                 success: function(responseJson){
                                         if(responseJson!=null){
                                        	 dataStudent=responseJson;
                                                $("#studentTable").find("tr:gt(0)").remove();
                                                 var table1 = $("#studentTable");
                                                 $.each(responseJson, function(key, value){
                                                         var rowNew = $("<tr><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
                                                        rowNew.children().eq(0).text(value['studentId']);
                                                        rowNew.children().eq(1).text(value['kanjiScore']);
                                                        rowNew.children().eq(2).text(value['goiScore']);
                                                        rowNew.children().eq(3).text(value['level']);
                                                        rowNew.children().eq(4).text(value['times']);
                                                        rowNew.children().eq(5).text(value['datepicker']);
                                                      	rowNew.appendTo(table1);
                                                });             
                                        }
                                }
                         })                      
        });
         
         ///caherty
    google.charts.load("current", {packages:['corechart']});
    google.charts.setOnLoadCallback(drawChart);
    function drawChart() {
    	
    var color=["3399FF","993300","CC3366","990033","#828282","#F4A460","#000080","#4EEE94","#00FF00","#7FFF00"];
    	
        var data = google.visualization.arrayToDataTable([
        	   ["Element", "Density", { role: "style" } ],
          ["gokaku", 75, "#b87333"],
         
        ]);
    	
        for(var i=0;i<dataStudent.length;i++){
        	var data2=google.visualization.arrayToDataTable([
        		  ["Element", "Density", { role: "style" } ],
        		 ["Copper", 8.94, "#b87333"],
              ]);
        	data2.og[0].c[0].v=dataStudent[i].studentId;
        	data2.og[0].c[1].v=parseInt(dataStudent[i].kanjiScore);
        	data2.og[0].c[2].v=color[i];
        	
        	 data.og.push(data2.og[0]);
        }
        var view = new google.visualization.DataView(data);
        view.setColumns([0, 1,
                         { calc: "stringify",
                           sourceColumn: 1,
                           type: "string",
                           role: "annotation" },
                         2]);

        var options = {
          title: "Chart about score of students in syuusyoku class",
          width: 1200,
          height: 400,
          bar: {groupWidth: "95%"},
          legend: { position: "none" },
        };
        var chart = new google.visualization.ColumnChart(document.getElementById("columnchart_values"));
        chart.draw(view, options);
    }
  </script>
</head>
<body class="container">
        <h1>Student in TIJ</h1>
        <div id="tablediv">
         
                <table class="display" cellspacing="0" width="100%" id="studentTable">
                     <thead>
                        <tr>
                                <th scope="col">Student Id</th>
                                <th scope="col">KanjiScore</th>
                                <th scope="col">Goiscore</th>
                                <th scope="col">Level</th>
                                <th scope="col">Time</th>
                                <th scope="col">Date</th>
                        </tr>
                         </thead>
                </table>
                
        </div>
        
      <div id="columnchart_values" style="width: 900px; height: 300px;"></div>
</body>
</html> 