<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Q & A Detail</title>
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
					<h1 class="h3 mb-4 text-gray-800">Q & A View</h1>
					<p>This page is [${qna.id }]'s Q & A view</p>

						<!-- Q & A form -->
						<div class="row">
						<div class="card shadow mb-4 col-lg-6">
							<div class="card-header mb-4">
								<h6 class="m-0 font-weight-bold">[${qna.kind }] ${qna.subject } / ${qna.indate }</h6>
							</div>
							<div class="card-body">
							ID : ${qna.id }
							<hr>
							Content<br>
								<pre>${qna.content }</pre>
							</div>
						</div>
						<form class="card shadow mb-4 col-lg-6" name="form" method="post" action="admin_reply_qna">
						
						<div class="card-header mb-4">
							<h6 class="m-0 font-weight-bold">reply for no. ${qna.qnanum } Q&A</h6>
						</div>
							<div class="card-body">
							<div class="form-group">
								<textarea name="reply" rows="6" class="form-control">${qna.reply }</textarea>
								</div>
							</div>
							<div class="form-group">
							<input type="hidden" id="qnanum" name="qnanum" value="${qna.qnanum }">
								<input type="submit" class="btn btn-primary" value="reply">
							</div>
						</form>
						</div>
						
				</div>
				<!-- End Page Content -->
			</div>
			<!-- End Main Content -->
		</div>
		<!-- End Content Wrapper -->
	</div>
<%@include file="../footer.jsp"%>