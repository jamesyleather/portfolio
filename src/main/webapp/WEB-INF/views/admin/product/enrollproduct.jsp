<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enroll Product</title>
</head>
<body>
	<div id="wrapper">
<%@include file="../sidebar.jsp"%>
		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">
			

			<!-- Main Content -->
			<div id="content">
				<%@include file="../topbar.jsp"%>

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<h1 class="h3 mb-4 text-gray-800">Enroll Product</h1>
					<p>This page is to enroll product</p>

	

						<!-- enroll product form -->
						<form method="post" name="enrollform" enctype="multipart/form-data" action="admin_enroll_product">
							<div><!-- class="col-lg-6" -->
								<div class="card shadow mb-4">
									<div class="card-header py-3">
										<h6 class="m-0 font-weight-bold text-primary">enroll
											product</h6>
									</div>
									<div class="card-body">
										<div class="form-group">
											Name <input type="text"
												class="form-control form-control-user" id="name" name="name"
												placeholder="Product Name">
										</div>
										<div class="form-group">
										Kind
										<select name="kind" class="form-control form-control-user">
											<c:forEach items="${kindList }" var="kind">
												<option value="${kind}">${kind}</option>
											</c:forEach>
										</select>
										</div>
										<div class="form-group">
											Cost <input type="text"
												class="form-control form-control-user" id="price1"
												name="price1" placeholder="cost">
										</div>
										<div class="form-group">
											Selling price <input type="text"
												class="form-control form-control-user" id="price2"
												name="price2" placeholder="Selling price">
										</div>
										
									</div>
								</div>
							</div>
							
							<div>
								<div class="card shadow mb-4">
									<div class="card-body">
										<div class="form-group">
											Main Picture <br>
											<input class="form-control form-control-user" type="file" 
											name="product_image" id="product_image" onchange="setThumbnail(event);">
										</div>
										
										<div id="image_container"></div>
										
										<div class="form-group">
											Detail Picture <br>
											<input class="form-control form-control-user" type="file" multiple="multiple"
											name="product_detail_image" id="product_detail_image" onchange="setDetailImage(event);">
										</div>
										
										<div id="images_container"></div>
										
										
										
										<div class="form-group">
											Content
											<textarea rows="6" id="content" name="content"
												class="form-control form-control-user"></textarea>
										</div>
										<div class="form-group">
											<input type="button" class="btn btn-primary btn-user btn-block" value="enroll" onclick="enrollcheck()"/>
										</div>
									</div>
								</div>
							</div>
						</form>
				</div>
				<!-- End Page Content -->
			</div>
			<!-- End Main Content -->
		</div>
		<!-- End Content Wrapper -->
	</div>
	
	<!-- 이미지 미리보기 -->
	<script>
	function setThumbnail(event){
		var reader = new FileReader();
		
		reader.onload = function(event){
			var img = document.createElement("img");
			img.setAttribute("src", event.target.result);
			img.setAttribute("class", "col-lg-6");
			document.querySelector("div#image_container").appendChild(img);
		};
		
		reader.readAsDataURL(event.target.files[0]);
	}
	</script>
	
	<script>
		function setDetailImage(event){
			for(var image of event.target.files){
				var reader = new FileReader();
				
				reader.onload = function(event){
					var img = document.createElement("img");
					img.setAttribute("src", event.target.result);
					img.setAttribute("class", "col-lg-6");
					document.querySelector("div#images_container").appendChild(img);
				};
				
				console.log(image);
				reader.readAsDataURL(image);
			}
		}
	</script>
<%@include file="../footer.jsp"%>