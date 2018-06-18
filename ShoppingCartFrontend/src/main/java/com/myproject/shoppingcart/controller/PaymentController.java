package com.myproject.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.myproject.shoppingcart.dao.CartDAO;
import com.myproject.shoppingcart.dao.PaymentDAO;
import com.myproject.shoppingcart.dao.ProductDAO;
import com.myproject.shoppingcart.domain.Cart;
import com.myproject.shoppingcart.domain.Payment;
import com.myproject.shoppingcart.domain.Product;

@Controller
public class PaymentController {

	@Autowired
	private CartDAO cartDAO;

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private Product product;
	
	@Autowired
	private PaymentDAO paymentDAO;

	@Autowired
	private Payment payment;
	
	@Autowired 
	HttpSession httpSession;
	
	Logger log= LoggerFactory.getLogger(PaymentController.class);
	
	
	@ModelAttribute("paying")  //to get the details from the form
	public Payment f1()
	{
		return new Payment();
	}
	@PostMapping("/proceed")
	public String proceedToPayment( @ModelAttribute("paying")  Payment order, Model model)
	{
		log.debug("Starting of the proceed to payment method");
		
		httpSession.getAttribute("loggedInUserId");
		payment= (Payment)httpSession.getAttribute("purchaseDetails");
		
		if((boolean) httpSession.getAttribute("fromCart")==false)
		{
			Product p= (Product)httpSession.getAttribute("productContinue");
			payment.setGrandTotal(p.getPrice()*order.getQuantity());
			payment.setProductName(p.getName()); 
			payment.setQuantity(order.getQuantity());
		}
		payment.setName(order.getName());
		payment.setMobile(order.getMobile());
		payment.setShippingAddress(order.getShippingAddress());
		payment.setPincode(order.getPincode());
		payment.setState(order.getState());
		
		model.addAttribute("purchase1",payment);
		
		log.debug("End of the proceed to payment method");
		return "Payment";
	}
	
	
	@PostMapping("/pay")
	public String payAmount()
	{
		log.debug("Starting of the payment method");
		
		String loggedInUserID= (String)httpSession.getAttribute("loggedInUserId");
		List<Cart> usercart= cartDAO.list(loggedInUserID);
		paymentDAO.save(payment);
		
		if((boolean) httpSession.getAttribute("fromCart")==true)
		{
			payment= (Payment)httpSession.getAttribute("purchaseDetails");
			for(Cart row:usercart)
			{
				product= productDAO.get(row.getProductID());
				System.out.println("Old stock of "+ product.getName()+" was "+product.getStock());
				product.setStock(product.getStock() - row.getQuantity());
				productDAO.update(product);
				System.out.println(product.getStock() + " is qty of " +product.getName()+ " left");
				cartDAO.delete(row.getId());
			}
		}
		else
		{
			product= (Product)httpSession.getAttribute("productContinue");
			System.out.println("Old stock of "+ product.getName()+" was "+product.getStock());
			product.setStock(product.getStock() - payment.getQuantity());
			System.out.println(product.getStock() + " is qty of individual " +product.getName()+ " left");
			productDAO.update(product);
		}
	
		log.debug("End of the payment method");
		return "Confirmed";
	}
	
}
