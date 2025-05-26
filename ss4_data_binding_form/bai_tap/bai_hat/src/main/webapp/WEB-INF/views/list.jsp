<%--
  Created by IntelliJ IDEA.
  User: Owner
  Date: 5/26/2025
  Time: 7:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách bài hát</title>
</head>
<body>
<h2>Danh sách bài hát đã upload</h2>

<table border="1">
    <tr>
        <th>Tên bài hát</th>
        <th>Nghệ sĩ</th>
        <th>Thể loại</th>
        <th>File</th>
    </tr>
    <c:forEach items="${songs}" var="s">
        <tr>
            <td>${s.name}</td>
            <td>${s.artist}</td>
            <td>${s.genre}</td>
            <td><a href="${s.filePath}">Nghe</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

