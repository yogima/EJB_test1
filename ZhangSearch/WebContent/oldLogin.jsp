<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title>登录页面</title>
	<style>  
		div
		{
			width:170px;
			height:70px;
		}
		*
		{
			padding: 0;
			margin:0;
			list-style: none;
		}
		b
		{
			display:block;
			width:1200px;
			height:120px;
			margin:0px,360px,0px,360px;
			text-decoration:none;
			text-align:center;
			line-height:120px;
		}
		.buttom
		{
			width:100px;
			height:40px;
			background-image:pic/button-background.jpg;
			color:#000000;
			font-family:微软雅黑;
		}
		.buttom:hover 
		{
    		background: #606060;
		}
		#header 
		{
			padding: 5px 220px 7px 1px;
			position: relative;
			background: #335e54;
			width: 100%;
			height: 10%;
			display:inline;
		}
		#header ul 
		{
			list-style: none; /* 去掉列表项目前的点 */
		}
		#header ul li 
		{
			float: left;
			font-size: 20px;
			line-height: 42px;
			position: relative;
		}
		#header ul li a, #header ul li a span 
		{
			float: left;
			background-position: left top;
			background-color: #335e54
		}
		#header ul li a 
		{
			color: #ffffff;
			text-decoration: none;
			padding-right:2px;
			background-color: #ffffff
		}
		#header ul li a span 
		{
			padding: 0 20px 0 20px;
			background-position: left top;
		}
		#header ul li a:hover, #header ul li a:hover span 
		{
			color: #000000;
		}		
		.clearfloat:after 
		{
			display: block;
			height: 0;
			width: 0;
			content: "";
			clear: both;
			visibility: hidden;
		}
		.img-area
		{
			width:80px;
			height:auto;
			position:relative;
		}
		.img-area img
		{
			width:100%;
			height:100%;
		}
		.img-area input
		{
			position:absolute;
			left:0;
			top:0;
			width:100%;
			height:100%;
			opacity:0;
		}
		body
		{
			width: 100%;
			background-image:url(pic/login-register.jpg);
			font-family:"微软雅黑";
			color:white;
			font-size:30px;
		}
	</style>
</head>
<body>
<form action="login" method="post">
<center>
<div style="font-size:40px;margin-top:300px">账号登录<br></div>
<img src="pic/user.png" style="width:40px;height:40px;margin-top:80px"/>账  号：<input name="account" type="text" style="width:580px;height:40px;font-size:24px;"/><br><br>
<img src="pic/password.png" style="width:40px;height:40px;margin-top:30px"/>密  码：<input name="password" type="password" style="width:580px;height:40px;font-size:24px;"/><br><br>
<input type="submit" value="立即登录" style="width:200px;height:60px;font-size:24px;color:#ffffff;background-color:#4f8f80;margin-top:60px"/>
</center>
<div style="font-size:20px;margin-left:1220px;"><a href="">立即注册</a></div>
</form>
</body>
</html>