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
					<h1 class="h3 mb-4 text-gray-800">Write Notice</h1>
					<p>This page is to write notice</p>

	

						<!-- enroll product form -->
						<form method="post" name="enrollform" enctype="multipart/form-data" action="admin_enroll_product">
							<div><!-- class="col-lg-6" -->
								<div class="card shadow mb-4">
									<div class="card-header py-3">
										<h6 class="m-0 font-weight-bold text-primary">Write Notice</h6>
									</div>
									<div class="card-body">
										<div class="form-group">
											Title <input type="text"
												class="form-control form-control-user" id="title" name="title"
												placeholder="Title">
										</div>
										<div class="form-group">
										Kind
										<select name="kind" class="form-control form-control-user">
											<c:forEach items="${kindList }" var="kind">
												<option value="${kind}">${kind}</option>
											</c:forEach>
										</select>
										</div>
									</div>
								</div>
							</div>
							
							<div>
								<div class="card shadow mb-4">
									<div class="card-body">
										<div class="form-group">
											Main Pciture <br>
											<input class="form-control form-control-user" type="file" 
											name="notice_image" id="notice_image" onchange="setThumbnail(event);"  multiple="multiple"/>
										</div>
										
										<div id="image_container"></div>
										
										<div class="form-group">
											Content
											<textarea rows="6" id="content" name="content"
												class="form-control form-control-user"></textarea>
										</div>
										<div class="form-group">
											<input type="button" class="btn btn-primary btn-user btn-block" value="enroll" onclick="noticecheck()"/>
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
		for(var image of event.target.files){
			var reader = new FileReader();
			
			reader.onload = function(event){
				var img = document.createElement("img");
				img.setAttribute("src", event.target.result);
				img.setAttribute("class", "col-lg-6");
				document.querySelector("div#image_container").appendChild(img);
			};
			
			console.log(image);
			reader.readAsDataURL(image);
		}
	}
	</script>
	
	<script type="text/javascript">
	function noticecheck(){
		var Form = document.enrollform;
		if(Form.title.value==""){
			alert("Please enter a title");
			return Form.title.focus();
		}else {
			Form.action = "admin_write_notice";
			Form.submit();
		}
	}
	</script>
<%@include file="../footer.jsp"%>