<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/4/2023
  Time: 1:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MAIL</title>
</head>
<body>
<form:form action="/mail" method="post" modelAttribute="mail">
    <form:select path="languages">
        <form:options items="${listLanguages}"/>
    </form:select>
    <br>
    <form:select path="pageSize">
        <form:options items="${listPageSize}"/>
    </form:select>
    <br>
    <form:label path="spamsFilter">Spams filter</form:label>
    <form:input path="spamsFilter"/>
    <br>
    <form:label path="signature">signature</form:label>
    <form:input path="signature"/>
    <button type="submit">update</button>
</form:form>
</body>
</html>
