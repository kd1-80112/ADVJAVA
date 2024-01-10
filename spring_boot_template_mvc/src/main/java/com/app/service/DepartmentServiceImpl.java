package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.DepartmentDao;
import com.app.pojos.Department;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService{

	

	@Autowired
	private DepartmentDao deptdao;
	
	@Override
	public List<Department> getAllDepartments()
	{
		return deptdao.findAll();
	}
}
