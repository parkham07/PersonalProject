<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Thymeleaf vs JSP</title>
</head>

<body>
    <h2>JSP 페이지</h2>
    <spring:url var="formUrl" value="/subscribe-jsp.do" />
    <form:form modelAttribute="subscription" action="${formUrl}">
    <fieldset>
    <div>
        <label for="email"><spring:message code="subscription.email" text="이메일" />: </label>
        <form:input path="email" />
    </div>
    <div>
        <label><spring:message code="subscription.type" text="타입" />: </label>
        <ul>
            <c:forEach var="type" items="${allTypes}" varStatus="typeStatus">
            <li>
                <form:radiobutton path="subscriptionType" value="${type}" />
                <label for="subscriptionType${typeStatus.count}">
                <spring:message code="subscriptionType.${type}" />
                </label>
            </li>
            </c:forEach>
        </ul>
    </div>
    <div class="submit">
        <button type="submit" name="save"><spring:message code="subscription.submit" text="구독!" /></button>
    </div>
    </fieldset>
    </form:form>
</body>
</html>