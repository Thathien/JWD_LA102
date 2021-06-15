<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link href="<c:url value ="/resources//Boostrap/css/bootstrap.min.css"></c:url>" rel="stylesheet"/>
    <script src="<c:url value = "/resources/Boostrap/jquery-3.6.0.min.js"/>"  type="text/javascript"></script>
     <script src="<c:url value = "/resources/Boostrap/jquery-3.6.0.min.js"/>" ></script>
    <!-- <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/> -->
    <link href="<c:url value ="/resources/Boostrap/js/bootstrap.min.js"></c:url>" rel="stylesheet"/>
    <link href="<c:url value ="/resources/Boostrap/font-awesome-4.7.0/css/font-awesome.min.css"></c:url>" rel="stylesheet"/>
</head>
<body>
    <div class="container ">
       <div class="container-fluid">
        <nav class="navbar navbar-expand-sm bg-light navbar-light">
            <ul class="navbar-nav">
              <li class="nav-item active">
                <a class="nav-link" href='<c:url value = "/"/>'>Home</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href='<c:url value = "/about"/>'>About</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href='<c:url value = "/contact"/>'>Contack</a>
              </li>
      
              <c:choose>
              	<c:when test="${User==null}">
              		 <li class="nav-item">
		                <a class="nav-link " href='<c:url value = "/login"/>'>Login</a>
		              </li>
              	</c:when>
              	<c:otherwise>
              		<li class="nav-item">
                		<a class="nav-link " href="<c:url value = "/postmm"/>">Post Manager</a>
             		 </li>
              		 <li class="nav-item">
                		<a class="nav-link " href="<c:url value = "/logout"/>">Logout</a>
             		 </li>
              	</c:otherwise>
              </c:choose>
            </ul>
          </nav>
    
    </div>