<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <title>board</title>


    <script>
        $(document).on('click', '#btnWriteForm', function(e){
            e.preventDefault();
            location.href = "${pageContext.request.contextPath}/board/boardForm";	});
    </script>

<script>
    $(document).on('click', '#btnWriteForm', function(e){
	e.preventDefault();
	location.href = "${pageContext.request.contextPath}/board/boardForm";
		});</script>

</head>


<body>

<article>

<div class="container">
<h2>board list</h2>
<div class="table-responsive">

<table class="table table-striped table-sm" border="2px">
    <colgroup>
        <col style="width:5%;" />
        <col style="width:15%;" />
        <col style="width:auto;" />
        <col style="width:15%;" />
        <col style="width:10%;" />
        <col style="width:10%;" />
    </colgroup>

    <thead>
    <tr align="center">
        <th>NO</th>
        <th>글제목</th>
        <th>내용</th>
        <th>작성자</th>
        <th>조회수</th>
        <th>작성일</th>
    </tr>
    </thead>

    <tbody>
    <c:choose>
        <c:when test="${empty boardList }" >
            <tr><td colspan="5" align="center">데이터가 없습니다. No data available!!</td></tr>
        </c:when>

        <c:when test="${!empty boardList}">

            <c:forEach var="list" items="${boardList}">
                <tr align="center">
                    <td><c:out value="${list.bid}"/></td>
                    <td><c:out value="${list.title}"/></td>
                    <td><c:out value="${list.content}"/></td>
                    <td><c:out value="${list.reg_id}"/></td>
                    <td><c:out value="${list.view_cnt}"/></td>
                    <td><c:out value="${list.reg_dt}"/></td>

                </tr>
            </c:forEach>

        </c:when>
    </c:choose>
    </tbody>
</table>
</div>

<ul>
   <c:forTokens var="item" items="사과,포도,바나나,수박,딸기" delims=",">
       <li>(forTokens 테스트) 과일 : ${item}</li>
   </c:forTokens>
</ul>

<div >	<button type="button" class="btn btn-sm btn-primary" id="btnWriteForm">글쓰기</button>		</div>
</div>

</article>

</body>
</html>