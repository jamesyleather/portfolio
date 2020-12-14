<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Detail View</title>
</head>
<body>
	<!-- Wrapper -->
	<div id="wrapper">
		<%@include file="../sidebar.jsp"%>

		<!-- content-wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- main content -->
			<div id="content">
				<%@include file="../topbar.jsp"%>

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<h1 class="h3 mb-4 text-gray-800">Product Detail</h1>

					<form name="detailform">
						<div class="row">

							<div class="col-lg-6">
								<div class="card mb-4 py-3">
									<div class="card-body">
										<c:choose>
											<c:when test="${product.image == null }">
												<img src="product_images/default.jpg">
											</c:when>
											<c:otherwise>
												<img src="product_images/${product.image }" class="col-lg-12">
											</c:otherwise>
										</c:choose>
									</div>
								</div>
							</div>

							<div class="col-lg-6">
								<div class="card mb-4 py-3">
									<div class="card-body">
										name
										<h1 class="h3 mb-1 text-gray-800">${product.name }</h1>
										${product.kind }
										<hr>
										cost : ${product.price1 }<br> sale price :
										${product.price2 }<br> profit : ${product.price3 }
										<hr>
										status :
										<c:choose>
											<c:when test="${product.useyn == 'n' }">판매취소</c:when>
											<c:otherwise>판매중</c:otherwise>
										</c:choose>
										<hr>
										Date : ${product.regdate }
										<hr>
										<input type="hidden" name="prodnum"
											value="${product.prodnum }">
										<div class="form-group">
											<input type="button" class="btn btn-info btn-user btn-block"
												onclick="modifyProduct()" value="modify">
										</div>
										<div class="form-group">
											<input type="button"
												class="btn btn-secondary btn-user btn-block"
												onclick="productList()" value="Product List">
										</div>
									</div>
								</div>
							</div>

						</div>

						<div class="row">
							<div class="col-lg-12">
								<div class="card mb-4 py-3">
									<div class="card-body"><pre>${product.content }</pre></div>
									<c:forEach items="${productDetailImage }" var="detailImage">
										<c:if test="${detailImage.detail_image != null }">
											<img src="product_images/${detailImage.detail_image }"
											 class="col-lg-8 center-block">
										</c:if>
									</c:forEach>
								</div>
							</div>
						</div>
					</form>
				</div>
				<!-- End Page Content -->
			</div>
			<!-- end main content -->
		</div>
		<!-- end content-wrapper -->
	</div>
	<!-- End Wrapper -->
	<script type="text/javascript">
		function modifyProduct() {
			document.detailform.action = "admin_modify_product?"
					+ document.detailform.prodnum.value;
			document.detailform.submit();
		}
		
		function productList(){
			document.detailform.action = "admin_product_list";
			document.detailform.submit();
		}
	</script>
	<%@include file="../footer.jsp"%>