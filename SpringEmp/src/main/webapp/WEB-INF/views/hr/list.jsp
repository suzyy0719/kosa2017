<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>사원 목록</h1>
	<table border = 1>
	<tr>
		<th>사원ID</th>
		<th>이름</th>
	</tr>
	<c:forEach var="emp" items="${emps }">
	<tr>
		<td><a href="<c:url value='/hr/${emp.employeeId}'/>">${emp.employeeId}</a></td>
		<td>${emp.firstName }${emp.lastName }</td>	
	</tr>
	</c:forEach>
	</table>
</body>
</html>