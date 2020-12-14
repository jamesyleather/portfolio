<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jamesy Order List</title>
</head>
<body>
	<div id="wrapper">

		<!-- Coontent Wrapper -->
		<div id="content-wrapper" class="d-flex felx-cloumn">
			<%@include file="../sidebar.jsp"%>

			<!-- Main Content -->
			<div id="content">
				<%@include file="../topbar.jsp"%>

				<!-- Begin Page Content -->
				<div class="container" style="width:100%">

					<!-- Page Heading -->
					<h1 class="h3 mb-2 text-grey-800">Order</h1>
					<p>Order List</p>

					<form name="form" method="post">
						<!-- DataTable -->
						<div class="card shadow mb-4">
							<div class="card-header py-3">
								<h6 class="m-0 font-weight-bold text-primary">Order List</h6>
							</div>
							<div class="card-body">
								<div class="table-respnsive">
									<table class="table table-bordered" id="dataTable">
										<thead>
											<tr>
												<th style="width:10%">status</th>
												<th style="width:8%">no.</th>
												<th style="width:10%">Orderer</th>
												<th style="width:10%">Product</th>
												<th style="width:8%">Quantity</th>
												<th style="width:40%">zip code & address</th>
												<th style="width:12.5%">phone</th>
												<th style="width:12.5%">date</th>
											</tr>
										</thead>
										<tfoot>
											<tr>
												<th><input type="button" class="btn btn-info" value="delivery" onclick="start_delivery()"></th>
												<th>no.</th>
												<th>Orderer</th>
												<th>Product</th>
												<th>Quantity</th>
												<th>post code & address</th>
												<th>phone</th>
												<th>date</th>
											</tr>
										</tfoot>
										<tbody>
											<c:forEach items="${orderList }" var="order">
												<tr>
													<td><c:choose>
															<c:when test="${order.result==1 }">
																<div class="form-group">
																	<div class="custom-control custom-checkbox small">
																		<input type="checkbox" class="custom-control-input"
																			id="customCheck${order.odnum }" name="ordernum"
																			value="${order.odnum }"> <label
																			class="custom-control-label text-danger"
																			for="customCheck${order.odnum }">Preparing product</label>
																	</div>
																</div>
															</c:when>
															<c:otherwise>
																<div class="form-group">
																	<div class="custom-control custom-checkbox small">
																		<input type="checkbox" class="custom-control-input"
																			id="customCheck${order.odnum }" name="ordernum"
																			value="${order.odnum }"> <label
																			class="custom-control-label text-info"
																			for="customCheck${order.odnum }">Delivery completed</label>
																	</div>
																</div>
															</c:otherwise>
														</c:choose>
													</td>
													<td>${order.ordernum }</td>
													<td>${order.mname}</td>
													<td>${order.pname}</td>
													<td>${order.quantity }</td>
													<td>(${order.zip_code }) ${order.address }</td>
													<td>${order.phone }</td>
													<td><fmt:formatDate value="${order.indate }" pattern="yy.MM.dd hh:mm"/></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								<%@include file="order_paging.jsp" %>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%@include file="../footer.jsp"%>