<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modify Product</title>
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
					<h1 class="h3 mb-4 text-gray-800">Modify Product</h1>

					<form name="updateform" method="post" aciton="admin_update_product" enctype="multipart/form-data">
						<div class="row">

							<div class="col-lg-6">
								<div class="card mb-4 py-3">
									<div class="card-body">
										<c:choose>
										<c:when test="${product.image == null }">
											<img src="product_images/default.jpg" class="col-lg-12">
										</c:when>
										<c:otherwise>
											<img src="product_images/${product.image }" class="col-lg-12">
										</c:otherwise>
									</c:choose>	
									<div class="form-group">
									<input type="file" id="product_image" name="product_image" class="form-control form-control-user">
									</div>
									</div>
								</div>
							</div>

							<div class="col-lg-6">
								<div class="card mb-4 py-3">
									<div class="card-body">
										name
										<h1 class="h3 mb-1 text-gray-800">${product.name }</h1>
										<div class="form-group">
											<input type="text" class="form-control form-control-user"
												name="name" id="name" value="${product.name }">
										</div>
										<div class="form-group">
											Kind <select name="kind"
												class="form-control form-control-user">
												<c:forEach items="${kindList }" var="kind">
													<option value="${kind}">${kind}</option>
												</c:forEach>
											</select>
										</div>
										<hr>
										cost
										<div class="form-group">
											<input type="text" class="form-control form-control-user"
												name="price1" id="price1" value="${product.price1 }">
										</div>
										<br> sale price
										<div class="form-group">
											<input type="text" class="form-control form-control-user"
												name="price2" id="price2" value="${product.price2 }">
										</div>
										<hr>
										status :
										<c:choose>
											<c:when test="${product.useyn == 'n' }">
												<div class="form-group">
													<input type="radio" name="useyn" value="y"> 판매중 <input
														type="radio" name="useyn" value="n" checked> 판매취소
												</div>
											</c:when>
											<c:otherwise>
												<div class="form-group">
													<input type="radio" name="useyn" value="y" checked>
													판매중 <input type="radio" name="useyn" value="n">
													판매취소
												</div>
											</c:otherwise>
										</c:choose>
										<hr>
										Date : ${product.regdate } <input type="hidden" name="prodnum"
											value="${product.prodnum }">
										<hr>

										
									</div>
								</div>
							</div>

						</div>

						<div class="row">
							<div class="col-lg-12">
								<div class="card mb-4 py-3">
									<div class="card-body">
										<div class="form-group">
											Content
											<textarea rows="6" id="content" name="content"
												class="form-control form-control-user">${product.content }</textarea>
										</div>
										<div class="form-group">
											<input type="button" class="btn btn-info btn-user btn-block"
											onclick="updateProduct()" value="update">
										</div>
										<div class="form-group">
											<input type="button" class="btn btn-secondary btn-user btn-block"
											onclick="productList()" value="Product List">
										</div>
									</div>
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
		function updateProduct() {
			document.updateform.action = "admin_update_product";
			document.updateform.submit();
		}
		
		function productList(){
			document.updateform.action = "admin_product_list";
			document.updateform.submit();
		}
	</script>
	<%@include file="../footer.jsp"%>