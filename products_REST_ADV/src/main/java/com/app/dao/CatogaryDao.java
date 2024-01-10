package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Catogary;
import com.app.entities.Products;

public interface CatogaryDao extends JpaRepository<Catogary, Long> {

}
