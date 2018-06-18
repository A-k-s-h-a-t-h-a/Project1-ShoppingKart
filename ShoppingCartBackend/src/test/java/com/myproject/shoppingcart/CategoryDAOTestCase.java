package com.myproject.shoppingcart;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.myproject.shoppingcart.dao.CategoryDAO;
import com.myproject.shoppingcart.domain.Category;

public class CategoryDAOTestCase {

	@Autowired
	private static CategoryDAO categoryDAO;
	
	@Autowired
	private static Category category;
	
	private static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void init()
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.myproject");
		context.refresh();
		categoryDAO= (CategoryDAO)context.getBean("categoryDAO");
		category= (Category)context.getBean("category");
	}
	
//	@Test
//	public void saveCategoryTestCase() {
//		category.setCategory_id("Mob-001");
//		category.setDescription("This is mobile category");
//		category.setName("Mobile");
//		categoryDAO.save(category);
//		
//		category.setCategory_id("Elec-001");
//		category.setDescription("This is electronics category");
//		category.setName("Electronics");
//		categoryDAO.save(category);
//		
//		category.setCategory_id("Books-001");
//		category.setDescription("This is books category");
//		category.setName("Books");
//		categoryDAO.save(category);
//	}

	@Test
	public void updateCategoryTestCase(){
		category.setCategory_id("Mob-002");
		category.setName("Cellphone");
		boolean status= categoryDAO.update(category);
		assertEquals("update category test case", true, status);
	}
	
	@Test
	public void getCategorySucceedsTestCase(){
		category= categoryDAO.get("Mob-001");
		assertNotNull("get Category Test Case", category);
	}
	@Test
	public void getCategoryFailsTestCase(){
		category= categoryDAO.get("Mob-003");
		assertNull("get Category Test Case fails", category);
	}
	
	@Test
	public void deleteCategorySucceedsTestCase(){
		boolean status= categoryDAO.delete("Mob-003");
		assertEquals("delete Category Test Case succeeds", true, status);
	}
	@Test
	public void deleteCategoryFailsTestCase(){
		boolean status= categoryDAO.delete("Mob-002");
		assertEquals("delete Category Test Case fails", false, status);
	}
	
	@Test
	public void getAllCategoryTestCase(){
		List<Category> categories= categoryDAO.list();
		assertEquals("get all categories", 3, categories.size());
	}
}
