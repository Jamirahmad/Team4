<%@include file="include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<title>FundIt</title>

	<!-- Google Fonts -->
<!-- 	<link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700|Lato:400,100,300,700,900' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="/resources/core/css/animate.css">
	Custom Stylesheet
	<link rel="stylesheet" href="/resources/core/css/style.css"> -->

<spring:url value="/resources/core/css/animate.css" var="coreCss" />
<spring:url value="/resources/core/css/style.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
</head>

<body>
	<div class="container">
		<div class="top">
			<h1 id="title" class="hidden"><span id="logo"></span></h1>
		</div>
		<div class="login-box animated fadeInUp">
			<div class="box-header">
				<h2>Log In</h2>
			</div>
		
		<form:form id="loginForm" method="post" action="/auth/login" modelAttribute="loginBean">
			
			<form:label path="username">Username</form:label>
			<form:input id="username" name="username" path="" /><br>
			<form:label path="username">Password</form:label>
			<form:password id="password" name="password" path="" /><br>
			<input type="submit" value="Submit" />
			<a href=""><p class="small">Forgot your password?</p></a>
		</form:form>
		</div>
	</div>
</body>

<script>
	$(document).ready(function () {
    	$('#logo').addClass('animated fadeInDown');
    	$("input:text:visible:first").focus();
	});
	$('#username').focus(function() {
		$('label[for="username"]').addClass('selected');
	});
	$('#username').blur(function() {
		$('label[for="username"]').removeClass('selected');
	});
	$('#password').focus(function() {
		$('label[for="password"]').addClass('selected');
	});
	$('#password').blur(function() {
		$('label[for="password"]').removeClass('selected');
	});
</script>

</html>