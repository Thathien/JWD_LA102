<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
    <jsp:include page="Header.jsp"></jsp:include>
    
    <div class="container p-3 ">
            <p class="h2">Update Post</p>
            <p>sfhafhabfhjabdhabdhba</p>

		<div class="row">
			
            <div class="col-md-8">
                <form:form  action="updatepost" modelAttribute="PostModalUpdate" method ="POST">
                <div class="form-group ">
                    <form:input  path="id" type="hidden" class="form-control" name="id" placeholder="Địa chỉ Email" value="${postEdit.getIdPost()}"/>
                  <form:errors path="id" cssClass="text-danger"></form:errors>
                 </div>
                <div class="form-group ">
                    <label for="exampleInputEmail1">Title</label>
                    <form:input  path="title" type="text" class="form-control" name="title" placeholder="Địa chỉ Email" value="${postEdit.getTitle()}"/>
                     <form:errors path="title" cssClass="text-danger"></form:errors>
                  </div>
                  <div class="form-group">
                    <label for="exampleInputEmail1">Content</label>
                	<form:textarea path="content" class="form-control" rows="5" value="${postEdit.content}"/> 
                	<c:out value="${postEdit.content}"></c:out>
<%-- 					<textarea path="content" class="form-control" rows="3">${postEdit.content}</textarea> --%>
                      <form:errors path="content" cssClass="text-danger"></form:errors>
                  </div>
                  <div class="form-group">
                    <label for="exampleInputEmail1">Tag</label>
                  
                    <form:input  path="tags" type="text" class="form-control" name="tags" placeholder="Địa chỉ Email" value="${postEdit.getTags()}"/>
                      <form:errors path="tags" cssClass="text-danger"></form:errors>
                  </div>
                    <div class="form-group">
                       <label for="exampleFormControlInput1">Status</label>
	                      <form:select path="status" name="status" class="form-control">
		                    <c:choose>
		                    <c:when test="${postEdit.getStatus()==1}">
		                    	<form:option value="1" >not visible to public</form:option>
			                     <form:option value="2">published to public</form:option>
			                     <form:option value="3">outdated and is not visible in the post list</form:option>
		                    </c:when>
		                     <c:when test="${postEdit.getStatus()==2}">
		                      <form:option value="2">published to public</form:option>
		                    	<form:option value="1" >not visible to public</form:option>
			                     <form:option value="3">outdated and is not visible in the post list</form:option>
		                    </c:when>
		                       <c:when test="${postEdit.getStatus()==3}">
		                           <form:option value="3">outdated and is not visible in the post list</form:option>
		                      <form:option value="2">published to public</form:option>
		                    	<form:option value="1" >not visible to public</form:option>
			                 
		                    </c:when>
		                    <c:otherwise>
		                    	<form:option value="0" >Error Post is not set stauts</form:option>
		                    </c:otherwise>
		                    </c:choose>
	                     </form:select>
	                      <form:errors path="status" cssClass="text-danger"></form:errors>
                     </div>
                     <br>
                     <a class="btn btn-danger text-white" href="javascript:history.back()" > <i class="fa fa-backward"></i> Back</i></a>
                 	<form:button type="submit" class="btn btn-primary pb-2"><i class="fa fa-edit"></i> Update post</form:button>
                
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
             <a href="#">Create New Post</a>
         </div>
         <div class="col-12">
             <a href="#">Manage Posts</a>
         </div>
         <div class="col-12">
             <a href="#">Approve Comments <span> (0)</span></a>
         </div>
         <div class="col-12">
             <a href="#">Logout</a>
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