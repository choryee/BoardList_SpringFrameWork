<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>


<! DOCTYPE html>
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

    <script type="text/javascript">
        var newTitle;

        $(document).ready(function(){
            var mode = '<c:out value="${mode}"/>';
            newTitle=$(".title").val();

            if ( mode == 'edit'){
                //입력 폼 셋팅(수정 폼에, 기존 데이터 넣는 것. 밑)
                $("#reg_id").prop('readonly', true);
                $("input:hidden[name='bid']").val(<c:out value="${boardContent.bid}"/>);
                $("input:hidden[name='mode']").val('<c:out value="${mode}"/>');

                $("#title").val('<c:out value="${boardContent.title}"/>');
                $("#reg_id").val('<c:out value="${boardContent.reg_id}"/>');
                $("#content").val('<c:out value="${boardContent.content}"/>');
                $("#tag").val('<c:out value="${boardContent.tag}"/>');
            }
        });

        $(document).on('click', '#btnSave', function(e){ //저장버튼
            e.preventDefault();
            console.log('newTitle>>>',  newTitle );
           // alert(newTitle);

            swal({
                title: "수정하시겠습니까?",
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

        });

        $(document).on('click', '#btnList', function(e){ //목록 버븐
            e.preventDefault();
            location.href="${pageContext.request.contextPath}/board/getBoardList";
        });
    </script>

</head>
<body>
<article>
    
    <div class="container" role="main">
        <h2>도서 Update Form(editForm)</h2>

        <form:form name="form" id="form" role="form" modelAttribute="boardVO" method="post" action="${pageContext.request.contextPath}/board/saveBoard">

            <form:hidden path="bid" />

            <input type="hidden" name="mode" />



            <div class="mb-3">

                <label for="title">제목</label>

                <form:input path="title" id="title" class="form-control" placeholder="제목을 입력해 주세요" />

            </div>



            <div class="mb-3">

                <label for="reg_id">작성자</label>

                <form:input path="reg_id" id="reg_id" class="form-control" placeholder="이름을 입력해 주세요"  />

            </div>



            <div class="mb-3">

                <label for="content">내용</label>

                <form:textarea path="content" id="content" class="form-control" rows="5" placeholder="내용을 입력해 주세요" />

            </div>



            <div class="mb-3">

                <label for="tag">TAG</label>

                <form:input path="tag" id="tag" class="form-control" placeholder="태그를 입력해 주세요" />

            </div>



        </form:form>

        <div >
            <button type="button" class="btn btn-sm btn-primary" id="btnSave">저장</button>
            <button type="button" class="btn btn-sm btn-warning" id="btnList">목록</button>
        </div>
    </div>
</article>
</body>
</html>
