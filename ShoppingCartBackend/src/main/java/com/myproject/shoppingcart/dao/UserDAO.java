package com.myproject.shoppingcart.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.myproject.shoppingcart.domain.User;

@Repository("userDAO")
public interface UserDAO {
	
	public boolean save(User user);
	
	public boolean update(User user);
	
	public User get(String emailId);
	
	public boolean delete(String emailId);
	
	public List<User> list();
		
	public User validate(String emailId, String password);

	public User getByName(String name);
}
