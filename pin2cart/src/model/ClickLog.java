package model;

import java.util.Date;

public class ClickLog {
	
	private int clickId;
    private int userId;
    private int productId;
    private Date timestamp;
    private String affiliateLink;

    
    public ClickLog(int clickId, int userId, int productId, Date timestamp, String affiliateLink) {
        this.clickId = clickId;
        this.userId = userId;
        this.productId = productId;
        this.timestamp = timestamp;
        this.affiliateLink = affiliateLink;
    }

    
    public ClickLog(int userId, int productId, Date timestamp, String affiliateLink) {
        this.userId = userId;
        this.productId = productId;
        this.timestamp = timestamp;
        this.affiliateLink = affiliateLink;
    }

    
    public int getClickId() {
        return clickId;
    }

    public void setClickId(int clickId) {
        this.clickId = clickId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getAffiliateLink() {
        return affiliateLink;
    }

    public void setAffiliateLink(String affiliateLink) {
        this.affiliateLink = affiliateLink;
    }

    
    public void displayLog() {
        System.out.println("📌 Click Record: User ID " + userId +
                " clicked on Product ID " + productId +
                " at " + timestamp +
                " | Link: " + affiliateLink);
    }

}
