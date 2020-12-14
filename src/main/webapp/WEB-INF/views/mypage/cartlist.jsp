<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../header.jsp"%>
<html>
<head>
<title>Jamesy Leather Product</title>
</head>
<body>
	<!-- Page Content -->
	<div class="container">

		<!-- Page Heading/Breadcrumbs -->
		<h1 class="mt-4 mb-3">${loginUser.name }'s Cart</h1>
		<form name="form" method="post">
			<!-- cart List -->

			<div class="row">
				<div class="card h-100">
					<div class="card-body">
						<div class="table-responsive col-lg-12">
							<table class="table table-bordered" id="dataTable" width="100%"
								cellspacing="0">
								<thead>
									<tr align="center">
										<th><input type="checkbox" id="chk_all"></th>
										<th>image</th>
										<th>name</th>
										<th>price</th>
									</tr>
								</thead>
								<tfoot>
									<tr align="right">
										<th></th>
										<th></th>
										<th>total</th>
										<th>${totalPrice }</th>
									</tr>
								</tfoot>
								<tbody>
									<c:forEach items="${cartList }" var="cart">
										<tr id="cartRow">
											<td><input type="checkbox" id="cartnum" name="cartnum"
												value="${cart.cartnum }"></td>
											<td width="15%"><img src="product_images/${cart.image }"
												class="col-lg-12"></td>
											<td width="70%" align="center">${cart.pname }</td>
											<td>${cart.price2 * cart.quantity }</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><input type="button"
					class="btn btn-danger" value="delete" onclick="delete_cartlist()"></li>
				<li class="breadcrumb-item"><input type="button"
					class="btn btn-secondary" value="order(checked)"
					onclick="order_action()"></li>
			</ol>

			<!-- end cart List -->
		</form>
		<div id="ex1_result"></div>

	</div>
	<!-- end page content -->

	<!-- delete cart list -->
	<script>
		function delete_cartlist() {
			var count = 0; // 삭제할 항목의 갯수 저장

			// 삭제할 항목이 1개일 경우 배열로 인식이 안되기 때문에 배열의 길이에 값이 안들어감
			if (document.form.cartnum.length == undefined) {
				// 체크박스가 하나만 체크되어 있는 경우를 확인
				if (document.form.cartnum.checked == true) {
					count++;
				}
			}

			// 여러개의 항목이 체크되어 있을 경우 체크된 갯수 확인
			for (var i = 0; i < document.form.cartnum.length; i++) {
				if (document.form.cartnum[i].checked == true) {
					count++;
				}
			}

			if (count == 0) {
				alert("삭제할 항목을 선택해 주세요.");
			} else {
				document.form.action = "delete_cartlist";
				document.form.submit();
			}
		}
	</script>

	<!-- order action -->
	<script>
		function order_action() {
			var count = 0; // 삭제할 항목의 갯수 저장

			// 삭제할 항목이 1개일 경우 배열로 인식이 안되기 때문에 배열의 길이에 값이 안들어감
			if (document.form.cartnum.length == undefined) {
				// 체크박스가 하나만 체크되어 있는 경우를 확인
				if (document.form.cartnum.checked == true) {
					count++;
				}
			}

			// 여러개의 항목이 체크되어 있을 경우 체크된 갯수 확인
			for (var i = 0; i < document.form.cartnum.length; i++) {
				if (document.form.cartnum[i].checked == true) {
					count++;
				}
			}


			if (count == 0) {
				alert("주문할 항목을 선택해주세요.");
			} else {
				document.form.action = "order_product";
				document.form.submit();
			}
		}
	</script>

	<script>
		$(document).ready(function(){
			$("#chk_all").click(function(){
				if($("#chk_all").prop("checked")){
					$("input[name=cartnum]").prop("checked", true);
				} else {
					$("input[name=cartnum]").prop("checked", false);
				}
			})
		});
	</script>
	<%@ include file="../footer.jsp"%>