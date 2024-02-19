package com.entity;

public class Customer {
	private String name;
	private String email;
	private Cart cart;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String name, String email) {
		super();
		this.name = name;
		this.email = email;
		this.cart = new Cart();
	}
	public Cart getCart() {
		return cart;
		
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", email=" + email + "]";
	}
	

}