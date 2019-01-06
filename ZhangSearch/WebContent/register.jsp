<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
    <title>注册</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="utf-8">
    <meta name="keywords" content="Border sign in Form a Responsive Web Template, Bootstrap Web Templates, Flat Web Templates, Android Compatible Web Template, Smartphone Compatible Web Template, Free Webdesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design">
    <script>
        addEventListener("load", function () {setTimeout(hideURLbar, 0);}, false);
        
        function hideURLbar() 
        {
            window.scrollTo(0, 1);
        }
    </script>
    <link rel="stylesheet" href="css/style.css" type="text/css" media="all">
    <link rel="stylesheet" href="css/font-awesome.css" type="text/css" media="all">
	<link href="//fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&amp;subset=devanagari,latin-ext" rel="stylesheet">
</head>
<body>
	<h1 class="title-agile text-center">Border Register form</h1>
    	<div class="content-w3ls">
        	<div class="content-bottom">
				<h2>Register Here <i class="fa fa-hand-o-down" aria-hidden="true"></i></h2>
			<form action="registerAction" method="post">
				<div class="field-group">
                    <div class="wthree-field">
                        <input name="user.account" id="user.username" type="text" placeholder="Username" required>
                    </div>
                </div>
                <div class="field-group">
                    <div class="wthree-field">
                        <input name="user.password" id="user.password" type="Password" placeholder="Password">
                    </div>
                </div>
                <div class="wthree-field">
                    <input id="saveForm" name="saveForm" type="submit" value="register" />
                </div>
			</form>
			</div>
    	</div>
    <!-- <div class="copyright text-center">
        <p>© 2018 Border Sign In Form. All rights reserved | Design by
            <a href="http://w3layouts.com">W3layouts</a>
        </p>
    </div> -->
</body>
</html>