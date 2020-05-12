<%--
  Created by IntelliJ IDEA.
  User: berno
  Date: 2020-03-06
  Time: 오후 3:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원정보 수정</title>
    <style>
        .wrap {
            margin: 30px 50px;
        }

        .table1 {
            font-family: "KoPubWorld돋움체 Light";
            font-size: 12pt;
        }

        .submit input {
            margin-top: 20px;
            width: 100px;
            float: right;
        }

        span {
            color: red;
        }

        td {
            width: 100px;
        }

        th {
            text-align: left;
            width: 100px;
            background-color: gainsboro;
        }

        input .box {
            width: 200px;
            height: 25px;
        }
    </style>
    <script>
        document.getElementById('create_datetime').valueAsDate = new Date();
    </script>
</head>

<body class="wrap">
<div>
    <form action="/userList/userUpdate" method="post">
        <fieldset style="width: 700px">
            <legend><h2>회원정보 수정</h2></legend>

            <table class="table1">
                <tr>
                    <input type="hidden" name="id" value="${param.id}">
                    <th>계정 이메일<span>&nbsp;*</span></th>
                    <td colspan="2"><input type="text" id="accountEmail" class="box" name="accountEmail"
                                           placeholder="Email" value="${param.accountEmail}" disabled></td>
                </tr>
                <tr>
                    <th>계정 암호<span>&nbsp;*</span></th>
                    <td colspan="2"><input type="password" id="accountPassword" class="box" name="accountPassword"
                                           maxlength="16" value=""></td>
                </tr>
<%--                <tr>--%>
<%--                    <th>생년월일</th>--%>
<%--                    <td colspan="2"><input type="text" class="box" name="birthDay" placeholder="주민번호 앞 6자리 입력"--%>
<%--                                           maxlength="6" disabled></td>--%>
<%--                </tr>--%>
<%--                <tr>--%>
<%--                    <th>성&nbsp;&nbsp;별</th>--%>
<%--                    <td><input type="radio" name="sexCode" value="F">여자</td>--%>
<%--                    <td><input type="radio" name="sexCode" value="M">남자</td>--%>
<%--                </tr>--%>
                <tr>
                    <th>공개범위</th>
                    <td><input type="radio" name="openScopeCode" value="A">모두 공개</td>
                    <td><input type="radio" name="openScopeCode" value="F">친구만 공개</td>
                    <td><input type="radio" name="openScopeCode" value="B">모두 비공개</td>

                </tr>
                <tr>
                    <th>국&nbsp;&nbsp;가</th>
                    <td><input type="radio" name="countryCode" value="82">한국</td>
                    <td><input type="radio" name="countryCode" value="86">중국</td>
                    <td><input type="radio" name="countryCode" value="44">영국</td>
                </tr>
<%--                <tr>--%>
<%--                    <th>가입구분</th>--%>
<%--                    <td><input type="radio" name="joinDivisionCode" value="F">Facebook</td>--%>
<%--                    <td><input type="radio" name="joinDivisionCode" value="G">Google</td>--%>
<%--                    <td><input type="radio" name="joinDivisionCode" value="E">Email</td>--%>
<%--                </tr>--%>
                <tr>
                    <th>사용자명</th>
                    <td colspan="2"><input type="text" class="box" name="userName"  value="${param.userName}" disabled></td>
                </tr>

            </table>
            <div class="submit">
                <input type="submit" value="수정완료">
                <input type="reset" value="초기화">
            </div>
        </fieldset>
    </form>
</div>
</body>
</html>
