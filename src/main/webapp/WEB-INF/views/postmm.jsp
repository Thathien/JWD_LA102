<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
    <jsp:include page="Header.jsp"></jsp:include>
    
    <div class="container p-3 ">
           
        

		<div class="row">
			
            <div class="col-md-9">
             <p class="h2"> Post Management</p>
                <table class="table table-hover">
              <thead class="thead-dark" style="background-color: #a1c4fd !important; border-radius: 2px; padding: 4px">
                <tr>
                  <th scope="col">#</th>
                  <th scope="col">Tittle</th>
                  <th scope="col">Status</th>
                  <th scope="col">Create Time</th>
                  <th scope="col">Action</th>
                </tr>
              </thead>
              <tbody>
              
                <c:choose>
                	<c:when test="${listPostUser.size()>0 }">
                	 	<c:forEach var="listPost" items="${listPostUser }">
                	 			<tr>
				                  <th scope="row">${listPost.getIdPost() }</th>
				                  <td>${listPost.getTitle() }</td>
				                  <td>${listPost.getStatus() }
				                  
				                 <c:choose>
				                 	<c:when test="${listPost.getStatus()==1 }">
				                 		<c:out value="Not visible to public"></c:out>
				                 	</c:when>
				                 	<c:when test="${listPost.getStatus()==2 }">
				                 		<c:out value="Published to public"></c:out>
				                 	</c:when>
				                 	<c:when test="${listPost.getStatus()==3 }">
				                 		<c:out value="Outdated and is not visible in the post list"></c:out>
				                 	</c:when>
				                 	<c:otherwise>
				                 		<c:out value="Eroor not choose status"></c:out>
				                 	</c:otherwise>
				                 </c:choose>
				                  
				                  
				                  </td>
				                   <td>${listPost.getCreateTime() }</td>
				                  <td>
				                  	 <a href="<c:url value ="/edit/${listPost.getIdPost()}"></c:url>" title="Edit"><i class="fa fa-edit"></i></a>
					                    <a href="<c:url value ="/comment/${listPost.getIdPost()}"></c:url>"><i class="fa fa-search-plus"></i></a>
					                    <a href="<c:url value ="/delete/${listPost.getIdPost()}"></c:url>"  onclick="if (!(confirm('Are you sure you want to delete ?'))) return false"><i class="fa fa-trash text-danger"></i></a>
				                  </td>
				                </tr>
                		</c:forEach>
                	</c:when>
                	<c:otherwise>
                	 <tr>
	                  <td scope="col" rowspan="4">Emty</td>
	                </tr>
                	</c:otherwise>
                </c:choose>
              </tbody>
            </table>
            
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
             <a href='<c:url value = "/commentmm"/>'>Approve Comments <span> (0)</span></a>
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