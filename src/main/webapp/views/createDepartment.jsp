<%--
  Created by IntelliJ IDEA.
  User: 81901
  Date: 2024/11/28
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Department</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/departmentController/create" method="post">
  <label for="deptName">Department Name</label>
  <input type="text" id="deptName" name="deptName"/><br>
  <label for="deptNo">Department No</label>
  <input type="text" id="deptNo" name="deptNo"/><br>
  <label for="action">Department status</label>
  <input type="radio" id="action" name="deptStatus" value="true" checked/><label for="action">Action</label>
  <input type="radio" id="inAction" name="deptStatus" value="false"/><label for="inAction">Inaction</label><br>
  <input type="submit" value="Create">
</form>
</body>
</html>
