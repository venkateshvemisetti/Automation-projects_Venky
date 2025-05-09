package com.intense.pages;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.intense.accelator.ActionWrappers;
import com.intense.objects.UsersObject;

public class UsersPage extends ActionWrappers {

	
	public void userMove() {
		try {
			if (findElementts(UsersObject.user).size() > 0) {
				if (findElementt(UsersObject.user).isDisplayed()) {
					click(UsersObject.user, "user");
					sleep(2000);
					extentTest.pass("Users page is ",
							MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
				} else {
					System.err.println("user option is not dispalyed");
					extentTest.info("user option is not dispalyed",
							MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
				}

			} else {
				System.err.println("user option size is not matched");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
