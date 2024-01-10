package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AddProductDTO2;
import com.app.dto.AddProductsDTO;
import com.app.dto.ProdUpdatedDTO;
import com.app.dto.ProductRespDTO;
import com.app.entities.Products;
import com.app.service.ProductService;

@RestController 
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
	@Autowired
	private ProductService proserv;
	
//	@GetMapping
//	public List<Products> getlistofProducts()
//	{
//		return  proserv.GetAllProducts();
//		
//		
//	}
//    @PostMapping
//   public Products postProduct(@RequestBody Products prod)
//   {
//	   return proserv.AddProduct(prod);
//   }
//   @GetMapping("/{prodId}")
//   public Products getProdById(@PathVariable Long prodId)
//   {
//	   return proserv.GetProdDetails(prodId);
//   }
//   @GetMapping("/{categoryName}")
//   public List<Products> getprodByCatg(@PathVariable String catogary)
//   {
//	   return proserv.GetProdwithCategory(catogary);
//   }
   
  @PostMapping
 public ProductRespDTO addNewProduct(@RequestBody AddProductsDTO prod)
 {
	return proserv.AddProduct(prod);
	  
 }
 @PostMapping("/category/{categoryId}")
 public AddProductDTO2 addNewProduct2(@PathVariable Long categoryId,@RequestBody AddProductDTO2 prod)
 {
      return proserv.addProduct2(categoryId,prod);
 
}
@GetMapping("/catgory/{categoryName}")
public List<ProductRespDTO> getProducts(@PathVariable String categoryName)
{
  return proserv.showproducts(categoryName);
}
@DeleteMapping("/{productId}")

	public String deleteProducts(@PathVariable Long productId)
	{
		return proserv.deleteprod(productId);
}
@PutMapping("/{productId}/{productprice}")
public ProdUpdatedDTO updateproduct(@PathVariable Long productId,@PathVariable Double productprice)
{
	return proserv.updateprice(productId,productprice);
}

}
