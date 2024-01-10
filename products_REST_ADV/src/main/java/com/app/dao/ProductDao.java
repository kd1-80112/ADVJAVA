package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.dto.ProductRespDTO;
import com.app.entities.Products;

public interface ProductDao extends JpaRepository<Products, Long> {

	List<Products> findByCatogaryName(String categoryName);

}
