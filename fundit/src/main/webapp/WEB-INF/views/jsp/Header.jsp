<%@include file="include.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>FundIT Home Page</title>
  

        

    
  </head>

  <body>
  <p></p>
  <p></p>
  <% if(request.getSession().getAttribute("loggedInUser")!=null) { %>
	<center class="textColor"> Welcome <b><%= request.getSession().getAttribute("loggedInUser") %></b> to FundIT</center>
	<% } %>
<span
	class="right">   <a href="/auth/logoff">LogOut</a> </span>


  <a href="/home">Home</a>
    
  <a href="/project">Create</a>
    
  <a href="/project/all">Explore</a>
    
  <a href="#">Dashboard</a>
  
  <a href="/howItWorks">How it works</a>  
  
  <a href="howItWorks">About us</a>
   

  </body>
</html>
