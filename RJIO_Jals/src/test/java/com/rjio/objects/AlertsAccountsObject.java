package com.rjio.objects;

import org.openqa.selenium.By;

public class AlertsAccountsObject {
	public static By alertAccountLink = By.xpath("//td[contains(text(),'Alerts Accounts')]");
	public static By addAccountDD = By.xpath("//select[@class='content_bold']");
	public static By name = By.xpath("//input[@name='name']");
	public static By description = By.xpath("//textarea[@name='description']");
	public static By queue = By.xpath("//div[@id='qID-bodyEl']/input|//div[@id='amqpClient']/div[@id='amqpClient-bodyEl']|//div[@id='jmsClient-bodyEl']/input|//div[@id='connectionType-bodyEl']/input");
	public static By queueList = By.xpath("//div[@class='list-ct x-body-masked']/ul/li|//div[@id='boundlist-1021-listEl']/ul/li");
	public static By senderID = By.xpath("//input[@name='sender']");
	public static By host = By.xpath("//input[@name='host']");
	public static By port = By.xpath("//input[@name='port']");
	public static By username = By.xpath("//input[@name='user']|//input[@name='username']");
	public static By password = By.xpath("//input[@name='pwd']|//input[@name='password']");
	public static By saveBTN = By.xpath("//span[@id='saveOrUpdatId-btnInnerEl']|//span[@id='saveOrUpdatebottomID-btnInnerEl']");
	public static By updateBTN=By.xpath("//span[@id='saveOrUpdatId-btnInnerEl']|//span[@id='saveOrUpdatebottomID-btnInnerEl']");
	public static By alertAccountOK = By.xpath("//button/span[contains(@id,'btnInnerEl') and contains(.,'OK')]");
	public static By startAccountIcon = By.xpath("//div/img[@data-qtip='Start Account']");
	public static By stopAccountIcon = By.xpath("//div/img[@data-qtip='Stop Account']");
	public static By editAccountIcon = By.xpath("//div/img[@data-qtip='Edit Account']");
	public static By deleteAccountIcon = By.xpath("//div/img[@data-qtip='Delete Account']");
	public static By yesBTN = By.xpath("//button/span[contains(@id,'btnInnerEl') and contains(.,'Yes')]");
	public static By searchfiled = By.xpath("//div[@id='searchField-bodyEl']/input");
	public static By splitType = By.xpath("//div[@id='splitType-bodyEl']/input");
	public static By splitTypeList = By.xpath(
			"//div[contains(@class,'x-boundlist-floating') and not(contains(@style,'display: none;'))]//div[@class='list-ct x-body-masked']/ul/li");
	public static By bindMode = By.xpath("//div[@id='bindMode-bodyEl']/input");
	public static By bindModeList = By.xpath(
			"//div[contains(@class,'x-boundlist-floating') and not(contains(@style,'display: none;'))]//div[@class='list-ct x-body-masked']/ul/li");
	public static By timeout = By.xpath("//div[@id='tIntID-bodyEl']/input");
	public static By sourceTON = By.xpath("//div[@id='stonID-bodyEl']/input");
	public static By sourceNPI = By.xpath("//div[@id='snpID-bodyEl']/input");
	public static By destinationTON = By.xpath("//div[@id='dtonID-bodyEl']/input");
	public static By destinationNPI = By.xpath("//div[@id='dnpIDForNational-bodyEl']/input");
	public static By systemType = By.xpath("//div[@id='stypID-bodyEl']/input");
	public static By maxConnections = By.xpath("//div[@id='maxConnID-bodyEl']/input");
	public static By maxTPS = By.xpath("//input[@name='maxTPS']");
	public static By registerDelivery = By.xpath("//div[@id='regDelivery-bodyEl']/input");
	public static By registerDeliveryList = By.xpath(
			"//div[contains(@class,'x-boundlist-floating') and not(contains(@style,'display: none;'))]//div[@class='list-ct x-body-masked']/ul/li");
	public static By receiverIDasasperDelRes = By.xpath("//div[@id='receiverIDas-bodyEl']/input");
	public static By receiverIDasasperDelResList = By.xpath(
			"//div[contains(@class,'x-boundlist-floating') and not(contains(@style,'display: none;'))]//div[@class='list-ct x-body-masked']/ul/li");
	public static By thresholdResponseTime = By.xpath("//input[@name='thresholdResponseTime']");
	public static By TLVPEID = By.xpath("//input[@name='dltPEId']");
	public static By TLVTemplateID = By.xpath("//input[@name='dltTemplateId']");
	public static By TLVTelemarketerID = By.xpath("//input[@name='dltTelemarketerId']");
	public static By cancelBTN = By.xpath("//span[contains(text(),'Cancel')]");
	public static By authentication = By.xpath("//div[@id='authid-bodyEl']/input");
	public static By authenticationList = By.xpath("//div[@class='list-ct']/ul/li");
	public static By searchResult=By.xpath("//td/table[@class='x-grid-table x-grid-table-resizer']");
	public static By searchAccType=By.xpath("//table[not (@*)]//tr/td[2]");
	public static By searchAccName=By.xpath("//td[@class=' x-grid-cell x-grid-cell-name   x-grid-cell-first']");
	
	
/*------AMQP-----*/
	
	public static By AMQPvendor=By.xpath("//div[@id='amqpClient']/div[@id='amqpClient-bodyEl']");
	public static By AMQPvendorlist=By.xpath("//div[@id='boundlist-1021-listEl']/ul/li");
	public static By virtualhost=By.xpath("//input[@name='virtualHost']");
	public static By requestQueue=By.xpath("//input[@name='requestQueue']");
	
	public static By connectionurl=By.xpath("//input[@name='connectionUrl']");
	public static By connectionfactory=By.xpath("//input[@name='connectionFactory']");
	
	
	
	
	
	
}




//Accounts Information
//tr/td[@class='title_txt'];