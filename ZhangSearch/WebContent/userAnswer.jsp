<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title>我要回答</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<meta name="keywords" content="Border sign in Form a Responsive Web Template, Bootstrap Web Templates, Flat Web Templates, Android Compatible Web Template, Smartphone Compatible Web Template, Free Webdesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design">
	<script type="text/javascript">
	function tempClick()
	{	
	/**
	 * 火狐浏览器实现点击图片出现文件上传界面
	 * var a=document.createEvent("MouseEvents"); 
	 * a.initEvent("click", true, true);  
	 * document.getElementById("upload_main_img").dispatchEvent(a); 
	 */	
	//IE浏览器实现点击图片出现文件上传界面
		document.getElementById('main_img').click();//调用main_img的onclick事件	
	} 
	</script>
	<style>    
		.buttom
		{
			width:80px;
			height:35px;
			color:#000000;
			font-family:微软雅黑;
		}
		.buttom:hover 
		{
    		background: #606060;
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
	</style>
	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/style1.css" type="text/css" media="all">
    <link rel="stylesheet" href="css/font-awesome.css" type="text/css" media="all">
    <link rel="stylesheet" href="css/header.css" type="text/css" media="all">
	<link href="//fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&amp;subset=devanagari,latin-ext" rel="stylesheet">
	<link href="//fonts.googleapis.com/css?family=Pacifico&amp;subset=cyrillic,latin-ext,vietnamese" rel="stylesheet">
	<link href="//fonts.googleapis.com/css?family=Amaranth:400,400i,700,700i" rel="stylesheet">
	<link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
</head>

<body>
	<div class="header-w3l">
		<!-- navigation -->
		<div class="nav-agile">
			<nav class="navbar navbar-default">
			<div class="navbar-header logo-w3layouts">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<!-- logo -->
					<h1>
						<a href="index.html">老張搜题</a>
					</h1>
					<!-- //logo -->
				</div>
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<div class="w3l-navtop">
						<ul class="nav navbar-nav navbar-right">
							<li><a href="#" style="font-size:24px">个人中心</a></li>
							<li><a href="userCollection.jsp" style="font-size:24px">我的错题</a></li>
							<li><a href="homePage.jsp" style="font-size:24px">退出登录</a></li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
	</div>
<form action="upload" method="post" enctype="multipart/form-data">
	<div>
	<center>
		<textarea rows="10" name="question" style="width:300px;height:100px;font-size:16px;margin-top:50px;"><!-- 此处显示识别出的问题 --></textarea>
		<h2 class="title-agile text-center" style="margin-top:10px;">请输入您的答案：</h2>
		<textarea rows="10" name="result" style="width:760px;height:200px;font-size:16px;margin-top:10px;"></textarea><br>
		<input type="submit" value="提交" id="submit" class="buttom" style="margin-top:10px;">
	</center>
	</div>
</form>
</body>
</html>