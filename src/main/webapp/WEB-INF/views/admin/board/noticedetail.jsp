<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notice Detail View</title>
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
					<h1 class="h3 mb-4 text-gray-800">Notice Detail</h1>

					<form name="detailform">
						<div class="row">
							<div class="col-lg-12">
								<div class="card mb-4 py-3">
									<div class="card-body">
										Title
										<h1 class="h3 mb-1 text-gray-800">${notice.title }</h1>
										${notice.kind }
										<hr>
										Date : ${notice.indate }
										<hr>
										<input type="hidden" name="prodnum"
											value="${notice.noticenum }">
									</div>
								</div>
							</div>

						</div>

						<div class="row">
							<div class="col-lg-12">
								<div class="card mb-4 py-3">
									<div class="card-body">
										<c:forEach items="${noticeImageList }" var="noticeImage">
											<c:if test="${noticeImage.image != null }">
												<img src="notice_images/${noticeImage.image}"
													class="col-lg-8 center-block">
											</c:if>
										</c:forEach>
										<pre>${notice.content }</pre>
									</div>
								</div>
							</div>
							<input type="button" class="btn btn-info btn-user btn-block"
								onclick="modifyNotice()" value="Modify"> <input
								type="button" class="btn btn-secondary btn-user btn-block"
								onclick="noticeList()" value="Notice List">
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
		function modifyNotice() {
			document.detailform.action = "admin_modify_notice?"
					+ document.detailform.noticenum.value;
			document.detailform.submit();
		}

		function noticeList() {
			document.detailform.action = "admin_notice_list";
			document.detailform.submit();
		}
	</script>
	<%@include file="../footer.jsp"%>