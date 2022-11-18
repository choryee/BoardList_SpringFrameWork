
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

       <title>upload </title>



</head>
<body>
Number: "${number}" </br>
Number: <c:out value="${ticket.ticket_no}"/> </br>
Number: "${ticket.ticket_no}" </br>
Number: ${ticket.ticket_no} </br></br>
Fee: <c:out value="${ticket.ticket_price}"/></br>
Fee: "${ticket.ticket_price}"</br>

 <form action="uploadForm" id="form1" method="POST" enc-type="multipart/form-data">
 <input type="file" name="file"/>
 <input type="submit"/>
 </form>

</body>
</html>
