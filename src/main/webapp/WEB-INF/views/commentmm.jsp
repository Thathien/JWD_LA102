<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
    <jsp:include page="Header.jsp"></jsp:include>
    
    <div class="container p-3 ">
            <p class="h2"> Comment Management</p>
            <p>sfhafhabfhjabdhabdhba</p>

		<div class="row">
		
            <div class="col-md-8">
            <p class="h6 text-uppercase">List comment Approve</p>
             <table class="table table-hover">
              <thead class="thead-dark">
                <tr>
                  <th scope="col">#</th>
                  <th scope="col">Content</th>
                  <th scope="col">Author</th>
                  <th scope="col">Create Time</th>
                  <th scope="col">Email</th>
                   <th scope="col">Link</th>
                   <th scope="col">Status</th>
                  <th scope="col">Action</th>
                </tr>
              </thead>
              <tbody>
              
                <c:choose>
                	<c:when test="${listCommnet.size()>0 }">
                	 	<c:forEach var="listCommnet" items="${listCommnet }">
                	 	<c:if test="${listCommnet.getStatus()=='published' || listCommnet.getStatus()=='visible' || listCommnet.getStatus()=='outdated'}">
                	 			<tr>
				                  <th scope="row">${listCommnet.getIdComment()}</th>
				                  <td>${listCommnet.getContent()}</td>
				                  <td>${listCommnet.getAuthor()}</td>
				                  <td>${listCommnet.getCreate_time()}</td>
				                  <td>${listCommnet.getEmail()}</td>
				                  <td>${listCommnet.getUrl()}</td>
				                  <td>
				                  	<c:choose>
				                  		<c:when test="${listCommnet.getStatus()=='published'}">
				                  			<c:out value="Published to public"></c:out>
				                  		</c:when>
				                  		<c:when test="${listCommnet.getStatus()=='visible'}">
				                  			<c:out value="draft and is not visible to public"></c:out>
				                  		</c:when>
				                  		<c:when test="${listCommnet.getStatus()=='outdated'}">
				                  			<c:out value="outdated and is not visible in the post list"></c:out>
				                  		</c:when>
				                  		<c:otherwise>
				                  			<c:out value="No Identify"></c:out>
				                  		</c:otherwise>
				                  	</c:choose>
				                  </td>
				                  <td>
				                  	
<%-- 					                    <a href="<c:url value ="/aprovecomment/${listCommnet.getIdComment()}"></c:url>"   onclick="if (!(confirm('Are you sure you want to apvove commnent ?'))) return false"><i class="fa fa-check"></i></i></a> --%>
					                    <a href="<c:url value ="/deletecomment/${listCommnet.getIdComment()}"></c:url>"  onclick="if (!(confirm('Are you sure you want to delete ?'))) return false"><i class="fa fa-trash text-danger"></i></a>
				                  </td>
				                </tr>
                	 			</c:if>
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
                        <p class="h6 text-uppercase text-danger">List comment NOT Approve</p>
             <table class="table table-hover">
              <thead class="thead-dark">
                <tr>
                  <th scope="col">#</th>
                  <th scope="col">Content</th>
                  <th scope="col">Author</th>
                  <th scope="col">Create Time</th>
                  <th scope="col">Email</th>
                   <th scope="col">Link</th>
                   <th scope="col">Status</th>
                  <th scope="col">Action</th>
                </tr>
              </thead>
              <tbody>
              
                <c:choose>
                	<c:when test="${listCommnet.size()>0 }">
                	 	<c:forEach var="listCommnet" items="${listCommnet }">
                	 			<c:if test="${listCommnet.getStatus()!='published' && listCommnet.getStatus()!='visible' && listCommnet.getStatus()!='outdated'}">
                	 			<tr>
				                  <th scope="row">${listCommnet.getIdComment()}</th>
				                  <td>${listCommnet.getContent()}</td>
				                  <td>${listCommnet.getAuthor()}</td>
				                  <td>${listCommnet.getCreate_time()}</td>
				                  <td>${listCommnet.getEmail()}</td>
				                  <td>${listCommnet.getUrl()}</td>
				                  <td>
				                  	<c:choose>
				                  		<c:when test="${listCommnet.getStatus()=='published'}">
				                  			<c:out value="Published to public"></c:out>
				                  		</c:when>
				                  		<c:when test="${listCommnet.getStatus()=='visible'}">
				                  			<c:out value="draft and is not visible to public"></c:out>
				                  		</c:when>
				                  		<c:when test="${listCommnet.getStatus()=='outdated'}">
				                  			<c:out value="outdated and is not visible in the post list"></c:out>
				                  		</c:when>
				                  		<c:otherwise>
				                  			<c:out value="No Identify"></c:out>
				                  		</c:otherwise>
				                  	</c:choose>
				                  </td>
				                  <td>
					                    <a href="<c:url value ="/aprovecomment/${listCommnet.getIdComment()}"></c:url>"   onclick="if (!(confirm('Are you sure you want to aprove comment ?'))) return false"><i class="fa fa-check"></i></a>
					                    <a href="<c:url value ="/deletecomment/${listCommnet.getIdComment()}"></c:url>"  onclick="if (!(confirm('Are you sure you want to delete ?'))) return false"><i class="fa fa-trash text-danger"></i></a>
				                  </td>
				                </tr>
                	 			</c:if>
                	 			
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