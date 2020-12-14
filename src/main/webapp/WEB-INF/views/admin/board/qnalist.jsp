<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jamesy Q & A List</title>
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
				<h1 class="h3 mb-2 text-grey-800">Q & A</h1>
				<p>Consult with customers about inconvenience. </p>
                
                <!-- DataTable -->
                <div class="card shadow mb-4">
                	<div class="card-header py-3">
                		<h6 class="m-0 font-weight-bold text-primary">Q & A List</h6>
                	</div>
                	<div class="card-body">
                		<div class="table-respnsive">
                			<table class="table table-bordered" id="dataTable" width="100%" cellsapcing="0">
                				<thead>
                					<tr>
                						<th>No.</th>
                						<th>subject</th>
                						<th>ID</th>
                						<th>rep</th>
                						<th>Date</th>
                						<th>Kind</th>
                					</tr>
                				</thead>
                				<tfoot>
                					<tr>
                						<th>No.</th>
                						<th>subject</th>
                						<th>ID</th>
                						<th>rep</th>
                						<th>Date</th>
                						<th>Kind</th>
                					</tr>
                				</tfoot>
                				<tbody>
                					<c:forEach items="${qnaList }" var="qna">
                						<tr>
                							<td>${qna.qnanum }</td>
                							<td><a href="admin_qna_detail?qnanum=${qna.qnanum }">${qna.subject }</a></td>
                							<td>${qna.id }</td>
                							<td>
                								<c:choose>
                									<c:when test="${qna.rep=='1' }"><span class="text-danger">No Answer</span></c:when>
                									<c:otherwise><span class="text-info">Answer Complete</span></c:otherwise>
                								</c:choose>
                							</td>
                							<td>
                								<fmt:formatDate value="${qna.indate }" pattern="yyyy-MM-dd"/>
                							</td>
                							<td>${qna.kind }</td>
                						</tr>
                					</c:forEach>
                				</tbody>
                			</table>
                		</div>
                		<%@include file="qna_paging.jsp" %>
                	</div>
                </div>
			</div>
		</div>
	</div>
</div>
<%@include file="../footer.jsp"%>