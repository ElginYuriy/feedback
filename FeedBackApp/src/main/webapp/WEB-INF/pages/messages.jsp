<%--
  Created by IntelliJ IDEA.
  User: elgin
  Date: 07.01.17
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"
         isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
                  <a href="${contextPath}/feedback">
                      <img src="${contextPath}/resources/image/back.png" style="height: 50px; width: 50px"/>
                  </a>
              </div>
          </div>
          <div class="container well">
              <div class="col-sm-4">
                  <form:form method="POST" modelAttribute="messageForm" acceptCharset="utf-8">
                      <span class="lead">Создание нового сообщения:</span>
                      <spring:bind path="messageText">
                          <div class="form-group ${status.error ? 'has-error' : ''}">
                              <form:textarea rows="5" type="text" path="messageText" class="form-control" placeholder="Новое сообщение"
                                             autofocus="true" cssStyle="resize: none;"></form:textarea>
                              <form:errors path="messageText"></form:errors>
                          </div>
                      </spring:bind>
                      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                      <button class="btn btn-sm btn-primary btn-block" type="submit" style="width: 150px;">Отправить</button>
                  </form:form>
              </div>
              <div class="col-sm-8">
                  <span class="lead">Сообщения: ${themeForm.themeText} </span>
                  <ul class="list-group">
                      <c:forEach items="${messageList}" var="message">
                        <li class="list-group-item">
                          <div class="row">
                            <div class="col-sm-3">
                                <div class="well">
                                    <c:choose>
                                        <c:when test="${message.messageDirection =='out'}">
                                            <b>${currentUser.firstName} ${currentUser.lastName}</b>
                                        </c:when>
                                        <c:when test="${message.messageDirection =='in'}">
                                            <b>Интернет-Банк</b>
                                        </c:when>
                                    </c:choose>
                                    <small>Дата: ${message.messageDate}</small>
                                </div>
                            </div>
                            <div class="col-sm-9">
                                <div class="well">
                                       <b>ID:  ${message.messageID}</b><br>
                                        ${message.messageText}
                                </div>
                            </div>
                          </div>
                        </li>
                      </c:forEach>
                  </ul>
              </div>

          </div>
      </c:if>
    </div>
</body>
</html>
