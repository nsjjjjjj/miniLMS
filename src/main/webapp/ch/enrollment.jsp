<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>수강 신청</title>
    <style>
        body { font-family: sans-serif; padding: 20px; }
        table { border-collapse: collapse; width: 100%; margin-top: 10px; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: center; }
        th { background-color: #e8f5e9; } /* 초록색 느낌 */
        .menu-bar { margin-bottom: 20px; padding: 10px; background-color: #eee; border-radius: 5px; }
        .menu-bar a { margin-right: 15px; text-decoration: none; font-weight: bold; color: #333;}
        .form-box { background-color: #fafafa; padding: 15px; border: 1px solid #ddd; display: inline-block;}
        button { padding: 5px 15px; cursor: pointer; background-color: #4CAF50; color: white; border: none;}
    </style>
</head>
<body>
<h2>📝 수강 신청 시스템 </h2>

<div class="menu-bar">
    [<a href="/jwbook/studentControl">학생관리</a>]
    [<a href="/jwbook/courseControl">강의관리</a>]
    [<a href="/jwbook/enrollControl">수강신청</a>]
</div>
<hr>

<h3>수강신청 하기</h3>
<div class="form-box">
    <form method="post" action="/jwbook/enrollControl?action=insert">
        <label>학생 선택:</label>
        <select name="student_id">
            <c:forEach items="${sList}" var="s">
                <option value="${s.id}">${s.username} (${s.univ})</option>
            </c:forEach>
        </select>

        <label>강의 선택:</label>
        <select name="course_id">
            <c:forEach items="${cList}" var="c">
                <option value="${c.cid}">${c.cname} (${c.professor})</option>
            </c:forEach>
        </select>

        <button type="submit">신청하기</button>
    </form>
</div>

<hr>

<h3> 전체 수강신청 현황</h3>
<table>
    <tr>
        <th>No.</th> <th>학생명</th> <th>강의명</th> <th>신청일</th> <th>관리</th>
    </tr>
    <c:forEach items="${eList}" var="e">
        <tr>
            <td>${e.eid}</td>
            <td>${e.studentName}</td>
            <td>${e.courseName}</td>
            <td>${e.regDate}</td>
            <td>
                <a href="/jwbook/enrollControl?action=delete&id=${e.eid}" onclick="return confirm('수강 신청을 취소하시겠습니까?');">
                    <button type="button">취소</button>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>