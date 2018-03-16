$("#profile-img").click(function() {
	$("#status-options").toggleClass("active");
});

$(".expand-button").click(function() {
  $("#profile").toggleClass("expanded");
	$("#contacts").toggleClass("expanded");
});

$("#status-options ul li").click(function() {
	$("#profile-img").removeClass();
	$("#status-online").removeClass("active");
	$("#status-away").removeClass("active");
	$("#status-busy").removeClass("active");
	$("#status-offline").removeClass("active");
	$(this).addClass("active");
	
	if($("#status-online").hasClass("active")) {
		$("#profile-img").addClass("online");
	} else if ($("#status-away").hasClass("active")) {
		$("#profile-img").addClass("away");
	} else if ($("#status-busy").hasClass("active")) {
		$("#profile-img").addClass("busy");
	} else if ($("#status-offline").hasClass("active")) {
		$("#profile-img").addClass("offline");
	} else {
		$("#profile-img").removeClass();
	};
	
	$("#status-options").removeClass("active");
});

function newMessage() {
	message = $(".message-input input").val();
	if($.trim(message) == '') {
		return false;
	}
	$('<li class="sent"><img src="http://emilcarlsson.se/assets/mikeross.png" alt="" /><p>' + message + '</p></li>').appendTo($('.messages ul'));
	$('.message-input input').val(null);
	$('.contact.active .preview').html('<span>You: </span>' + message);
	$(".messages").animate({ scrollTop: $(document).height() }, "fast");
};
function newMessage2(message) {
	if($.trim(message) == '') {
		return false;
	}
	$('<li class="replies"><img src="http://icons.iconarchive.com/icons/killaaaron/adobe-cc-circles/1024/Adobe-Ai-icon.png" alt="" /><p>' + message + '</p></li>').appendTo($('.messages ul'));
	$('.message-input input').val(null);
	$('.contact.active .preview').html('<span>You: </span>' + message);
	$(".messages").animate({ scrollTop: $(document).height() }, "fast");
};
$(window).on('keydown', function(e) {
  if (e.which == 13) {
	  addchat();
    return false;
  }
});
function addchat(){
  var data={
		  chat:document.getElementById("test").value
			
	}
  $.ajax({
	    type: "POST",
	    url: "chatbot",
	    dataType: "json",
	    data: { 
	        loadProds: 1,
	        data: JSON.stringify(data) // look here!
	      },
	    error: function (responseJson) {
	    	 newMessage();
	    	 newMessage2(responseJson.responseText);
	    },
	      
	});
 
}
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

