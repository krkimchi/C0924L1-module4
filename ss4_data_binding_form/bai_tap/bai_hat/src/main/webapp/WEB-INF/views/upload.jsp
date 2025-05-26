<%--
  Created by IntelliJ IDEA.
  User: Owner
  Date: 5/26/2025
  Time: 7:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Upload bài hát</title>
</head>
<body>
<h2>Upload bài hát</h2>

<c:if test="${not empty error}">
    <p style="color: red;">${error}</p>
</c:if>

<form:form action="/upload" method="post" modelAttribute="song" enctype="multipart/form-data">
    <p>Tên bài hát: <form:input path="name"/></p>
    <p>Nghệ sĩ: <form:input path="artist"/></p>
    <p>Thể loại: <form:input path="genre"/></p>
    <p>Chọn file nhạc: <input type="file" name="file"/></p>
    <p><input type="submit" value="Upload"/></p>
</form:form>
</body>
</html>

