<%--
  Created by IntelliJ IDEA.
  User: Owner
  Date: 5/23/2025
  Time: 3:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sandwich Condiments</title>
</head>
<body>
<h2>Sandwich Condiments</h2>
<form action="save" method="post">
    <label><input type="checkbox" name="condiment" value="Lettuce"> Lettuce</label><br/>
    <label><input type="checkbox" name="condiment" value="Tomato"> Tomato</label><br/>
    <label><input type="checkbox" name="condiment" value="Mustard"> Mustard</label><br/>
    <label><input type="checkbox" name="condiment" value="Sprouts"> Sprouts</label><br/>
    <br/>
    <input type="submit" value="Save"/>
</form>
</body>
</html>

