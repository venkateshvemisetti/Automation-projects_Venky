package com.rjio.testcases;

import org.testng.annotations.Test;

import com.rjio.accelator.ActionWrappers;
import com.rjio.pages.OpenBrowserPage;

public class OpenBrowserTestcase extends ActionWrappers {
	
	 OpenBrowserPage obp=new OpenBrowserPage();
	 
	 @Test
	 public void openApplication() {
		 try {
			obp.setBrowser();
			 obp.openURL(getRowData("LoginPage", 1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }

}
