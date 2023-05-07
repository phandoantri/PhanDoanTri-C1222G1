<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/4/2023
  Time: 7:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
</head>
<body>
<form action="/home/calculator">
    <div class="input-group">
        <input type="number"
               class="form-control" name="firstNumber"  >
    </div>
    <div>
        <input type="number"
               class="form-control" name="secondNumber" >
    </div>
    <div class="input-group">
        <button type="submit" class="btn btn-secondary" name="calculator" value="cong">Addition(+)</button>
        <button type="submit" class="btn btn-secondary" name="calculator" value="tru">Subtraction(-)</button>
        <button type="submit" class="btn btn-secondary" name="calculator" value="nhan">Multiplication(x)</button>
        <button type="submit" class="btn btn-secondary" name="calculator" value="chia">Division(/)</button>
    </div>
</form>
<p>Result : ${result}</p>
</body>
</html>

