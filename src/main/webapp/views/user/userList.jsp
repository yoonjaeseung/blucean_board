
<%--
  Created by IntelliJ IDEA.
  User: berno
  Date: 2020-03-15
  Time: 오후 8:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>회원목록</title>
</head>
<body>
<h1>전체회원 목록</h1>
<form action="/userList/userSearch" method="post">
    <table width="100%" border="0" cellspacing="1" cellpadding="0"
           style="overflow:auto; overflow-x: auto; font-size: 11pt; font-family: 'KoPubWorld돋움체 Light'">
        <tr>
            <td style="float: left">
                <b style="font-size: medium">회원검색&nbsp;</b>
                <input type="text" name="accountEmail" placeholder="계정이메일">
                <input type="submit" value="Search">
            </td>
        </tr>
    </table>
</form>
<table width="100%" border="0" cellspacing="1" cellpadding="0"
       style="overflow:auto; overflow-x: auto; font-size: 11pt; font-family: 'KoPubWorld돋움체 Light'">
    <thead style="background-color: gainsboro">
    <th>NO</th>
    <th>계정이메일</th>
    <th>계정암호</th>
    <th>생년월일</th>
    <th>성별코드</th>
    <th>공개범위코드</th>
    <th>국가코드</th>
    <th>가입구분코드</th>
    <th>사용자명</th>
    <th>최초실행일시</th>
    <th>최근실행일시</th>
    <th>생성일시</th>
    <th>생성ID</th>
    <th>수정일시</th>
    <th>수정ID</th>


    </thead>
    <tbody style="background-color: aliceblue">
    <c:forEach var="response" items="${userAccountList}" varStatus="status">
        <tr>
            <td>${response.id}</td>
            <td>${response.accountEmail}</td>
            <td>${response.accountPassword}</td>
            <td>${response.birthday}</td>
            <td>${response.sexCode}</td>
            <td>${response.openScopeCode}</td>
            <td>${response.countryCode}</td>
            <td>${response.joinDivisionCode}</td>
            <td>${response.userName}</td>
            <td>${response.firstPracticeDatetime}</td>
            <td>${response.lastPracticeDatetime}</td>
            <td>${response.createDatetime}</td>
            <td>${response.createHost}</td>
            <td>${response.updateDatetime}</td>
            <td>${response.updateHost}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</div>
<div style="float: right"><a href="/">메인페이지</a></div>
</body>
</html>
