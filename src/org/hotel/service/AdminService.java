package org.hotel.service;

import org.hotel.model.AdminModel;
import org.hotel.repository.AdminRepository;

public class AdminService {
	
	AdminRepository AdminRepo=new AdminRepository();
	
	public boolean setCustomerCredentials(AdminModel Am) {
		return AdminRepo.setCustomerCredentials(Am);
	}

	public boolean setHotelCredentials(AdminModel Am) {
		return AdminRepo.setHotelCredentials(Am);
	}

	public AdminModel getHotelCredentials(String hotel_Username, String hotel_Password) {
		return AdminRepo.getHotelCredentials(hotel_Username,hotel_Password);
	}
	
	public AdminModel getCustomerCredentials(String Customer_Username, String customer_Password) {
		return AdminRepo.getCustomerCredentials(Customer_Username,customer_Password);
	}
}



	
	
	
//	System.out.println("Enter the Admin Username");
//	String Username=scan.next();
//	System.out.println("Enter the Admin Password");
//	String Password=scan.next();
//	
//	AdminModel AM=acs.getAdminCredentials();
//	
//	if(Username.equals(AM.getAdminUsername())&& Password.equals(AM.getAdminPassword()))
//	{