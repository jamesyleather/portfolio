<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp"%>
<html>
<head>
<!-- index page -->
<title>Home</title>
</head>
<body>
	<header>
		<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
		
			<ol class="carousel-indicators">
				<li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
				<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
				<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
			</ol>
			
			<div class="carousel-inner" role="listbox">
				<!-- Slide One - Set the background image for this slide in the line below -->
				<c:forEach items="${bestProductList }" var="bestProduct">
					<c:choose>
					
						<c:when test="${bestProduct.rn == 1 }">
							<div class="carousel-item active"
								style="background-image: url('product_images/${bestProduct.image}')" 
								onclick="location.href='product_detail?prodnum=${bestProduct.prodnum}';">
									<div class="carousel-caption d-none d-md-block">
										<h3>${bestProduct.name }</h3>
										<p>views : ${bestProduct.viewnum }</p>
									</div>
								</div>
						</c:when>
						
						<c:otherwise>
							<div class="carousel-item"
								style="background-image: url('product_images/${bestProduct.image}')"
								onclick="location.href='product_detail?prodnum=${bestProduct.prodnum}';">
								<div class="carousel-caption d-none d-md-block">
									<h3>${bestProduct.name }</h3>
									<p>views : ${bestProduct.viewnum }</p>
								</div>
							</div>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</div>

			<a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev"> 
				<span class="carousel-control-prev-icon" aria-hidden="true"></span> 
				<span class="sr-only">Previous</span>
			</a> 
			<a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next"> 
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
	</header>

	<%@ include file="footer.jsp"%>