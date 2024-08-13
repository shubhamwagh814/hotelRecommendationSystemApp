package org.hotel.model;

public class CustomerModel {

	private int CustomerId;
	private String CustomerName;
	private String CustomerAddress;
	private String CustomerEmail;
	private String CustomerContact;
	private String CustomerGender;
	private int CustomerAge;
	public CustomerModel()
	{
		
	}
	public CustomerModel(String CustomerName,String CustomerAddress,String CustomerEmail,String CustomerContact,String CustomerGender,int CustomerAge)
	{
		
		this.CustomerName=CustomerName;
		this.CustomerAddress=CustomerAddress;
		this.CustomerEmail=CustomerEmail;
		this.CustomerContact=CustomerContact;
		this.CustomerGender=CustomerGender;
		this.CustomerAge=CustomerAge;
	}
	public int getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getCustomerAddress() {
		return CustomerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		CustomerAddress = customerAddress;
	}
	public String getCutomerEmail() {
		return CustomerEmail;
	}
	public void setCutomerEmail(String cutomerEmail) {
		CustomerEmail = cutomerEmail;
	}
	public String getCustomerContact() {
		return CustomerContact;
	}
	public void setCustomerContact(String customerContact) {
		CustomerContact = customerContact;
	}
	public String getCutomerGender() {
		return CustomerGender;
	}
	public void setCutomerGender(String cutomerGender) {
		CustomerGender = cutomerGender;
	}
	public int getCutomerAge() {
		return CustomerAge;
	}
	public void setCutomerAge(int cutomerAge) {
		CustomerAge = cutomerAge;
	}
//===========================================================Customer Booking======================================================
	private int No_Rooms;
	private String CheckInDate;
	private String chekcOurDate;
	private int Days;
	private int HotelId;
	
	public int getHotelId() {
		return HotelId;
	}
	public void setHotelId(int hotelId) {
		HotelId = hotelId;
	}
	public String getCustomerEmail() {
		return CustomerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		CustomerEmail = customerEmail;
	}
	public String getCustomerGender() {
		return CustomerGender;
	}
	public void setCustomerGender(String customerGender) {
		CustomerGender = customerGender;
	}
	public int getCustomerAge() {
		return CustomerAge;
	}
	public void setCustomerAge(int customerAge) {
		CustomerAge = customerAge;
	}
	public int getNo_Rooms() {
		return No_Rooms;
	}
	public void setNo_Rooms(int no_Rooms) {
		No_Rooms = no_Rooms;
	}
	public String getCheckInDate() {
		return CheckInDate;
	}
	public void setCheckInDate(String checkInDate) {
		CheckInDate = checkInDate;
	}
	public String getChekcOurDate() {
		return chekcOurDate;
	}
	public void setChekcOurDate(String chekcOurDate) {
		this.chekcOurDate = chekcOurDate;
	}
	public int getDays() {
		return Days;
	}
	public void setDays(int days) {
		Days = days;
	}
}