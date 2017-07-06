package com.coderby.myapp.hr.service;

import java.util.List;
import java.util.Map;

import com.coderby.myapp.hr.model.EmpVO;

public interface IEmpService {
	int getEmpCount();
	int getEmpCount(int deptid);
	EmpVO getEmpInfo(String employeeId);
	List<EmpVO> getEmpList();

	void insertEmp(EmpVO emp);

	void updateEmp(EmpVO emp);

	void deleteEmp(String empid, String email);
	List<Map<Integer, String>> getAllDeptId();
	List<Map<String, Object>> getAllJobId();
	List<Map<String, Object>> getAllManagerId();
	void deleteJobHistory(String empid);
}
