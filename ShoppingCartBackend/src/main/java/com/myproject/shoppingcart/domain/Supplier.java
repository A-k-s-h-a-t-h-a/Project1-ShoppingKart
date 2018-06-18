package com.myproject.shoppingcart.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table
public class Supplier implements Serializable {

	@Id
	private String supplier_id;
	@NonNull
	private String name;
	@NonNull
	private String address;
	@OneToMany(mappedBy="supplier", fetch= FetchType.EAGER)
	private Set<Product> products;
	
	
	public String getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
}
