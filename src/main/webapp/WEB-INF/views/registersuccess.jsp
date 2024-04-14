<%--
  Created by IntelliJ IDEA.
  User: nykim
  Date: 2024-03-20
  Time: 오후 4:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="kr.ac.hansung.cse.util.UserUtils" %>

<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Please sign in(Custom Login Form)</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous"/>
</head>
<body>
<div class="container">
    <h2 class="form-signin-heading">수강 신청 성공</h2>

    <p>
        <a href="<c:url value='/' />" class="btn btn-lg btn-success btn-block">홈으로 가기</a>
        <a href="<c:url value='/register-course' />" class="btn btn-lg btn-success btn-block">수강신청 계속</a>
    </p>
</div>
</body>
</html>
