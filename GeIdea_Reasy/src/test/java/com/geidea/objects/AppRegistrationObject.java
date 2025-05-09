package com.geidea.objects;

import org.openqa.selenium.By;

public class AppRegistrationObject {
	public static By createNewApp=By.xpath("//div/button[contains(text(),'Create New Application')] | //div/button[contains(text(),'Create Application')]");
	//public static By createNewApp=By.xpath("//div/button[contains(text(),'Create Application')]");
	
    public static By firstname=By.xpath("//input[@name='customer_name']");
    public static By lastname=By.xpath("//input[@name='last_name']");
    public static By email=By.xpath("//input[@name='email']");
    public static By mobilenum=By.xpath("//input[@name='phone_mobile']");
    public static By businesslandlineNum=By.xpath("//input[@name='phone_landline']");
    public static By businessname=By.xpath("//input[@name='business_name']");
   // public static By natureofbusiness=By.xpath("//button/div[contains(text(),'Select Business Type')]");
    public static By searchlist=By.xpath("//div[@class='dropdown show']//input[@class='searchInput form-control']");
    public static By searchresult=By.xpath("//a[@class='dropdown-item']");
    //public static By nobvalue=By.xpath("//a[@class='dropdown-item']/span");
    public static By jobrole=By.xpath("//input[@name='job_role']");
    public static By address=By.xpath("//textarea[@name='address']");
   // public static By emirate=By.xpath("//button/div[contains(text(),'Select Emirate')]");
   // public static By city=By.xpath("//button/div[contains(text(),'Select City')]");
    public static By pobox=By.xpath("//input[@name='zip_code']");
    public static By nextBTN=By.xpath("//button[@myid='CustomerRegistration_2_submit_67440904_1']");
    public static By backBTN=By.xpath("//input[@name='zip_code']");
    public static String natureofbusiness="//div[@myid='CustomerRegistration_2_dropDownWithSearch_14140904_2']";
    public static String emirate="//div[@myid='CustomerRegistration_2_dropDownWithSearch_50140904_2']";
    public static String city="//div[@myid='CustomerRegistration_2_dropDownWithSearch_31440904_2']";
    public static String searchbox="//div[@class='dropdown show']//input[@class='searchInput form-control']";
    public static By password=By.xpath("//input[@name='password']");
    public static By confirmpwd=By.xpath("//input[@name='confirm_password']");
    public static By termANDcon=By.xpath("//label[@myid='CustomerRegistration_2_Checkbox_49940904_3']/span");
    public static By sizeofbusinessLabel=By.xpath("//div[@id='userRadioId']/li/label");
    public static By sizeofbusinessBTN=By.xpath("//div[@id='userRadioId']/li/label/input[@type='radio']");
    public static By nextBTN_pwd=By.xpath("//div/button[@myid='CustomerRegistration_2_save_50440904_1']");
  
    
    
 
    
  
 
    
  
	/*
	 * public static By
	 * businessLandlineNumber=By.xpath("//input[@name='phone_landline']"); public
	 * static By businessLandlineNumber=By.xpath("//input[@name='phone_landline']");
	 * public static By
	 * businessLandlineNumber=By.xpath("//input[@name='phone_landline']");
	 */
    
}
