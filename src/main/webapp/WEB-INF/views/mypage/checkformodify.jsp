<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Log In</title>
</head>
<body>
<div class="container">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
            <h5 class="card-title text-center">Check Password</h5>
            <form class="form-signin" method="post" action="pass_check">
              <div class="form-label-group">
              <input type="hidden" id="id" name="id" value="${loginUser.id }">
                <input type="password" id="pwd" name="pwd" class="form-control" placeholder="Password" required>
              </div>         
              <hr>
              <div class="form-label-group">
              <c:if test="${message != null }">
                <label>${message }</label>
              </c:if>
              </div>

              <input class="btn btn-lg btn-primary btn-block text-uppercase" type="submit" value="check"/>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
  
  <script type="text/javascript">
  function findid(){
		var url="find_id_form";
		
		window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=500");
	}
  
  function findpassword(){
	  var url="find_password_form";
	  
	  window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=500");
  }
  </script>
<%@ include file="../footer.jsp"%>