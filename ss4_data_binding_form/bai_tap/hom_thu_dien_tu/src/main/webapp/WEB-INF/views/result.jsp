<%--
  Created by IntelliJ IDEA.
  User: Owner
  Date: 5/26/2025
  Time: 7:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Updated Settings</title>
</head>
<body>
<h2>Updated Settings</h2>
<p><b>Language:</b> ${setting.language}</p>
<p><b>Page Size:</b> ${setting.pageSize} emails/page</p>
<p><b>Spams Filter:</b> ${setting.spamsFilter ? "Enabled" : "Disabled"}</p>
<p><b>Signature:</b><br/>
<pre>${setting.signature}</pre>
</p>
<a href="/settings">Back</a>
</body>
</html>

