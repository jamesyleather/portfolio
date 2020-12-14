<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<title>Log In</title>
</head>
<body>
<div class="container">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-12 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
            <h5 class="card-title text-center">Q & A</h5>
            <form name="form" method="post">
              <div class="form-label-group">
              <input type="hidden" id="qnanum" name="qnanum" value="${qna.qnanum }">
                <input type="text" id="subject" name="subject" class="form-control" placeholder="subject" required autofocus value="${qna.subject }">
              </div>
              <hr class="my-4">
              
              <div class="form-label-group">
               <input type="radio" id="kind" name="kind" value="stock" checked="checked"><label> Product Stock / </label>
               <input type="radio" id="kind" name="kind" value="exchage"><label> Exchange Product / </label>
               <input type="radio" id="kind" name="kind" value="return"><label> Return Product / </label>
               <input type="radio" id="kind" name="kind" value="delivery"><label> Delivery / </label>
               <input type="radio" id="kind" name="kind" value="etc"><label>etc</label>
              </div>
              <hr class="my-4">
              
              <div class="form-label-group">
              <textarea id="content" name="content" class="form-control" rows="6">${qna.content }</textarea>
              </div>
              <hr class="my-4">

              <button class="btn btn-lg btn-primary btn-block text-uppercase" onclick="modifycheck()">modify</button>
              <button class="btn btn-lg btn-secondary btn-block text-uppercase" onclick="location='qna_form'">cancle</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
  
  <script type="text/javascript">
  function modifycheck(){
	  if(document.form.subject.value==""){
		  alert("The title is empty");
		  document.form.subject.focus();
	  } else if(document.form.content.value==""){
		  alert("The content is empty");
		  document.form.content.focus();
	  } else {
		  document.form.action = "modify_qna";
		  document.form.submit();
	  }
	  
  }
  </script>
<%@ include file="../footer.jsp"%>