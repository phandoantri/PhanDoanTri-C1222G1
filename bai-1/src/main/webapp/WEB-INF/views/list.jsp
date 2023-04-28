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
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
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

