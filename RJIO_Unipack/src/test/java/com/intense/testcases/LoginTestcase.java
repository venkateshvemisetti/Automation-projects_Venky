package com.intense.testcases;

import org.testng.annotations.Test;

import com.intense.accelator.ActionWrappers;
import com.intense.pages.LoginPage;

public class LoginTestcase extends ActionWrappers {
	
	LoginPage lip=new LoginPage();
	
	@Test
	public void loginApp() {
		try {
			lip.logoutOthers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
