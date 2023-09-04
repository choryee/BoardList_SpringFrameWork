<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>


<! DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

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

            $("#form").submit();
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

        <form name="form" id="form" role="form" method="post" action="${pageContext.request.contextPath}/board/saveBoard">
            <input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
            <input type="hidden" name="mode" />

            <div class="mb-3">
                <label for="title">제목</label>
                <input type="text" class="form-control title" name="title" id="title" placeholder="제목을 입력해 주세요">
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
            <button type="button" class="btn btn-sm btn-warning" id="btnList">목록</button>
        </div>
    </div>
</article>
</body>
</html>
