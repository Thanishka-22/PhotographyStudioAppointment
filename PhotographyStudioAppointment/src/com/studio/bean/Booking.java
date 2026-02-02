package com.studio.bean;

import java.util.Date;

public class Booking {
    private int bookingID;
    private String customerID;
    private Date shootDate;
    private String startTime;
    private String endTime;
    private String packageType;
    private String status;

    public int getBookingID() {
    	return bookingID; 
    }
    public void setBookingID(int bookingID) {
    	this.bookingID = bookingID; 
    }
    public String getCustomerID() {
    	return customerID; 
    }
    public void setCustomerID(String customerID) {
    	this.customerID = customerID; 
    }
    public Date getShootDate() {
    	return shootDate; 
    }
    public void setShootDate(Date shootDate) {
    	this.shootDate = shootDate; 
    }
    public String getStartTime() { 
    	return startTime; 
    }
    public void setStartTime(String startTime) {
    	this.startTime = startTime; 
    }
    public String getEndTime() { 
    	return endTime; 
    }
    public void setEndTime(String endTime) { 
    	this.endTime = endTime; 
    }
    public String getPackageType() { 
    	return packageType; 
    }
    public void setPackageType(String packageType) { 
    	this.packageType = packageType; 
    }
    public String getStatus() { 
    	return status; 
    }
    public void setStatus(String status) { 
    	this.status = status; 
    }
}
