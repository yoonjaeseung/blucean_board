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
<script src="${pageContext.request.contextPath}/js/jquery-1.10.1.js"></script>
<script type="text/javascript">
</script>
<head>
    <title>Main Page</title>
</head>
<body class="wrap">
<h1>Spring Boot Main </h1><br/>
<h1>${serverTime}</h1>
<h2>새로운 게시판</h2><br/>
<div>
    <fieldset>
        <legend><h2>메뉴</h2></legend>
        <ul>
            <li><h3><a href="/userList">회원 목록</a></h3></li>
            <li><h3><a href="/userJoin">회원 가입</a></h3></li>
        </ul>
        <ul>
            <li>
                <h3>
                    <a href="/boardList">글목록</a>
                </h3>
            </li>
            <li><h3><a href="/boardWrite">글쓰기</a></h3></li>
            <li><h3><a href="/bbs">BBS</a></h3></li>
        </ul>
    </fieldset>
</div>


</body>
</html>
