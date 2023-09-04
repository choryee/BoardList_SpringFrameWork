<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>



<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <title>board</title>
<style>
    .etcBox {padding:0 1em 1em .2em; width:50%;}
    .noticeBox {box-shadow: 4px 4px 10px #bbb; border-bottom-left-radius: 10px; border-top-right-radius: 10px;}
    .noticeTab {background:url("../images/noticeMore.png") right no-repeat #0060c4; position: relative; padding:1em; border-top-right-radius: 10px; text-align: left;}
    .noticeTab li {display: inline-block; margin:0 15px;}
    .noticeTab li:last-child {}
    .noticeTab li a {display: block; color:#7c9fd9; font-size:20px; font-weight: 700;}
    .noticeTab li.tabChoice a {color:#fff;}
    .noticeMore {position: absolute; right:10px; top:20px;}
    .noticeMore button {background-color: transparent; border:0; cursor: pointer;}
    .noticeList {background-color: #fff; padding:.5em 1em; border-bottom-left-radius: 10px;}
    .noticeList ul {overflow: hidden; border-bottom: 1px dashed #ccc;}
    .noticeList ul:last-child {border-bottom:0;}
    .noticeList li {float: left; box-sizing: border-box; color:#8d8d8d; min-height: 36px; margin:.2em 0;}
    .noticeList li:first-child {width:80%; text-align: left;}
    .noticeList li:last-child {width:20%; text-align: right;  padding:.5em 0; font-size:14px; color:#c2c2c2;}
    .noticeList li a {display: block; color:#8d8d8d;  padding:.7em 0; text-overflow: ellipsis; overflow: hidden; white-space: nowrap; font-size:15px;}
    .noticeList li a::before {content: "-"; margin:0 10px 0 5px;}


</style>

    <script>
     $(document).on('click', '#btnWriteForm', function(e){
            e.preventDefault();
            location.href = "${pageContext.request.contextPath}/board/boardForm";
        });

    function fn_contentView(bid){
		var url = "${pageContext.request.contextPath}/board/getBoardContent";
		url = url + "?bid="+bid;
		location.href = url;
	}

     // let color=["green", "yellow", "red","aqua"];
     // let i=0;
     //
     // function changeColor(){
     //     i++;
     //     if(i>=color.length) i=0;
     //     let bodyTag=document.getElementsByTagName("body")[0];
     //     bodyTag.style.backgroundColor=color[i];
     // }
     //
     // window.onload=function (){
     //     let btn2=document.getElementById("btn2");
     //     btn2.onclick=function (){
     //         changeColor();
     //     }
     // }
     //
     // function addNumber(){
     //     let num=$('#text').value();
     //     console.log('num>>>>', num);
     //     return num+1;
     // }

     // $('#textResult').onmouseover(function (){
     //     addNumber();
     // })

     // $('#btn3').onclick(function (){
     //     $(this).text('BEST');
     // })


  </script>
    <!-- 합쳐지고 최소화된 최신 CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <!-- 합쳐지고 최소화된 최신 자바스크립트 -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
     <link rel="stylesheet" type="text/css" href="<c:url value='/css/index.css?after'/>" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
            <div class="container">
            <h2>도서 리스트</h2>


            <div class="table-responsive">

            <table class="table table-striped table-sm" border="2px">
                <colgroup>
                    <col style="width:5%;" />
                    <col style="width:15%;" />
                    <col style="width:15%;" />
                    <col style="width:7%;" />
                    <col style="width:7%;" />
                    <col style="width:10%;" />
                </colgroup>

                <thead>
                <tr align="center">
                    <th>NO</th>
                    <th>도서제목</th>
                    <th>도서설명</th>
                    <th>저자</th>
                    <th>조회수</th>
                    <th>등록일</th>
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
                                <td>
                                  <a href="#" onClick="fn_contentView(<c:out value="${list.bid}"/>)"> <c:out value="${list.title}"/> </a>
                                </td>
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

            <div >	<button type="button" class="btn btn-sm btn-primary" id="btnWriteForm" style="font-size: large">도서등록</button></div>

            </div>

            </article>

<%--            <script src="<c:url value='/js/main.js'/>"></script>--%>
</body>
</html>
