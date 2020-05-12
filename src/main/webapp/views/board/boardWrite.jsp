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
        // Create
        function insert_btn() {
            var requestUrl = '/boardInsert';
            // var data = {
            //     accountEmail: "qwe", userPhoneNumber:"01012341234", questionContent:"안녕 배열"
            // }
            var data = {}; // 객체
            data.accountEmail = $("#insertAccountEmail").val(); // 객체의 속성 추가
            data.userPhoneNumber = $("#insertUserPhoneNumber").val();
            data.questionContent = $("#insertQuestionContent").val();
            data = JSON.stringify(data); //자바스크립트 객체를 json 객체로 변환
            console.log("Insert Request Data:", data);
            $.ajax({
                type: 'post',
                url: requestUrl,
                data: data,
                // dataType   : 'json',
                contentType: 'application/json',
                success: function (response) {
                    console.log("Insert Response Data:", response);
                    if (response.code === 200) {
                        alert("생성을 성공하였습니다.")
                        location.window.href = '/boardList';
                    }
                },
                error: function (xhr, e, response) {
                    console.log("Insert Error:", xhr, e, response);
                }
            });
        }

        function clear_btn() {
            $("#insertAccountEmail").val('');
            $("#insertUserPhoneNumber").val('');
            $("#insertQuestionContent").val('');
            $(".updateQuestionContent").val('');
        }
    </script>
</head>
<body>
<%-- 글쓰기 --%>
<fieldset style="margin-top: 50px">
    <legend>회원 QnA 작성</legend>
    <table>
        <tr>
            <td>가입자계정/이메일</td>
            <td><input type="text" id="insertAccountEmail" placeholder="Email input"></td>
        </tr>
        <tr>
            <td>전화번호</td>
            <td><input type="text" id="insertUserPhoneNumber" placeholder="-없이 입력" maxlength="11"></td>
        </tr>
        <tr>
            <td>질문내용</td>
            <td><textarea rows="10" id="insertQuestionContent" placeholder="내용을 입력하세요"></textarea></td>
        </tr>
        <tr>
            <td colspan="2">
                <div style="float: right">
                    <button onclick="javascript:insert_btn()">완료</button>
                    <button onclick="javascript:clear_btn()">취소</button>
                </div>
            </td>
        </tr>
    </table>
</fieldset>
</body>
</html>
