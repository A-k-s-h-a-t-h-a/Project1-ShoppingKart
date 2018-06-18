package com.myproject.shoppingcart.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table
public class Cart implements Serializable{

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	@Email
	private String emailID;
	@NonNull
	private String productName;
	@NonNull
	private int price;
	@NonNull
	private int quantity;
	@NonNull
	private String productID;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}
	
}
