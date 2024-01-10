package com.app.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.entities.Catogary;

@DataJpaTest // => Spring boot test frmwork will scan entities n dao
@AutoConfigureTestDatabase(replace = Replace.NONE) // => use regulate DB
@Rollback(false)
public class CatogaryDaoTest {
	@Autowired
	private CatogaryDao dao;
	@Test
	void testAddCatogary()
	{
		List<Catogary> list1=List.of(new Catogary("Category1", "DescriptionofCategory1"),
				                     new Catogary("Category2", "DescriptionofCategory2"),
				                     new Catogary("Category3", "DescriptionofCategory3"),
				                     new Catogary("Category4", "DescriptionofCategory4"));
	
	
	List<Catogary> list2 = dao.saveAll(list1);
	assertEquals(4, list2.size());
	
}
}