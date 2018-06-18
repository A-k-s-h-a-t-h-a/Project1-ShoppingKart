package com.myproject.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.shoppingcart.dao.CartDAO;
import com.myproject.shoppingcart.dao.CategoryDAO;
import com.myproject.shoppingcart.dao.ProductDAO;
import com.myproject.shoppingcart.domain.Cart;
import com.myproject.shoppingcart.domain.Category;
import com.myproject.shoppingcart.domain.Product;

@Controller
public class HomeController {

	@Autowired
	private CartDAO cartDAO; 
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	HttpSession httpSession;
	
	Logger log= LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping("/")
	public ModelAndView h()
	{
		log.debug("Start of the home method");
		ModelAndView mv= new ModelAndView("Home");

		List<Category> categories= categoryDAO.list();
		httpSession.setAttribute("categoryList", categories);
		List<Product> products= productDAO.list();
		httpSession.setAttribute("productList", products);
		
		mv.addObject("carouselDisplayedOnce", true);
		
		String loggedInUserID= (String)httpSession.getAttribute("loggedInUserId");
		List<Cart> usercart= cartDAO.list(loggedInUserID);
		httpSession.setAttribute("size", usercart.size());
		
		log.debug("End of the home method");
		return mv;										
	}
	
	@GetMapping("/home")
	public ModelAndView home()
	{
		log.debug("Start of the home method for one instance");
		
		ModelAndView mv= new ModelAndView("Home");
		
		List<Category> categories= categoryDAO.list();
		httpSession.setAttribute("categoryList", categories);
		
		String loggedInUserID= (String)httpSession.getAttribute("loggedInUserId");
		List<Cart> usercart= cartDAO.list(loggedInUserID);
		httpSession.setAttribute("size", usercart.size());
		List<Product> products= productDAO.list();
		httpSession.setAttribute("productList", products);
		
		mv.addObject("brandLogoClicked", true);
		mv.addObject("carouselDisplayedOnce", true);
		
		log.debug("End of the home method for one instance");
		return mv;
	}
	
	
//	@GetMapping("/signin")
//	public ModelAndView l()
//	{
//		log.debug("Start of the sign in method");
//		
//		ModelAndView mv= new ModelAndView("Home");
//		List<Category> categories= categoryDAO.list();
//		httpSession.setAttribute("categoryList", categories);
//		
//		mv.addObject("sinceUserClickedSignIn", true);
//		
//		log.debug("End of the sign in method");
//		return mv;
//	}
	
	@GetMapping("/signup")
	public ModelAndView r()
	{
		log.debug("Start of the sign up method");
		
		ModelAndView mv= new ModelAndView("Home");
		List<Category> categories= categoryDAO.list();
		httpSession.setAttribute("categoryList", categories);
		
		mv.addObject("sinceUserClickedSignUp", true);
		
		log.debug("End of the sign up method");
		return mv;
	}
	
//	@GetMapping("/signout")
//	public ModelAndView lg()
//	{
//		log.debug("Start of the logout method");
//		
//		ModelAndView mv= new ModelAndView("SignIn");
//		List<Category> categories= categoryDAO.list();
//		httpSession.setAttribute("categoryList", categories);
//		
//		httpSession.removeAttribute("loggedInUserId");
//		httpSession.removeAttribute("ifLoggedIn");
//		httpSession.removeAttribute("isAdmin");
//		httpSession.removeAttribute("success");
//		mv.addObject("carouselDisplayedOnce", true);
//		mv.addObject("logoutmessage", "You have successfully logged out");
//		
//		log.debug("End of the logout method");
//		return mv;
//	}

}
