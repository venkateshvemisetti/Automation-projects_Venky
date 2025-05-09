package com.intense.pages;


import com.aventstack.extentreports.Status;
import com.intense.accelator.ActionWrappers;
import com.intense.accelator.ExcelOperations;

public class OpenBrowserPage extends ActionWrappers {

ExcelOperations re=new ExcelOperations();
	public void setBrowser() {
		try {
			setBrowserType();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void openURL() {
		try {
			System.err.println("jkjjj");
			System.err.println("hhhggg"+re.readExcel("Login", 4, 1));
			openAppURL(re.readExcel("Login", 4, 1));
			extentTest.log(Status.INFO, "Application URL is " + re.readExcel("Login", 4, 1));
			extentTest.addScreenCaptureFromPath(takeScreenShot());
			//extentTest.info("Login form is filledup", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}}

}
