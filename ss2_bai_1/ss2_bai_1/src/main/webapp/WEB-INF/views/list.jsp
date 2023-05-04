<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/3/2023
  Time: 9:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
</head>
<body>
<form action="/save">
    <div class="input-group">
        <label for="lettuce"></label>
        <input type="text"
               class="form-control" name="condiments" value="lettuce" id="lettuce" >
    </div>
    <div class="input-group">
        <label for="tomato"></label>
        <input type="text"
               class="form-control" name="condiments" value="tomato" id="tomato" >
    </div>
    <div class="input-group">
        <label for="mustard"></label>
        <input type="text"
               class="form-control" name="condiments" value="mustard" id="mustard" >
    </div>
    <div class="input-group">
        <label for="sprouts"></label>
        <input type="text"
               class="form-control" name="condiments" value="sprouts" id="sprouts" >
    </div>
    <button type="submit">Save</button>
</form>
<p>The condiments in the sandwich : ${condimentsList}</p>
</body>
</html>
