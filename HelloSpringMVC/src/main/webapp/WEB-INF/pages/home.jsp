<html>
<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>design by bootstrap</title>
 <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/glm-ajax.js"></script>
		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="css/bootstrap.css">
		<link rel="stylesheet" href="css/footer.css">
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
	 <script src="js/newjs.js"></script>

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
				<div class="form-group">
                    <input type="email" name="email" id="email" class="form-control input-lg" placeholder="Email Address">
				</div>
				<div class="form-group">
                    <input type="password" name="password" id="password" class="form-control input-lg" placeholder="Password">
				</div>
				<span class="button-checkbox">
					<button type="button" class="btn" data-color="info">Remember Me</button>
                    <input type="checkbox" name="remember_me" id="remember_me" checked="checked" class="hidden">
					<a href="" class="btn btn-link pull-right">Forgot Password?</a>
				</span>
				<hr class="colorgraph">
				<div class="row">
					<div class="col-xs-6 col-sm-6 col-md-6">
                        <button type="button" class="btn btn-lg btn-success btn-block"onclick="sigin()">Sign in</button>
					</div>
					<div class="col-xs-6 col-sm-6 col-md-6">
						<button  type="button" class="btn btn-lg btn-primary btn-block" onclick="myFunction()">Register</button>
					</div>
				</div>
			</fieldset>
		</form>
	</div>
</div>

</div>

</body>
<footer class="footer-section bg-with-black">
        <div class="footer-top-section" style="     margin-top: 40px;   background-color: black;">
            <div class="container">
                <div class="row">
                    <div class="col-md-3 col-sm-6 col-xs-12">
                        <div class="single-fta">
                            <img src="http://themeinnovation.com/demo2/html/build-up/img/home1/logo2.png" alt="">
                            <ul class="fta-list">
                                <li><a href="#"><span class="glyphicon glyphicon-chevron-right"></span> Finacial Planning</a></li>
                                <li><a href="#"><span class="glyphicon glyphicon-chevron-right"></span> Investments Management</a></li>
                                <li><a href="#"><span class="glyphicon glyphicon-chevron-right"></span>Taxes Planning</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6 col-xs-12">
                        <div class="single-fta">
                            <h3 class="fta-title">Important Link</h3>
                            <ul class="fta-list">
                                <li><a href="#"><i class="fa fa-square"></i>Finacial Planning</a></li>
                                <li><a href="#"><i class="fa fa-square"></i>Investments Management</a></li>
                                <li><a href="#"><i class="fa fa-square"></i>Taxes Planning</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6 col-xs-12">
                        <div class="single-fta">
                            <h3 class="fta-title">Important Link</h3>
                            <ul class="fta-list">
                                <li><a href="#"><i class="fa fa-square"></i>Finacial Planning</a></li>
                                <li><a href="#"><i class="fa fa-square"></i>Investments Management</a></li>
                                <li><a href="#"><i class="fa fa-square"></i>Taxes Planning</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6 col-xs-12">
                        <div class="single-fta">
                            <h3 class="fta-title">Contact Us</h3>
                            <ul class="fta-list">
                                <li>Address: 8th floor, 379 Hudson St, New York, NY 10018</li>
                                <li>Phone: (+1) 96 716 6879</li>
                                <li>Email: contact@site.com</li>
                            </ul>
                        </div>
                    </div>
                    
                </div>
            </div>
        </div>
        <div class="footer-bottom-area">
            <div class="container">
                <div class="row">
                    <div class="col-xs-12">
                        <div class="footer-bottom">
                            <div class="row">
                                <div class="col-md-6 col-sm-12 col-xs-12">
                                    <div class="fba-copyright">
                                        <p>Copyright © 2017 Designed by EXchange. All rights reserved.</p>
                                    </div>
                                </div>
                                <div class="col-md-6 col-sm-12 col-xs-12">
                                    <div class="fba-links">
                                        <ul>
                                            <li><a href="#">About</a></li>
                                            <li><a href="#">Contact Us</a></li>
                                            <li><a href="#">Term & Conditions</a></li>
                                            <li><a href="#">Privacy Policy</a></li>
                                            <li><a href="#">Sites Map</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
	
</html>
