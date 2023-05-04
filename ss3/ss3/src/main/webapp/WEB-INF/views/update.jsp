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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
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

