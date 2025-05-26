<%--
  Created by IntelliJ IDEA.
  User: Owner
  Date: 5/26/2025
  Time: 7:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Email Settings</title>
    <style>
        body {
            font-family: Arial;
            padding: 20px;
        }

        label {
            display: inline-block;
            width: 100px;
            margin-top: 10px;
        }

        textarea {
            width: 300px;
            height: 80px;
        }

        input[type=submit], button {
            margin-top: 20px;
            padding: 5px 15px;
        }
    </style>
</head>
<body>
<h2>Settings</h2>
<form:form modelAttribute="setting" action="/settings" method="post">
    <div>
        <label>Languages</label>
        <form:select path="language">
            <form:options items="${languages}"/>
        </form:select>
    </div>

    <div>
        <label>Page Size:</label>
        Show <form:select path="pageSize">
        <form:options items="${pageSizes}"/>
    </form:select> emails per page
    </div>

    <div>
        <label>Spams filter:</label>
        <form:checkbox path="spamsFilter"/> Enable spams filter
    </div>

    <div>
        <label>Signature:</label><br/>
        <form:textarea path="signature"/>
    </div>

    <div>
        <input type="submit" value="Update"/>
        <button type="reset">Cancel</button>
    </div>
</form:form>
</body>
</html>
