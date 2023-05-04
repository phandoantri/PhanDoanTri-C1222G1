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
    <title>Dictionary</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
</head>
<body>
<form>
    <div class="input-group">
        <label for="english">English</label>
        <input type="text"
               class="form-control" name="english" id="english" value="${word}">
    </div>
    <div class="input-group">
        <label for="vietnamese">Vietnamese</label>
        <input type="text"
               class="form-control" id="vietnamese" value="${vietnamese}">
    </div>
    <button type="submit">Search</button>
</form>
</body>
</html>
