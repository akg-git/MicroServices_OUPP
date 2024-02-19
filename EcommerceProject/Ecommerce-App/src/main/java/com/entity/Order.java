package com.entity;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private Customer customer;
	private List<OrderItem> orderItems;
	
	public Order(Customer customer) {
		this.customer = customer;
		this.orderItems = new ArrayList<>();
	}
	public void addOrderItem(OrderItem orderItem) {
		orderItems.add(orderItem);
	}
	@Override
	public String toString() {
		return "Order [customer=" + customer + ", orderItems=" + orderItems + "]";
		
	}

}