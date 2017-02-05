<%--
  Created by IntelliJ IDEA.
  User: elgin
  Date: 07.01.17
  Time: 13:23
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
</head>
<body>
 <div class="container">
   <c:if test="${pageContext.request.userPrincipal.name != null}">
     <div class="container well">
         <div class="col-sm-3">
             <h2>Интернет-Банк</h2>
         </div>
         <div class="col-sm-6">
             <h3>${currentUser.firstName} ${currentUser.lastName}  </h3>
             Последний вход ${lastVisit}
         </div>
         <div class="col-sm-3">
             <a href="${contextPath}/welcome">
                 <img src="${contextPath}/resources/image/back.png" style="height: 50px; width: 50px"/>
             </a>
         </div>
     </div>
     <div class="container well">
         <div class="col-sm-4">
             <form:form method="POST" modelAttribute="themeForm" acceptCharset="utf-8">
                 <span class="lead">Создание нового обращения:</span>
                 <spring:bind path="themeText">
                     <div class="form-group ${status.error ? 'has-error' : ''}">
                         <form:input type="text" path="themeText" class="form-control" placeholder="Тема обращения"
                                     autofocus="true"></form:input>
                         <form:errors path="themeText"></form:errors>
                     </div>
                 </spring:bind>
                 <spring:bind path="firstMessage">
                     <div class="form-group ${status.error ? 'has-error' : ''}">
                         <form:textarea rows="5" type="text" path="firstMessage" class="form-control" placeholder="Текст обращения"
                                        autofocus="true" cssStyle="resize: none"></form:textarea>
                         <form:errors path="firstMessage"></form:errors>
                     </div>
                 </spring:bind>
                 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                 <button class="btn btn-sm btn-primary btn-block" type="submit" style="width: 150px;">Отправить</button>
             </form:form>
         </div>
         <div class="col-sm-8">
             <span class="lead">Список обращений:</span>
             <table class="table">
                 <thead>
                 <tr>
                     <th width="10px">№</th>
                     <th width="300px">Тема</th>
                     <th width="100px">Дата</th>

                     <th width="50px">Новых ответов</th>
                 </tr>
                 </thead>
                 <tbody>
                 <c:forEach items="${themeList}" var="theme">
                     <tr>
                         <td>${theme.themeID}</td>
                         <td>${theme.themeText}</td>
                         <td>${theme.themeDate}</td>

                         <td><span class="badge">0</span></td>
                         <td><a href="<c:url value="/messages-${theme.themeID}"/>"
                                class="btn btn-success btn-sm">Просмотр</a>
                             <a href="<c:url value="/delete-${theme.themeID}"/>"
                                class="btn btn-danger btn-sm">Удалить</a></td>
                     </tr>
                 </c:forEach>
                 </tbody>
             </table>
         </div>
     </div>
    </c:if>
 </div>

</body>
</html>
