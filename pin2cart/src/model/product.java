package model;

public class product {
	
	 private int productId;
	    private String name;
	    private double price;
	    private double matchConfidence;
	    private String affiliateLink;
	    private String platformName;
	    private boolean flagged;

	    
	    public Product(int productId, String name, double price, String platformName,
	                   double matchConfidence, String affiliateLink, boolean flagged) {
	        this.productId = productId;
	        this.name = name;
	        this.price = price;
	        this.platformName = platformName;
	        this.matchConfidence = matchConfidence;
	        this.affiliateLink = affiliateLink;
	        this.flagged = flagged;
	    }

	    
	    public int getProductId() {
	        return productId;
	    }

	    public String getName() {
	        return name;
	    }

	    public double getPrice() {
	        return price;
	    }

	    public String getPlatformName() {
	        return platformName;
	    }

	    public double getMatchConfidence() {
	        return matchConfidence;
	    }

	    public String getRedirectLink() {
	        return affiliateLink;
	    }

	    public boolean isFlagged() {
	        return flagged;
	    }

	    
	    public boolean isHighConfidenceMatch() {
	        return matchConfidence >= 0.8;
	    }

	    
	    @Override
	    public String toString() {
	        return "\n🛒 Product ID   : " + productId +
	               "\n📦 Name         : " + name +
	               "\n💰 Price        : ₹" + price +
	               "\n🏬 Platform     : " + platformName +
	               "\n📈 Match Score  : " + matchConfidence +
	               "\n🔗 Purchase Link: " + affiliateLink +
	               "\n--------------------------------------------";
	    }

}
