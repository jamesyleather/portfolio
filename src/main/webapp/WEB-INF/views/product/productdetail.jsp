<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../header.jsp"%>
<html>
<head>
<title>Jamesy Leather Product</title>
</head>
<body>
	<!-- Page Content -->
	<div class="container">

		<h1 class="my-4">${productVO.name }</h1>

		<!-- Product detail -->
		<div class="row">

			<div class="col-lg-6 mb-6">
				<div class="card h-100">
					<div class="card-body">
						<img src="product_images/${productVO.image }" class="col-lg-12">
					</div>
				</div>
			</div>
			<form class="col-lg-6 mb-6" method="post" name="form">
				<input type="hidden" name="prodnum" id="prodnum"
					value="${productVO.prodnum }">

				<div class="card h-100">
					<div class="card-body">
						<h5 class="my-4">${productVO.name }</h5>
						views : ${productVO.viewnum }
						<hr>
						<label class="breadcrumb-item active">(Price Info)</label><br>
						<fmt:formatNumber type="number" pattern="#,###"
							value="${productVO.price2 }" />
						won
						<hr>
						<div class="form-group">
							<input type="number" min="1" max="50" name="quantity"
								id="quantity" class="form-control" value="1">
						</div>
						<div class="row">
						
						<!--  
							<div class="form-group col-lg-6">
								<input type="button" class="btn btn-primary form-control"
									value="order" onclick="orderAction()">

							</div>
							-->
							
							<div class="form-group">
								<input type="button" class="btn btn-lg btn-secondary btn-block text-uppercase"
									value="cart" onclick="cartAction()" />
							</div>
						</div>

					</div>
				</div>

			</form>
		</div>
		<!-- end product detail -->

		<!-- product content row -->
		<div class="row">
			<div class="col-lg-12 mb-12">
				<div class="card h-100">
					<div class="card-body">
						<h4 class="card-title">Info</h4>
						<pre>${productVO.content }</pre>

						<c:forEach items="${productDetailImage }" var="detailImage">
							<c:if test="${detailImage.detail_image != null }">
								<img src="product_images/${detailImage.detail_image }"
									class="col-lg-8 center-block">
							</c:if>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end page content -->

	<%@ include file="../footer.jsp"%>