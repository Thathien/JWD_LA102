<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
    <jsp:include page="Header.jsp"></jsp:include>
    
  <div class="container p-3">
            <p class="h2 ">Login</p>
            <p class="">Lleade</p>
            
            <form:form  action="login" modelAttribute="Usermodel" method ="post">
				 <div class="row ">
                    <div class="form-group col-md-6">
                        <label for="exampleFormControlTextarea1">UserName</label>
                       <form:input  path="username" type="text" class="form-control" name="username" placeholder="Địa chỉ Email" />
                    	<form:errors path="username" cssClass="text-danger"></form:errors>
                    </div>
                </div>
                <div class="row ">
                    <div class="form-group col-md-6">
                        <label for="exampleFormControlTextarea1">Password</label>
                         <form:input  path="password" type="password"  class="form-control" name="password" placeholder="Địa chỉ Email" />
                   		<form:errors path="password" cssClass="text-danger"></form:errors>
                    </div>
                  
                </div>
                <c:if test="${ not empty Error}">
             			<span class="text-danger" id="password-eror">${Error}</span>	
             			<br/>
                </c:if>
             	
				<form:button type="submit" class="btn btn-default">Đăng nhập</form:button>
			</form:form>
            
       </div>
    
      <jsp:include page="Footer.jsp"></jsp:include>