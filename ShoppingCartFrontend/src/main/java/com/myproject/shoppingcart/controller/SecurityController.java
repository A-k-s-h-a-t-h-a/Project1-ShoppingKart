package com.myproject.shoppingcart.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.shoppingcart.dao.CartDAO;
import com.myproject.shoppingcart.dao.CategoryDAO;
import com.myproject.shoppingcart.dao.ProductDAO;
import com.myproject.shoppingcart.dao.UserDAO;
import com.myproject.shoppingcart.domain.Cart;
import com.myproject.shoppingcart.domain.Category;
import com.myproject.shoppingcart.domain.Product;
import com.myproject.shoppingcart.domain.User;

@Controller
public class SecurityController {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private User user;
	
	@Autowired
	HttpSession httpSession;
	
	@Autowired
	private CartDAO cartDAO;
	
	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	ProductDAO productDAO;
	
	Logger log= LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value="/secure")
	public ModelAndView secure(Principal p)
	{
		System.out.println("Authenticating user "+p.getName());
		ModelAndView mv= new ModelAndView("Home");
		user=userDAO.getByName(p.getName());
		httpSession.setAttribute("success", "Welcome "+ user.getFullname());
		
		httpSession.setAttribute("loggedInUserId", user.getEmailID());
		httpSession.setAttribute("ifLoggedIn", true);
		
		mv.addObject("carouselDisplayedOnce", true);
		
		if (user.getRole().equals("ROLE_ADMIN"))
		{
			httpSession.setAttribute("isAdmin", true);
			return mv;
		}
		List<Cart> carts= cartDAO.list(user.getEmailID());
		
		List<Category> categories= categoryDAO.list();
		httpSession.setAttribute("categoryList", categories);
		httpSession.setAttribute("size", carts.size());	
		httpSession.setAttribute("carts", carts);
		
		return mv;
	}
	
	@RequestMapping(value="/signin")
	public String loginError(@RequestParam(value="error", required= false) String error, 
							 @RequestParam(value="logout", required= false) String logout, Model model)
	{
		if (error!= null)
			model.addAttribute("error", "Invalid username or password");
		if (logout!= null)
		{
			List<Category> categories= categoryDAO.list();
			httpSession.setAttribute("categoryList", categories);
			
			httpSession.removeAttribute("loggedInUserId");
			httpSession.removeAttribute("ifLoggedIn");
			httpSession.removeAttribute("isAdmin");
			httpSession.removeAttribute("success");
			List<Product> products= productDAO.list();
			httpSession.setAttribute("productList", products);
			
			model.addAttribute("logoutmsg", "You have successfully logged out");
			model.addAttribute("home", true);
		}
		model.addAttribute("sinceUserClickedSignIn",true);
		return "Home";
	}
	
	@RequestMapping(value="/accessDenied")
	public ModelAndView wrongUser()
	{
		ModelAndView mv= new ModelAndView("Home");
		mv.addObject("forbidden", "Access Denied");
		return mv;
	}
}
