package com.rjio.objects;

import org.openqa.selenium.By;

public class AlertsQueuesObject {
	public static By alertQueueLink=By.xpath("//td[contains(text(),'Alerts Queues')]");
	public static By createQueue = By.xpath("//td[@name='tblCreate']");
	public static By name=By.xpath("//input[@name='name']");
	public static By description=By.xpath("//textarea[@name='description']");
	public static By saveBTN=By.xpath("//span[@id='saveOrUpdatId-btnInnerEl']");
	public static By yesBTN=By.xpath("//button/span[contains(@id,'btnInnerEl') and contains(.,'Yes')]");
	public static By searchfiled=By.xpath("//div[@id='searchField-bodyEl']/input");
	public static By alertQueueOK=By.xpath("//button/span[contains(@id,'btnInnerEl') and contains(.,'OK')]");
	public static By editIcon=By.xpath("//tr/td[@title='Edit']");
	public static By updateBTN=By.xpath("//div/div[@id='saveOrUpdatId']");
	public static By deleteIcon=By.xpath("//tr/td[@title='Delete']");
	
	
}
