<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .formtable {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
        }
        .formtable th, .formtable td {
            border: 1px solid #ccc;
            padding: 8px;
            text-align: left;
        }
        .formtable th {
            background-color: #f2f2f2;
            color: #333;
        }
        .formtable tr:hover {
            background-color: #f9f9f9;
        }
    </style>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/main.css">
    <title>상세 과목 조회</title>
</head>
<body>
<table class="formtable">
    <tr>
        <th>수강년도</th>
        <th>수강학기</th>
        <th>교과목명</th>
        <th>교과구분</th>
        <th>담당교수</th>
        <th>학점</th>
    </tr>
    <c:set var="totalCredits" value="0" />
    <c:forEach var="course" items="${courses}">
        <tr>
            <td>${course.getYear()}</td>
            <td>${course.getSemester()}</td>
            <td>${course.getCourseTitle()}</td>
            <td>${course.getCourseType()}</td>
            <td>${course.getProfessor()}</td>
            <td>${course.getCredits()}</td>
            <c:set var="totalCredits" value="${totalCredits + course.getCredits()}" />
        </tr>
    </c:forEach>
</table>
<p>총 학점: ${totalCredits}</p>
<p><a href="${pageContext.request.contextPath}/">홈으로</a></p>
<p><a href="${pageContext.request.contextPath}/grade-credit">목록으로</a></p>
</body>
</html>
