package com.geidea.testcases;

import org.testng.annotations.Test;

import com.geidea.accelator.ActionWrappers;
import com.geidea.pages.AppRegistrationPage;

public class AppRegistrationTestcase extends ActionWrappers {
	
	AppRegistrationPage srp=new AppRegistrationPage();
	
	@Test
	public void salesRegistartion() {
		try {
			srp.createNewRegistrationLink();
			srp.registartion(getRowData(srp.getClass().getSimpleName(), 1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
