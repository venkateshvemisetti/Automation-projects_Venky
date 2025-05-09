package com.rjio.testcases;

import org.testng.annotations.Test;

import com.rjio.accelator.ActionWrappers;
import com.rjio.pages.LoginPage;

public class LoginTestcase extends ActionWrappers {

	LoginPage lip = new LoginPage();

	@Test
	public void loginApplication() {
		try {

			// lip.logoutOthers(getRowData(getClassName(lip.getClass().getName()), 11));
			lip.logoutOthers(getRowData(lip.getClass().getSimpleName(), 4));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
