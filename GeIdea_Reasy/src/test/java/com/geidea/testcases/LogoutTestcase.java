package com.geidea.testcases;

import org.testng.annotations.Test;

import com.geidea.accelator.ActionWrappers;
import com.geidea.pages.LogoutPage;

public class LogoutTestcase extends ActionWrappers {

	LogoutPage lop = new LogoutPage();

	@Test
	public void logoutApplication() {
		try {
			lop.logoutUser();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
