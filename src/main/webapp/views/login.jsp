<%@ page import="org.springframework.web.bind.annotation.RequestParam" %><%--
  Created by IntelliJ IDEA.
  User: berno
  Date: 2020-02-27
  Time: 오후 2:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <style>
        .wrap {
            position: relative;
        }

        .box1 {
            position: absolute;
            top: 50px;
            right: 500px;
            left: 500px;
        }

        .box2 {
            position: absolute;
            top: 140px;
            right: 500px;
            left: 500px;
        }

    </style>
</head>
<body class="wrap">
<div>
    <fieldset class="box1" style="width: 400px">
        <legend>로그인</legend>
        <form id="userVO" action="/login" method="post">
            <input type="text" name="userId" placeholder="아이디">
            <input type="password" name="userPw" placeholder="패스워드" maxlength="20">
            <input type="submit" value="GO">
        </form>
    </fieldset>
</div>

<div>
    <fieldset class="box2" style="width: 400px">
        <legend>회원정보</legend>
        <table style="margin-top: 10px">
            <thead style="background: aqua; border-bottom: aquamarine">
            <td style="width: 200px">이름</td>
            <td style="width: 200px">패스워드</td>
            </thead>
            <tbody>
            <td>${userVO.userId}</td>
            <td>${userVO.userPw}</td>
            </tbody>
        </table>
    </fieldset>
</div>

</body>
</html>
