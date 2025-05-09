package com.geidea.testcases;

import org.testng.annotations.Test;

import com.geidea.accelator.ActionWrappers;
import com.geidea.pages.AdminPage;

public class AdminTestcase extends ActionWrappers{

	AdminPage ap=new AdminPage();
	
	@Test
	public void ApplicationClick() {
		try {
			ap.ApplicationClick();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
