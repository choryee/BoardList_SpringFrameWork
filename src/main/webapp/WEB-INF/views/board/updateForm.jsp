
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

       <title>board</title>

    <script>
        $(document).on('click', '#btnSave', function(e){
            e.preventDefault();
        $("#form").submit();
        });

        $(document).on('click', '#btnList', function(e){
            e.preventDefault();
            location.href="${pageContext.request.contextPath}/board/getBoardList";
        });

         function fn_contentView(bid){
        		var url = "${pageContext.request.contextPath}/board/updateBoard";
        		url = url + "?bid="+bid;
        		location.href = url;
        	}

    </script>


</head>
<body>
<article>
    <div class="container" role="main">
        <h2>Update Form</h2>

        <form name="form" id="form" role="form" method="post" action="${pageContext.request.contextPath}/board/updateBoard">
            <div class="mb-3">
                <label for="title"> 제목 </label>
                <input type="text" class="form-control" name="title" id="title"> <c:out value="${updateBoard.title}"/></input>
            </div>

            <div class="mb-3">
                <label for="reg_id">작성자</label>
                <input type="text" class="form-control" name="reg_id" id="reg_id" placeholder="<c:out value="${updateBoard.reg_id}"/>">
            </div>

            <div class="mb-3">
                <label for="content">내용</label>
                <textarea class="form-control" rows="5" name="content" id="content" placeholder="내용을 입력해 주세요" ><c:out value="${updateBoard.content}"/></textarea>
            </div>

            <div class="mb-3">
                <label for="tag">TAG</label>
                <input type="text" class="form-control" name="tag" id="tag" placeholder="태그를 입력해 주세요">
            </div>

        </form>
        <div >
        	<button type="button" class="btn btn-sm btn-primary" id="btnUpdate">삭제</button>
            <button type="button" class="btn btn-sm btn-primary" id="btnSave">삭제</button>
            <button type="button" class="btn btn-sm btn-warning" id="btnList">목록</button>
        </div>
    </div>
</article>
</body>
</html>
