package com.myproject.shoppingcart.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.myproject.shoppingcart.domain.Cart;

@Repository("cartDAO")
public interface CartDAO {

	public boolean save(Cart cart);
	
	public boolean update(Cart cart);
	
	public Cart get(int id);
	
	public Cart get(String pr_id);
	
	public List<Cart> list(String userid);
	
	public boolean delete(int id);

}
