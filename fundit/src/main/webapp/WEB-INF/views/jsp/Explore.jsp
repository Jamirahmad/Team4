<%@ include file="include.jsp"%>
<%@ include file="Header.jsp"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

   <jsp:useBean id="projects" type="java.util.List<com.fundit.beans.ProjectBean>"
    scope="session"></jsp:useBean>       


<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>FundIT Explore</title>
        <style>
    </style>
        <spring:url value="/resources/core/js/prefixfree.min.js" var="coreJs" />
		<script src="${coreJs}"></script> 
  </head>

<body>
<table id="getAllProjectTable" class="">
    <thead>
        <tr>
            <th>Project ID</th>
            <th>Project Title</th>
            <th>Project Description</th>
            <th>Project Purpose</th>
            <th>Project Golbal Purpose</th>
            <th>Project Planned Finished Date</th>
            <th>Project Fund required</th>
            <th>Project My Fund</th>
            <th>User ID</th>                                  
        </tr>
    </thead>
    <tbody>
        <c:forEach var="projects" items="${projectBeans}">
            <tr>
                <td>${getAllProjects.project_id}</td>
                <td>${getAllProjects.project_title}</td>
                <td>${getAllProjects.project_description}</td>
                <td>${getAllProjects.project_purpose}</td>
                <td>${getAllProjects.project_global_business}</td>
                <td>${getAllProjects.project_planned_finish_date}</td>
                <td>${getAllProjects.project_fund_required}</td>
                <td>${getAllProjects.project_my_fund}</td>
                <td>${getAllProjects.user_id}</td>                                                
            </tr>       
        </c:forEach>
    </tbody>
</table>
  </body>
</html>
