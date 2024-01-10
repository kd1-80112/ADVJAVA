package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.service.DepartmentService;

@Controller
@RequestMapping("/departments")
public class DepartmentController {
@Autowired
private DepartmentService deptservice;

public  DepartmentController() {
	// TODO Auto-generated constructor stub
}

//@GetMapping("/list")
//public ModelAndView listAllDepts()
//{
//  return new ModelAndView("/departments/list","dept_list",deptservice.getAllDepartments());	
//}
@GetMapping("/list")
public String listDept(Model map)
{
	map.addAttribute("dept_list",deptservice.getAllDepartments());
	return "/departments/list";
}
}
