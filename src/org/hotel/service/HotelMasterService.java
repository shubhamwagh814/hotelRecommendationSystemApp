package org.hotel.service;

import java.util.*;
import org.hotel.model.HotelMasterModel;
import org.hotel.repository.HotelMasterRepository;

public class HotelMasterService {

	Scanner scan=new Scanner(System.in);
	
	HotelMasterRepository HotelRepo=new HotelMasterRepository();
	HotelMasterModel Hmm=new HotelMasterModel();
	
	public boolean isCityAdded(HotelMasterModel hmm) //Adding the City Details
	{
		boolean b=HotelRepo.isCityAdded(hmm);
		return b;
	}
	
	public ArrayList<HotelMasterModel> getCityDetails() //Fetching the City Details
	{
		return HotelRepo.getCityDetails();
	}

	public int getCityId(String CityName)  {
		return HotelRepo.getCityId(CityName);
	}
	public int getAreaId(String AreaName) {
		return HotelRepo.getAreaId(AreaName);
	}
	public boolean isAreaAdded(HotelMasterModel Hmm)
	{
		return HotelRepo.isAreaAdded(Hmm);
	}
	public ArrayList<HotelMasterModel> getCityWiseArea(String CityName){
		return HotelRepo.getCityWiseArea(CityName);
	}
	public boolean isHotelAdded(HotelMasterModel Hmm)
	{
		return HotelRepo.isHotelAdded(Hmm);
	}

	public ArrayList<HotelMasterModel> getHotelDetails() {
		return HotelRepo.getHotelDetails();
	}

	public int getHotelDelete(String h_name) {
		return HotelRepo.getHotelDelete(h_name);
	}

	public boolean isHotelDetailsUpdated(HotelMasterModel Hmm) {
		return HotelRepo.isHotelDetailsUpdated(Hmm);
	}

	public int getHotelId(String hotelname, String hotelEmail) {
		return HotelRepo.getHotelId(hotelname,hotelEmail);
	}

	public ArrayList<HotelMasterModel> getHotelDetailsByArea(String areaName) {
		return HotelRepo.getHotelDetailsByArea(areaName);
	}

	public ArrayList<HotelMasterModel> getHotelFeatureList() {
		return HotelRepo.getHotelFeatureList();
	}

	public int getFeatureId(String feature) {
		return HotelRepo.getFeatureId(feature);
	}

	public boolean addFeatures(String feat) {
		return HotelRepo.addFeature(feat);
	}

	public boolean getFeatureAdded(int hId, int fid) {
		return HotelRepo.getFeatureAdded(hId,fid);
	}

}