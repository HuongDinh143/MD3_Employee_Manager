<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 81901
  Date: 2024/11/28
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Department</title>
</head>
<body>
<table border="1">
  <thead>
  <tr>
    <th>No</th>
    <th>Department Id</th>
    <th>Department Name</th>
    <th>Department No</th>
    <th>Department status</th>
    <th>Action</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${listDepartments}" var="dept" varStatus="loop">
    <tr>
      <td>${loop.index+1}</td>
      <td>${dept.deptId}</td>
      <td>${dept.deptName}</td>
      <td>${dept.deptNo}</td>
      <td>${dept.deptStatus}</td>
      <td>
        <a href="<%=request.getContextPath()%>/departmentController/initUpdate?deptId=${dept.deptId}">Update</a>|
        <a href="<%=request.getContextPath()%>/departmentController/delete?deptId=${dept.deptId}">Delete</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<a href="<%=request.getContextPath()%>/departmentController/initCreate">Create Deparment</a>

</body>
</html>
