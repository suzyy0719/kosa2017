package com.coderby.myapp.hr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coderby.myapp.hr.model.EmpVO;
import com.coderby.myapp.hr.service.IEmpService;

@Controller
@RequestMapping("/hr")
public class EmpController {
	
	@Autowired
	IEmpService empService;
	
	@RequestMapping(value="/count", method=RequestMethod.GET)
	public String getEmpCount(Model model){
		model.addAttribute("result", empService.getEmpCount());
		return "hr/count";
	}
	
	@RequestMapping(value="/count/{deptid}", method=RequestMethod.GET)
	public String getEmpCount(@PathVariable int deptid, Model model){
		if(deptid==0){
			model.addAttribute("result", empService.getEmpCount());
		}else {
			model.addAttribute("result", empService.getEmpCount(deptid));
		}
		return "hr/count";
	}
	
	@RequestMapping(value="/{employeeId}", method=RequestMethod.GET)
	public String getEmpInfo(@PathVariable String employeeId,  Model model){
		model.addAttribute("emp", empService.getEmpInfo(employeeId));
		return "hr/view";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String list(Model model){
		List<EmpVO> emps = empService.getEmpList();
		model.addAttribute("emps", emps);
		return "hr/list";
	}
	
	public Map<Integer, String> getAllDeptId(){
		Map<Integer, String> depts = new HashMap<Integer, String>();
		depts.put(10, "Administration");
		depts.put(20, "Marketing");
		depts.put(30, "Purchasing");
		depts.put(40, "Human Resources");
		depts.put(50, "Shipping");
		depts.put(60, "IT");
		depts.put(70, "Public Relations");
		depts.put(80, "Sales");
		depts.put(90, "Executive");
		depts.put(100, "Finance");
		depts.put(110, "Accounting");
		return depts;
	}
	
	public Map<String, String> getAllJobId(){
		Map<String, String> jobs = new HashMap<String, String>();
		jobs.put("AD_PRES", "President");
		jobs.put("AD_VP", "Administration Vice President");
		jobs.put("AD_ASST", "Administration Assistant");
		jobs.put("FI_MGR", "Finance Manager");
		jobs.put("FI_ACCOUNT", "Accountant");
		jobs.put("AC_MGR", "Accounting Manager");
		jobs.put("AC_ACCOUNT", "Public Accountant");
		jobs.put("SA_MAN", "Sales Manager");
		jobs.put("SA_REP", "Sales Representative");
		jobs.put("PU_MAN", "Purchasing Manager");
		jobs.put("PU_CLERK", "Purchasing Clerk");
		jobs.put("ST_MAN", "Stock Manager");
		jobs.put("ST_CLERK", "Stock Clerk");
		jobs.put("SH_CLERK", "Shipping Clerk");
		jobs.put("IT_PROG", "Programmer");
		jobs.put("MK_MAN", "Marketing Manager");
		jobs.put("MK_REP", "Marketing Representative");
		jobs.put("HR_REP", "Human Resources Representative");
		jobs.put("PR_REP", "Public Relations Representative");
		return jobs;
	}
	
	public Map<Integer, String> getAllManagertId(){
		Map<Integer, String> managers = new HashMap<Integer, String>();
		managers.put(100, "100");
		managers.put(101, "101");
		managers.put(102, "102");
		managers.put(103, "103");
		managers.put(108, "108");
		managers.put(114, "114");
		managers.put(120, "120");
		managers.put(121, "121");
		managers.put(122, "122");
		managers.put(123, "123");
		managers.put(124, "124");
		return managers;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insertEmp(Model model){
		model.addAttribute("jobs", getAllJobId());
		model.addAttribute("depts", getAllDeptId());
		model.addAttribute("managers", getAllManagertId());
		return "hr/insertform";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(EmpVO emp){
		empService.insertEmp(emp);
		return "redirect:/hr";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String updateEmp(String employeeId,  Model model){

		empService.getEmpInfo(employeeId);
		return "hr/updateform";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateEmp(EmpVO emp, Model model){
			empService.updateEmp(emp);
			return "redirect:/hr/view";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String deleteEmp(String employeeId, Model model){
		return "hr/deleteform";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String deleteEmp(String employeeId, String email, Model model){
			empService.deleteEmp(employeeId, email); 
			return "redirect:/hr";
		}
	}

