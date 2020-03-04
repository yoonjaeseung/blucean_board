<%--
  Created by IntelliJ IDEA.
  User: berno
  Date: 2020-02-27
  Time: 오전 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE>
<html>
<style>
    .wrap {
        margin: 30px 50px;
    }
</style>
<head>
    <title>Main Page</title>
</head>
<body class="wrap">
<h1>Spring Boot Main </h1><br/>
<h1>${serverTime}</h1>
<h3>안녕하세요 게시판 만들기 입니다.</h3><br />
<div>
    <fieldset>
        <legend><h2>메뉴</h2></legend>
        <ul>
            <li><h3><a href="/login">로그인</a></h3></li>
            <li><h3><a href="/userList">전체회원 목록</a></h3></li>
            <li><h3><a href="/userView">회원 찾기</a></h3></li>
        </ul>
    </fieldset>
</div>



</body>
</html>
