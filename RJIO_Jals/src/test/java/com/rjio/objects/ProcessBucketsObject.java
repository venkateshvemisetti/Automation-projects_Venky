package com.rjio.objects;

import org.openqa.selenium.By;

public class ProcessBucketsObject {

	public static By processBucketLink = By.xpath("//td[contains(text(),'Process Buckets')]");
	public static By addBucketDD = By.xpath("//select[@class='content_bold']");
	public static By bucketName = By.xpath("//input[@name='name']");
	public static By description = By.xpath("//textarea[@name='description']");
	public static By workerSize = By.xpath("//input[@name='workerSize']");
	public static By priority = By.xpath("//input[@name='priority']");
	public static By ruleDefinition = By.xpath("//textarea[@name='ruleDefinition']");
	public static By account = By.xpath("//div[@id='accID-bodyEl']/input");
	public static By accountList=By.xpath("//div[@class='list-ct']/ul/li");
	public static By useAccountCheck = By.xpath("//input[@class='x-form-field x-form-checkbox']");
	public static By saveBTN = By.xpath("//span[@id='saveOrUpdatebottomID-btnInnerEl']");
	public static By cancelBTN=By.xpath("//span[@id='button-1016-btnInnerEl']");
	public static By alertBucketOK = By.xpath("//button/span[contains(@id,'btnInnerEl') and contains(.,'OK')]");
	public static By enableIcon = By.xpath("//tr/td[@title='Enable Bucket']");
	public static By searchfiled = By.xpath("//div[@id='searchField-bodyEl']/input");
	public static By disableIcon = By.xpath("//tr/td[@title='Disable Bucket']");
	public static By editIcon = By.xpath("//tr/td[@title='Edit Bucket']");
	public static By updateBTN = By.xpath("//button/span[@id='saveOrUpdatebottomID-btnInnerEl']");
	public static By yesBTN = By.xpath("//button/span[contains(@id,'btnInnerEl') and contains(.,'Yes')]");

}
