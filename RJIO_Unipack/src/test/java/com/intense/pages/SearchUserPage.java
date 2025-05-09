package com.intense.pages;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.intense.accelator.ActionWrappers;
import com.intense.objects.SearchUserObject;

public class SearchUserPage extends ActionWrappers {

	public void searchUSR() {
		try {
			if (findElementts(SearchUserObject.searchUsrName).size() > 0) {
				if (findElementt(SearchUserObject.searchUsrName).isDisplayed()) {
					clear(SearchUserObject.searchUsrName, "searchUsrName");
					sendKeys(SearchUserObject.searchUsrName, "searchUsrName", "log3");
				} else {
					System.err.println("searchUsrName is not displayed");
				}
			} else {
				
				System.err.println("searchUsrName size is not matched");
			}
			if (findElementt(SearchUserObject.searchUsrBTN).isDisplayed()) {
				click(SearchUserObject.searchUsrBTN, "searchUsrBTN");
			} else {
				System.err.println("searchUsrBTN is not displayed");
			}
			sleep(1500);
			extentTest.info("The user is", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
