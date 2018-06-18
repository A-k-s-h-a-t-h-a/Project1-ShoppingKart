package com.myproject.shoppingcart;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.myproject.shoppingcart.dao.SupplierDAO;
import com.myproject.shoppingcart.domain.Supplier;

public class SupplierDAOTestCase {

	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static SupplierDAO supplierDAO;
	
	@Autowired
	private static Supplier supplier;
	
	@BeforeClass
	public static void init()
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.myproject");
		context.refresh();
		supplier= (Supplier)context.getBean("supplier");
		supplierDAO= (SupplierDAO)context.getBean("supplierDAO");
	}
	
//	@Test
//	public void saveSupplierTestCase() {
//		supplier.setSupplier_id("sup-01");
//		supplier.setName("The Souled Store");
//		supplier.setAddress("Mumbai");
//		supplierDAO.save(supplier);
//		
//		supplier.setSupplier_id("sup-02");
//		supplier.setName("Retail.net");
//		supplier.setAddress("NH-33");
//		supplierDAO.save(supplier);
//		
//		supplier.setSupplier_id("sup-03");
//		supplier.setName("India Mart");
//		supplier.setAddress("Nagpur");
//		supplierDAO.save(supplier);
//	}

	@Test
	public void updateSupplierTestCase(){
		supplier.setSupplier_id("sup-07");
		supplier.setName("Retail.net");
		supplier.setAddress("NH-33");
		boolean status= supplierDAO.update(supplier);
		assertEquals("Successfully updated", true, status);
	}
	
	@Test
	public void getSupplierTestCaseSuccess(){
		supplier= supplierDAO.get("02");
		assertNotNull("getting supplier test case", supplier);
	}
	@Test
	public void getSupplierTestCaseFail(){
		supplier= supplierDAO.get("08");
		assertNull("getting supplier test case fails", supplier);
	}
	
	@Test
	public void deleteSupplierTestCaseSuccess(){
		boolean status= supplierDAO.delete("06");
		assertEquals("Deleted properly", true, status);
	}
	@Test
	public void deleteSupplierTestCaseFail(){
		boolean status= supplierDAO.delete("06");
		assertEquals("Not deleted", false, status);
	}
	
	@Test
	public void getAllSuppliersTestCase(){
		List<Supplier> suppliers= supplierDAO.list();
		assertEquals("list of all suppliers", 1, suppliers.size());
	}
}
