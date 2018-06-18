package com.myproject.shoppingcart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.myproject.shoppingcart.dao.CartDAO;
import com.myproject.shoppingcart.domain.Cart;

public class CartDAOTestCase {


	@Autowired
	private static CartDAO cartDAO;
	
	@Autowired
	private static Cart cart;
	
	private static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void init()
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.myproject");
		context.refresh();
		cartDAO= (CartDAO)context.getBean("cartDAO");
		cart= (Cart)context.getBean("cart");
	}
	
//	@Test
//	public void saveCartTestCase() {
//		cart.setEmailID("kiran@gmail.com");
//		cart.setProductName("Lenovo");
//		cart.setProductID("Len-01");
//		cart.setPrice(20000);
//		cart.setQuantity(1);
//		cartDAO.save(cart);
//	}
	
	@Test
	public void updateCartTestCase(){
		cart.setEmailID("kiran@gmail.com");
		cart.setProductName("Acer");
		cart.setProductID("Ace-01");
		cart.setPrice(35000);
		cart.setQuantity(1);
		boolean status= cartDAO.update(cart);
		assertEquals("update cart test case", true, status);
	}
	
	@Test
	public void getCartSuccessTestCase()
	{
		cart= cartDAO.get(01);
		assertNotNull("get cart test case", cart);
	}
	@Test
	public void getCartFailureTestCase()
	{
		cart= cartDAO.get(002);
		assertNull("get cart test case fails", cart);
	}
	
	@Test
	public void deleteCartSuccessTestCase()	
	{
		boolean status= cartDAO.delete(03);
		assertEquals("delete cart success test case", true, status);
	}
	@Test
	public void deleteCartFailureTestCase()	
	{
		boolean status= cartDAO.delete(04);
		assertEquals("delete cart failure test case", false, status);
	}
	
	@Test
	public void getAllCartsTestCase()
	{
		List<Cart> carts= cartDAO.list("michelle@gmail.com");
		assertEquals("get all carts", 1, carts.size());
	}
}
