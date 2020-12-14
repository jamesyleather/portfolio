<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<meta name="google-signin-scope" content="profile email">
<meta name="google-signin-client_id" content="YOUR_CLIENT_ID.apps.googleusercontent.com">
 <script src="https://apis.google.com/js/platform.js" async defer></script>
<title>Log In</title>
</head>
<body>
<div class="container">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
            <h5 class="card-title text-center">Log In</h5>
            <form class="form-signin" method="post" action="login">
              <div class="form-label-group">
                <input type="text" id="id" name="id" class="form-control" placeholder="id" required autofocus>
              </div><br>

              <div class="form-label-group">
                <input type="password" id="pwd" name="pwd" class="form-control" placeholder="Password" required>
              </div>
              
              <hr>
              
              <div class="form-label-group">
              <c:if test="${check == 1 }">
                <label>${message }</label>
              </c:if>
              </div>

              <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Sign in</button>
              <div class="text-center">
              <!--  
              	<a href="${naver_url }"><img class="col-lg-12" src="images/naver-login.png" alt="Naver Login"></a>
              	<a href="${google_url }"><img class="col-lg-12" src="images/google-login.png" alt="Google Login"></a>
              -->
              </div>
               <!--  <div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark"></div> -->
              <hr class="my-4">
              Forgot your <a href="javascript:void(0)" onclick="findid()">ID</a> or 
              				<a href="javascript:void(0)" onclick="findpassword()">Password</a>?
              <button class="btn btn-lg btn-secondary btn-block text-uppercase" onclick="location='join_form'">Join</button>
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
  
  <!--  
  <script>
      function onSignIn(googleUser) {
        // Useful data for your client-side scripts:
        var profile = googleUser.getBasicProfile();
        console.log("ID: " + profile.getId()); // Don't send this directly to your server!
        console.log('Full Name: ' + profile.getName());
        console.log('Given Name: ' + profile.getGivenName());
        console.log('Family Name: ' + profile.getFamilyName());
        console.log("Image URL: " + profile.getImageUrl());
        console.log("Email: " + profile.getEmail());

        // The ID token you need to pass to your backend:
        var id_token = googleUser.getAuthResponse().id_token;
        console.log("ID Token: " + id_token);
      }
    </script>
    -->
<%@ include file="../footer.jsp"%>