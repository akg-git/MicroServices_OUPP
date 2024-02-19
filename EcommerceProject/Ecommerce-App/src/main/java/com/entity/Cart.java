package com.entity;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Cart {
	private Map<Product, Integer>items;
	public Cart() {
		this.items = new HashMap<>();
	}
	public void addToCart(Product product, int quantity) {
		items.put(product, items.getOrDefault(product, 0) + quantity);
		
	}
	public void displayCart() {
		System.out.println("Shopping cart");
		items.forEach((product, quantity) -> System.out.println(product.getName() + "-Quantity: " + quantity));
	}
	public boolean isEmpty() {
		return items.isEmpty();
	}
	public Map<Product, Integer> getItems() {
		return Collections.unmodifiableMap(items);
		
	}
	public void clearCart() {
		items.clear();
	}
	@Override
	public String toString() {
		return "Cart [items=" + items + "]";
	}

}