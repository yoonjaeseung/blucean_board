<%--
  Created by IntelliJ IDEA.
  User: berno
  Date: 2020-03-03
  Time: 오후 2:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<script type="text/javascript">
    //계정 삭제
    function btn_delete(id) {
        location.href = "/userDelete?id="+id;
        alert("삭제되었습니다")
    }
</script>
<style>
    .wrap {
        margin: 30px 50px;
    }

    table {
        font-family: "KoPubWorld돋움체 Light";
        font-size: 10pt;

    }
</style>
<title>Board View</title>

</head>
<body class="wrap">
<div>
    <form id="userAccount" action="/userView" method="post">
        <table>
            <tr>
                <td><h1>회원찾기</h1></td>
            </tr>
            <tr>
                <td><input type="text" name="accountEmail" placeholder="회원이메일" style="width: 150px;"></td>
                <td><input id="select" type="submit" value="조회" style="width: 100px;"></td>
                <td><input type="reset" value="초기화" style="width: 100px;"></td>
            </tr>
        </table>
    </form>
</div>
<div style="width:100%; height:200px; overflow:auto; overflow-x: auto">
    <table>
        <tr>
            <td><h1>회원 정보</h1></td>
        </tr>
    </table>
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
        <td></td>
        </thead>
        <tbody style="background-color: aliceblue">
        <c:forEach var="entity" items="${userAccountEmail}" varStatus="status">
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
                <td style="alignment: center" >
                    <button>수정</button>
                    <button onclick="btn_delete(${entity.id})">삭제</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div style="float: right"><a href="/">메인페이지</a></div>

</body>
</html>
