package com.myproject.shoppingcart.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.myproject.shoppingcart.domain.Supplier;

@Repository("supplierDAO")
public interface SupplierDAO {
	
	public boolean save(Supplier supplier);
	
	public boolean update(Supplier supplier);
	
	public Supplier get(String supplier_id);
	
	public List<Supplier> list();
	
	public boolean delete(String supplier_id);
}
