package com.rjio.objects;

import org.openqa.selenium.By;

public class ListenersObject {
	public static By listenerPagetitle=By.xpath("//tr/td[@innerhtm='ALERTS.LABEL.LISTENER.INFORMATION']");
	public static By listenerLink = By.xpath("//td[contains(text(),'Listeners')]");
	public static By addListenerDD = By.xpath("//select[@name='forma']");
	public static By name=By.xpath("//input[@name='name']");
	public static By description=By.xpath("//textarea[@name='description']");
	public static By folderPath=By.xpath("//input[@name='folderPath']");
	public static By saveBTN=By.xpath("//button/span[@id='saveOrUpdatId-btnInnerEl']");
	public static By searchfiled=By.xpath("//div[@id='searchField-bodyEl']/input");
	public static By yesBTN=By.xpath("//button/span[contains(@id,'btnInnerEl') and contains(.,'Yes')]");
	public static By startIcon=By.xpath("//tr/td[@title='Start']");
	public static By stopIcon=By.xpath("//tr/td[@title='Stop']");
	public static By editIcon=By.xpath("//tr/td[@title='Edit']");
	public static By deleteIcon=By.xpath("//tr/td[@title='Delete']");
	public static By alerListenerOK=By.xpath("//button/span[contains(@id,'btnInnerEl') and contains(.,'OK')]");
	
	
	
	public static By amqpname=By.xpath("//input[@name='name']");
	public static By amqpdescription=By.xpath("//textarea[@name='description']");
	public static By AMQPvendor= By.xpath("//input[@aria-describedby='amqpClient-errorEl']");
	public static By AMQPvendorlistoption=By.xpath("//div[@id='boundlist-1021-listEl']//li[text()='RabbitMQ']");
	public static By amqphost=By.xpath("//input[@name='host']");
	public static By amqpport=By.xpath("//input[@name='port']");
	public static By amqvirtualHost=By.xpath("//input[@name='virtualHost']");
	public static By amqpuser=By.xpath("//input[@name='user']");
	public static By amqppwd=By.xpath("//input[@name='pwd']");
	public static By amqpreqqueue=By.xpath("//input[@name='requestQueue']");
	public static By amqpSaveBTN=By.xpath("//button/span[@id='saveOrUpdatetopID-btnInnerEl']");
	
	
	
			
	
	
	
	
///File
}
