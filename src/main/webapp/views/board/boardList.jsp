<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: berno
  Date: 2020-03-09
  Time: 오후 3:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        .wrap {
            margin: 30px 50px;
        }
    </style>
    <title>게시판 목록</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.10.1.js"></script>
    <script type="text/javascript">
        function showList() {
            var requestUrl = '/board/boardList'; // 변수에 요청할 url 저장
            var data = {};
            data = JSON.stringify(data); // JSON.stringify(data) 데이터를 전달하기 위해 사용
            $.ajax({
                type       : "GET",
                url        : requestUrl,
                data       : data,
                dataType   : 'json', // JSON.stringify(data) 데이터를 전달하기 위해 사용
                contentType: 'application/json', // @RequestBody가 정보를 받기 위해 설정해줌
                success    : function (data) {

                }, error   : function (xhr, e, data) {
                    console.log("error" + data);
                }
            });
        }
    </script>
</head>
<body class="wrap">
<div>
    <table border="1" cellspacing="0" cellpadding="0">
        <thead>
        <td>이메일</td>
        <td>전화번호</td>
        <td>글내용</td>
        </thead>
        <c:forEach var="item" items="${allBoardList}">
            <tbody>
            <td>${item.accountEmail}</td>
            <td>${item.userPhoneNumber}</td>
            <td>${item.questionContent}</td>
            </tbody>
        </c:forEach>
    </table>
</div>
</body>
</html>
