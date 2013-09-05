package com.itp.rrencryptioninucloud.dbHandler;

public class DataDetailsBean {

	int ServiceID;
	String Title;     
	String Description;      
	int Price;       
	//int UpdatedPrice;   
	
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public int getServiceID() {
		return ServiceID;
	}
	public void setServiceID(int serviceID) {
		ServiceID = serviceID;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	
	

}
