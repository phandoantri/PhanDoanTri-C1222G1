<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/27/2023
  Time: 4:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form>
    <div class="input-group">
        <label for="english">English</label>
        <input type="text"
               class="form-control"  name="english" id="english" value="${word}">
    </div>
    <div class="input-group">
        <label for="vietnamese">Vietnamese</label>
        <input type="text"
               class="form-control"  id="vietnamese"  value="${vietnamese}" >
    </div>
    <button type="submit">Search</button>
</form>
</body>
</html>
