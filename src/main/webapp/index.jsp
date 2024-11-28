<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>EmployeeManagement</title>
</head>
<body>
<h1><%= "EmployeeManagement" %>
</h1>
<br/>
<ul>
    <li><a href="<%=request.getContextPath()%>/departmentController/findAll">List Department </a></li>
    <li><a href="<%=request.getContextPath()%>/employeeController/findAll">List Employee</a></li>
</ul>
</body>
</html>