package com.myproject.shoppingcart.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table
public class Product implements Serializable {

	@Id
	private String product_id;
	@NonNull
	private String name;
	@NonNull
	private int price;
	@Nullable
	private String description;
	@NonNull
	private int stock;
	private Date date_created;
	private String cat_id;
	private String sup_id;
	
	@ManyToOne
	@JoinColumn(name="cat_id", updatable= false, insertable= false, nullable= false)
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="sup_id", updatable= false, nullable= false, insertable= false)
	private Supplier supplier;
	
	
	public String getCat_id() {
		return cat_id;
	}
	public void setCat_id(String cat_id) {
		this.cat_id = cat_id;
	}
	public String getSup_id() {
		return sup_id;
	}
	public void setSup_id(String sup_id) {
		this.sup_id = sup_id;
	}
	
	
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getName() {
		return name;
	}
	public String setName(String name) {
		return this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate_created() {
		return date_created;
	}
	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
}
