package com.intense.objects;

import org.openqa.selenium.By;

public class SearchUserObject {
	public static By searchUsrName=By.xpath("//input[@id='userName' and @value='Search by User Name']");
	public static By searchUsrBTN=By.xpath("//tr/td[contains(text(),'Search')]");

}
