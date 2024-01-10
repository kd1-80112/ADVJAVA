package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CatogaryDao;
import com.app.dto.CategoryDTO;
import com.app.entities.Catogary;

@Service
@Transactional
public class CategoryServiceImpl implements CatogaryService{
	@Autowired
	private CatogaryDao catgdao;
	// dep :
	@Autowired
	private ModelMapper mapper;

	@Override
	public CategoryDTO addCategory(CategoryDTO category) {
		
		  Catogary catg=catgdao.save(mapper.map(category,Catogary.class));
		  return mapper.map(catg, CategoryDTO.class);
		
		
		
	}

}
