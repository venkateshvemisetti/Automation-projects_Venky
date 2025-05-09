package com.intense.objects;

import org.openqa.selenium.By;

public class CreateUserObject {
	
	public static By createNewUserBTN=By.xpath("//td//a[contains(text(),'Create User')]");
	public static By createUserPage=By.xpath("//td[contains(text(),'Create New User')]");
	public static By userID=By.xpath("//input[@id='userName' and @type='text']");
	public static By policyName=By.xpath("//select[@id='policyName']");
	public static By password=By.xpath("//input[@id='password']");
	public static By confirmPwd=By.xpath("//input[@id='confirmpassword']");
	public static By firstName=By.xpath("//input[@id='firstName']");
	public static By middleName=By.xpath("//input[@id='middleName']");
	public static By lastName=By.xpath("//input[@id='lastName']");
	public static By mobileNum=By.xpath("//input[@id='mobileNo']");
	public static By emailID=By.xpath("//input[@id='emailId']");
	public static By roleList=By.xpath("//select[@id='roleList']");
	public static By addBTN=By.xpath("//tr/td[contains(text(),'Add')]");
	public static By deptNames=By.xpath("//select[@id='deptName']");
	public static By design=By.xpath("//select[@id='desgName']");
	public static By saveNewBTN=By.xpath("//tr/td[text()='Save & New']");
	public static By saveBTN=By.xpath("//tr/td[text()='Save']");
	public static By cancelBTN=By.xpath("//td[not(contains(@style,'display:none'))]//td[.='Cancel']");
	public static By cancelYesBTN=By.xpath("//button[.='Yes']");
	public static By cancelNoBTN=By.xpath("//button[.='No']");
	//span[@id='msgDiv']





	//a[normalize-space(text())='Create New User']





}
