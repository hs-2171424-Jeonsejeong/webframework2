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

<html>
  <head>
    <title>학사 정보 시스템</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
      .icon {
        width: 100%;
        height: 100px;
        margin-bottom: 15px;
      }
      .icon i {
        font-size: 5em;
      }
      .navigation-bar {
        display: flex;
        justify-content: space-between;
        padding: 10px;
        background: #f8f9fa;
        align-items: center; /* 추가: 아이템들을 세로 중앙에 위치 */
      }
      .navigation-title {
        flex-grow: 1; /* 추가: 제목이 공간을 채우도록 */
        text-align: center; /* 추가: 텍스트를 중앙으로 정렬 */
        font-size: 24px; /* 추가: 제목 크기 설정 */
      }
      .login-button {
        padding: 5px 15px;
        background: #ffc107;
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
        box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
      }
      .submit-button {
        padding: 10px 20px;
        background: #007bff;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
      }
    </style>
  </head>
  <body>
    <header class="navigation-bar">
      <div></div> <!-- 추가: 좌측 공백을 위해 추가 -->
      <div class="navigation-title">학사 정보 시스템</div>

      <c:if test="${!UserUtils.isAuthenticated()}">
        <button class="login-button" onclick="loginRedirect()">Login</button>
      </c:if>
      <c:if test="${UserUtils.isAuthenticated()}">
        <button class="login-button" onclick="logoutRedirect()">Logout</button>
      </c:if>

    </header>


    <script>
      function loginRedirect() {
        window.location.href = '/login'; // 로그인 페이지 또는 로그인 처리 URL로 리다이렉트
      }

      function logoutRedirect() {
        window.location.href = '/logout'; // 스프링 시큐리티 로그아웃 처리 URL
      }
      // 학년별 이수 학점 조회
      function getGradeCredit() {
          window.location.href = '/grade-credit'; // 학년별 이수 학점 조회 페이지로 이동
      }
      // 수강 신청하기
      function getRegisterCourse() {
          window.location.href = '/register-course'; // 수강 신청 페이지로 이동
      }
      // 수강 신청 조회
      function getCourseList() {
          window.location.href = '/course-list'; // 수강 신청 조회 페이지로 이동
      }
      function getPresentRegistration() {
          window.location.href = '/grade-credit/detail/2024/2'; // 수강 신청 조회 페이지로 이동
      }
    </script>

    <main class="content">
      <!-- 섹션 1 -->
      <section class="card">
        <div class="icon"><i class="fas fa-graduation-cap"></i></div>
        <h2>학년별 이수 학점 조회</h2>
        <p>'학년별 이수 학점 조회' 시 학기별 이수 총 학점을 보여준다. 총계도 보여줍니다.</p> <!-- 내용 -->
        <button class="submit-button" onclick="getGradeCredit()">submit</button>
      </section>

      <!-- 섹션 2 -->
      <section class="card">
        <div class="icon"><i class="fas fa-book"></i></div>
        <h2>수강 신청하기</h2>
        <p>2024년 2학기에 신청할 교과목을 웹 폼을 통해 입력할 수 있습니다.</p> <!-- 내용 -->
        <button class="submit-button" onclick="getRegisterCourse()">submit</button>
      </section>

      <!-- 섹션 3 -->
      <section class="card">
        <div class="icon"><i class="fas fa-user"></i></div>
        <h2>수강 신청 조회</h2>
        <p>메뉴를 통해 2024 년 2 학기 수강 신청 내역을 디스플레이합니다.</p> <!-- 내용 -->
        <button class="submit-button" onclick="getPresentRegistration()">submit</button>
      </section>
    </main>

<%--    <p> <a href="${pageContext.request.contextPath}/offers"> Show current offers</a></p>--%>
<%--    <p> <a href="${pageContext.request.contextPath}/createoffer"> Add a new offer</a></p>--%>

<%--    <c:if test="${pageContext.request.userPrincipal.name != null}">--%>
<%--      <a href="javascript:document.getElementById('logout').submit()">Logout</a>--%>
<%--    </c:if>--%>

<%--    <form id="logout"  action="<c:url value="/logout" />"method="post">--%>
<%--      <input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}" />--%>
<%--    </form>--%>

  </body>
</html>
