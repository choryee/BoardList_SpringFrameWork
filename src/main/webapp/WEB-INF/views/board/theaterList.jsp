<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <title>board</title>


    <script>
     $(document).ready(function(){
        $('#btnSend').on('click', function(){
         var aaa=$('select option:selected').val();
        // alert(aaa);
        });
	});


	$(document).on('click', '#btnSend', function(e){
                    e.preventDefault();
                $("#ticketForm").submit();
                });



  </script>
</head>


<body>

<article>

<div class="container">
<h2>Ticket page</h2>



<div class="table-responsive">

<table class="table table-striped table-sm" border="2px">
    <colgroup>
        <col style="width:10%;" />
        <col style="width:10%;" />
        <col style="width:10%;" />
        <col style="width:auto;" />
        <col style="width:15%;" />
        <col style="width:10%;" />
        <col style="width:10%;" />
    </colgroup>

    <thead>
    <tr align="center">
        <th>NO</th>
        <th>티켓종류</th>
        <th>티켓수</th>
        <th>티켓가격</th>
        <th>매표소 매출액</th>
        <th>초대장유무</th>
        <th>입장가능유무</th>
        <th>구매일</th>
    </tr>
    </thead>

    <tbody>
            <form id="ticketForm"  action="<c:url value='/ticket/ticketList'/>" method="get">
                <tr align="center">
                    <td><c:out value="${list.bid}"/></td>
                    <td><input type="text" name="ticket_type"></td>

                    <td>
                     <select  name="ticket_no" id="id_select">
                      <option value="" selected>선택</option>
                      <option value="1">1</option>
                      <option value="2">2</option>
                      <option value="3">3</option>
                      <option value="4">4</option>
                      <option value="5">5</option>
                      </select>
                    </td>

                     <td><input type"text" name="ticket_price"/>  </td>

                    <td>  </td>

                    <td><c:out value="${list.view_cnt}"/></td>
                    <td><c:out value="${list.reg_dt}"/></td>

                </tr>

        </form>
    </tbody>
</table>
</div>


<ul>
   <c:forTokens var="item" items="사과,포도,바나나,수박,딸기" delims=",">
       <li>(forTokens 테스트) 과일 : ${item}</li>
   </c:forTokens>
</ul>

<div >	<button type="button" class="btn btn-sm btn-primary" id="btnWriteForm">글쓰기</button>		</div>
<div >	<button type="button" class="btn btn-sm btn-warning" id="btnSend">보내기</button>		</div>
</div>

</article>

</body>
<script>
 $.ajax({
    url:"/ticket/ticketForm",
    type:"GET",
    data: {
        ticket_no : 6,
        ticket_price : 2000
        },
    contentType : "application/x-www-form-urlencoded : charset=UTF-8;"
  });


</html>
