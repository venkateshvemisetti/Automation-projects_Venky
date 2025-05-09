package com.intense.objects;

import org.openqa.selenium.By;

public class EditUserObject {

	public static By editIcon = By.xpath("//img[@data-qtip='Edit']");
	public static By editUserPage = By.xpath("//tr/td[contains(text(),'Edit User')]");

	public static By userID = By.xpath("//input[@id='userName' and @type='text']");
	public static By policyName = By.xpath("//select[@id='policyName']");
	public static By password = By.xpath("//input[@id='password']");
	public static By confirmPwd = By.xpath("//input[@id='confirmpassword']");
	public static By firstName = By.xpath("//input[@id='firstName']");
	public static By middleName = By.xpath("//input[@id='middleName']");
	public static By lastName = By.xpath("//input[@id='lastName']");
	public static By mobileNum = By.xpath("//input[@id='mobileNo']");
	public static By emailID = By.xpath("//input[@id='emailId']");

	public static By rolecheck = By.xpath("//input[@name='chk1']");
	public static By editBTN = By.xpath("//tr/td[(text()='Edit')]");
	public static By roleList = By.xpath("//select[@id='selEdit0']");
	public static By roleSaveBTN = By.xpath("//td[@name='edit1']");

	public static By deptNames = By.xpath("//select[@id='deptName']");
	public static By design = By.xpath("//select[@id='desgName']");

	public static By saveBTN = By.xpath("//tr/td[text()='Save']");
	
	public static By deleteBTN = By.xpath("//table[@name='del2']//td[text()='Delete'] ");
	public static By cancelBTN = By.xpath("//td[not(contains(@style,'display:none'))]//td[.='Cancel']");
	public static By cancelYesBTN = By.xpath("//button[.='Yes']");
	public static By cancelNoBTN = By.xpath("//button[.='No']");

}
