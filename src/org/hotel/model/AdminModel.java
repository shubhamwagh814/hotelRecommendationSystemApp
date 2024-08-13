package org.hotel.model;

public class AdminModel {

	private String AdminUsername;
	private String AdminPassword;
	
	public AdminModel(String AdminUsername,String AdminPassword)
	{
		this.AdminUsername=AdminUsername;
		this.AdminUsername=AdminPassword;
	}
	public AdminModel()
	{
		
	}
	public String getAdminUsername() {
		return AdminUsername;
	}
	public void setAdminUsername(String adminUsername) {
		AdminUsername = adminUsername;
	}
	public String getAdminPassword() {
		return AdminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		AdminPassword = adminPassword;
	}
	
//======================================================Customer Logic Credentials===================================================================
	
	private String CustomerName;
	private String CustomerContact;
	private String CustomerUsername;
	private String CustomerPassword;
	
	public AdminModel(String CustomerName, String CustomerContact, String CustomerUsername, String CustomerPassword)
	{
		this.CustomerName=CustomerName;
		this.CustomerContact=CustomerContact;
		this.CustomerUsername=CustomerUsername;
		this.CustomerPassword=CustomerPassword;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getCustomerContact() {
		return CustomerContact;
	}
	public void setCustomerContact(String customerContact) {
		CustomerContact = customerContact;
	}
	public String getCustomerUsername() {
		return CustomerUsername;
	}
	public void setCustomerUsername(String customerUsername) {
		CustomerUsername = customerUsername;
	}
	public String getCustomerPassword() {
		return CustomerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		CustomerPassword = customerPassword;
	}
	
//========================================================Hotel Owner Credentials============================================================
	
	
	private String HotelName;
	private String HotelContact;
	private String HotelUsername;
	private String HotelPassword;

	public String getHotelName() {
		return HotelName;
	}
	public void setHotelName(String hotelName) {
		HotelName = hotelName;
	}
	public String getHotelContact() {
		return HotelContact;
	}
	public void setHotelContact(String hotelContact) {
		HotelContact = hotelContact;
	}
	public String getHotelUsername() {
		return HotelUsername;
	}
	public void setHotelUsername(String hotelUsername) {
		HotelUsername = hotelUsername;
	}
	public String getHotelPassword() {
		return HotelPassword;
	}
	public void setHotelPassword(String hotelPassword) {
		HotelPassword = hotelPassword;
	}
}