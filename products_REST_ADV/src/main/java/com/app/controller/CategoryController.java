package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CategoryDTO;
import com.app.service.CatogaryService;
import com.app.service.ProductService;

@RestController 
@RequestMapping("/category")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {
	@Autowired
	private CatogaryService catgserv;
	
	@PostMapping
	public CategoryDTO addNewCategory(@RequestBody CategoryDTO catg) {
		
		
		return catgserv.addCategory(catg);

}
}