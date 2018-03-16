<html>
<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>design by bootstrap</title>
  <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/glm-ajax.js"></script>
		<!-- Bootstrap CSS -->
		 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
			<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="css/bootstrap.css">
		<link rel="stylesheet" href="css/footer.css">
    <script src="js/bootstrap.min.js"></script>
	 <script src="js/newjs.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script>
</head>

<body>
<div class="container">
<div id="header" style=" height: 100; width: 1063px;"> 
	<div id="icon" style="    margin-top: 50px;"><img src="image\rogo.png" alt="Smiley face">
	</div>
	<div id="icon2" style="    "><img style="    margin-top: -38px; margin-left: 400;"src="image\mail.png" alt="Smiley face">
	</div>
	<div id="icon3" style="    "><img style="    margin-left: 600px; margin-top: -43px;"src="image\phone.png" alt="Smiley face">
	</div>
</div>
<hr>

<div class="row" style="margin-top:20px">
<input type="hidden" id="fileName" value="<%=(String)request.getAttribute("username")%>">
    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
		<form role="form">
			<fieldset>
				<h2>Please Sign In</h2>
				<hr class="colorgraph">
						<div class="control-group">
					<p>Date: <input type="text" id="datepicker"></p>
						</div>
						<div class="form-group">
                    <input type="text" id="studentId" class="form-control input-lg" placeholder="StudentID">
				</div>
				<div class="form-group">
                    <input type="text" id="kanjiScore" class="form-control input-lg" placeholder="Kanji Score">
				</div>
					<div class="form-group">
                    <input type="text" id="goiScore" class="form-control input-lg" placeholder="Goi Score">
				</div>
					<div class="form-group">
                    <input type="text" id="level" class="form-control input-lg" placeholder="Level">
				</div>
					<div class="form-group">
                    <input type="text" id="Times" class="form-control input-lg" placeholder="Times">
				</div>
				<hr class="colorgraph">
				<div class="row">
					<div class="col-xs-6 col-sm-6 col-md-6">
                        <button type="button" class="btn btn-lg btn-success btn-block"onclick="saveScore()">Save</button>
					</div>
					<div class="col-xs-6 col-sm-6 col-md-6">
						<button  type="button" class="btn btn-lg btn-primary btn-block" onclick="">Cancel</button>
					</div>
				</div>
			</fieldset>
		</form>
	</div>
</div>

</div>

</body>

	
</html>
