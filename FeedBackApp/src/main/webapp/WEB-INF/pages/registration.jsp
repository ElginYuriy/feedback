<%--
  Created by IntelliJ IDEA.
  User: elgin
  Date: 06.01.17
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"
         isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Интернет-Банк</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">


    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

</head>

<body>

<div class="container">

    <form:form method="POST" modelAttribute="userForm" class="form-signin">
        <h2 class="form-signin-heading">Регистрация:</h2>
        <spring:bind path="userName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="userName" class="form-control" placeholder="Ваш логин"
                            autofocus="true"></form:input>
                <form:errors path="userName"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="firstName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="firstName" class="form-control"
                            placeholder="Ваше имя"></form:input>
                <form:errors path="firstName"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="lastName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="lastName" class="form-control"
                            placeholder="Ваша фамилия"></form:input>
                <form:errors path="lastName"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="userPassword">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="userPassword" class="form-control" placeholder="Ваш пароль"></form:input>
                <form:errors path="userPassword"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="confirmUserPassword">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="confirmUserPassword" class="form-control"
                            placeholder="Подтверждение пароля"></form:input>
                <form:errors path="confirmUserPassword"></form:errors>
            </div>
        </spring:bind>



        <button class="btn btn-lg btn-primary btn-block" type="submit">Принять</button>
    </form:form>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>