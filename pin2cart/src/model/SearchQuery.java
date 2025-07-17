package model;

import java.util.Date;
import java.util.List;


public class SearchQuery {
	
	 private int queryId;
	    private int userId;
	    private boolean imageUploaded;
	    private String keyword;
	    private Date timestamp;
	    private List<Product> matchedProducts;

	    
	    public void processKeyword(String keyword) {
	        this.keyword = keyword;
	        this.timestamp = new Date(); // capture search time
	        System.out.println("🔎 Searching products related to: " + keyword);
	        
	    }

	    

	    public int getQueryId() {
	        return queryId;
	    }

	    public void setQueryId(int queryId) {
	        this.queryId = queryId;
	    }

	    public int getUserId() {
	        return userId;
	    }

	    public void setUserId(int userId) {
	        this.userId = userId;
	    }

	    public boolean isImageUploaded() {
	        return imageUploaded;
	    }

	    public void setImageUploaded(boolean imageUploaded) {
	        this.imageUploaded = imageUploaded;
	    }

	    public String getKeyword() {
	        return keyword;
	    }

	    public Date getTimestamp() {
	        return timestamp;
	    }

	    public List<Product> getMatchedProducts() {
	        return matchedProducts;
	    }

	    public void setMatchedProducts(List<Product> matchedProducts) {
	        this.matchedProducts = matchedProducts;
	    }

}
