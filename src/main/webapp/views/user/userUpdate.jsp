<%--
  Created by IntelliJ IDEA.
  User: berno
  Date: 2020-03-04
  Time: 오후 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <script>
        //게정 수정
        function btn_update() {
            alert("변경되었습니다")
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
    <title>회원정보 수정</title>
</head>
<body class="wrap">

<div>
    <fieldset style="width: 75%">
        <legend><h2>회원정보 수정</h2></legend>
        <form action="/userUpdate" method="post">
            <input type="hidden" name="id" value="${param.id}">
            <table border="0" cellpadding="1" cellspacing="10">
                <tr>
                    <th><label for="accountPassword">변경할 패스워드</label></th>
                    <td><input type="password" id="accountPassword" name="accountPassword"></td>
                </tr>
            </table>


            <table style="float: right">
                <tr>
                    <td><input type="submit" value="확인" style="width: 100px" onclick="btn_update()"></td>
                    <td><input type="reset" value="초기화" style="width: 100px"></td>
                    <td><input type="button" value="취소" onclick="{location.href = '/userView'}" style="width: 100px">
                    </td>
                </tr>
            </table>
        </form>
    </fieldset>
    <%--    <table border="1">--%>
    <%--        <tr>--%>
    <%--            <c:forEach var="entity" items="${accountPaasword}">--%>
    <%--                <td>${entity.}</td>--%>
    <%--            </c:forEach>--%>
    <%--        </tr>--%>
    <%--    </table>--%>
</div>

</body>
</html>
