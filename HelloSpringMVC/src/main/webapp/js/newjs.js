


function myFunction()
{
	alert("âs");
window.location = "register";
}

function saveScore()
{	
	var data={
			studentId:document.getElementById("studentId").value,
			kanjiScore:document.getElementById("kanjiScore").value,
			goiScore:document.getElementById("goiScore").value,
			level:document.getElementById("level").value,
			times:document.getElementById("Times").value,
			datepicker:document.getElementById("datepicker").value
	}
	$.ajax({
	    type: "post",
	    url: "addStudentScore",
	    data: { 
	        loadProds: 1,
	        data: JSON.stringify(data) // look here!
	      },
	      error: function (responseJson) {
	    	     alert(
	    	    		 responseJson.responseText);
	    	     window.location = "showScore.html";
	    	    },
	});
	document.getElementById("studentId").value = "";
	document.getElementById("kanjiScore").value = "";
	document.getElementById("goiScore").value = "";
	document.getElementById("level").value = "";
	document.getElementById("Times").value = ""
	document.getElementById("datepicker").value = "";
}
function sigin()
{
	alert("âs");
	var name = document.getElementById("email").value;
	var password =document.getElementById("password").value;
	var data={
			username:document.getElementById("email").value,
			password:document.getElementById("password").value
	}
	$.ajax({
	    type: "get",
	    url: "login",
	    data: { 
	        loadProds: 1,
	        data: JSON.stringify(data) // look here!
	      },
	      error: function (responseJson) {
	    	     alert(
	    	    		 responseJson.responseText);
	    	     window.location = "view.html";
	    	    },
	});
}
function register()
{
	
var name = document.getElementById("name").value;
var studentId = document.getElementById("studentId").value;
var classA = document.getElementById("class").value;
var age = document.getElementById("age").value;
var sex = document.getElementById("sex").value;
var test = 
    {name: document.getElementById("name").value,
    studentId: document.getElementById("studentId").value,
    classA: document.getElementById("class").value,
    age: document.getElementById("age").value,
    sex: document.getElementById("sex").value} 
;
$.ajax({
    type: "POST",
    url: "AddNewStudent",
    dataType: "json",
    data: { 
        loadProds: 1,
        test: JSON.stringify(test) // look here!
      },
    error: function () {
     //alert('Error');
    },
      
});
alert("register susseed");
}

