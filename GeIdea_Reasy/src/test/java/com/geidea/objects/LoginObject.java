package com.geidea.objects;

import org.openqa.selenium.By;

public class LoginObject {
	public static By username = By.xpath("//input[@id='username']");
	public static By password = By.xpath("//input[@id='password']");
	public static By SigninBTN = By.xpath("//input[@name='login']");
	public static By robotCHK=By.xpath("//div[contains(@class,'rc-anchor-checkbox-holder')]/span");
}


