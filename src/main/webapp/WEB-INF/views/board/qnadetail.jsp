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
<ol class="breadcrumb">
      <li class="breadcrumb-item">
        <button class="btn btn-info btn-block text-uppercase" onclick="qnamodify()">modify</button>
      </li>
      <li class="breadcrumb-item"><button class="btn btn-secondary btn-block text-uppercase" onclick="location='qna_form'">List</button></li>
    </ol>
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-12 mx-auto">
        <div class="card h-100">
          <div class="card-body">
            <h5 class="card-title text-center">Q & A</h5>
            <form name="form" method="post">
              <input type="hidden" name="qnanum" value="${qna.qnanum }">
                <h4 class="my-4">[${qna.kind }]${qna.subject }</h4>
                ${qna.indate }
              <hr class="my-4">
              ${qna.content }
              <hr class="my-4">
              <div class="media mb-4">
          <img class="d-flex mr-3 rounded-circle" src="http://placehold.it/50x50" alt="">
          <div class="media-body">
            <h5 class="mt-0">Admin</h5>
            ${qna.reply }
          </div>
        </div>
              
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
  
  <script type="text/javascript">
  function qnamodify(){
		  document.form.action = "modify_qna_form?qnanum=" + ${qna.qnanum};
		  document.form.submit();	  
  }
  </script>
<%@ include file="../footer.jsp"%>