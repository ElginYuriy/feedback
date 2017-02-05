<%--
  Created by IntelliJ IDEA.
  User: elgin
  Date: 06.01.17
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"
         isELIgnored="false" %>

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
</head>
<body>

<div class="container">
  <c:if test="${pageContext.request.userPrincipal.name != null}">
    <form id="logoutForm" method="POST" action="${contextPath}/logout">
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
    <div class="container page-header well">
        <div class="col-sm-3">
            <h2>Интернет-Банк</h2>
        </div>
        <div class="col-sm-6">
            <h3>${currentUser.firstName} ${currentUser.lastName}  </h3>
            Последний вход ${lastVisit}
        </div>
        <div class="col-sm-3">
            <a href="${contextPath}/feedback" style="text-decoration: none">

                <img src="${contextPath}/resources/image/email.png" style="height: 50px; width: 50px">
                <span class="badge">${newMessages}</span>
            </a>
            <a href="#" onclick="document.forms['logoutForm'].submit()">
               <img src="${contextPath}/resources/image/logout.png" style="height: 50px; width: 50px">
            </a>
        </div>
    </div>

  </c:if>

</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>