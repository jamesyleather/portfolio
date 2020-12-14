<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../header.jsp"%>
<html>
<head>
<title>Jamesy Leather Notice</title>
</head>
<body>
	<!-- Page Content -->
	<div class="container">

		<!-- Page Heading/Breadcrumbs -->
		<h1 class="mt-4 mb-3">Notice</h1>
		<form name="form">
			<!-- cart List -->

			<div class="row">
				<div class="card h-100 col-lg-12">
					<div class="card-body">
						<div class="table-responsive">
							<table class="table table-bordered" id="dataTable" width="100%"
								cellspacing="0">
								<thead>
									<tr align="center">
										<th>no.</th>
										<th>title</th>
										<th>id</th>
										<th>date</th>
									</tr>
								</thead>
								<tfoot>
									<tr align="right">
										<th>no.</th>
										<th>title</th>
										<th>id</th>
										<th>date</th>
									</tr>
								</tfoot>
								<tbody>
									<c:forEach items="${noticeList }" var="notice">
										<tr>
											<td>${notice.noticenum }</td>
											<td><a href="notice_detail?noticenum=${notice.noticenum }">[${notice.kind}]${notice.title }</a></td>
											<td>${notice.id }</td>
											<td><fmt:formatDate value="${notice.indate }" pattern="yyyy-MM-dd"/></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<%@include file="notice_paging.jsp" %>
					</div>
				</div>
			</div>
			<!-- end cart List -->
		</form>
	</div>
	<!-- end page content -->
	<%@ include file="../footer.jsp"%>