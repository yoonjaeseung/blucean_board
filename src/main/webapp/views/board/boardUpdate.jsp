<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: berno--%>
<%--  Date: 2020-03-09--%>
<%--  Time: 오후 3:24--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>게시글 수정</title>--%>
<%--    <script src="${pageContext.request.contextPath}/js/jquery-1.10.1.js"></script>--%>
<%--    <script type="text/javascript">--%>
<%--        // Update--%>
<%--        function update_btn() {--%>
<%--            var requestUrl = '/boardUpdate';--%>
<%--            var data = {}; // 객체--%>
<%--            data.id = $("#id").val();//updateView에서 id를 전달 받음--%>
<%--            data.questionContent = $(".updateQuestionContent").val();--%>
<%--            console.log("Update Request id", data.id)--%>
<%--            data = JSON.stringify(data);--%>
<%--            $.ajax({--%>
<%--                type       : 'post',--%>
<%--                url        : requestUrl,--%>
<%--                data       : data,--%>
<%--                dataType   : 'json',//서버가 리턴하는 데이터 타입. 생략 시 자동 파싱 가능--%>
<%--                contentType: 'application/json',--%>
<%--                success    : function (data) {--%>
<%--                    if (data.code === 200) {--%>
<%--                        console.log("Update Response Data:", data)--%>
<%--                        alert("수정을 성공하였습니다")--%>
<%--                        location.reload();--%>
<%--                    }--%>
<%--                },--%>
<%--                error      : function (xhr, e, data) {--%>
<%--                    console.log("Update Error:", xhr + e + data);--%>
<%--                    alert("수정을 실패하였습니다")--%>
<%--                }--%>
<%--            });--%>
<%--        }--%>
<%--    </script>--%>
<%--</head>--%>
<%--<body>--%>
<%--&lt;%&ndash; 글수정 &ndash;%&gt;--%>
<%--<fieldset style="margin-top: 30px">--%>
<%--    <legend style="color: #2aa5f3">회원 QnA 수정</legend>--%>
<%--    <table>--%>
<%--        <input type="hidden" id="id">--%>
<%--        <tr>--%>
<%--            <td>가입자계정/이메일</td>--%>
<%--            <td id="updateViewAccountEmail"></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>전화번호</td>--%>
<%--            <td id="updateViewUserPhoneNumber"></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>질문내용</td>--%>
<%--            <td><textarea rows="10" class="updateQuestionContent" id="updateViewQuestionContent"--%>
<%--                          placeholder="수정할 내용을 입력하세요"></textarea></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td colspan="2">--%>
<%--                <div style="float: right">--%>
<%--                    <button onclick="javascript:update_btn()">완료</button>--%>
<%--                    <button onclick="javascript:clear_btn()">취소</button>--%>
<%--                </div>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--    </table>--%>
<%--</fieldset>--%>
<%--</body>--%>
<%--</html>--%>
