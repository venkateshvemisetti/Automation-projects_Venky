package com.rjio.objects;

import org.openqa.selenium.By;

public class AlertsSourcesObject {
	public static By alertSourcLink = By.xpath("//td[contains(text(),'Alerts Sources')]");
	public static By addSourceDD = By.xpath("//select[@class='content_bold']");
	public static By name=By.xpath("//input[@name='name']");
	public static By description=By.xpath("//textarea[@name='description']");
	public static By addParametersBTN=By.xpath("//span[contains(text(),'Add Parameters')]");
	//public static By parameter=By.xpath("//table[contains(@class,'x-grid-table x-grid-table-resizer')]//tr[2]//td[1]");
	public static By parameter=By.xpath("//td/div[contains(@class,'x-grid-cell-inner x-unselectable')]");
	public static By mask=By.xpath("//table[contains(@class,'x-grid-table x-grid-table-resizer')]//tr[2]//td[2]");
	public static By maskvalue=By.xpath("//div[contains(@id,'boundlist')]/div//li[2]");
	public static By alertSourceOK=By.xpath("//button/span[contains(@id,'btnInnerEl') and contains(.,'OK')]");
	public static By saveBTN=By.xpath("//span[@id='saveOrUpdatebottomID-btnInnerEl']");
	public static By searchfiled=By.xpath("//div[@id='searchField-bodyEl']/input");
	public static By editIcon=By.xpath("//tr/td[@title='Edit Source']");
	public static By updateBTN=By.xpath("//span[@id='saveOrUpdatebottomID-btnInnerEl']");
	public static By startIcon=By.xpath("//td[@title='Start Source']");
	public static By stopIcon=By.xpath("//td[@title='Pause Source']");
	public static By deleteIcon=By.xpath("//td[@title='Delete Source']");
	public static By yesBTN=By.xpath("//button/span[contains(@id,'btnInnerEl') and contains(.,'Yes')]");
	

}
