<%--
  Created by IntelliJ IDEA.
  User: ruslan
  Date: 05.12.16
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Api exception</title>
</head>
<body>
Error code: ${exception.errorCode}
<br>
Error message:
<br>
${exception.errorMessage}
Error description:
<br>
${exception.errorDescription}
</body>
</html>
