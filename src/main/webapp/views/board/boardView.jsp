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
    <title>게시판 글내용</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.10.1.js"></script>
    <script type="text/javascript">

        // function updateView_btn(id) {
        //     var requestUrl = '/boardView';
        //     var data = {}; // 객체
        //     data.id = id; //넘겨받은 id를 data에 담아서 서버에 id값을 조회 요청
        //     console.log("Update View Request id\n", data.id);
        //     $.ajax({
        //             type       : 'get',
        //             url        : requestUrl,
        //             data       : data,
        //             dataType   : 'json',
        //             contentType: 'application/json',
        //             success    : function (data) {
        //                 console.log("Update View Response id", data.id + data)
        //                 alert("상세조회를 성공하였습니다")
        //                 $("#id").val(data.id);
        //                 $("#updateViewAccountEmail").html(data.accountEmail);// 해당 샐럭터의 html 테그 요소와 함께 출력
        //                 $("#updateViewUserPhoneNumber").html(data.userPhoneNumber);
        //                 $("#updateViewQuestionContent").html(data.questionContent);
        //             },
        //             error      : function (xhr, e, data) {
        //                 console.log("Update View Error:", data);
        //                 alert("상세조회를 실패하였습니다")
        //             }
        //         }
        //     );
        //
        // }
    </script>
</head>
<body>
<%-- 글수정 --%>
<fieldset style="margin-top: 30px">
    <legend style="color: #2aa5f3">회원 QnA 수정</legend>
    <table>
        <input type="hidden" id="id">
        <tr>
            <td>가입자계정/이메일</td>
            <td id="updateViewAccountEmail"></td>
        </tr>
        <tr>
            <td>전화번호</td>
            <td id="updateViewUserPhoneNumber"></td>
        </tr>
        <tr>
            <td>질문내용</td>
            <td><textarea rows="10" class="updateQuestionContent" id="updateViewQuestionContent"
                          placeholder="수정할 내용을 입력하세요"></textarea></td>
        </tr>
        <tr>
            <td colspan="2">
                <div style="float: right">
                    <button onclick="javascript:update_btn()">완료</button>
                    <button onclick="javascript:clear_btn()">취소</button>
                </div>
            </td>
        </tr>
    </table>
</fieldset>
</body>
</html>
