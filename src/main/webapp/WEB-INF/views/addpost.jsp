<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
	<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
    <jsp:include page="Header.jsp"></jsp:include>
    
    <div class="container p-3 ">
            <p class="h2">Create Post</p>
            <p>sfhafhabfhjabdhabdhba</p>

		<div class="row">
			
            <div class="col-md-8">
                <form:form  action="addpost" modelAttribute="PostModal" method ="post">
                <div class="form-group ">
                    <label for="exampleInputEmail1">Tiitle</label>
                    
                    <form:input  path="title" type="text" class="form-control" name="title" placeholder="Địa chỉ Email"/>
                    <form:errors path="title" cssClass="text-danger"></form:errors>
                  </div>
                  <div class="form-group">
                    <label for="exampleInputEmail1">Content</label>
                  	<form:textarea path="content" class="form-control" rows="3"/>
                     <form:errors path="content" cssClass="text-danger"></form:errors>
                   
                  </div>
                  <div class="form-group">
                    <label for="exampleInputEmail1">Tag</label>
                  
                    <form:input  path="tags" type="text" class="form-control" name="tags" placeholder="Địa chỉ Email"/>
                     <form:errors path="tags" cssClass="text-danger"></form:errors>
                  </div>
                    <div class="form-group">
                       <label for="exampleFormControlInput1">Status</label>
                     
	                       <form:select path="status" name="status" class="form-control">
		                     	<form:option value="1">Not visible to public</form:option>
		                     	<form:option value="2">Published to public</form:option>
		                     	<form:option value="3">Outdated and is not visible in the post list</form:option>
	                     	</form:select>
                    
                     	 <form:errors path="status" cssClass="text-danger"></form:errors>
                     </div>
                     <br>
                
                 	<form:button type="submit" class="btn btn-default pb-2">Tạo bài post</form:button>
                
               </form:form>
            </div>
            <div class="col-md-3">
     <div class="row" style="margin-bottom: 20px">
         <div class="col-12">
             <p
                 style="background-color: #a1c4fd; border-radius: 2px; padding: 4px">
                 <Strong>Demo</Strong>
             </p>
         </div>
         <div class="col-12">
             <a  href='<c:url value = "/addpost"/>'>Create New Post</a>
         </div>
         <div class="col-12">
             <a  href='<c:url value = "/postmm"/>'>Manage Posts</a>
         </div>
         <div class="col-12">
             <a href="#">Approve Comments <span> (0)</span></a>
         </div>
         <div class="col-12">
             <a  href='<c:url value = "/logout"/>'>Logout</a>
         </div>
     </div>
     <div class="row" style="margin-bottom: 20px">
         <div class="col-12">
             <p
                 style="background-color: #a1c4fd; border-radius: 2px; padding: 4px">
                 <Strong>Tag</Strong>
             </p>
         </div>


         <div class="col-12">
             <!-- Chỗ này foreach để hiển thị ra các tag -->
             <a href="#">blog</a> <a href="#">test</a>
         </div>
     </div>
     <div class="row" style="margin-bottom: 20px">
         <div class="col-12">
             <p
                 style="background-color: #a1c4fd; border-radius: 2px; padding: 4px">
                 <Strong>Recent Comments</Strong>
             </p>
         </div>


         <div class="col-12">
             <span>Tester on </span><a href="#">blog</a>


         </div>
     </div>
 </div>
		</div>
            
       </div>
    
      <jsp:include page="Footer.jsp"></jsp:include>