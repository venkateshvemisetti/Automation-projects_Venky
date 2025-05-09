package com.intense.pages;

import com.intense.accelator.ActionWrappers;
import com.intense.objects.UserManagerObject;

public class UserManagerPage extends ActionWrappers {

	public void userMangerMove() {
		try {
			if (findElementts(UserManagerObject.userManager).size() > 0) {
				if (findElementt(UserManagerObject.userManager).isDisplayed()) {
					click(UserManagerObject.userManager, "userManager");
				} else {
                   System.err.println("userManager is not dispalyed");
				}
			} else {
				System.err.println("userManager size is not matched");
				extentTest.info("userManager size is not matched");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
