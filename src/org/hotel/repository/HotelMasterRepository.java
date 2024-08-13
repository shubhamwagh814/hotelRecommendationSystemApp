package org.hotel.repository;

import java.sql.CallableStatement;
import java.util.ArrayList;

import org.hotel.config.DBHelper;
import org.hotel.model.HotelMasterModel;

public class HotelMasterRepository extends DBHelper {
	
	ArrayList<HotelMasterModel> CityList=null;

	
	public boolean isCityAdded(HotelMasterModel hmm) {
		try {
			ps=c.prepareStatement("insert into HotelCityMaster values('0',?,?)");
			ps.setString(1, hmm.getCityName());
			ps.setInt(2, hmm.getCityPin());	
			
			int value=ps.executeUpdate();
			return value>0?true:false;
		}
		catch(Exception e)
		{
			System.out.println("Error in the Hotel repository method 1"+e);
			return false;
		}
	}
	public int getCityId(String CityName) {
		try {
			ps=c.prepareStatement("select City_id from HotelCityMaster where City_Name=?");
			ps.setString(1, CityName);
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
			System.out.println("Error in the Hotel repository method 2"+e);
			return -1;
		}
	}
	public boolean isAreaAdded(HotelMasterModel Hmm)
	{
		try {
			CallableStatement cs=c.prepareCall("{call savearea(?,?)}");
			cs.setString(1, Hmm.getAreaName());
			cs.setInt(2, Hmm.getCityId());
			
			boolean b=cs.execute();
			return !b;		
			
		}
		catch(Exception e)
		{
			System.out.println("Error in the Hotel repository method 4"+e);
		}
		return false;
	}
	public ArrayList<HotelMasterModel> getCityDetails() {
		try {
			CityList=new ArrayList<HotelMasterModel>();
			ps=c.prepareStatement("select *from HotelCityMaster");
			rs=ps.executeQuery();
			while(rs.next())
			{
				HotelMasterModel Hmm=new HotelMasterModel();
				Hmm.setCityId(rs.getInt(1));
				Hmm.setCityName(rs.getString(2));
				Hmm.setCityPin(rs.getInt(3));
				
				CityList.add(Hmm);
			}
			return CityList.size()>0?CityList:null;
		}
		catch(Exception e) {
			System.out.println("Error in the Hotel repository method 5"+e);
			return null;
		}
	}

	public int getAreaId(String areaName) {
		try {
			ps=c.prepareStatement("select Area_id from HotelAreaMaster where Area_Name=?");
			ps.setString(1, areaName);
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
			System.out.println("Error in the Hotel repository method 6"+e);
			return -1;
		}
	}
	public ArrayList<HotelMasterModel> getCityWiseArea(String CityName) {
		try {
			ps=c.prepareStatement("select ha.Area_id,ha.Area_Name from hotelareamaster ha inner join Cityareajoin cj on ha.area_id=cj.area_id inner join HotelCityMaster hc on cj.City_id=hc.City_id where hc.City_Name=?");
			ps.setString(1, CityName);
			rs=ps.executeQuery();
			ArrayList<HotelMasterModel> AreaList=new ArrayList<HotelMasterModel>();
			while(rs.next())
			{
				HotelMasterModel Hmm=new HotelMasterModel();
				Hmm.setAreaId(rs.getInt(1));
				Hmm.setAreaName(rs.getString(2));
				AreaList.add(Hmm);
			}
			return AreaList.size()>0?AreaList:null;
		}
		catch(Exception e)
		{
			System.out.println("Error in the Hotel repository method 7"+e);
			return null;
		}
	}
	public boolean isHotelAdded(HotelMasterModel Hmm) {
		try {
			ps=c.prepareStatement("insert into hotelmaster values('0',?,?,?,?,?,?,?)");
			
			ps.setString(1, Hmm.getHotelName() );
			ps.setString(2, Hmm.getHotelAddress());
			ps.setString(3, Hmm.getHotelEmail());
			ps.setString(4, Hmm.getHotelContact());
			ps.setInt(5, Hmm.getHotelType());
			ps.setInt(6, Hmm.getCityId());
			ps.setInt(7, Hmm.getAreaId());
			
			int value=ps.executeUpdate();
			return value>0?true:false;
			
		}
		catch(Exception e)
		{
			System.out.println("Error in the Hotel repository method 9"+e);
		}
		return false;
	}
	public ArrayList<HotelMasterModel> getHotelDetails()  {
		try {
			ArrayList<HotelMasterModel> HotelList=new ArrayList<HotelMasterModel>();
			ps=c.prepareStatement("select *from HotelMaster");
			rs=ps.executeQuery();
			while(rs.next())
			{
				HotelMasterModel Hmm=new HotelMasterModel();
				Hmm.setHotelId(rs.getInt(1));
				Hmm.setHotelName(rs.getString(2));
				Hmm.setHotelAddress(rs.getString(3));
				Hmm.setHotelEmail(rs.getString(4));
				Hmm.setHotelContact(rs.getString(5));
				Hmm.setHotelType(rs.getInt(6));
				
				HotelList.add(Hmm);
			}
			return HotelList.size()>0?HotelList:null;
		}
		catch(Exception e)
		{
			System.out.println("Error in the Hotel repository method 10"+e);
			return null;
		}
		
	}
	public int getHotelDelete(String h_name) {
		try {
			ps=c.prepareStatement("delete from HotelMaster where Hotel_Name=?");
			ps.setString(1, h_name);
			int value=ps.executeUpdate();
			return value>0?1:-1;
					
		}
		catch(Exception e)
		{
			System.out.println("Error int the hotel repository method 11"+e);
			return -1;
		}
	}
	public int getHotelId(String HotelName, String hotelEmail) {
		try {
			ps=c.prepareStatement("select Hotel_id from HotelMaster where Hotel_Name=? and Hotel_Email=?");
			ps.setString(1, HotelName);
			ps.setString(2, hotelEmail);
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
			System.out.println("Error in the Hotel repository method 12"+e);
			return -1;
		}
	}
	public boolean isHotelDetailsUpdated(HotelMasterModel Hmm) {
		try {
			
			ps=c.prepareStatement("update HotelMaster set Hotel_Name = ?, Hotel_Address = ?, Hotel_Email = ?,Hotel_Contact = ?, Hotel_type = ?, City_id = ?, Area_id = ? where Hotel_id = ?");
			
			ps.setString(1,Hmm.getHotelName());
			ps.setString(2,Hmm.getHotelAddress());
			ps.setString(3,Hmm.getHotelEmail());
			ps.setString(4,Hmm.getHotelContact());
			ps.setInt(5, Hmm.getHotelType());
			ps.setInt(6, Hmm.getCityId());
			ps.setInt(7, Hmm.getAreaId());
			ps.setInt(8, Hmm.getHotelId());
			
			int value=ps.executeUpdate();
			return value>0?true:false;
		}
		catch(Exception e)
		{
			System.out.println("Error in the Hotel repository method 13 "+e);
			return false;
		}
	}
	public ArrayList<HotelMasterModel> getHotelDetailsByArea(String areaName) {
		try {
			ps=c.prepareStatement("select ha.Hotel_id,ha.Hotel_Name,ha.Hotel_Address,ha.Hotel_Email,ha.Hotel_Contact,ha.Hotel_Type from hotelmaster ha inner join Cityareajoin cj on ha.area_id=cj.area_id inner join HotelAreaMaster hc on cj.area_id=hc.area_id where hc.Area_Name=?");
			ps.setString(1, areaName);
			rs=ps.executeQuery();
			ArrayList<HotelMasterModel> HotelList=new ArrayList<HotelMasterModel>();
			while(rs.next())
			{
				HotelMasterModel Hmm=new HotelMasterModel();
				Hmm.setHotelId(rs.getInt(1));
				Hmm.setHotelName(rs.getString(2));
				Hmm.setHotelAddress(rs.getString(3));
				Hmm.setHotelEmail(rs.getString(4));
				Hmm.setHotelContact(rs.getString(5));
				Hmm.setHotelType(rs.getInt(6));
				HotelList.add(Hmm);
			}
			return HotelList.size()>0?HotelList:null;
		}
		catch(Exception e)
		{
			System.out.println("Error in the Hotel Repository method 14 "+e);
			return null;
		}
	}
	public ArrayList<HotelMasterModel> getHotelFeatureList() {
		try {
			ps=c.prepareStatement("select *from HotelFeatureMaster");
			rs=ps.executeQuery();
			ArrayList<HotelMasterModel> FeatureList=new ArrayList<HotelMasterModel>();
			while(rs.next())
			{
				HotelMasterModel Hmm=new HotelMasterModel();
				Hmm.setFeaturesId(rs.getInt(1));
				Hmm.setFeatures(rs.getString(2));
				FeatureList.add(Hmm);
			}
			return FeatureList.size()>0?FeatureList:null;
		}
		catch(Exception e)
		{
			System.out.println("Error in the Hotel Repository method 15 "+e);
			return null;
		}
	}
	public int getFeatureId(String feature) {
		try {
			ps=c.prepareStatement("select Feature_id from HotelFeatureMaster where Feature_name=? ");
			ps.setString(1, feature);
			rs=ps.executeQuery();
			if(rs.next())
			{
				return rs.getInt(1);
			}
			return -1;
		}
		catch(Exception e)
		{
			System.out.println("Error in the Hotel Repository method 16 "+e);
			return -1;
		}
	}
	public boolean addFeature(String feat) {
		try {
			ps=c.prepareStatement("insert into HotelFeaturemaster values('0',?)");
			ps.setString(1, feat);
			int value=ps.executeUpdate();
			return value>0?true:false;
		}
		catch(Exception e)
		{
			System.out.println("Error int the Hotel Repository method 17 "+e);
			return false;
		}
	}
	public boolean getFeatureAdded(int hId, int fid) {
		try {
			ps=c.prepareStatement("insert into HotelFeaturejoin values(?,?)");
			ps.setInt(1, hId);
			ps.setInt(2, fid);
			int value=ps.executeUpdate();
			return value>0?true:false;
		}
		catch(Exception e)
		{
			System.out.println("Error int the Hotel Repository method 17 "+e);
			return false;
		}
	}
}