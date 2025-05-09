package com.geidea.testcases;

import org.testng.annotations.Test;

import com.geidea.accelator.ActionWrappers;
import com.geidea.pages.LoginPage;

public class LoginTestcase extends ActionWrappers {

	LoginPage lip = new LoginPage();

	@Test
	public void loginApplication() {
		try {
			lip.loginUser(getRowData(lip.getClass().getSimpleName(), 4));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
