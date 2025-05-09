package com.intense.pages;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.intense.accelator.ActionWrappers;
import com.intense.accelator.ExcelOperations;
import com.intense.objects.LoginObject;

public class LoginPage extends ActionWrappers {
	ExcelOperations re = new ExcelOperations();

	public void username() {
		try {
			if (findElementts(LoginObject.username).size() > 0) {
				clear(LoginObject.username, "username");
				sendKeys(LoginObject.username, "username", re.readExcel("Login", 5, 1));
				extentTest.info("Entered username is " + re.readExcel("Login", 5, 1));
			} else {
				System.err.println("username size is not matched");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void password() {
		try {
			if (findElementts(LoginObject.password).size() > 0) {
				clear(LoginObject.password, "password");
				sendKeys(LoginObject.password, "password", re.readExcel("Login", 6, 1));
				extentTest.info("Entered password is " + re.readExcel("Login", 6, 1));
			} else {
				System.err.println("password size is not matched");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loginUser() {
		try {
			username();
			password();
			if (findElementts(LoginObject.loginBTN).size() > 0) {
				if (findElementt(LoginObject.loginBTN).isEnabled()
						&& findElementt(LoginObject.loginBTN).isDisplayed()) {
					extentTest.info("The application is ",
							MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
					click(LoginObject.loginBTN, "loginBTN");
					// extentTest.addScreenCaptureFromPath(takeScreenShot());
					
				} else {
					System.err.println("loginBTN is not enabled/displayed");
				}

			} else {
				System.out.println("loginBTN size is not matched");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void logoutOthers() {
		try {

			loginUser();
			if (findElementts(LoginObject.otherLogoutText).size() > 0) {
				if (!(findElementt(LoginObject.logoutOtherUserRBTN).isSelected())) {
					click(LoginObject.logoutOtherUserRBTN, "logoutOtherUserRBTN");
				} else {
					System.err.println("logoutOtherUserRBTN already selected");
				}
				if (findElementt(LoginObject.submitBTN).isDisplayed()) {
					click(LoginObject.submitBTN, "submitBTN");
					System.out.println("submitBTN :: Other User loggedout successfully");
					extentTest.log(Status.INFO, "Other User loggedout successfully");
					sleep(1500);
					loginUser();
				} else {
					System.err.println("submitBTN is not displayed");
				}

			} else {
				/*
				 * extentTest.error("otherLogoutText size is not matched",
				 * MediaEntityBuilder.createScreenCaptureFromPath( "size is " +
				 * findElementts(LoginObject.otherLogoutText).size(), takeScreenShot())
				 * .build());
				 */
				System.err.println("otherLogoutText size is not matched");
				extentTest.log(Status.INFO, "Other user is not logging with same userID");
			}
			extentTest.pass("The application is opened ",
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
