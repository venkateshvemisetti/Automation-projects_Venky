package com.rjio.testcases;

import org.testng.annotations.Test;

import com.rjio.accelator.ActionWrappers;
import com.rjio.pages.LogoutPage;

public class LogoutTestcase extends ActionWrappers {
	
 LogoutPage lop=new LogoutPage();
 
 @Test
 public void logoutApplication() {
	 try {
		 waitUntilSpinnerDisappers();
		lop.logoutUser();
	} catch (Exception e) {
		e.printStackTrace();
	}
 }
}
