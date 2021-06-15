<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<jsp:include page="Header.jsp"></jsp:include>


<div class="container mb-6">
	<div class="row">
		<div class="col-md-9">
			<c:forEach var="post" items="${listPost}">
				<p class="h2 mt-5 font-weight-bold font-italic">${post.getTitle()}</p>
				<hr>
				<p class="font-italic">
					Posted by <span class="font-weight-bold">${post.getUser().getUserName()}</span> on  <span>${post.getCreateTime()}</span>
				</p>
				
				<p>${post.getContent()}</p>

				<div class="" style="background-color: rgba(128, 128, 128, 0.089);">
					<p class="ml-3 pt-2">
						Tags:  <a href="#">${post.getTags()}</a>
					</p>
					<div class="ml-3 pb-2">
						<a href="#">Permalink</a> |
						<a href="#">Comment (<span>0</span>)</a> |
						<span class="font-italic">Last update on ${post.getUpdateTime()}</span>
					</div>
				</div>
			</c:forEach>
		</div>
		
		<div class="col-md-3 ">
			<div class="row mt-5" style="margin-bottom: 20px">
				<div class="col-12 ">
					<p
						style="background-color: #a1c4fd; border-radius: 2px; padding: 4px">
						<Strong class="ml-2">Tag</Strong>
					</p>
				</div>

				<div class="col-12">
					<!-- Chỗ này foreach để hiển thị ra các tag -->
					<a href="#" class="ml-2">blog</a> <a href="#">test</a>
				</div>
			</div>

			<div class="row " style="margin-bottom: 20px">
				<div class="col-12">
					<p
						style="background-color: #a1c4fd; border-radius: 2px; padding: 4px">
						<Strong class="ml-2">Recent Comments</Strong>
					</p>
				</div>

				<div class="col-12">
					<span class="ml-2">Tester on </span><a href="#">A Test Post</a>

				</div>
			</div>
		</div>
	</div>


</div>

<jsp:include page="Footer.jsp"></jsp:include>