package org.hotel.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import org.hotel.model.CustomerModel;
import org.hotel.repository.CustomerRepository;

public class CustomerService {

	CustomerRepository CustomerRepo=new CustomerRepository();
	
	
	public boolean isCustomerAdded(CustomerModel cm) {
		boolean b=CustomerRepo.isCityAdded(cm);
		return b;
	}

	public ArrayList<CustomerModel> getCustomerDetails() {
		return CustomerRepo.getCustomerDetails();
	}

	public int getCustomerDelete(String c_name) {
		return CustomerRepo.getCustomerDelete(c_name);
	}

	public int getCustomerId(String CustName) {
		return CustomerRepo.getCustomerId(CustName);
	}

	public boolean isCustomerDetailsUpdated(CustomerModel cm) {
		return CustomerRepo.isCustomerDetailsUpdated(cm);
	}

	public int getCustomerBookingId(String customer_Email) {
		return CustomerRepo.getCustomerBookingId(customer_Email);
	}
	public int getDays(String check_in, String check_out) {
		
		String Check_in=check_in;
		String Check_Out=check_out;
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		 LocalDate date1 = LocalDate.parse(Check_in, formatter);
	     LocalDate date2 = LocalDate.parse(Check_Out, formatter);
	     
	     long Days=ChronoUnit.DAYS.between(date1, date2);
	     
	     return (int) Days;
	}

	public boolean getHotelBook(CustomerModel cm) {
		return CustomerRepo.getHotelBook(cm);
	}
}