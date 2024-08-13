package org.hotel.model;

public class HotelMasterModel {

	private int HotelId;
	private String HotelName;
	private String HotelAddress;
	private String HotelEmail;
	private String HotelContact;
	private int HotelType;
	
	public HotelMasterModel()
	{
		
	}
	public HotelMasterModel( String hName, String hAddress, String hEmail, String hContact, int hType)
	{
		
		this.HotelName=hName;
		this.HotelAddress=hAddress;
		this.HotelEmail=hEmail;
		this.HotelContact=hContact;
		this.HotelType=hType;
	}
	
	public int getHotelId() {
		return HotelId;
	}
	public void setHotelId(int hotelId) {
		HotelId = hotelId;
	}
	public String getHotelName() {
		return HotelName;
	}
	public void setHotelName(String hotelName) {
		HotelName = hotelName;
	}
	public String getHotelAddress() {
		return HotelAddress;
	}
	public void setHotelAddress(String hotelAddress) {
		HotelAddress = hotelAddress;
	}
	public String getHotelEmail() {
		return HotelEmail;
	}
	public void setHotelEmail(String hotelEmail) {
		HotelEmail = hotelEmail;
	}
	public String getHotelContact() {
		return HotelContact;
	}
	public void setHotelContact(String hotelContact) {
		HotelContact = hotelContact;
	}
	public int getHotelType() {
		return HotelType;
	}
	public void setHotelType(int hotelType) {
		HotelType = hotelType;
	}
	
//========================================Hotel Area Details====================================================
	private int AreaId;
	private String AreaName;
	
	
	public HotelMasterModel(int AreaId,String aName)
	{
		this.AreaName=aName;
		
	}
	
	public int getAreaId() {
		return AreaId;
	}
	public void setAreaId(int areaId) {
		AreaId = areaId;
	}
	public String getAreaName() {
		return AreaName;
	}
	public void setAreaName(String areaName) {
		AreaName = areaName;
	}
	
//========================================Hotel City Details====================================================

	private int CityId;
	private String CityName;
	private int CityPin;
	
	public HotelMasterModel(String cName,int cPin)
	{
		this.CityName=cName;
		this.CityPin=cPin;
	}
	
	public int getCityId() {
		return CityId;
	}
	public void setCityId(int cityId) {
		CityId = cityId;
	}
	public String getCityName() {
		return CityName;
	}
	public void setCityName(String cityName) {
		CityName = cityName;
	}
	public int getCityPin() {
		return CityPin;
	}
	public void setCityPin(int cityPin) {
		CityPin = cityPin;
	}
	
//===================================Hotel Feature Details=============================================================
	
	private String Features;
	private int FeatureId;
	
	public HotelMasterModel(String Features)
	{
		this.Features=Features;
		
	}
	public String getFeatures() {
		return Features;
	}
	public void setFeatures(String features) {
		Features = features;
	}
	public int getFeaturesId() {
		return FeatureId;
	}
	public void setFeaturesId(int featureId) {
		FeatureId= featureId;
	}
	
	
	
//	 delimiter //
//	 mysql> create procedure savefeature(IN Feature_name varchar(100), IN Hotel_id int(5))
//	     -> begin
//	     -> Declare Feature_id int(5);
//	     -> insert into HotelFeatureMaster (Feature_Name) values (Feature_name);
//	     -> set Feature_id=LAST_INSERT_ID();
//	     -> insert into HotelFeatureJoin (Hotel_id,Feature_id) values(Hotel_Id,Feature_id);
//	     -> end
}
