<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>사원 정보 입력</h1>
	<form action = "insert" method="POST">
	사원ID:  <input type="number" name="employeeId"><br>
	성: <input type="text" name="lastName"><br>
	이름: <input type="text" name="firstName"><br>
	이메일: <input type="text" name="email"><br>
	전화번호: <input type="text" name="phoneNumber"><br>
	입사일자: <input type="date" name="hireDate"><br>
	직업ID: <select name="jobId"><br>
		<c:forEach var="job" items="${jobs}">	
		<option value="${job.key}">${job.value}</option>
		</c:forEach></select><br>
	
	연봉: <input type="number" name="salary"><br>
	성과급: <input type="number" name="commissionPct"><br>
	매니저ID: <select name="managerId"><br>
		<c:forEach var="manager" items="${managers}">	
		<option value="${manager.key}">${manager.value}</option>
		</c:forEach></select><br>
	부서ID: <select name="departmentId">
      <c:forEach var="dept" items="${depts}">
      <option value="${dept.key}">${dept.value}</option>
      </c:forEach></select>
	<input type="submit" value="저장">
	<input type="reset" value="취소">
	</form>
</body>
</html>