package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Department;

public interface DepartmentDao extends JpaRepository<Department, Long> {
	List<Department> findAll();
}
