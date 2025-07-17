package model;

import java.util.ArrayList;
import java.util.List;


public class Cart {
	
	 private final List<Product> productsInCart = new ArrayList<>();

	    
	    public void add(Product product) {
	        productsInCart.add(product);
	    }

	    public void remove(Product product) {
	        productsInCart.remove(product);
	    }

	   
	    public void view() {
	        if (productsInCart.isEmpty()) {
	            System.out.println("🛒 Your shopping cart is currently empty.");
	        } else {
	            System.out.println("🛍️ Here's what's in your cart:");
	            for (Product product : productsInCart) {
	                System.out.println(product);
	            }
	        }
	    }

	    public double total() {
	        return productsInCart.stream()
	                             .mapToDouble(Product::getPrice)
	                             .sum();
	    }

	    
	    public List<Product> getItems() {
	        return productsInCart;
	    }

	    
	    public void clear() {
	        productsInCart.clear();
	    }

}
