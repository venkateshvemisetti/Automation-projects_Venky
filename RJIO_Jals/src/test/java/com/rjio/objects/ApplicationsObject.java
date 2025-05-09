package com.rjio.objects;

import org.openqa.selenium.By;

public class ApplicationsObject {
	public static By alertApplicationLink = By.xpath("//table[@id='table121']//td[contains(text(),'Applications')]");
	public static By createApplication = By.xpath("//td/a[@name='anchorCreate']");
	public static By name = By.xpath("//input[@name='name']");
	public static By description = By.xpath("//textarea[@name='description']");
	public static By owner = By.xpath("//input[@name='owner']");
	public static By mobileNumber = By.xpath("//input[@name='mobile']");
	public static By email = By.xpath("//input[@name='email']");
	public static By mobileSenderIDP = By.xpath("//input[@name='mobileSender']");
	public static By emailSenderIDP = By.xpath("//input[@name='emailSender']");
	public static By mobileSenderIDT = By.xpath("//input[@name='txnMobileSender']");
	public static By emailSenderIDT = By.xpath("//input[@name='txnEmailSender']");
	public static By RTTSSenderID = By.xpath("//input[@name='rtssSender']");
	public static By applicationID = By.xpath("//input[@name='appId']");
	public static By apiKey = By.xpath("//input[@name='appKey']");
	public static By secretKey = By.xpath("//input[@name='secretKey']");
	public static By message = By.xpath("//input[@name='message']");
	public static By templates = By.xpath("//input[@name='ser1']");
	public static By availableserachList=By.xpath("//div[@class='list-ct']/ul/li");
	public static By addToTempSel = By.xpath("//button[@data-qtip='Add to Selected']");
    public static By saveBTN=By.xpath("//span[@id='saveOrUpdatId-btnInnerEl']");
    public static By alertApplicationOK=By.xpath("//button/span[contains(@id,'btnInnerEl') and contains(.,'OK')]");
    public static By searchfiled=By.xpath("//div[@id='searchField-bodyEl']/input");
    public static By editIcon=By.xpath("//div/img[@data-qtip='Edit']");
    public static By deleteIcon=By.xpath("//div/img[@data-qtip='Delete']");
    public static By yesBTN=By.xpath("//button/span[contains(@id,'btnInnerEl') and contains(.,'Yes')]");
    public static By updateBTN=By.xpath("//span[@id='saveOrUpdatId-btnInnerEl']");
    
    

}

