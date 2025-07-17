package model;

import java.awt.Desktop;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
	
	private List<Product> wishlist = new ArrayList<>();
    private List<Product> searchResults = new ArrayList<>();
    private List<SearchQuery> searches = new ArrayList<>();  // Reserved for future search history tracking

    @Override
    public void login() {
        System.out.println(username + " has logged in. 👤");
    }

    @Override
    public void logout() {
        System.out.println(username + " has logged out. 👋");
    }

    
    public void addToWishlist(Product product) {
        wishlist.add(product);
    }

    
    public void redirectToPurchase(Product product) {
        String link = product.getRedirectLink();
        System.out.println("🔗 Redirecting you to: " + link);

        try {
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                if (desktop.isSupported(Desktop.Action.BROWSE)) {
                    desktop.browse(new URI(link));
                } else {
                    System.out.println("⚠️ Your system does not support browser opening.");
                }
            } else {
                System.out.println("⚠️ Desktop operations are not supported on your system.");
            }
        } catch (Exception e) {
            System.out.println("❌ Failed to open link. Reason: " + e.getMessage());
        }
    }

    
    public List<Product> getWishlist() {
        return wishlist;
    }

    
    public List<Product> getSearchResults() {
        return searchResults;
    }

    
    public void setSearchResults(List<Product> searchResults) {
        this.searchResults = searchResults;
    }

}
