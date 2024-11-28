<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 81901
  Date: 2024/11/28
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Employee</title>
</head>
<body>
  <label for="empId">Employee Id</label>
  <input type="text" id="empId" name="empId"/><br>
  <label for="empName">Employee Name</label>
  <input type="text" id="empName" name="empName"/><br>
  <label for="age">Employee Age</label>
  <input type="text" id="age" name="age"/><br>
  <label for="male">Employee Sex</label>
  <input type="radio" id="male" name="sex" value="true"/><label for="male">Male</label>
  <input type="radio" id="female" name="sex" value="false"/><label for="female">Female</label><br>
  <label for="empEmail">Employee Email</label>
  <input type="text" id="empEmail" name="empEmail"/><br>
  <label for="empPhone">Employee Phone</label>
  <input type="text" id="empPhone" name="empPhone"/><br>
  <input type="text" id="empAddress" name="empAddress"/><br>
  <label for="deptId">Dept Id</label>
  <select id="deptId" name="department.deptId">
    <c:forEach items="${departments}" var="dept">
      <option value="${dept.deptId}">${dept.deptName}</option>
    </c:forEach>
  </select><br>
  <label for="empStatus">Status</label>
  <select id="empStatus" name="empStatus">
    <option value="0">Đang làm việc</option>
    <option value="1">Nghỉ Việc</option>
    <option value="2">Nghỉ Chế độ</option>
  </select><br>
  <input type="submit" value="Create">
</form>
</body>
</html>
