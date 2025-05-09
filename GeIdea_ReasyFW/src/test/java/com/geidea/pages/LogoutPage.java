package com.geidea.pages;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.geidea.accelator.ActionWrappers;
import com.geidea.objects.LogoutObject;

public class LogoutPage extends ActionWrappers {

	public void logoutUser() {
		try {
			click(LogoutObject.profileLink, "profileLink");
			sleep(1000);
			if (findElementts(LogoutObject.logoutBTN).size() > 0) {
				if (findElementt(LogoutObject.logoutBTN).isEnabled()) {
					click(LogoutObject.logoutBTN, "logoutBTN");
					extentTest.pass("Post logging-out the application", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
				} else {
					System.err.println("logoutBTN is not enabled");
				}
			} else {
				System.err.println("logoutBTN size is not matched");
				extentTest.error("logoutBTN size is not matched", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
			}

		} catch (Exception e) {

		}
	}

}
