<%@ include file="include.jsp"%>
<%@ include file="Header.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>FundIT Home Page</title>
        <style>
        .imageAlign{
        margin-left:135px;
        }
    </style>

    
        <spring:url value="/resources/core/js/prefixfree.min.js" var="coreJs" />
		<script src="${coreJs}"></script>
        

    
  </head>

  <body>

    <h1>START YOURS TODAY</h1>

  <img alt="home" src="../resources/core/images/Group.jpg" class="imageAlign">
<span></span>
<h1>Funding your ideas for a better world.</h1>
  </body>
</html>
