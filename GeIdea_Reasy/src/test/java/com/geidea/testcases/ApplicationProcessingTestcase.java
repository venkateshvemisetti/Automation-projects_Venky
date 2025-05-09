package com.geidea.testcases;

import org.testng.annotations.Test;

import com.geidea.accelator.ActionWrappers;
import com.geidea.pages.ApplicationProcessingPage;

public class ApplicationProcessingTestcase extends ActionWrappers {
	
	
	ApplicationProcessingPage app=new ApplicationProcessingPage();
	
	@Override
	protected boolean hasChildTest() throws Exception {
		return true;
	}

	@Override
	protected String getParentTestName() {
		return "Application Submission";
	}
	
	@Test(priority = 1)
	public void searchApplication() {
		try {
			app.findApplication(getRowData(app.getClass().getSimpleName(), 1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 2)
	public void editApplication() {
		try {
			app.editClick(getRowData(app.getClass().getSimpleName(), 1));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Test(priority = 3)
	public void addProducts() {
		try {
			app.productsDeatils(getRowData(app.getClass().getSimpleName(), 1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test(priority = 4)
	public void saveANDcon() {
		try {
			app.saveConClick();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test(priority = 5)
	public void addBusinessDeatils() {
		try {
			app.businessDetails(getRowData(app.getClass().getSimpleName(), 4));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
