package com.entity;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EcommerceApp {
	public static final Scanner scanner = new Scanner(System.in);
	private static final Logger logger = LogManager.getLogger(EcommerceApp.class);
	private static Customer customer;

	public static void main(String[] args) {
//        showMenu();
		// initialize entitites
		Product laptop = new Product("Laptop", 800.0, "Electronics");
		Product phone = new Product("phone", 500.0, "Electronics");
		Product headphones = new Product("Headphones", 180.0, "Electronics");

		Customer customer = new Customer("John Doe", "john@example.com");

		Category electronicsCategory = new Category("Electronics");

		Order order = new Order(customer);

		// Main Menu
		while (true) {
			logger.info("\nSelect an option: ");
			logger.info("1. Add Product to Cart");
			logger.info("2. View Cart");
			logger.info("3. Place Order");
			logger.info("4. Exit");

			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				logger.info("Select a product: ");
				logger.info("1. Laptop");
				logger.info("2. Phone");
				logger.info("3. Headphones");

				int productChoice = scanner.nextInt();

				Product selectedProduct;
				switch (productChoice) {
				case 1:
					selectedProduct = laptop;
					break;
				case 2:
					selectedProduct = phone;
					break;
				case 3:
					selectedProduct = headphones;
					break;
				default:
					logger.info("Invalid Choice. Please select a valid option. [1/2/3]");
					continue;
				}

				System.out.println("Enter quantity: ");
				int quantity = scanner.nextInt();

				customer.getCart().addToCart(selectedProduct, quantity);
				logger.info("Product Added to cart!!");
				break;

			case 2:
				customer.getCart().displayCart();
				break;

			case 3:
				if (!customer.getCart().isEmpty()) {
					OrderItem orderItem = new OrderItem(customer.getCart().getItems());
					order.addOrderItem(orderItem);

					// assume payment and shipment are processed here
					logger.info("Order placed successfully.");
					System.out.println(order);
					customer.getCart().clearCart();
				}else {
					logger.info("Cart is Empty. Add product before placing an order.");
					break;
				}
			
			case 4:
				logger.info("Leaving the application, Goodbye!!");
				System.exit(0);
				break;
			
			default:
				logger.info("Invalid Choice. Please select a valid option. [1/2/3/4]");
			}

		}
	}

	/*
	 * private static void showMenu() { int choice;
	 * 
	 * do { System.out.println("Ecommerce App Menu:");
	 * System.out.println("1. Create Customer");
	 * System.out.println("2. Add Product to Cart");
	 * System.out.println("3. Display Cart"); System.out.println("4. Create Order");
	 * System.out.println("5. Exit"); System.out.print("Enter your choice: ");
	 * 
	 * choice = scanner.nextInt(); scanner.nextLine(); // Consume the newline
	 * character
	 * 
	 * switch (choice) { case 1: createCustomer(); break; case 2:
	 * addProductToCart(); break; case 3: displayCart(); break; case 4:
	 * createOrder(); break; case 5:
	 * System.out.println("Exiting Ecommerce App. Goodbye!"); break; default:
	 * System.out.println("Invalid choice. Please enter a valid option."); } } while
	 * (choice != 5); }
	 * 
	 * private static void createCustomer() {
	 * System.out.println("Enter customer name:"); String name = scanner.nextLine();
	 * System.out.println("Enter customer email:"); String email =
	 * scanner.nextLine();
	 * 
	 * customer = new Customer(name, email); System.out.println("Customer created: "
	 * + customer); }
	 * 
	 * private static void addProductToCart() { if (customer == null) {
	 * System.out.println("Please create a customer first."); return; }
	 * 
	 * System.out.println("Enter product name:"); String productName =
	 * scanner.nextLine(); System.out.println("Enter product price:"); double
	 * productPrice = scanner.nextDouble();
	 * System.out.println("Enter product category:"); String productCategory =
	 * scanner.next(); System.out.println("Enter quantity:"); int quantity =
	 * scanner.nextInt();
	 * 
	 * Product product = new Product(productName, productPrice, productCategory);
	 * customer.getCart().addToCart(product, quantity);
	 * System.out.println("Product added to cart."); }
	 * 
	 * private static void displayCart() { if (customer == null) {
	 * System.out.println("Please create a customer first."); return; }
	 * 
	 * Cart cart = customer.getCart(); if (cart.isEmpty()) {
	 * System.out.println("Cart is empty."); } else { cart.displayCart(); } }
	 * 
	 * private static void createOrder() { if (customer == null) {
	 * System.out.println("Please create a customer first."); return; }
	 * 
	 * Cart cart = customer.getCart(); if (cart.isEmpty()) {
	 * System.out.println("Cannot create order. Cart is empty."); } else { OrderItem
	 * orderItem = new OrderItem(cart.getItems()); double total =
	 * orderItem.calculateTotal(); System.out.println("Order created for customer: "
	 * + customer); System.out.println("Total Order Amount: " + total); Order order
	 * = new Order(customer); order.addOrderItem(orderItem);
	 * System.out.println("Order Details: " + order); cart.clearCart(); } }
	 */
}