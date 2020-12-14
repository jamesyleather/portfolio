<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jamesy Notice List</title>
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
				<h1 class="h3 mb-2 text-grey-800">Notice</h1>
				<p>This page is where you can view the announcement. </p>
                
                <!-- DataTable -->
                <div class="card shadow mb-4">
                	<div class="card-header py-3">
                		<h6 class="m-0 font-weight-bold text-primary">Notice List</h6>
                		
                	</div>
                	<div class="card-body">
                	<a class="btn btn-info pull-right" href="admin_write_notice_form">Write Notice</a>
                		<div class="table-respnsive">
                			<table class="table table-bordered" id="dataTable" width="100%" cellsapcing="0">
                				<thead>
                					<tr>
                						<th>No.</th>
                						<th>title</th>
                						<th>writer</th>
                						<th>Date</th>
                					</tr>
                				</thead>
                				<tfoot>
                					<tr>
                						<th>No.</th>
                						<th>title</th>
                						<th>writer</th>
                						<th>Date</th>
                					</tr>
                				</tfoot>
                				<tbody>
                					<c:forEach items="${noticeList }" var="noticeList">
                						<tr>
                							<td>${noticeList.noticenum }</td>
                							<td><a href="admin_notice_detail?noticenum=${noticeList.noticenum }">[${noticeList.kind}]${noticeList.title }</a></td>
                							<td>${noticeList.id }</td>
                							<td><fmt:formatDate value="${noticeList.indate }"/></td>
                						</tr>
                					</c:forEach>
                				</tbody>
                			</table>
                		</div>
                		<%@include file="notice_paging.jsp" %>
                	</div>
                </div>
			</div>
		</div>
		
	</div>
	
</div>

<%@include file="../footer.jsp"%>