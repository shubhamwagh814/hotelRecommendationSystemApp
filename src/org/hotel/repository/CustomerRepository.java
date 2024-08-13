package org.hotel.repository;

import java.util.ArrayList;


import org.hotel.config.DBHelper;
import org.hotel.model.CustomerModel;


public class CustomerRepository extends DBHelper{

	ArrayList<CustomerModel> CustomerList =null;
	
	public boolean isCityAdded(CustomerModel cm) {
		try {
			ps=c.prepareStatement("insert into CustomerMaster values('0',?,?,?,?,?,?)");
			ps.setString(1, cm.getCustomerName());
			ps.setString(2, cm.getCustomerAddress());
			ps.setString(3,cm.getCutomerEmail());
			ps.setString(4,cm.getCustomerContact());
			ps.setString(5, cm.getCutomerGender());
			ps.setInt(6, cm.getCutomerAge());
			
			int value=ps.executeUpdate();
			return value>0?true:false;
		}
		catch(Exception e)
		{
			System.out.println("Error in the Customer Repository method 1 "+e);
			return false;
		}
	}

	public ArrayList<CustomerModel> getCustomerDetails() {
		try {
			CustomerList=new ArrayList<CustomerModel>();
			ps=c.prepareStatement("select *from Customermaster");
			rs=ps.executeQuery();
			while(rs.next())
			{
				CustomerModel cm=new CustomerModel();
				
				cm.setCustomerId(rs.getInt(1));
				cm.setCustomerName(rs.getString(2));
				cm.setCustomerAddress(rs.getString(3));
				cm.setCutomerEmail(rs.getString(4));
				cm.setCustomerContact(rs.getString(5));
				cm.setCutomerGender(rs.getString(6));
				cm.setCutomerAge(rs.getInt(7));
				
				CustomerList.add(cm);
			}
			return CustomerList.size()>0?CustomerList:null;
		}
		catch(Exception e)
		{
			System.out.println("Error in the Customer Repository method 2 "+e);
			return null;
		}
	}

	public int getCustomerDelete(String c_name) {
		try {
			ps=c.prepareStatement("delete from CustomerMaster where Customer_Name=?");
			ps.setString(1, c_name);
			int value=ps.executeUpdate();
			return value>0?1:-1;
		}
		catch(Exception e)
		{
			System.out.println("Error in the Customer Repository method 3 "+e);
			return -1;
		}
	}

	public int getCustomerId(String custName) {
		try {
			ps=c.prepareStatement("select Customer_id from CustomerMaster where Customer_Name=?");
			ps.setString(1, custName);
			rs=ps.executeQuery();
			if(rs.next())
			{
				return rs.getInt(1);
			}
			else
			{
				return -1;
			}
		}
		catch(Exception e)
		{
			System.out.println("Error in th Customer Repository method 4 "+e);
			return -1;
		}
	}

	public boolean isCustomerDetailsUpdated(CustomerModel cm) {
		try {
			ps=c.prepareStatement("update CustomerMaster set Customer_Name = ?, Customer_Address = ?,Customer_Email = ?,Customer_Contact = ?,Customer_Gender = ?, Customer_Age = ? where Customer_id = ?");
			
			ps.setString(1, cm.getCustomerName());
			ps.setString(2, cm.getCustomerAddress());
			ps.setString(3, cm.getCutomerEmail());
			ps.setString(4, cm.getCustomerContact());
			ps.setString(5, cm.getCutomerGender());
			ps.setInt(6, cm.getCutomerAge());

			ps.setInt(7, cm.getCustomerId());
			
			int value=ps.executeUpdate();
			return value>0?true:false;
		}
		catch(Exception e)
		{
			System.out.println("Error in the Custome Repository method 5 "+e);
			return false;
		}
	}

	public int getCustomerBookingId(String customer_Email) {
		try {
			ps=c.prepareStatement("select Customer_id from CustomerMaster where Customer_Email=?");
			
			ps.setString(1, customer_Email);
			//System.out.println(customer_Email);
			rs=ps.executeQuery();
			if(rs.next())
			{
				return rs.getInt(1);
			}
			else
			{
				return -1;
			}
		}
		catch(Exception e)
		{
			System.out.println("Error in the Cutomer Repository method 6 "+e);
			return -1;
		}
	}

	public boolean getHotelBook(CustomerModel cm) {
		try {
			
			ps=c.prepareStatement("insert into HotelBooking values('0',?,?,?,?,?,?)");
			
			ps.setInt(1, cm.getCustomerId());
			ps.setInt(2, cm.getHotelId());
			ps.setInt(3, cm.getNo_Rooms());
			ps.setString(4, cm.getCheckInDate());
			ps.setString(5, cm.getChekcOurDate());
			ps.setInt(6, cm.getDays());
			
			int value=ps.executeUpdate();
			
			return value>0?true:false;
		}
		catch(Exception e)
		{
			System.out.println("Error in the Customeer Repository method 7 "+e);
			return false;
		}
	}
}