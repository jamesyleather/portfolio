<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jamesy Leather</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/modern-business.css" rel="stylesheet">

<!-- Bootstrap core JavaScript -->
<script src="jquery/jquery.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>

<!-- Join -->
<script type="text/javascript" src="js/cart.js"></script>
<script type="text/javascript" src="js/member.js"></script>

</head>
<body>

	<!-- Navigation -->
	<nav
		class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<!-- 로고를 클릭하면 메인 페이지로 이동 -->
			<a class="navbar-brand" href="index">Jamesy Leather</a>

			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<!-- 메뉴 목록 -->
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<!-- Introduce Brand -->
					<li class="nav-item"><a class="nav-link" href="about">About</a></li>
					
					<!-- Shop -->
					<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownPortfolio" 
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Shop </a>
						<div class="dropdown-menu dropdown-menu-right"
							aria-labelledby="navbarDropdownPortfolio">
							<a class="dropdown-item" href="category?kind=">All</a> 
							<a class="dropdown-item" href="category?kind=bag">Bag</a> 
							<a class="dropdown-item" href="category?kind=wallet">Wallet</a> 
							<a class="dropdown-item" href="category?kind=shoes">Shoes</a>
							<a class="dropdown-item" href="category?kind=acc">Acc</a> 
						</div>
					</li>
					
					<!-- Q and A -->
					<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownPortfolio" 
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Board </a>
						<div class="dropdown-menu dropdown-menu-right"
							aria-labelledby="navbarDropdownPortfolio">
							<a class="dropdown-item" href="qna_form">Q & A</a> 
							<a class="dropdown-item" href="notice_list">Notice</a> 
						</div>
					</li>
					
					<!-- Mypage -->
					<c:choose>
					<c:when test="${empty sessionScope.loginUser.id}">
					<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownPortfolio" 
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Mypage </a>
						<div class="dropdown-menu dropdown-menu-right"
							aria-labelledby="navbarDropdownPortfolio">
							<a class="dropdown-item" href="login_form">Login</a> 
						</div>
					</li>
					</c:when>
					<c:otherwise>
					<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownPortfolio" 
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> ${sessionScope.loginUser.name } </a>
						<div class="dropdown-menu dropdown-menu-right"
							aria-labelledby="navbarDropdownPortfolio">
							<a class="dropdown-item" href="cart_form">Cart</a> 
							<a class="dropdown-item" href="order_form">Order</a> 
							<a class="dropdown-item" href="check_password_view">Modify Info</a> 
							<a class="dropdown-item" href="logout">Logout</a> 
						</div>
					</li>
					</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
	</nav>