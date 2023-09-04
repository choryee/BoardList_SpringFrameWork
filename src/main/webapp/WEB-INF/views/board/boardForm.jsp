
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">

  <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
  <link rel="stylesheet"href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css" />
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <link rel="stylesheet" type="text/css" media="screen" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.css">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>

  <!-- jQuery -->
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

  <title>board</title>

  <script>
    $(document).on('click', '#btnSave', function(e){ // 저장버튼
      e.preventDefault();

      //   swal.fire({
      //     title: '저장하시겠습니까?',
      //     type: 'warning',
      //     confirmButtonColor: '#3085d6',
      //     confirmButtonText: '확인',
      //   }).then(function(isConfirm) {
      //     $("#form").submit();
      //
      //   /**/
      // }).always(function(){
      //   // 달력 랜더링
      // });

      // swal('저장하시겠습니까?', "님 로그인되었습니다.", 'success')
      //         .then(function(){
      //           $("#form").submit();
      //         })

        swal({
          title: "등록하시겠습니까?",
          type: "warning",
          showCancelButton: true,
          confirmButtonColor: "#DD6B55",
          confirmButtonText: "예",
          cancelButtonText: "아니요",
          closeOnConfirm: false,
          closeOnCancel : true
        }, function (isConfirm) {
          if (!isConfirm) return;
          $("#form").submit();
        });

    })



    $(document).on('click', '#btnList', function(e){ //목록버튼
      e.preventDefault();
      location.href="${pageContext.request.contextPath}/board/getBoardList";
    });
  </script>

  <style>
    body {
      padding-top: 70px;
      padding-bottom: 30px;
    }

  </style>
</head>

<body>
<article>
  <div class="container" role="main">
    <h2> 첫 등록시 board Form</h2>

    <form name="form" id="form" role="form" method="post" action="${pageContext.request.contextPath}/board/saveBoard">
      <input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">

      <div class="mb-3">
        <label for="title">제목</label>
        <input type="text" class="form-control" name="title" id="title" placeholder="제목을 입력해 주세요">
      </div>

      <div class="mb-3">
        <label for="reg_id">작성자</label>
        <input type="text" class="form-control" name="reg_id" id="reg_id" placeholder="이름을 입력해 주세요">
      </div>

      <div class="mb-3">
        <label for="content">내용</label>
        <textarea class="form-control" rows="5" name="content" id="content" placeholder="내용을 입력해 주세요" ></textarea>
      </div>

      <div class="mb-3">
        <label for="tag">TAG</label>
        <input type="text" class="form-control" name="tag" id="tag" placeholder="태그를 입력해 주세요">
      </div>

    </form>

    <div >
      <button type="button" class="btn btn-sm btn-primary" id="btnSave">저장</button>
      <button type="button" class="btn btn-sm btn-primary" id="btnList">목록</button>
    </div>
  </div>
</article>
</body>
</html>
