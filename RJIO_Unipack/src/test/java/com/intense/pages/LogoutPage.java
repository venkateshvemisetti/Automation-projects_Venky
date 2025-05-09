package com.intense.pages;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.intense.accelator.ActionWrappers;
import com.intense.objects.LogoutObject;

public class LogoutPage extends ActionWrappers {

	public void logoutUser() {
		try {
			if (findElementts(LogoutObject.logoutBTN).size() > 0) {
				if (findElementt(LogoutObject.logoutBTN).isEnabled()) {
					sleep(1000);
					click(LogoutObject.logoutBTN, "logoutBTN");
					sleep(2000);
					extentTest.pass("Post loggingout , the respective page is ", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
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
