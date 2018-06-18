package com.myproject.shoppingcart;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.myproject.shoppingcart.dao.ProductDAO;
import com.myproject.shoppingcart.domain.Product;

public class ProductDAOTestCase {

	@Autowired
	private static ProductDAO productDAO;
	
	@Autowired
	private static Product product;
	
	private static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void init(){
		context= new AnnotationConfigApplicationContext();
		context.scan("com.myproject");
		context.refresh();
		productDAO= (ProductDAO)context.getBean("productDAO");
		product= (Product)context.getBean("product");
	}
	
//	@Test
//	public void saveProductTestCase() {
//		product.setProduct_id("01");
//		product.setName("Dell");
//		product.setDescription("Best deals");
//		product.setPrice(25000);
//		product.setStock(80);
//		productDAO.save(product);
//		
//		product.setProduct_id("02");
//		product.setName("Hewlett-Packard");
//		product.setDescription("Offers available");
//		product.setPrice(43000);
//		product.setStock(40);
//		productDAO.save(product);
//		
//		product.setProduct_id("03");
//		product.setName("Vaio");
//		product.setDescription("Latest edition");
//		product.setPrice(125000);
//		product.setStock(10);
//		productDAO.save(product);
//	}

	@Test
	public void updateProductTestCase(){
		product.setProduct_id("008");
		product.setPrice(1000);
		product.setStock(120);
		boolean status= productDAO.update(product);
		assertEquals("Successfully updated", true, status);
	}
	
	@Test
	public void getProductSucceedsTestCase(){
		product= productDAO.get("02");
		assertNotNull("get product test case", product);
	}
	@Test
	public void getProductFailsTestCase(){
		product= productDAO.get("04");
		assertNull("get product test case fails", product);
	}
	
	@Test
	public void deleteProductSucceedsTestCase(){
		boolean status= productDAO.delete("02");
		assertEquals("Successfully deleted", true, status); 
	}
	@Test
	public void deleteProductFailsTestCase(){
		boolean status= productDAO.delete("06");
		assertEquals("Unsuccessfully deleted", false, status); 
	}
	
	@Test
	public void getAllProductTestCase(){
		List<Product> products= productDAO.list();
		assertEquals("get all products", 3, products.size());
	}
}
