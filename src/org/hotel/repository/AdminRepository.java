package org.hotel.repository;

import org.hotel.config.DBHelper;
import org.hotel.model.AdminModel;

public class AdminRepository extends DBHelper{

	AdminModel Am=new AdminModel();
	
	public AdminModel getAdminCredentials() {
		try {
			ps=c.prepareStatement("select Admin_Username,Admin_Password from admin");
			rs=ps.executeQuery();
			if(rs.next())
			{
				Am.setAdminUsername(rs.getString("Admin_Username"));
				Am.setAdminPassword(rs.getString("Admin_Password"));
				return Am;
			}
			return null;		
		}
		catch(Exception e)
		{
			System.out.println("Error in admin respository method 1 "+e);
			return null;

		}
	}

	public boolean setCustomerCredentials(AdminModel Am) {
		try {
			ps=c.prepareStatement("insert into CustomerLogin values(?,?,?,?)");
			ps.setString(1, Am.getCustomerName());
			ps.setString(2, Am.getCustomerContact());
			ps.setString(3, Am.getCustomerUsername());
			ps.setString(4, Am.getCustomerPassword());
			
			int value=ps.executeUpdate();
			
			return value>0?true:false;
		}
		catch(Exception e)
		{
			System.out.println("Error in the Admin repository method 2 "+e);
			return false;
		}
	}

	public boolean setHotelCredentials(AdminModel Am) {
		try {
			ps=c.prepareStatement("insert into HotelLogin values(?,?,?,?)");
			ps.setString(1, Am.getHotelName());
			ps.setString(2, Am.getHotelContact());
			ps.setString(3, Am.getHotelUsername());
			ps.setString(4, Am.getHotelPassword());
			
			int value=ps.executeUpdate();
			
			return value>0?true:false;
		}
		catch(Exception e)
		{
			System.out.println("Error in the Admin repository method 2 "+e);
			return false;
		}
	}
	public AdminModel getCustomerCredentials(String Customer_Username, String customer_Password) {
		try {
			ps=c.prepareStatement("select Cust_Username,Cust_Password from Customerlogin where Cust_Username=? and Cust_Password=?");
			ps.setString(1, Customer_Username);
			ps.setString(2, customer_Password);
			rs=ps.executeQuery();
			if(rs.next())
			{
				Am.setCustomerUsername(rs.getString("Cust_Username"));
				Am.setCustomerPassword(rs.getString("Cust_Password"));
				return Am;
			}
			return null;		
		}
		catch(Exception e)
		{
			System.out.println("Error in admin respository method 1 "+e);
			return null;

		}
	}
	public AdminModel getHotelCredentials(String hotel_Username, String hotel_Password) {
		try {
			ps=c.prepareStatement("select  Hotel_Username,Hotel_Password from Hotellogin where Hotel_Username=? and Hotel_Password=?");
			ps.setString(1, hotel_Username);
			ps.setString(2, hotel_Password);			
			rs=ps.executeQuery();
			
			if(rs.next())
			{
				Am.setHotelUsername(rs.getString("Hotel_Username"));
				Am.setHotelPassword(rs.getString("Hotel_Password"));
				return Am;
			}
			return null;		
		}
		catch(Exception e)
		{
			System.out.println("Error in admin respository method 1 "+e);
			return null;

		}
	}
}