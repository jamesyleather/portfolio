<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jamesy Product List</title>
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
				<h1 class="h3 mb-2 text-grey-800">Product</h1>
				<p>DataTables is a third party plugin that is used to generate the demo table below.
                        For more information about DataTables, please visit the </p>
                
                <!-- DataTable -->
                <div class="card shadow mb-4">
                	<div class="card-header py-3">
                		<h6 class="m-0 font-weight-bold text-primary">Product List</h6>
                	</div>
                	<div class="card-body">
                		<div class="table-respnsive col-lg-12">
                			<table class="table table-bordered" id="dataTable" width="100%" cellsapcing="0">
                				<thead>
                					<tr>
                						<th>No.</th>
                						<th>Name</th>
                						<th>Kind</th>
                						<th>Price</th>
                						<th>Status</th>
                						<th>Date</th>
                					</tr>
                				</thead>
                				<tfoot>
                					<tr>
                						<th>No.</th>
                						<th>Name</th>
                						<th>Kind</th>
                						<th>Price</th>
                						<th>Status</th>
                						<th>Date</th>
                					</tr>
                				</tfoot>
                				<tbody>
                					<c:forEach items="${productList }" var="productList">
                						<tr>
                							<td>${productList.prodnum }</td>
                							<td><a href="admin_product_detail?prodnum=${productList.prodnum }">${productList.name }</a></td>
                							<td>${productList.kind }</td>
                							<td><fmt:formatNumber value="${productList.price2 }"/></td>
                							<td>
                								<c:choose>
                									<c:when test="${productList.useyn == 'n' }"><span class="text-danger">판매취소</span></c:when>
                									<c:otherwise><label class="text-info">판매중</label></c:otherwise>
                								</c:choose>
                							</td>
                							<td><fmt:formatDate value="${productList.regdate }"/></td>
                						</tr>
                					</c:forEach>
                				</tbody>
                			</table>
                		</div>
                		<%@include file="product_paging.jsp" %>
                	</div>
                </div>
			</div>
		</div>
		
	</div>
	
</div>

<%@include file="../footer.jsp"%>