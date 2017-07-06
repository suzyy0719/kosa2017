<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>사원 상세 정보</h1>

사원 ID : ${emp.employeeId }<br>
사원 이름 : ${hr.firstName } ${emp.lastName }<br>
이메일 주소 :${emp.email }<br>
전화번호 :${emp.phoneNumber }<br>
입사일자 : ${emp.hireDate }<br>
직업ID :${emp.jobId }<br>
연봉 :${emp.salary }<br>
성과급 :${emp.commissionPct }<br>
매니저 ID :${emp.managerId}<br>
부서 ID : ${emp.departmentId }<br>
<a href="update">수정</a>
</body>
</html>

