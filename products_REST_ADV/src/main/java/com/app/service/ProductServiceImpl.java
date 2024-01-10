package com.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dao.CatogaryDao;
import com.app.dao.ProductDao;
import com.app.dto.AddProductDTO2;
import com.app.dto.AddProductsDTO;
import com.app.dto.ProdUpdatedDTO;
import com.app.dto.ProductRespDTO;
import com.app.entities.Catogary;
import com.app.entities.Products;



@Service
@Transactional
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao prodao;
	@Autowired
	private CatogaryDao catgdao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public ProductRespDTO AddProduct( AddProductsDTO prod) {
     Catogary catogary =catgdao.findById(prod.getCategoryid()).orElseThrow(()->new ResourceNotFoundException("xyz"));
     Products product=mapper.map(prod, Products.class);
     product.setCatogary(catogary);
     Products productpersistant=prodao.save(product);
     return mapper.map(productpersistant, ProductRespDTO.class);
     
		
	}

	@Override
	public AddProductDTO2 addProduct2(Long categoryId,AddProductDTO2 prod) {
		
		Catogary catogary=catgdao.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("catogary not found"));
		Products product =mapper.map(prod,Products.class);
		product.setCatogary(catogary);
        Products productpersistant=prodao.save(product);
        return mapper.map(productpersistant, AddProductDTO2.class);
		
		
		
	}

	@Override
	public List<ProductRespDTO> showproducts(String categoryName) 
	{
		List<Products> product=prodao.findByCatogaryName(categoryName);
		return product.stream().map(s->mapper.map(s,ProductRespDTO.class)).collect(Collectors.toList());
//		return prodao.findByCatogaryName(categoryName).
//				stream().map(s->mapper.map(s, ProductRespDTO.class)).collect(Collectors.toList());	
//		mapper.map(productpersistant, AddProductDTO2.class);
	}

	@Override
	public String deleteprod(Long productId) {
	      prodao.deleteById(productId);
		return ("deleted"+" "+productId);
	}

	@Override
	public ProdUpdatedDTO updateprice(Long productId,Double productprice) {
		Products product=prodao.findById(productId).orElseThrow(()->new ResourceNotFoundException("not"));
	    product.setPrice(productprice);
		
		return mapper.map(product, ProdUpdatedDTO.class);
	}
   




	

	

//	@Override
//	public List<Products> GetAllProducts() {
//		return prodao.findAll();
//		
//	}
//
//	@Override
//	public Products AddProduct(Products prod) {
//		
//		return prodao.save(prod);
//	}
//
//	@Override
//	public Products GetProdDetails(Long prodId) {
//		
//		return prodao.findById(prodId).orElseThrow(() -> new ResourceNotFoundException("Invalid emp id !!!!!"));
//	}
//
//	@Override
//	public List<Products> GetProdwithCategory(String catogary) {
//		
//		return null;
//	}
//	
	
}
