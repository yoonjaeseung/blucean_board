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
    <title>게시판</title>
    <style>
        #btnCss {
            background-color: transparent !important;
            background-image: none !important;
            border: none;
            color: #2aa5f3;
        }

        .listTable {
            width: 100%;
        }

        .listTable th {
            padding: 5px;
            border: 0px solid #666666;
            text-align: center;
        }

        .listTable td {
            padding: 5px;
            border: 0px solid #666666;
            border-bottom: 1px solid #008bb9;
        }
    </style>
    <script src="${pageContext.request.contextPath}/js/jquery-1.10.1.js"></script>
    <script type="text/javascript">
        // 전체
        function selectAll_btn() {
            var requestUrl = '/boardSelectAll';
            var data = {} // 객체
            console.log("Select Request Data:", data);
            $.ajax({
                type       : 'get',
                url        : requestUrl,
                data       : data,
                dataType   : 'json',
                contentType: 'application/json',
                success    : function (data) {
                    console.log("Select Response Data:", data);
                    console.log("data length", data.length);
                    var html = "";

                    $("#listBody")
                    if (data.length > 0) {
                        $.each(data, function (index, item) {
                            console.log("Select Response Id:", item.id);
                            html += "<tr>"
                            html += "<td>" + "<input type='button' id='btnCss' onclick='updateView_btn(" + item.id + ")' value='" + item.accountEmail + "'>" + "</td>";
                            html += "<td>" + item.userPhoneNumber + "</td>"
                            html += "<td>" + item.questionContent + "</td>"
                            html += "<td>" + "<button onclick='delete_btn(" + item.id + ")'>" + "삭제" + "</button>" + "</td>"
                            html += "</tr>"
                        })
                    }
                    $("#listBody").children().remove();
                    $("#listBody").append(html);

                }, error   : function (xhr, e, data) {
                    console.log("Select Response Error", data);
                }
            });
        }

        // Read
        function select_btn() {
            var requestUrl = '/boardSelect'; // 변수선언
            // var data = {
            //     accountEmail: 'qwe', userPhoneNumber:'01000000000'
            // } // javascript 객체
            var data = {}; //javascript 객체
            data.accountEmail = $("#accountEmail").val(); // 객체의 속성 추가  controller의 RequestParam 속성네임과 요청한 속성과 매핑
            data.userPhoneNumber = $("#userPhoneNumber").val();
            console.log("Select Request Data:", data.accountEmail + " " + data.userPhoneNumber);
            $.ajax({
                type    : 'get',
                url     : requestUrl,
                data    : data,
                // dataType   : 'json',
                // contentType: 'application/json',
                success : function (data) {
                    console.log("Select Response Data:", data);
                    console.log("data length", data.length);
                    var html = "";

                    if (data.length > 0) { //데이터를 object로 가져오는 제이슨의 사이즈
                        $("#noData").remove(html);
                        $.each(data, function (index, item) { //배열의 인덱스 [0]부터 시작, item에는 각각 배열 요소를 말한다.
                            console.log("Select Response Id:", item.id);
                            html += "<tr>";
                            html += "<td>" + index + "<input type='button' id='btnCss' onclick='updateView_btn(" + item.id + ")' value='" + item.accountEmail + "'>" + "</td>";
                            html += "<td>" + item.userPhoneNumber + "</td>";
                            html += "<td>" + item.questionContent + "</td>";
                            html += "<td>" + "<button onclick='delete_btn(" + item.id + ")'>" + "삭제" + "</button>" + "</td>";
                            html += "</tr>";
                        });
                        $("#listBody").html(html);
                    } else if (data.length <= 0) {
                        alert("검색조건을 입력하세요.");
                        html += "<tr>";
                        html += "<td colspan='4' align='center'>" + "<span style='color: #666666;'>" + "검색 결과가 없습니다" + "</span>" + "</td>";
                        html += "</tr>";
                        $("#noData").html(html);
                    }

                }, error: function (xhr, e, data) {
                    console.log("Select Response Error", data);
                }
            });
        }

        // View
        function updateView_btn(id) {
            var requestUrl = '/boardView';
            var data = {}; // 객체
            data.id = id; //넘겨받은 id를 data에 담아서 서버에 id값을 조회 요청
            console.log("Update View Request id\n", data.id);
            $.ajax({
                    type       : 'get',
                    url        : requestUrl,
                    data       : data,
                    dataType   : 'json',
                    contentType: 'application/json',
                    success    : function (data) {
                        console.log("Update View Response id", data.id + data)
                        alert("상세조회를 성공하였습니다")
                        location.href = '/boardView';
                        $("#id").val(data.id);
                        $("#updateViewAccountEmail").html(data.accountEmail);// 해당 샐럭터의 html 테그 요소와 함께 출력
                        $("#updateViewUserPhoneNumber").html(data.userPhoneNumber);
                        $("#updateViewQuestionContent").html(data.questionContent);
                    },
                    error      : function (xhr, e, data) {
                        console.log("Update View Error:", data);
                        alert("상세조회를 실패하였습니다")
                    }
                }
            );

        }

        // Delete
        function delete_btn(id) {
            var requestUrl = '/boardDelete';
            var data = {}; // 객체
            data.id = id;
            console.log("Delete Request id", data)
            data = JSON.stringify(data);
            $.ajax({
                type       : 'post',
                url        : requestUrl,
                data       : data,
                dataType   : 'json',
                contentType: 'application/json',
                success    : function (data) {
                    console.log(data);
                    if (data.code === 200) {
                        alert("삭제를 성공하였습니다")
                        location.reload();
                    }
                },
                error      : function (xhr, e, data) {
                    console.log("Delete Error:", xhr + e + data);
                    alert("삭제를 실패하였습니다")
                }
            });
        }
    </script>
</head>
<body class="wrap">
<table width="100%" border="0" style="margin-bottom: 10px;">
    <tr>
        <td>
            <label for="accountEmail">가입자계정/이메일</label>
            <input type="text" id="accountEmail" placeholder=" Email"
                   style="width: 200px; height: 30px">


            <label for="userPhoneNumber">전화번호</label>
            <input type="text" id="userPhoneNumber" placeholder=" -없이 입력" maxlength="11"
                   style="width: 200px; height: 30px">

            <button onclick="javascript:select_btn()" style="width: 50px;height: 30px;">검색</button>
            <button onclick="javascript:selectAll_btn()" style="width: 50px;height: 30px;">전체</button>
        </td>
    </tr>
</table>
<%-- 게시판 --%>
<table class="listTable" border="0" cellspacing="1">
    <thead style="background-color: #2aa5f3;">
    <th width="150">가입자계정/이메일</th>
    <th width="200">전화번호</th>
    <th width="300">질문내용</th>
    <th width="50"></th>
    </thead>
    <tbody id="listBody"></tbody>
    <tbody id="noData"></tbody>
</table>
<div><a href="/">메인페이지</a> </div>
</body>
</html>
