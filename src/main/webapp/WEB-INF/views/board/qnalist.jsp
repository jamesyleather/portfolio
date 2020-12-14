<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../header.jsp"%>
<html>
<head>
<title>Jamesy Leather Product</title>
</head>
<body>
	<!-- Page Content -->
	<div class="container">

		<!-- Page Heading/Breadcrumbs -->
		<h1 class="mt-4 mb-3">Q&A</h1>
		<form name="form">
			<!-- cart List -->

			<div class="row">
				<div class="card h-100 col-lg-12">
					<div class="card-body">
						<div class="table-responsive">
							<table class="table table-bordered" id="dataTable" width="100%"
								cellspacing="0">
								<thead>
									<tr align="center">
										<th>no.</th>
										<th>subject</th>
										<th>id</th>
										<th>reply</th>
										<th>date</th>
									</tr>
								</thead>
								<tfoot>
									<tr align="right">
										<th>no.</th>
										<th>subject</th>
										<th>id</th>
										<th>reply</th>
										<th>date</th>
									</tr>
								</tfoot>
								<tbody>
									<c:forEach items="${qnaList }" var="qna">
										<tr>
											<td>${qna.qnanum }</td>
											<td><a href="qna_detail?qnanum=${qna.qnanum }">[${qna.kind}]${qna.subject }</a></td>
											<td>${qna.id }</td>
											<td>
											<c:choose>
											<c:when test="${qna.rep=='1' }">
												<label class="text-danger">Waiting for a reply</label>
											</c:when>
											<c:otherwise>
												<label class="text-info">Answer complete</label>
											</c:otherwise>
											</c:choose>
											</td>
											<td><fmt:formatDate value="${qna.indate }" pattern="yyyy-MM-dd"/></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<%@include file="qna_paging.jsp" %>
					</div>
				</div>
			</div>
			
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><input type="button"
					class="btn btn-info" value="write" onclick="write_qna()"></li>
			</ol>

			<!-- end cart List -->
		</form>
	</div>
	
	<script type="text/javascript">
		function write_qna(){
			document.form.action = "write_qna_form";
			document.form.submit();
		}
	</script>
	<!-- end page content -->
	<%@ include file="../footer.jsp"%>