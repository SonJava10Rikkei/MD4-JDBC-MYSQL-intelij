<%--
  Created by IntelliJ IDEA.
  User: son
  Date: 5/8/2023
  Time: 11:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="text-align: center">FORM CREATE STUDENT</h1>
<c:if test='${requestScope["message"]!=null}'>
    <span style="color: blue">${requestScope["message"]}</span>
</c:if>
<form method="post">
    <label>Name</label><br>
    <input type="text" name="name"><br>
    <label>AGE</label><br>
    <input type="text" name="age"><br>
    <button>Create</button>

</form>
</body>
</html>
