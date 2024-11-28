<%--
  Created by IntelliJ IDEA.
  User: 81901
  Date: 2024/11/28
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/departmentController/update" method="post">
  <label for="deptId">Department Name</label>
  <input type="text" id="deptId" name="deptId" value="${departmentUpdate.deptId}" readonly/><br>
  <label for="deptName">Department Name</label>
  <input type="text" id="deptName" name="deptName" value="${departmentUpdate.deptName}"/><br>
  <label for="deptNo">Department No</label>
  <input type="text" id="deptNo" name="deptNo" value="${departmentUpdate.deptNo}"/><br>
  <label for="action">Department status</label>
  <input type="radio" id="action" name="deptStatus" value="true" ${departmentUpdate.deptStatus?'checked':''}/><label for="action">Action</label>
  <input type="radio" id="inAction" name="deptStatus" value="false" ${departmentUpdate.deptStatus?'':'checked'}/><label for="inAction">Inaction</label><br>
  <input type="submit" value="Update">
</form>
</body>
</html>
