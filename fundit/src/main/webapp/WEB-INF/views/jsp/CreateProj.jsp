<%@include file="include.jsp"%>
<%@ include file="Header.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<meta http-equiv="X-UA-Compatible"
	content="IE=EmulateIE7; IE=EmulateIE9">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no" />

<spring:url value="/resources/core/css/form_style.css" var="coreCss" />
<spring:url value="/resources/core/css/demo.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" media="all" />
<link href="${coreCss}" rel="stylesheet" media="all" />

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

</head>
<body>


<div class="container"><!-- freshdesignweb top bar -->

</div>
<!--/ freshdesignweb top bar --> <header>
<h1>Create A Business Proposal</h1>
</header>
<div class="form"><form:form id="contactform" method="post"
	action="/project/add" modelAttribute="projectBean">
	<p class="contact"><label for="name">Project title *</label></p>
	<form:input path="" id="project_title" name="project_title"
		placeholder="Please enter the project title"
		title="Please enter the project title" required="" tabindex="1"
		type="text" />

	<p class="contact"><label for="projectDescription">Project
	description *</label></p>
	<textarea rows="10" cols="60" name="project_description"
		id="project_description" required=""
		title="Please enter the brief project descripion"
		id="projectDescription"
		placeholder="Please enter the brief project description (Maximum length is 500 charcters)"></textarea>

	<p></p>
	<label>Project purpose *</label>
	<fieldset title="Please select a project global business"><label
		class="Please select a project purpose" required=""> <form:select
		class="select-style" name="project_purpose" path=""
		id="project_purpose">
		<form:option value="">Please select a project purpose</form:option>
		<form:option value="01">Business</form:option>
		<form:option value="02">Technology</form:option>
		<form:option value="03">Operation</form:option>
		<form:option value="04">Regulatory Compliance</form:option></label> </form:select></fieldset>

	<p class="contact"></p>

	<label>Project global business *</label>
	<fieldset title="Please select a project global business"><label
		class="Please select a project global business"> <form:select
		class="select-style" name="project_global_business"
		id="project_global_business" path="">
		<form:option value="">Please select a project global business</form:option>
		<form:option value="01">Investment</form:option>
		<form:option value="02">Private</form:option>
		<form:option value="03">Commercial</form:option>
		<form:option value="04">Retail</form:option></label> </form:select></fieldset>

	<p class="contact"></p>

	<form:label path="">Project planned finished date *<span></span>
	</form:label>
	<form:input path="" class="birthday" type="text" maxlength="8"
		name="project_planned_finish_date" id="project_planned_finish_date"
		placeholder="dd/mm/yyyy" required=""
		title="Please enter the date in dd/mm/yyyy" />

	<p class="contact"><form:label for="projectFundRequired" path="">Total project fund required (in $)</form:label></p>
	<form:input id="project_fund_required" name="project_fund_required"
		path="" placeholder="Please enter the amount"
		title="Please enter the project fund required in dollars" tabindex="1"
		type="text" />

	<p class="contact"><form:label path="" for="projectFundReceived">My funds(in $)</form:label></p>
	<form:input id="project_fund_received" name="project_fund_received"
		path="" placeholder="Please enter the amount"
		title="Please enter the funds you contribute in dollars" tabindex="1"
		type="text" />

	<p class="contact"></p>

	<input type="submit" value="Cancel" />

	<input type="submit" value="Submit" />
</form:form></div>
</div>

</body>

<script>
	$(function() {
		$("#project_planned_finish_date").datepicker();
	});
</script>

</html>