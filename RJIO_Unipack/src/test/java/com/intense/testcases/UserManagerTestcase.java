package com.intense.testcases;

import org.testng.annotations.Test;

import com.intense.accelator.ActionWrappers;
import com.intense.pages.UserManagerPage;

public class UserManagerTestcase extends ActionWrappers {

	UserManagerPage ump=new UserManagerPage();
	
	@Test
	public void userManger() {
		try {
			ump.userMangerMove();
			extent.removeTest(extentTest);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
