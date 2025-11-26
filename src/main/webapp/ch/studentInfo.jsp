<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>학생 관리</title>
    <style>
        body { font-family: sans-serif; padding: 20px; }
        table { border-collapse: collapse; width: 100%; margin-top: 10px; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: center; }
        th { background-color: #f2f2f2; }
        .menu-bar { margin-bottom: 20px; padding: 10px; background-color: #eee; border-radius: 5px; }
        .menu-bar a { margin-right: 15px; text-decoration: none; font-weight: bold; color: #333;}
        button { padding: 5px 15px; cursor: pointer; }
    </style>
</head>
<body>
<h2>학생 관리 시스템</h2>

<div class="menu-bar">
    [<a href="/jwbook/studentControl">학생관리</a>]
    [<a href="/jwbook/courseControl">강의관리</a>]
    [<a href="/jwbook/enrollControl">수강신청</a>]
</div>
<hr>

<h3>학생 목록</h3>
<table>
    <tr>
        <th>ID</th><th>이름</th><th>대학</th><th>생일</th><th>이메일</th><th>관리</th> </tr>
    <c:forEach items="${students}" var="s">
        <tr>
            <td>${s.id}</td>
            <td>${s.username}</td>
            <td>${s.univ}</td>
            <td>${s.birth}</td>
            <td>${s.email}</td>
            <td>
                <a href="/jwbook/studentControl?action=delete&id=${s.id}" onclick="return confirm('정말 삭제하시겠습니까?');">
                    <button type="button">삭제</button>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>

<hr>
<h3>학생 등록</h3>
<form method="post" action="/jwbook/studentControl?action=insert">
    <label>이름:</label> <input type="text" name="username">
    <label>대학:</label> <input type="text" name="univ">
    <label>생일:</label> <input type="text" name="birth" placeholder="2000-01-01">
    <label>이메일:</label> <input type="text" name="email">
    <button type="submit">등록</button>
</form>
</body>
</html>