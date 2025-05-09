package com.rjio.objects;

import org.openqa.selenium.By;

public class LoginObject {

	public static By username = By.xpath("//input[@id='username']");
	public static By password = By.xpath("//input[@id='password']");
	public static By loginBTN = By.xpath("//input[@class='login_btn']");

	public static By logoutOtherUserRBTN = By.xpath("//input[@id='forceRadio']");
	public static By continueRBTN = By.xpath("//input[@id='continueRadio']");
	public static By waitRBTN = By.xpath("//input[@id='waitRadio']");
	public static By submitBTN = By.xpath("//td[contains(text(),'Submit')]");
	public static By otherLogoutText = By.xpath("//td[contains(text(),'Logout the other user.')]");

}
