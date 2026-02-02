package com.studio.bean;

public class Customer {
    private String customerID;
    private String fullName;
    private String email;
    private String mobile;
    private String preferredPackage;

    public String getCustomerID() { 
    	return customerID; 
    }
    public void setCustomerID(String customerID) { 
    	this.customerID = customerID; 
    }
    public String getFullName() { 
    	return fullName; 
    }
    public void setFullName(String fullName) { 
    	this.fullName = fullName; 
    }
    public String getEmail() { 
    	return email; 
    }
    public void setEmail(String email) { 
    	this.email = email; 
    }
    public String getMobile() { 
    	return mobile; 
    }
    public void setMobile(String mobile) { 
    	this.mobile = mobile; 
    }
    public String getPreferredPackage() { 
    	return preferredPackage; 
    }
    public void setPreferredPackage(String preferredPackage) {
        this.preferredPackage = preferredPackage;
    }
}
