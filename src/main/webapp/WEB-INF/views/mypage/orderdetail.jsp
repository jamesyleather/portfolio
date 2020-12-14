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
		<h1 class="my-4">${loginUser.name }'s Order Detail</h1>
		<form name="form" method="post">

			<!-- user info -->
			<div class="row">
				<div class="card h-100">
					<div class="card-body">
						<div class="table-responsive">
							<table class="table table-bordered" id="dataTable" width="100%"
								cellspacing="0">
								<thead>
									<tr>
										<th>order date</th>
										<th>order no.</th>
										<th>orderer</th>
										<th>total price</th>
									</tr>
								</thead>
								<tr>
									<td><fmt:formatDate value="${orderDetail.indate }"
											type="date" /></td>
									<td>${orderDetail.ordernum }</td>
									<td>${orderDetail.mname }</td>
									<td><fmt:formatNumber type="currency"
											value="${totalPrice }" /></td>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>

			<!-- order List -->
			<div class="row">
				<div class="col-lg-12">
					<div class="card h-100">
						<h4 class="card-header">order product info</h4>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr align="center">
											<th>product</th>
											<th>product no.</th>
											<th>quantity</th>
											<th>price</th>
											<th>status</th>
										</tr>
									</thead>
									<tfoot>
										<tr align="right">
											<th></th>
											<th></th>
											<th></th>
											<th></th>
											<th>Order Success</th>
										</tr>
									</tfoot>
									<tbody>
										<c:forEach items="${orderList }" var="order">
											<tr id="cartRow">
												<td>${order.pname }</td>
												<td>${order.ordernum }</td>
												<td>${order.quantity }</td>
												<td><fmt:formatNumber type="currency"
														value="${order.price2 * order.quantity }" /></td>
												<td><c:choose>
														<c:when test="${order.result=='1'}"> <label class="text-danger">before delivery</label></c:when>
														<c:otherwise><label class="text-info">after delivery</label></c:otherwise>
													</c:choose></td>
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
					class="btn btn-info" value="order list" onclick="history.back()"></li>
				<li class="breadcrumb-item"><input type="button"
					class="btn btn-secondary" value="keep shopping"
					onclick="keep_shopping()"></li>
			</ol>

			<!-- end cart List -->
		</form>
		<div id="ex1_result"></div>

	</div>
	<!-- end page content -->

	<!-- go shopping list -->
	<script>
		function keep_shopping() {
			document.form.action = "category";
			document.form.submit();
		}
	</script>

	<%@ include file="../footer.jsp"%>