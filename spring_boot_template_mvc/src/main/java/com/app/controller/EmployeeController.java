package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.service.DepartmentService;
import com.app.service.EmployeeService;
import com.app.service.EmployeeServiceImpl;

@Controller
@RequestMapping("/emps")
public class EmployeeController {

	@Autowired
	private EmployeeService empservice;

@PostMapping("/list")
public String listEmps(Model map,@RequestParam Long deptId)
{
	map.addAttribute("emp_list",empservice.EmpByDeptID(deptId));
	return "/emps/list";
}
@GetMapping("/delete")
public String DeleteEmp(Model map,@RequestParam Long empId,HttpSession session)
{
	map.addAttribute("emp_list",empservice.EmpByDeptID(empId));
	return "/emps/list";
}
}
