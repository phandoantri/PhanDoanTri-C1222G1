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
</head>
<body>
<form action="/home/calculator">
    <div class="input-group">
        <input type="number"
               class="form-control" name="number1"  >
        <input type="number"
               class="form-control" name="number2" >
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
