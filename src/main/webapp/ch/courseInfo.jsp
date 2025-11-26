<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>강의 관리</title>
    <style>
        /* 유비가 디자인한 심플 스타일 */
        body { font-family: sans-serif; padding: 20px; }
        table { border-collapse: collapse; width: 100%; margin-top: 10px; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: center; }
        th { background-color: #f2f2f2; }
        .menu-bar { margin-bottom: 20px; padding: 10px; background-color: #eee; border-radius: 5px; }
        .menu-bar a { margin-right: 15px; text-decoration: none; font-weight: bold; color: #333;}
        h3 { margin-top: 30px; border-bottom: 2px solid #ddd; padding-bottom: 10px;}
        button { padding: 5px 15px; cursor: pointer; }
    </style>
</head>
<body>
<h2> 강의 관리 시스템 </h2>

<div class="menu-bar">
    [<a href="/jwbook/studentControl">학생관리</a>]
    [<a href="/jwbook/courseControl">강의관리</a>]
    [<a href="/jwbook/enrollControl">수강신청</a>]
</div>

<h3>개설된 강의 목록</h3>
<table>
    <tr>
        <th>ID</th> <th>강의명</th> <th>교수님</th> <th>학점</th> <th>관리</th>
    </tr>
    <c:forEach items="${courses}" var="c">
        <tr>
            <td>${c.cid}</td>
            <td>${c.cname}</td>
            <td>${c.professor}</td>
            <td>${c.credit}</td>
            <td>
                <a href="/jwbook/courseControl?action=delete&id=${c.cid}" onclick="return confirm('이 강의를 삭제하시겠습니까?');">
                    <button type="button">삭제</button>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>

<h3>새 강의 개설</h3>
<form method="post" action="/jwbook/courseControl?action=insert">
    <label>강의명:</label> <input type="text" name="cname" required>
    <label>교수님:</label> <input type="text" name="professor" required>
    <label>학점:</label> <input type="number" name="credit" required>
    <button type="submit">등록</button>
</form>
</body>
</html>