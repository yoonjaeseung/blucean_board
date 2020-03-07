<%--
  Created by IntelliJ IDEA.
  User: berno
  Date: 2020-03-01
  Time: 오후 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE>
<html>
<head>
    <style>
        .wrap {
            margin: 30px 50px;
        }
    </style>
    <title>회원목록</title>
</head>
<body class="wrap">
<div style="width:100%; height:200px; overflow:auto; overflow-x: auto">
    <h1>전체회원 목록</h1>
    <table width="100%" border="0" cellspacing="1" cellpadding="0">
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
        <c:forEach var="entity" items="${allUserAccount}" varStatus="status">
            <tr>
                <td>${entity.id}</td>
                <td>${entity.accountEmail}</td>
                <td>${entity.accountPassword}</td>
                <td>${entity.birthDay}</td>
                <td>${entity.sexCode}</td>
                <td>${entity.openScopeCode}</td>
                <td>${entity.countryCode}</td>
                <td>${entity.joinDivisionCode}</td>
                <td>${entity.userName}</td>
                <td>${entity.firstPracticeDatetime}</td>
                <td>${entity.lastPracticeDatetime}</td>
                <td>${entity.createDatetime}</td>
                <td>${entity.createHost}</td>
                <td>${entity.updateDatetime}</td>
                <td>${entity.updateHost}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
<div style="float: right"><a href="/">메인페이지</a></div>
</body>
</html>
