<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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

<title>board</title>

<script>
	$(document).on('click', '#btnList', function(){ // 목록 버튼
    		location.href = "${pageContext.request.contextPath}/board/getBoardList";
	});

    $(document).on('click', '#btnTicket', function(){  // 티켓 버튼
       		location.href = "${pageContext.request.contextPath}/board/ticketList";
	});


	$(document).on('click', '#btnUpdate', function(){  // 수정 버튼
		var url="${pageContext.request.contextPath}/board/editForm";
		url=url+"?bid="+"${boardContent.bid}";
		url=url+"&mode=edit";  // mode 첨에 여기 있음.
		location.href=url;
	})


	$(document).on('click', '#btnDelete', function(){  // 삭제 버튼
		swal({
			title: "삭제하시겠습니까?",
			type: "warning",
			showCancelButton: true,
			confirmButtonColor: "#DD6B55",
			confirmButtonText: "예",
			cancelButtonText: "아니요",
			closeOnConfirm: false,
			closeOnCancel : true
		}, function (isConfirm) {
			if (!isConfirm) return;
			var url="${pageContext.request.contextPath}/board/deleteBoard";
			url=url+"?bid="+"${boardContent.bid}";
			location.href=url;
		});


	});

	function checkAlert(result1){
		if(result1==='DELETE SUCCESS'){
		alert('삭제가 완료됩습니다!!!');
	}};

</script>

</head>
<body>
	<article>
		<div class="container" role="main">
			<h2>도서 개별 Content</h2>

			<div class="bg-white rounded shadow-sm">
				<div class="board_title">제목 : <c:out value="${boardContent.title}"/></div>
				<div class="board_info_box">
					<span class="board_author">글쓴이 : <c:out value="${boardContent.reg_id}"/> ,
					</span><span class="board_date">작성일자 : <c:out value="${boardContent.reg_dt}"/></span>

				</div>
				<div class="board_content">내 용 : ${boardContent.content}</div>
				<div class="board_tag">TAG : <c:out value="${boardContent.tag}"/></div>
			</div>

			<div style="margin-top : 20px">
                <button type="button" class="btn btn-sm btn-primary" id="btnUpdate" onclick="<c:out value="${boardContent.bid}"/>">수정	</button>
				<button type="button" class="btn btn-sm btn-info" id="btnDelete" onclick="<c:out value="${boardContent.bid}"/>">삭제</button>

				<button type="button" class="btn btn-sm btn-warning" id="btnList">목록</button>
				<!--
				<button type="button" class="btn btn-sm btn-warning" id="btnTicket">티켓</button>
				-->
			</div>

		</div>
	</article>
</body>
</html>