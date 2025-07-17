package model;

public abstract class User {
	
	 protected int userId;
	    protected String username;
	    protected String email;

	   
	    public abstract void login();

	    
	    public abstract void logout();

	    

	    public int getUserId() {
	        return userId;
	    }

	    public void setUserId(int userId) {
	        this.userId = userId;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;

	    }

}
