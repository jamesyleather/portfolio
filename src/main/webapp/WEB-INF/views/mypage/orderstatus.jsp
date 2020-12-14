<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../header.jsp"%>
<html>
<head>
<title>Jamesy Leather Product</title>
</head>
<body>
	<!-- Page Content -->
	<div class="container">

		<!-- Page Heading/Breadcrumbs -->
		<h1 class="my-4">${loginUser.name }'s Order Status</h1>
		<form name="form" method="post">
			<!-- cart List -->

			<div class="row">
				<div class="col-lg-12">
					<div class="card h-100">
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr align="center">
											<th>order date</th>
											<th>order no.</th>
											<th>name</th>
											<th>price</th>
											<th>order info</th>
											<th>status</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${orderList }" var="order">
											<tr id="cartRow">
												<td><fmt:formatDate value="${order.indate }"
														type="date" /></td>
												<td>${order.ordernum }</td>
												<td>${order.pname }</td>
												<td><fmt:formatNumber type="currency" value="${order.price2}"/></td>
												<td><a href="order_detail?ordernum=${order.ordernum }">View</a></td>
												<td>
													<c:choose>
														<c:when test="${order.result == '1' }">
															<label class="text-danger">before delivery</label>
														</c:when>
														<c:otherwise>
															<label class="text-info">after delivery</label>
														</c:otherwise>
													</c:choose>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>

			<ol class="breadcrumb">
				<li class="breadcrumb-item"><input type="button"
					class="btn btn-secondary" value="keep shopping"
					onclick="keep_shopping()"></li>
			</ol>

			<!-- end cart List -->
		</form>
		<div id="ex1_result"></div>

	</div>
	<!-- end page content -->

	<script>
		function keep_shopping() {
			document.form.action = "category";
			document.form.submit();
		}
	</script>


	<%@ include file="../footer.jsp"%>