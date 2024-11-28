<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 81901
  Date: 2024/11/28
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Employee</title>
</head>
<body>

<table>
  <thead>
  <tr>
    <th>No</th>
    <th>Employee Id</th>
    <th>Employee Name</th>
    <th>Employee Age</th>
    <th>Employee Sex</th>
    <th>Employee Email</th>
    <th>Employee Phone</th>
    <th>Employee Address</th>
    <th>Employee DeptName</th>
    <th>Employee Status</th>
    <th>Action</th>
  </tr>

  </thead>
  <tbody>
  <c:forEach items="${listEmployees}" var="emp" varStatus="loop">
    <tr>
      <td>${loop.index+1}</td>
      <td>${emp.empId}</td>
      <td>${emp.empName}</td>
      <td>${emp.age}</td>
      <td>${emp.sex}</td>
      <td>${emp.empEmail}</td>
      <td>${emp.empPhone}</td>
      <td>${emp.empAddress}</td>
      <td>${emp.department.deptName}</td>
      <td>${emp.empStatus==0?"Đang làm việc":(emp.empStatus==1?"Nghỉ việc":"Nghỉ chế độ")}</td>
      <td>
        <a href="<%=request.getContextPath()%>/employeeController/initUpdate?empId=${emp.empId}">Update</a>|
        <a href="<%=request.getContextPath()%>/employeeController/delete?empId=${emp.empId}">Delete</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<a href="<%=request.getContextPath()%>/employeeController/initCreate">Create Employee</a>
<a href="<%=request.getContextPath()%>/employeeController/initSearch">Search</a>

</body>
</html>
