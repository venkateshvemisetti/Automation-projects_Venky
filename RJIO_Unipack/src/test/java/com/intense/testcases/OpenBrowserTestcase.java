package com.intense.testcases;

import org.testng.annotations.Test;

import com.intense.accelator.ActionWrappers;
import com.intense.pages.OpenBrowserPage;

public class OpenBrowserTestcase extends ActionWrappers {
	
	 OpenBrowserPage obp=new OpenBrowserPage();
	 
	 @Test
	 public void openApplication() {
		 try {
			obp.setBrowser();
			 obp.openURL();
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }

}
