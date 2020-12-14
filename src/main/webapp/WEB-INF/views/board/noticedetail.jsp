<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../header.jsp"%>
<html>
<head>
<title>Jamesy Leather Notice</title>
</head>
<body>
	<!-- Page Content -->
	<div class="container">

		<h1 class="my-4">Notice</h1>

		<!-- Notice detail -->
		<div class="row">

			<div class="col-lg-12 mb-6">

				<div class="card h-100">
					<div class="card-body">
						<h5 class="my-4">[${notice.kind}]${notice.title }</h5>
						<hr>
						<fmt:formatDate value="${notcie.indate }" pattern="yyyy-MM-dd"/>
					</div>
				</div>

			</div>
		</div>
		<!-- end product detail -->

		<!-- product content row -->
		<div class="row">
			<div class="col-lg-12 mb-12">
				<div class="card h-100">
					<div class="card-body">
						<h4 class="card-title">Content</h4>
						<pre>${notice.content }</pre>

						<c:forEach items="${noticeDetailImage }" var="detailImage">
							<c:if test="${detailImage.image != null }">
								<img src="product_images/${detailImage.image }"
									class="col-lg-8 center-block">
							</c:if>
						</c:forEach>
					</div>
					<!-- Comments Form -->
       				 <div class="card my-4">
         				<h5 class="card-header">Leave a Comment:</h5>
          			<div class="card-body">
            		<form method="POST" name="form" action="notice_comment">
            		<input type="hidden" name="noticenum" id="noticenum" value="${notice.noticenum }">
              			<div class="form-group">
                			<textarea class="form-control" rows="3" id="content" name="content"></textarea>
              			</div>
              			<button type="submit" class="btn btn-primary" onclick="comment_action(notice_comment?noticenum=${notice.noticenum})">Submit</button>
            		</form>
            		
            		<div id="commentContainer" class="container">
            			<c:forEach items="${commentList}" var="comment">
            				<div class="media mb-4">
          						<div class="media-body">
            						<h5 class="mt-0">${comment.id }</h5>
            							${comment.content }
          						</div>
        					</div>
            			</c:forEach>
            		</div>
          </div>
        </div>
					<div class="form-group">
					<a href="notice_list" class="btn btn-secondary form-control">notice list</a> 
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script>
		function comment_action(url){
			if(document.form.content.value==""){
				alert("empty comment");
				document.form.content.focus();
				return false;
			}else {
				var ajaxOption = {
					url : url,
					async : true,
					type : "post",
					cache : false
				};
				
				$.ajax(ajaxOption).done(function(data){
					$("commentContainer").chidren.remove();
					$("commentContainer").html(data);
				});
			}
		}
	</script>
	<!-- end page content -->
	<%@ include file="../footer.jsp"%>