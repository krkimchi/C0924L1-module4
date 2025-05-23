<%--
  Created by IntelliJ IDEA.
  User: Owner
  Date: 5/23/2025
  Time: 3:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>

<form action="calculate" method="post">
    <input type="number" name="number1" required/>
    <input type="number" name="number2" required/>
    <br/><br/>

    <button type="submit" name="operator" value="+">Addition(+)</button>
    <button type="submit" name="operator" value="-">Subtraction(-)</button>
    <button type="submit" name="operator" value="*">Multiplication(X)</button>
    <button type="submit" name="operator" value="/">Division(/)</button>
</form>

<c:if test="${not empty result}">
    <p><strong>Result ${message} :</strong> ${result}</p>
</c:if>

<c:if test="${not empty error}">
    <p style="color:red;"><strong>${error}</strong></p>
</c:if>
</body>
</html>

