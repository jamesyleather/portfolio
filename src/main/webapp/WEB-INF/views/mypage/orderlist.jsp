<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../header.jsp"%>
<html>
<head>
<title>Jamesy Leather Product</title>
</head>
<body>
	<!-- Page Content -->
	<div class="container">

		<!-- Page Heading/Breadcrumbs -->
		<h1 class="mt-4 mb-3">${loginUser.name }'s Order Status</h1>
		<form name="form" method="post">
			<!-- cart List -->

			<div class="row">
				<div class="card h-100">
					<div class="card-body">
						<div class="table-responsive">
							<table class="table table-bordered" id="dataTable" width="100%"
								cellspacing="0">
								<thead>
									<tr align="center">
										<th><input type="checkbox"></th>
										<th>image</th>
										<th>name</th>
										<th>price</th>
										<th>status</th>
									</tr>
								</thead>
								<tfoot>
									<tr align="right">
										<th></th>
										<th></th>
										<th>total</th>
										<th>${totalPrice }</th>
										<th>주문 처리 완료</th>
									</tr>
								</tfoot>
								<tbody>
									<c:forEach items="${orderList }" var="order">
										<tr id="cartRow">
											<td><input type="checkbox" id="ordernum" name="ordernum"
												value="${order.ordernum }"></td>
											<td width="15%"><img src="product_images/${order.image }"
												class="col-lg-12"></td>
											<td width="70%" align="center">${order.pname }</td>
											<td>${order.price2 * order.quantity }</td>
											<td> 처리 진행 중 </td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><input type="button"
					class="btn btn-danger" value="delete" onclick="delete_cartlist()"></li>
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
	function keep_shopping(){
		document.form.action = "category";
		document.form.submit();
	}
	</script>


	<%@ include file="../footer.jsp"%>