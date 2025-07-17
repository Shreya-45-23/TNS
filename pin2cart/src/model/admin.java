package model;

import java.util.List;

/**
 * Represents an Admin user in the Pin2Cart system.
 * Admins can log in, log out, and view flagged products.
 */


public class admin {
	
	  private int adminId;  // Reserved for future use, e.g., role-based access

	    @Override
	    public void login() {
	        System.out.println("🔐 Admin " + username + " has logged in.");
	    }

	    @Override
	    public void logout() {
	        System.out.println("🚪 Admin " + username + " has logged out.");
	    }

	    /**
	     * Displays a list of products that are flagged for review.
	     */
	    public void viewFlaggedProducts(List<Product> products) {
	        System.out.println("\n🚨 Flagged Products:");
	        boolean anyFlagged = false;

	        for (Product product : products) {
	            if (product.isFlagged()) {
	                System.out.println(product);
	                anyFlagged = true;
	            }
	        }

	        if (!anyFlagged) {
	            System.out.println("✅ No flagged products found.");
	        }
	    }

	    // Optional: Admin-specific ID
	    public int getAdminId() {
	        return adminId;
	    }

	    public void setAdminId(int adminId) {
	        this.adminId = adminId;
	    }

}
