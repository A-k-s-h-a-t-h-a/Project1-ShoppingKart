package com.myproject.shoppingcart.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.myproject.shoppingcart.domain.Category;

@Repository("categoryDAO")
public interface CategoryDAO {

	public boolean save(Category category);
	
	public boolean update(Category category);
	
	public Category get(String category_id);
	
	public List<Category> list();
	
	public boolean delete(String category_id);

}
