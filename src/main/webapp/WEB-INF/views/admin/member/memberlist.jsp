<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jamesy Member List</title>
</head>
<body>
<div id="wrapper">
	
	<!-- Coontent Wrapper -->
	<div id="content-wrapper" class="d-flex felx-cloumn">
		<%@include file="../sidebar.jsp" %>
		
		<!-- Main Content -->
		<div id="content">
			<%@include file="../topbar.jsp" %>
			
			<!-- Begin Page Content -->
			<div class="container-fluid">
				
				<!-- Page Heading -->
				<h1 class="h3 mb-2 text-grey-800">Member</h1>
				<p>This page displays a list of members that manage them.</p>
                
                <!-- DataTable -->
                <div class="card shadow mb-4">
                	<div class="card-header py-3">
                		<h6 class="m-0 font-weight-bold text-primary">Member List</h6>
                	</div>
                	<div class="card-body">
                		<div class="table-respnsive col-lg-12">
                			<table class="table table-bordered" id="dataTable" width="100%" cellsapcing="0">
                				<thead>
                					<tr>
                						<th>ID</th>
                						<th>Name</th>
                						<th>Address</th>
                						<th>Phone</th>
                						<th>Date</th>
                						<th>Status</th>
                					</tr>
                				</thead>
                				<tfoot>
                					<tr>
                						<th>ID</th>
                						<th>Name</th>
                						<th>Address</th>
                						<th>Phone</th>
                						<th>Date</th>
                						<th>Status</th>
                					</tr>
                				</tfoot>
                				<tbody>
                					<c:forEach items="${userList }" var="user">
                						<tr onclick="location.href='#';" style="cursor:pointer;">
                							<td>${user.id }</td>
                							<td>${user.name }</td>
                							<td>(${user.zip_code })${user.address }</td>
                							<td>${user.phone }</td>
                							<td><fmt:formatDate value="${user.regdate }"/></td>
                							<td>
                								<c:choose>
                									<c:when test="${user.useyn == 1 }">
                										<label class="text-info">active member</label>
                									</c:when>
                									<c:otherwise>
                										<label class="text-danger">withdrawal member</label>
                									</c:otherwise>
                								</c:choose>
                							</td>
                						</tr>
                					</c:forEach>
                				</tbody>
                			</table>
                		</div>
                		<%@include file="member_paging.jsp" %>
                	</div>
                </div>
			</div>
		</div>
		
	</div>
	
</div>

<%@include file="../footer.jsp"%>