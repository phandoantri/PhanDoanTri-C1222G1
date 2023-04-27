<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/27/2023
  Time: 1:48 PM
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
        <label for="vnd">USD :</label>
        <input type="number"
               class="form-control" name="vnd" id="vnd"  placeholder="USD">
    </div>
    <div class="input-group">
        <label for="vnd">VND</label>
        <input type="number"
               class="form-control" name="" id=""  placeholder="VND" value="${result}">
    </div>
    <button type="submit">Change</button>

</form>
</body>
</html>
