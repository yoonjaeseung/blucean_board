<%--
  Created by IntelliJ IDEA.
  User: berno
  Date: 2020-03-15
  Time: 오후 8:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>회원검색</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.10.1.js"></script>
    <script type="text/javascript">
        function allList() {
            location.href = "/userList";
        }
        function userAccountDelete(id) {
            location.href = "/userList/userDelete?id="+id;
            alert(id+"번 회원이 삭제되었습니다")
        }
        //fuction으로 값을 두개로 하면 작동안함.
        // function userAccountUpdate(id, accountEmail) {
        //     // location.href = "/userList/userUpdateView?id="+id;
        //     location.href="/userList/userUpdateView?id="+id+"&userAccountEmail="+accountEmail;
        // }

    </script>
</head>
<body>
<h1>검색한 회원</h1>
<form action="/userList/userSearch" method="post">
    <table width="100%" border="0" cellspacing="1" cellpadding="0"
           style="overflow:auto; overflow-x: auto; font-size: 11pt; font-family: 'KoPubWorld돋움체 Light'">
        <tr>
            <td style="float: left">
                <b style="font-size: medium">회원검색&nbsp;</b>
                <input type="text" name="accountEmail" placeholder="계정이메일">
                <input type="submit" value="Search">
                <input type="button" onclick="javascript:allList()" value="전체">
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
    <th></th>


    </thead>
    <tbody style="background-color: aliceblue">
    <c:forEach var="response" items="${userAccountSearch}">
        <tr>
            <td>${response.id}</td>
            <td><a href="/userList/userUpdate?id=${response.id}&accountEmail=${response.accountEmail}&userName=${response.userName}">${response.accountEmail}</a></td>
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
            <td><button onclick="userAccountDelete(${response.id})">삭제</button></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
