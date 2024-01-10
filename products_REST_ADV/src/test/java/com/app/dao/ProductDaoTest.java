package com.app.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.entities.Catogary;
import com.app.entities.Products;

@DataJpaTest // => Spring boot test frmwork will scan entities n dao
@AutoConfigureTestDatabase(replace = Replace.NONE) // => use regulate DB
@Rollback(false)
public class ProductDaoTest 
{
   @Autowired
   private ProductDao prodao;
   
   @Test
   void testProdSaveAll()
   {//String name, String description, Catogary prodCatagory, Double price, int stock, LocalDate expiryDate
	   List<Products> prodlist1=List.of(new Products("product1","descriptionofprod1",234.32,10,LocalDate.parse("2024-10-12")),
			   new Products("product2","descriptionofprod2",647.45,20,LocalDate.parse("2024-09-21")),
			   new Products("product3","descriptionofprod3",724.23,30,LocalDate.parse("2024-05-19"))
			   );
	   List<Products> prodlist2=prodao.saveAll(prodlist1);
	   assertEquals(3, prodlist1);
   }
}
