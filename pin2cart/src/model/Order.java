package model;

import java.util.Date;
import java.util.List;


public class Order {
	
	 private List<Product> productList;
	    private double totalAmount;
	    private Date orderTime;
	    private String customerName;
	    private String deliveryAddress;
	    private String phoneNumber;

	    public Order(List<Product> productList, double totalAmount, String customerName,
	                 String deliveryAddress, String phoneNumber) {
	        this.productList = productList;
	        this.totalAmount = totalAmount;
	        this.customerName = customerName;
	        this.deliveryAddress = deliveryAddress;
	        this.phoneNumber = phoneNumber;
	        this.orderTime = new Date(); // Capture the current timestamp
	    }

	    
	    public void printReceipt() {
	        System.out.println("\n🧾 ORDER SUMMARY");
	        System.out.println("----------------------------------");

	        for (Product product : productList) {
	            System.out.println(product);
	        }

	        System.out.println("----------------------------------");
	        System.out.println("👤 Customer Name : " + customerName);
	        System.out.println("📍 Delivery To   : " + deliveryAddress);
	        System.out.println("📞 Contact No.   : " + phoneNumber);
	        System.out.println("💰 Grand Total   : ₹" + totalAmount);
	        System.out.println("🕒 Order Time    : " + orderTime);
	    }

}
