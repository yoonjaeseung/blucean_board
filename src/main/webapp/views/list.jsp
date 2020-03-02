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
<html>
<style>
    .wrap {
        margin: 30px 50px;
    }
</style>
<head>
    <title>User List</title>
</head>
<body class="wrap">
<div align="center">
    <form>
        <h1>회원 리스트</h1>
        <table border="1">
            <thead style="background-color: gainsboro">
            <td>NO</td>
            <td>계정이메일</td>
            <td>계정암호</td>
            <td>생년월일</td>
            <td>성별코드</td>
            <td>공개범위코드</td>
            <td>국가코드</td>
            <td>가입구분코드</td>
            <td>사용자명</td>
            <td>최초실행일시</td>
            <td>최근실행일시</td>
            <td>생성일시</td>
            <td>생성ID</td>
            <td>수정일시</td>
            <td>수정ID</td>


            </thead>
            <tbody>
            <c:forEach var="entity" items="${userAccountList}" varStatus="status">
                <tr>
                    <td>${entity.id}</td>
                    <td>${entity.accountEmail}</td>
                    <td>${entity.accountPassword}</td>
                    <td>${entity.birthday}</td>
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
    </form>
</div>
</body>
</html>
