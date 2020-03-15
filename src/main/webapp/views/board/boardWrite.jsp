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
    <title>게시판 글쓰기</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.10.1.js"></script>
    <script type="text/javascript">
        function doWrite() {
            var requestUrl = '/board/boardWrite';
            var data = {};
            data.accountEmail = $("#accountEmail").val(); //$()팩토리 함수
            data.userPhoneNumber = $("#userPhoneNumber").val();
            data.questionContent = $("#questionContent").val();
            data = JSON.stringify(data);

            $.ajax({
                type: "POST",
                url: requestUrl,
                data: data,                // $("#form").serialize(), // form을 통째로 넘김
                dataType: 'json',
                contentType: 'application/json',
                success: function (data) {
                    //data에 object 형식으로 데이터 담김
                    if (data.code === 200) {
                        console.log("data : " + data.accountEmail + data.userPhoneNumber + data.questionContent);
                        alert("데이터 생성 완료");
                        location.href = "/";

                    }
                    console.log(data)
                }, error: function (xhr, e, data) {
                    console.log("error" + data);
                    alert("데이터 생성 실패");
                }
            });
        }

    </script>
</head>
<body>
<div>
    <h1>안녕하세요 json</h1>
    <table>
        <tr>
            <td>작성자 이메일</td>
            <td><input id="accountEmail" type="text" name="accountEmail" placeholder="Email 입력"></td>
        </tr>
        <tr>
            <td>휴대전화 번호</td>
            <td><input id="userPhoneNumber" type="text" name="userPhoneNumber"></td>
        </tr>
        <tr>
            <td>글내용</td>
            <td><textarea id="questionContent" name="questionContent" rows="10"></textarea></td>
        </tr>

        <tr>
            <td colspan="2">
                <button onclick="javascript:doWrite()" style="float: right">전송</button>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
