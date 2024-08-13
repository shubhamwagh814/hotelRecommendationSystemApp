package org.hotel.client;

import java.util.*;

import org.hotel.model.AdminModel;
import org.hotel.model.CustomerModel;
import org.hotel.model.HotelMasterModel;
import org.hotel.service.AdminService;
import org.hotel.service.CustomerService;
import org.hotel.service.HotelMasterService;

public class HotelRecommendationApplication {

	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		int choice=0;
		int MainChoice=0;
		int HotelChoice=0;
		int CustomerChoice=0;
		
		HotelMasterService Hms=new HotelMasterService();
		HotelMasterModel Hmm=new HotelMasterModel();
		
		CustomerModel cm=new CustomerModel();
		CustomerService cs=new CustomerService();
		
		AdminService As=new AdminService();
		AdminModel Am=new AdminModel();
	
		ArrayList<HotelMasterModel> CityList=new ArrayList<HotelMasterModel>();
		ArrayList<HotelMasterModel> AreaList=new ArrayList<HotelMasterModel>();
		ArrayList<HotelMasterModel> HotelList=new ArrayList<HotelMasterModel>();
		ArrayList<HotelMasterModel> FeatureList=new ArrayList<HotelMasterModel>();
		
		ArrayList<CustomerModel> CustomerList=new ArrayList<CustomerModel>();
		
			do {
				
				System.out.println("================================================================================");
				
				System.out.println("1) Enter the Hotel Module");
				System.out.println("2) Enter the Customer Module");
				System.out.println("3) Sign Up");
					
				
				choice=scan.nextInt();
				System.out.println("================================================================================");

				switch(choice){
				
				case 1:
					
//					System.out.println("Enter the HotelOwner Username");
//					String Hotel_Username=scan.next();
//					System.out.println("Enter the HotelOwner Password");
//					String Hotel_Password=scan.next();
//					
//					Am=As.getHotelCredentials(Hotel_Username,Hotel_Password);
//					
//					
//					if(Hotel_Username.equals(Am.getHotelUsername())&& Hotel_Password.equals(Am.getHotelPassword()))
//					{
						do {
							System.out.println("================================================================================");
							System.out.println("1) Enter the City details into the Database");
							System.out.println("2) Enter the Area details into the Database");
							System.out.println("3) Enter the Hotel details into the Database");
							System.out.println("4) Display the All hotel Details from the Database");
							System.out.println("5) Delete the hotel Details from the Database");
							System.out.println("6) Update the hotel Details from the Database");
							System.out.println("7) Enter the Features of the Hotel");
							System.out.println("8) Exit from the Hotel Module");
							System.out.println("================================================================================");
							HotelChoice=scan.nextInt();
							
							switch(HotelChoice) {
							
							case 1:
								scan.nextLine();
								System.out.println("Enter the City Name,pin Details");
								String CityName=scan.next();
								int CityPin=scan.nextInt();
								
								Hmm=new HotelMasterModel(CityName,CityPin);
								
								boolean b=Hms.isCityAdded(Hmm);
								if(b)
								{
									System.out.println("The City Details are Added Successfully");
								}
								else
								{
									System.out.println("The City Details are not added Successfully");
								}
								System.out.println("================================================================================");
							break;
							
							case 2:
								System.out.println("Enter the name of the city to add area");
								String cName=scan.next();
								int CityId=Hms.getCityId(cName);
								
								if(CityId!=-1)
								{
									System.out.println("Enter the Area Name");
									String AreaName=scan.next();
									Hmm.setCityId(CityId);
									Hmm.setAreaName(AreaName);
									b=Hms.isAreaAdded(Hmm);
									if(b)
										System.out.println("Area Added Successfully");
									else
										System.out.println("Area not Added Successfully");
									
								}
								else
								{
									System.out.println("City is not present in the Database");
									System.out.println("Do you want to add the City into Database");
									String msg=scan.next();
									if(msg.equalsIgnoreCase("Yes"))
									{
										System.out.println("Enter the City Name,pin Details");
										String CName=scan.next();
										int CPin=scan.nextInt();
										
										Hmm=new HotelMasterModel(CName,CPin);
										
										 b=Hms.isCityAdded(Hmm);
										if(b)
										{
											System.out.println("The City Details are Added Successfully");
										}
										else
										{
											System.out.println("The City Details are not added Successfully");
										}
										System.out.println("================================================================================");
									}
									else
									{
										System.out.println("Thank you");
									}
								}
							break;
							
							case 3:
								System.out.println("Enter the City name where you want to add the hotel");
								CityList=Hms.getCityDetails();
								System.out.println("================================================================================");
								if(CityList!=null) 
								{
									System.out.println("C_id\tC_Name\tC_pin");
									System.out.println("================================================================================");
									for(HotelMasterModel Hmm1:CityList)
									{
										System.out.println(Hmm1.getCityId()+"\t"+Hmm1.getCityName()+"\t"+Hmm1.getCityPin());
									}
									String CName=scan.next();
									int Cid=Hms.getCityId(CName);
									if(Cid!=-1)
									{
										System.out.println("Enter the Area name where you want to add the hotel");
										AreaList=Hms.getCityWiseArea(CName);
										System.out.println("================================================================================");
										if(AreaList!=null) 
										{
											System.out.println("A_id\tA_Name");
											System.out.println("================================================================================");
											for(HotelMasterModel Hmm1:AreaList)
											{
												System.out.println(Hmm1.getAreaId()+"\t"+Hmm1.getAreaName());
											}
											scan.nextLine(); 
											String AreaName=scan.nextLine();
											int Aid=Hms.getAreaId(AreaName);
											if(Aid!=-1)
											{
												System.out.println("Enter the hotel Name,Address,Email,Contact,Type");
												String H_Name=scan.next();
												String H_Address=scan.next();
												String H_Email=scan.next();
												String H_Contact=scan.next();
												int H_Type=scan.nextInt();
												Hmm.setHotelName(H_Name);
												Hmm.setHotelAddress(H_Address);
												Hmm.setHotelEmail(H_Email);
												Hmm.setHotelContact(H_Contact);
												Hmm.setHotelType(H_Type);
												Hmm.setCityId(Cid);
												Hmm.setAreaId(Aid);
												b=Hms.isHotelAdded(Hmm);
												if(b)
													System.out.println("Hotel Details are added successfully");
												else
													System.out.println("Hotel Details are not added sucessfully");
											}
											else
											{
												System.out.println("Area is not present in the Database");
												System.out.println("Do you want to add the Area into Database");
												String msg=scan.next();
												if(msg.equalsIgnoreCase("Yes"))
												{
													System.out.println("Enter the area Name");
													String AName=scan.next();
													Hmm.setCityId(Cid);
													Hmm.setAreaName(AName);
													b=Hms.isAreaAdded(Hmm);
													if(b)
														System.out.println("Area Added Successfully");
													else
														System.out.println("Area not Added Successfully");

													System.out.println("================================================================================");
												}
												else
												{
													System.out.println("Thank you");
												}
											}
										}
									
									}
									else
									{
										System.out.println("City is not present in the Database");
										System.out.println("Do you want to add the City into Database");
										String msg=scan.next();
										if(msg.equalsIgnoreCase("Yes"))
										{
											System.out.println("Enter the City Name,pin Details,Area name");
											scan.nextLine();
											String Cityname=scan.next();
											int Citypin=scan.nextInt();
											scan.nextLine(); 
											Hmm=new HotelMasterModel(Cityname,Citypin);
											b=Hms.isCityAdded(Hmm);
											if(b)
											{
												System.out.println("The City Details are Added Successfully");
											}
											else
											{
												System.out.println("The City Details are not added Successfully");
											}
											System.out.println("================================================================================");
										}
										else
										{
											System.out.println("Thank you");
										}
									}
								}
								else
								{
									System.out.println("There is no data in the list");
								}
								System.out.println("================================================================================");
							break;
							
							case 4:
								System.out.println("The Hotel Details are");
								System.out.println("================================================================================");
								System.out.println("H_id\tH_Name\tH_Address\tH_Email\t\tH_Contact\tH_Type");
								HotelList=Hms.getHotelDetails();
								System.out.println("================================================================================");
								if(HotelList!=null)
								{
									for(HotelMasterModel hmm:HotelList)
									{
										System.out.println(hmm.getHotelId()+"\t"+hmm.getHotelName()+"\t"+hmm.getHotelAddress()+"\t"+"\t"+hmm.getHotelEmail()+"\t"+
										hmm.getHotelContact()+"\t"+hmm.getHotelType());
									}
								}
								else
								{
									System.out.println("There is no Hotel Available in the database");
								}
								System.out.println("================================================================================");
							break;
							
							case 5:
								System.out.println("Enter the Name of the hotel to delete from Database");
								String H_name=scan.next();
								int result=Hms.getHotelDelete(H_name);
								if(result!=-1)
								{
									System.out.println("The Hotel Details are deleted successfully");
								}
								else
								{
									System.out.println("The Hotel Details are deleted sucessfully");
								}
							break;
								
							case 6:
								System.out.println("The Hotel Details are");
								System.out.println("================================================================================");
								System.out.println("H_id\tH_Name\tH_Address\tH_Email\t\tH_Contact\tH_Type");
								HotelList=Hms.getHotelDetails();
								System.out.println("================================================================================");
								if(HotelList!=null)
								{
									for(HotelMasterModel hmm:HotelList)
									{
										System.out.println(hmm.getHotelId()+"\t"+hmm.getHotelName()+"\t"+hmm.getHotelAddress()+"\t"+"\t"+hmm.getHotelEmail()+"\t"+
										hmm.getHotelContact()+"\t"+hmm.getHotelType());
									}
								}
								else {
									System.out.println("There is no Hotel in the list");
								}
								System.out.println("================================================================================");
								System.out.println("Enter the hotel name and email which details you want to update");
								String Hotelname=scan.next();
								String Hotelemail=scan.next();
								scan.nextLine();
								int HotelId=Hms.getHotelId(Hotelname,Hotelemail);
						
								if(HotelId!=-1)
								{
									System.out.println("Enter The hotel City,Area,Name,Address,Email,Contaact,Type");
									String CName=scan.next();
									int CId=Hms.getCityId(CName);
									
									scan.nextLine();
									
									String AreaName=scan.nextLine();
									int Aid=Hms.getAreaId(AreaName);
							
									String H_Name=scan.nextLine();
									String H_Address=scan.nextLine();
									String H_Email=scan.nextLine();
									String H_Contact=scan.nextLine();
									int H_Type=scan.nextInt();
									
									Hmm.setHotelId(HotelId);
									Hmm.setHotelName(H_Name);
									Hmm.setHotelAddress(H_Address);
									Hmm.setHotelEmail(H_Email);
									Hmm.setHotelContact(H_Contact);
									Hmm.setHotelType(H_Type);
									Hmm.setCityId(CId);
									Hmm.setAreaId(Aid);
									
									b=Hms.isHotelDetailsUpdated(Hmm);
									if(b)
										System.out.println("Hotel Details are Updated successfully");
									else
										System.out.println("Hotel Details are not Updated sucessfully");
								System.out.println("================================================================================");
								}
								else
								{
									System.out.println("There is no such hotel present in the Database do you want to add");
									String msg=scan.next();
									if(msg.equalsIgnoreCase("yes"))
									{
										System.out.println("Enter the City name where you want to add the hotel");
										CityList=Hms.getCityDetails();
										System.out.println("================================================================================");
										if(CityList!=null) 
										{
											System.out.println("C_id\tC_Name\tC_pin");
											System.out.println("================================================================================");
											for(HotelMasterModel Hmm1:CityList)
											{
												System.out.println(Hmm1.getCityId()+"\t"+Hmm1.getCityName()+"\t"+Hmm1.getCityPin());
											}
											System.out.println("================================================================================");
											String CName=scan.next();
											int Cid=Hms.getCityId(CName);
											
											if(Cid!=-1)
											{
												System.out.println("Enter the Area name where you want to add the hotel");
												AreaList=Hms.getCityWiseArea(CName);
												System.out.println("================================================================================");
												if(AreaList!=null) 
												{
													System.out.println("A_id\tA_Name");
													System.out.println("================================================================================");
													for(HotelMasterModel Hmm1:AreaList)
													{
														System.out.println(Hmm1.getAreaId()+"\t"+Hmm1.getAreaName());
													}
													scan.nextLine(); 
													System.out.println("================================================================================");
													String AreaName=scan.nextLine();
													int Aid=Hms.getAreaId(AreaName);
													if(Aid!=-1)
													{
														System.out.println("Enter the hotel Name,Address,Email,Contact,Type");
														String H_Name=scan.next();
														String H_Address=scan.next();
														String H_Email=scan.next();
														String H_Contact=scan.next();
														int H_Type=scan.nextInt();
														Hmm.setHotelName(H_Name);
														Hmm.setHotelAddress(H_Address);
														Hmm.setHotelEmail(H_Email);
														Hmm.setHotelContact(H_Contact);
														Hmm.setHotelType(H_Type);
														Hmm.setCityId(Cid);
														Hmm.setAreaId(Aid);
														b=Hms.isHotelAdded(Hmm);
														if(b)
															System.out.println("Hotel Details are added successfully");
														else
															System.out.println("Hotel Details are not added sucessfully");
													}
													else
													{
														System.out.println("Area is not present in the Database");
														System.out.println("Do you want to add the Area into Database");
														msg=scan.next();
														if(msg.equalsIgnoreCase("Yes"))
														{
															System.out.println("Enter the area Name");
															String AName=scan.next();
															Hmm.setCityId(Cid);
															Hmm.setAreaName(AName);
															b=Hms.isAreaAdded(Hmm);
															if(b)
																System.out.println("Area Added Successfully");
															else
																System.out.println("Area not Added Successfully");

															System.out.println("================================================================================");
														}
														else
														{
															System.out.println("Thank you");
														}
													}
												}
											}
											else
											{
												System.out.println("City is not present in the Database");
												System.out.println("Do you want to add the City into Database");
												msg=scan.next();
												if(msg.equalsIgnoreCase("Yes"))
												{
													System.out.println("Enter the City Name,pin Details,Area name");
													scan.nextLine();
													String Cityname=scan.next();
													int Citypin=scan.nextInt();
													scan.nextLine(); 
													Hmm=new HotelMasterModel(Cityname,Citypin);
													b=Hms.isCityAdded(Hmm);
													if(b)
													{
														System.out.println("The City Details are Added Successfully");
													}
													else
													{
														System.out.println("The City Details are not added Successfully");
													}
													System.out.println("================================================================================");
												}
												else
												{
													System.out.println("Thank you");
												}
											}
										}
									}
									else
									{
										System.out.println("Thank You");
									}
									System.out.println("================================================================================");
								}
							break;
							
							case 7:
								System.out.println("================================================================================");
								System.out.println("The Existing Feature List is");
								System.out.println("================================================================================");
								FeatureList=Hms.getHotelFeatureList();
								if(FeatureList!=null)
								{
									System.out.println("Fet_id\tFet_Name");
									System.out.println("================================================================================");
									for(HotelMasterModel hmm:FeatureList)
									{
										System.out.println(hmm.getFeaturesId()+"\t"+hmm.getFeatures());
									}
									System.out.println("================================================================================");
									System.out.println("Enter The Feature name");
									String Feature=scan.next();
									int Fid=Hms.getFeatureId(Feature);
									if(Fid!=-1)
									{
										System.out.println("Enter the Hotel Name and Email to add feature");
										String HotelName=scan.next();
										String HotelEmail=scan.next();
										int HId=Hms.getHotelId(HotelName, HotelEmail);
										if(HId!=-1)
										{
											b=Hms.getFeatureAdded(HId,Fid);
											if(b)
												System.out.println("The Feature is Added to Hotel ");
											else
												System.out.println("The Feature is not Added to Hotel");
										}
										else
										{
											System.out.println("The Hotel not Present in database first add the hotel");
										}
									}
									else
									{
										System.out.println("This Feature does not exist");
										System.out.println("Do you want to add this feature");
										String msg=scan.next();
										if(msg.equalsIgnoreCase("yes"))
										{
											System.out.println("Enter the Feature name");
											String Feat=scan.next();
											scan.nextLine();
											 b=Hms.addFeatures(Feat);
											 if(b)
												 System.out.println("The Feature is added Sucessfully");
											 else
												 System.out.println("The Feature is not added successfully");
										}
									}
								}
							break;
							
							case 8:
								System.out.println("Exited from the Hotel Module");
							break;
							}	
						}while(HotelChoice!=8);
					//}
//					else
//					{
//						System.out.println("Invalid Hotel Login Details");
//					}
				break;
				
				case 2:
					
					System.out.println("Enter the Customer Username");
					String Customer_Username=scan.next();
					System.out.println("Enter the Customer Password");
					String Customer_Password=scan.next();
					
					Am=As.getCustomerCredentials(Customer_Username,Customer_Password);
					System.out.println("================================================================================");
					if(Customer_Username.equals(Am.getCustomerUsername())&& Customer_Password.equals(Am.getCustomerPassword()))
					{
						do {
							
							System.out.println("1) Enter the Customer details into the Database");
							System.out.println("2) Display the Customer  details into the Database");
							System.out.println("3) Delete the Customer details into the Database");
							System.out.println("4) Update the Customer Details from the Database");
							System.out.println("5) Enter the Booking Details");
							System.out.println("6) Exit from the Customer module");
							System.out.println("================================================================================");

							CustomerChoice=scan.nextInt();
							
							switch(CustomerChoice)
							{
								case 1:
									scan.nextLine();
									System.out.println("Enter the Customer name,Address,Email,contact,Gender,Age Details");
									String CustomerName=scan.next();
									String CustomerAddress=scan.next();
									String CustomerEmail=scan.next();
									String CustomerContact=scan.next();
									String CustomerGender=scan.next();
									int CustomerAge=scan.nextInt();
									
									cm=new CustomerModel(CustomerName,CustomerAddress,CustomerEmail,CustomerContact,CustomerGender,CustomerAge);
									
									boolean b=cs.isCustomerAdded(cm);
									if(b)
									{
										System.out.println("The Customer Details are Added Successfully");
									}
									else
									{
										System.out.println("The Custoemer Details are not added Successfully");
									}
									System.out.println("============================================================================================");
								break;
								
								case 2:
									System.out.println("The Customers Details are ");
									CustomerList=cs.getCustomerDetails();
									System.out.println("============================================================================================");
									if(CustomerList!=null)
									{
										System.out.println("C_id\tC_Name\tC_Address\tC_Email\t\tC_Contact\tC_Gender\tC_Age");
										System.out.println("========================================================================================");
										for(CustomerModel Cm:CustomerList)
										{
											System.out.println(Cm.getCustomerId()+"\t"+Cm.getCustomerName()+"\t"+Cm.getCustomerAddress()+"\t"+"\t"+Cm.getCutomerEmail()+"\t"+
										    Cm.getCustomerContact()+"\t"+Cm.getCutomerGender()+"\t"+"\t"+Cm.getCutomerAge());
										}
									}
									else
									{
										System.out.println("There are no customer in the Database");
									}
									System.out.println("=============================================================================================");
								break;
								
								case 3:
									System.out.println("Enter the Name of the Customer to delete from Database");
									String C_name=scan.next();
									int result=cs.getCustomerDelete(C_name);
									if(result!=-1)
									{
										System.out.println("The Customer Details are deleted successfully");
									}
									else
									{
										System.out.println("The Customer Details are not deleted sucessfully");
									}
									System.out.println("=============================================================================================");
								break;
								
								case 4:
									System.out.println("The Customers Details are ");
									CustomerList=cs.getCustomerDetails();
									System.out.println("=============================================================================================");
									if(CustomerList!=null)
									{
										System.out.println("C_id\tC_Name\tC_Address\tC_Email\t\tC_Contact\tC_Gender\tC_Age");
										System.out.println("=========================================================================================");
										for(CustomerModel Cm:CustomerList)
										{
											System.out.println(Cm.getCustomerId()+"\t"+Cm.getCustomerName()+"\t"+Cm.getCustomerAddress()+"\t"+"\t"+Cm.getCutomerEmail()+"\t"+
										    Cm.getCustomerContact()+"\t"+Cm.getCutomerGender()+"\t"+"\t"+Cm.getCutomerAge());
										}
									}
									else
									{
										System.out.println("There is no cutomer present in the database");
									}
									System.out.println("=============================================================================================");
									System.out.println("Enter the Customer name to update the details");
									String CustName=scan.next();
									scan.nextLine();
									int CustId=cs.getCustomerId(CustName);
									if(CustId!=-1)
									{
										System.out.println("Enter the Customer name,address,Email,Contact,Gender,Age");
										String C_Name=scan.nextLine();
										String C_Address=scan.nextLine();
										String C_Email=scan.nextLine();
										String C_Contact=scan.nextLine();
										String C_Gender =scan.nextLine();
										int C_Age=scan.nextInt();
										
										cm.setCustomerId(CustId);
										cm.setCustomerName(C_Name);
										cm.setCustomerAddress(C_Address);
										cm.setCutomerEmail(C_Email);
										cm.setCustomerContact(C_Contact);
										cm.setCutomerGender(C_Gender);
										cm.setCutomerAge(C_Age);
										
										b=cs.isCustomerDetailsUpdated(cm);
										if(b)
											System.out.println("The Customer Details are updated successfully");
										else
											System.out.println("The Customer Details are not updated successfully");
										
									}
									else
									{
										System.out.println("No such customer present in the database");
										System.out.println("Do you want to add the customer into the database");
										
										String msg=scan.next();
										
										if(msg.equalsIgnoreCase("yes"))
										{
											System.out.println("Enter the Customer name,Address,Email,contact,Gender,Age Details");
											String CName=scan.next();
											String CAddress=scan.next();
											String CEmail=scan.next();
											String CContact=scan.next();
											String CGender=scan.next();
											int CAge=scan.nextInt();
											
											cm=new CustomerModel(CName,CAddress,CEmail,CContact,CGender,CAge);
											
											b=cs.isCustomerAdded(cm);
											if(b)
											{
												System.out.println("The Customer Details are Added Successfully");
											}
											else
											{
												System.out.println("The Custoemer Details are not added Successfully");
											}
											System.out.println("============================================================================================");
										}
										else
										{
											System.out.println("Thank you");
										}
										System.out.println("============================================================================================");
									}
									
								break;
								
								case 5:
									System.out.println("Enter the City for Booking Hotel");
									CityList=Hms.getCityDetails();
									System.out.println("================================================================================");
									if(CityList!=null) 
									{
										System.out.println("C_id\tC_Name\tC_pin");
										System.out.println("================================================================================");
										for(HotelMasterModel Hmm1:CityList)
										{
											System.out.println(Hmm1.getCityId()+"\t"+Hmm1.getCityName()+"\t"+Hmm1.getCityPin());
										}
										String CityName=scan.next();
										int CityId=Hms.getCityId(CityName);
										if(CityId!=-1)
										{
											System.out.println("Enter the Area for Booking Hotel");
											AreaList=Hms.getCityWiseArea(CityName);
											System.out.println("================================================================================");
											if(AreaList!=null) 
											{
												System.out.println("A_id\tA_Name");
												System.out.println("================================================================================");
												for(HotelMasterModel Hmm1:AreaList)
												{
													System.out.println(Hmm1.getAreaId()+"\t"+Hmm1.getAreaName());
												}
												scan.nextLine(); 
												System.out.println("================================================================================");
												String AreaName=scan.nextLine();
												int Aid=Hms.getAreaId(AreaName);
												if(Aid!=-1)
												{
													System.out.println("The Hotel Details are");
													System.out.println("================================================================================");
													System.out.println("H_id\tH_Name\tH_Address\tH_Email\t\tH_Contact\tH_Type");
													HotelList=Hms.getHotelDetailsByArea(AreaName);
													System.out.println("================================================================================");
													if(HotelList!=null)
													{
														for(HotelMasterModel hmm:HotelList)
														{
															System.out.println(hmm.getHotelId()+"\t"+hmm.getHotelName()+"\t"+hmm.getHotelAddress()+"\t"+"\t"+hmm.getHotelEmail()+"\t"+
															hmm.getHotelContact()+"\t"+hmm.getHotelType());
														}
													}
													System.out.println("================================================================================");
													System.out.println("Enter the Hotel name For Booking");
													String HotelName=scan.next();
													String HotelEmail=scan.next();
													int HotelId=Hms.getHotelId(HotelName,HotelEmail);
													if(HotelId!=-1)
													{
														System.out.println("Enter the Customer Email and Contact");
														String Customer_Email=scan.next();
														scan.nextLine();
														int CustomerId=cs.getCustomerBookingId(Customer_Email);
														
														if(CustomerId!=-1)
														{
															System.out.println("Enter the Number of Room you want");
															int Rooms=scan.nextInt();
															System.out.println("Enter the Check in date");
															String Check_in=scan.next();
															System.out.println("Enter the Check Our date");
															String Check_Out=scan.next();
															int Days=cs.getDays(Check_in,Check_Out);
															
															
															
															cm.setNo_Rooms(Rooms);
															cm.setCheckInDate(Check_in);
															cm.setChekcOurDate(Check_Out);
															cm.setDays(Days);
															cm.setCustomerId(CustomerId);
															cm.setHotelId(HotelId);
															
															b=cs.getHotelBook(cm);
															if(b)
																System.out.println("The Hotel Boking is Successful");
															else
																System.out.println("The Hotel Booking is no Successful");
														}
														else {
															System.out.println("The customer not present in the Database first sign up");
														}
													}
													else
													{
														System.out.println("Hotel not present please enter the hotel into database");
													}
												}
												else
												{
													System.out.println("Area not found in the Database");
												}
											}
											else 
											{
												System.out.println("The Area is not Present in the Database please enter the Area");
											}
											
										}
										else 
										{
											System.out.println("City not found in the Database");
										}
									}
									else
									{
										System.out.println("The City is no Present in Database please enter the City");
									}
								break;
								case 6:
									System.out.println("Exited from the customer module");
								break;
								
								default:
									System.out.println("Wrong choice");
								break;
								
							}
						}while(CustomerChoice!=6);	
					}
					else
					{
						System.out.println("Invlid Customer login details");
					}
					
				break;
				
				case 3:
					do {
						
						System.out.println("1) Create the Customer Login Details");
						System.out.println("2) Create the Hotel Login Details");
						System.out.println("3) Exit !!!!");
						
						MainChoice=scan.nextInt();
						
						switch(MainChoice)
						{
							case 1:
								System.out.println("Enter the Customer Name, Contact, Username, Password");
								String CustomerName=scan.next();
								String CustomerContact=scan.next();
								String CustomerUsername=scan.next();
								String CustomerPassword=scan.next();
								
								Am.setCustomerName(CustomerName);
								Am.setCustomerContact(CustomerContact);
								Am.setCustomerUsername(CustomerUsername);
								Am.setCustomerPassword(CustomerPassword);
								
								boolean b=As.setCustomerCredentials(Am);
								if(b)
									System.out.println("The Login Deatils are saved successfully");
								else
									System.out.println("The Login Deatils are not saved Successfully");
							break;
							
							case 2:
								System.out.println("Enter the Hotel Owner Name, Contact, Username, Password");
								String HotelName=scan.next();
								String HotelContact=scan.next();
								String HotelUsername=scan.next();
								String HotelPassword=scan.next();
								
								Am.setHotelName(HotelName);
								Am.setHotelContact(HotelContact);
								Am.setHotelUsername(HotelUsername);
								Am.setHotelPassword(HotelPassword);
								
							    b=As.setHotelCredentials(Am);
								if(b)
									System.out.println("The Login Deatils are saved successfully");
								else
									System.out.println("The Login Deatils are not saved Successfully");
							break;
							
							case 3:
								System.out.println("Exit from the Sign up");
							break;
							
							default:
								System.out.println("Wrong choice entered");
							break;
						}
	
					}while(MainChoice!=3);
					
					default:
						System.out.println("Wrong Choice");
				}
				
			}while(true);
	}
}