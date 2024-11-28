<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 81901
  Date: 2024/11/28
  Time: 23:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Employee</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/employeeController/update" method="post">
  <label for="empId">Employee Id</label>
  <input type="text" id="empId" name="empId" value="${employeeUpdate.empId}" readonly/><br>
  <label for="empName">Employee Name</label>
  <input type="text" id="empName" name="empName" value="${employeeUpdate.empName}"/><br>
  <label for="age">Employee Age</label>
  <input type="text" id="age" name="age" value="${employeeUpdate.age}"/><br>
  <label for="male">Employee Sex</label>
  <input type="radio" id="male" name="sex" value="true" ${employeeUpdate.sex?'checked':''}/><label for="male">Male</label>
  <input type="radio" id="female" name="sex" value="false" ${employeeUpdate.sex?'':'checked'}/><label for="female">Female</label><br>
  <label for="empEmail">Employee Email</label>
  <input type="text" id="empEmail" name="empEmail" value="${employeeUpdate.empEmail}"/><br>
  <label for="empPhone">Employee Phone</label>
  <input type="text" id="empPhone" name="empPhone" value="${employeeUpdate.empPhone}"/><br>
  <label for="empAddress">Employee Address</label>
  <input type="text" id="empAddress" name="empAddress" value="${employeeUpdate.empAddress}"/><br>
  <label for="deptId">Dept Id</label>
  <select id="deptId" name="department.deptId">
    <c:forEach items="${departments}" var="dept">
      <option value="${dept.deptId}" ${dept.deptId == employeeUpdate.department.deptId ? 'selected' : ''}>
          ${dept.deptName}
      </option>
    </c:forEach>
  </select><br>
  <label for="empStatus">Status</label>
  <select id="empStatus" name="empStatus">
    <option value="0" ${employeeUpdate.empStatus == 0 ? 'selected' : ''}>Đang làm việc</option>
    <option value="1" ${employeeUpdate.empStatus == 1 ? 'selected' : ''}>Nghỉ Việc</option>
    <option value="2" ${employeeUpdate.empStatus == 2 ? 'selected' : ''}>Nghỉ Chế độ</option>
  </select><br>
  <input type="submit" value="Update">
</form>
</body>
</html>
