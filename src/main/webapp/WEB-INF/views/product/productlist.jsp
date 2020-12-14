<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../header.jsp"%>
<html>
<head>
<title>Jamesy Leather Product</title>
</head>
<body>
	
	<!-- Page Content -->
	<div class="container">
	<c:choose>
		<c:when test="${kind==''}">
			<h1 class="my-4">ALL</h1>
		</c:when>
		<c:otherwise>
			<h1 class="my-4">${kind }</h1>
		</c:otherwise>
	</c:choose>
	
	<!-- Product Kind -->
	<ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="category?kind=">ALL</a>
      </li>
      <li class="breadcrumb-item">
        <a href="category?kind=bag">Bag</a>
      </li>
      <li class="breadcrumb-item">
        <a href="category?kind=wallet">Wallet</a>
      </li>
      <li class="breadcrumb-item">
        <a href="category?kind=shoes">Shoes</a>
      </li>
      <li class="breadcrumb-item">
        <a href="category?kind=acc">Acc</a>
      </li>
    </ol>
		<!-- ProductList -->
		<div class="row">
		<c:forEach items="${productList }" var="productVO">
			<div class="col-lg-4 mb-4">
				<div class="card h-100">
					<a href="product_detail?prodnum=${productVO.prodnum }"><h4 class="card-header">${productVO.name }</h4></a>
					<div class="card-body">
					<c:choose>
						<c:when test="${productVO.image==null }">
							<a href="product_detail?prodnum=${productVO.prodnum }"><img src="product_images/default.jpg" class="col-lg-12"/></a>
						</c:when>
						<c:otherwise>
							<a href="product_detail?prodnum=${productVO.prodnum }"><img src="product_images/${productVO.image }" class="col-lg-12"/></a>
						</c:otherwise>
					</c:choose>
					</div>
					<div class="card-footer">
					Price :
						<a href="product_detail?prodnum=${productVO.prodnum }">
						<fmt:formatNumber type="number" pattern="#,###" value="${productVO.price2 }"/>
						</a> won
					</div>
				</div>
			</div>
		</c:forEach>
		</div>
		<!-- end productList -->
	</div>
	<!-- end page content -->

<%@ include file="../footer.jsp"%>
