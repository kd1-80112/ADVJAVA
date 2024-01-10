package com.app.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.dto.AddProductDTO2;
import com.app.dto.AddProductsDTO;
import com.app.dto.ProdUpdatedDTO;
import com.app.dto.ProductRespDTO;
import com.app.entities.Products;

public interface ProductService {
//List<Products> GetAllProducts();
//Products AddProduct(Products prod);
//Products GetProdDetails(Long prodId);
//List<Products>GetProdwithCategory(String catogary);
 ProductRespDTO AddProduct(AddProductsDTO prod);
  AddProductDTO2 addProduct2(Long categoryId,AddProductDTO2 prod);
  List<ProductRespDTO> showproducts(String categoryName);
  String deleteprod(Long productId);
ProdUpdatedDTO updateprice(Long productId,Double productprice);
  
  
}
