<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="text-center">
	<ul class="pagination justify-content-center">

		<c:if test="${pageMaker.prev }">
			<li class="page-item"><a class="page-link"
				href="admin_product_list${pageMaker.makeQuery(pageMaker.startPage-1) }">Prev</a></li>
		</c:if>

		<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }"
			var="index">
			<li class="page-item"><a class="page-link"
				href="admin_product_list${pageMaker.makeQuery(index) }">${index }</a></li>
		</c:forEach>

		<c:if test="${pageMaker.next }">
			<li class="page-item"><a class="page-link"
				href="admin_product_list${pageMaker.makeQuery(pageMaker.endPage+1) }">Next</a></li>
		</c:if>
	</ul>
</div>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>