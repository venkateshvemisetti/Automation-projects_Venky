package com.intense.testcases;

import org.testng.annotations.Test;

import com.intense.accelator.ActionWrappers;
import com.intense.pages.LogoutPage;

public class LogoutTestcase extends ActionWrappers {
	
 LogoutPage lop=new LogoutPage();
 
 @Test
 public void logoutApp() {
	 try {
		lop.logoutUser();
	} catch (Exception e) {
		e.printStackTrace();
	}
 }
}
