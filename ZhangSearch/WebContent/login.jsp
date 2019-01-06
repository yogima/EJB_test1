<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
    <title>登录</title>
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
	<h1 class="title-agile text-center">Border Sign in form</h1>
    	<div class="content-w3ls">
        	<div class="content-bottom">
				<h2>Sign In Here <i class="fa fa-hand-o-down" aria-hidden="true"></i></h2>
			<form action="loginAction" method="post">
				<div class="field-group">
                    <div class="wthree-field">
                        <input name="user.account" id="user.username" type="text" value="" placeholder="Username" required>
                    </div>
                    <span class="fa fa-user" aria-hidden="true"></span>
                </div>
                <div class="field-group">
                    <div class="wthree-field">
                        <input name="user.password" id="user.password" type="Password" placeholder="Password">
                    </div>
                    <span class="fa fa-lock" aria-hidden="true"></span>
                </div>
                <div class="field-group">
                    <div class="check">
                        <label class="checkbox w3l">
                            <input type="checkbox" onclick="myFunction()">
                            <i> </i>show password</label>
                    </div>
                    <!-- script for show password -->
                    <script>
                        function myFunction() 
                        {
                            var x = document.getElementById("myInput");
                            if (x.type === "password") 
                            {
                                x.type = "text";
                            } 
                            else 
                            {
                                x.type = "password";
                            }
                        }
                    </script>
                    <!-- //script for show password -->
                </div>
                <div class="wthree-field">
                    <input id="saveForm" name="saveForm" type="submit" value="login" />
                </div>
                <ul class="list-login">
                    <li class="switch-agileits">
                        <label class="switch">
                            <input type="checkbox">
                            <span class="slider round"></span>
                            keep signed in
                        </label>
                    </li>
                    <!-- 注册！！！注册！！！注册！！！ -->
                    <li>
                        <a href="register.jsp" class="text-right">register</a>
                    </li>
                    <li class="clearfix"></li>
                </ul>
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