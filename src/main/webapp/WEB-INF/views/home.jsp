<%--
  Created by IntelliJ IDEA.
  User: nykim
  Date: 2022/12/13
  Time: 12:55 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="kr.ac.hansung.cse.util.UserUtils" %>

<!DOCTYPE html>
<html>
<head>
  <title>학사 정보 시스템</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <style>
    .navigation-bar {
      display: flex;
      justify-content: space-between;
      padding: 10px;
      background: #f8f9fa;
      align-items: center;
    }

    .navigation-title {
      flex-grow: 1;
      text-align: center;
      font-size: 24px;
      color: #007bff;
    }

    .login-button {
      padding: 5px 15px;
      background: #ffc107;
      border: none;
      border-radius: 5px;
    }

    .logout-button {
      padding: 5px 15px;
      background: #dc3545; /* 로그아웃 버튼 배경색 */
      color: white;
      border: none;
      border-radius: 5px;
    }

    .content {
      display: flex;
      justify-content: center;
      padding: 20px;
    }

    .cards-container {
      display: flex;
      justify-content: space-between;
      width: 100%;
    }

    .card {
      margin: 10px;
      flex-basis: calc(33.333% - 20px);
      text-align: center;
      padding: 20px;
      box-shadow: 0 2px 4px 0 rgba(0,0,0,0.1), 0 4px 8px 0 rgba(0,0,0,0.2);
    }

    .submit-button {
      padding: 10px 20px;
      background: #28a745;
      color: white;
      border: none;
      border-radius: 5px;
      cursor: pointer;
    }
  </style>
</head>
<body>
<header class="navigation-bar">
  <div></div>
  <div class="navigation-title">학사 정보 시스템</div>

  <%-- 사용자가 인증되어 있는지 확인하여 로그인 또는 로그아웃 버튼을 표시 --%>
  <c:if test="${!UserUtils.isAuthenticated()}">
    <button class="login-button" onclick="loginRedirect()">Login</button>
  </c:if>
  <c:if test="${UserUtils.isAuthenticated()}">
    <button class="logout-button" onclick="logoutRedirect()">Logout</button>
  </c:if>

</header>

<script>
  function loginRedirect() {
    window.location.href = '/login';
  }

  function logoutRedirect() {
    window.location.href = '/logout';
  }

  function getGradeCredit() {
    window.location.href = '/grade-credit';
  }

  function getRegisterCourse() {
    window.location.href = '/register-course';
  }

  function getPresentRegistration() {
    window.location.href = '/grade-credit/detail/2024/2';
  }
</script>

<main class="content">
  <section class="card">
    <h2>학년별 이수 학점 조회</h2>
    <button class="submit-button" onclick="getGradeCredit()">submit</button>
  </section>

  <section class="card">
    <h2>수강 신청하기</h2>
    <button class="submit-button" onclick="getRegisterCourse()">submit</button>
  </section>

  <section class="card">
    <h2>수강 신청 조회</h2>
    <button class="submit-button" onclick="getPresentRegistration()">submit</button>
  </section>
</main>

</body>
</html>



