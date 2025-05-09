package com.intense.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.intense.accelator.ActionWrappers;
import com.intense.accelator.ExcelOperations;
import com.intense.objects.CreateUserObject;

public class CreateUserPage extends ActionWrappers {

	ExcelOperations re = new ExcelOperations();

	public void createUserOption() {
		try {
			if (findElementt(CreateUserObject.createNewUserBTN).isDisplayed()) {
				click(CreateUserObject.createNewUserBTN, "createNewBTN");
				sleep(20000);
				extentTest.pass("Creation user page is ",
						MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
			} else {
				System.err.println("createNewUserBTN is not dispalyed");
				extentTest.info("createNewUserBTN is not dispalyed",
						MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void frameMove() {
		try {
			driver.switchTo().frame("bodyframe");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createNewUserData() {

		try {
			if (findElementts(CreateUserObject.createUserPage).size() ==1) {
				clear(CreateUserObject.userID, "userID");
				sendKeys(CreateUserObject.userID, "userID", re.readExcel("CreateUser_Data", 4, 1));
				Select pwdpolicy = new Select(findElementt(CreateUserObject.policyName));
				pwdpolicy.selectByVisibleText(re.readExcel("CreateUser_Data", 5, 1));
				clear(CreateUserObject.password, "password");
				sendKeys(CreateUserObject.password, "password", re.readExcel("CreateUser_Data", 6, 1));
				clear(CreateUserObject.confirmPwd, "confirmPwd");
				sendKeys(CreateUserObject.confirmPwd, "confirmPwd", re.readExcel("CreateUser_Data", 7, 1));
				clear(CreateUserObject.firstName, "firstName");
				sendKeys(CreateUserObject.firstName, "firstName", re.readExcel("CreateUser_Data", 8, 1));
				clear(CreateUserObject.middleName, "middleName");
				sendKeys(CreateUserObject.middleName, "middleName", re.readExcel("CreateUser_Data", 9, 1));
				clear(CreateUserObject.lastName, "lastName");
				sendKeys(CreateUserObject.lastName, "lastName", re.readExcel("CreateUser_Data", 10, 1));
				clear(CreateUserObject.mobileNum, "mobileNum");
				sendKeys(CreateUserObject.mobileNum, "mobileNum", re.readExcel("CreateUser_Data", 11, 1));
				clear(CreateUserObject.emailID, "emailID");
				sendKeys(CreateUserObject.emailID, "emailID", re.readExcel("CreateUser_Data", 12, 1));
				Select roles = new Select(findElementt(CreateUserObject.roleList));
				roles.selectByValue("1");
				if (findElementt(CreateUserObject.addBTN).isDisplayed()) {
					click(CreateUserObject.addBTN, "addBTN");
				} else {
					System.err.println("addBTN is not displayed");
				}
				Select depts = new Select(findElementt(CreateUserObject.deptNames));
				depts.selectByValue("1");
				Select designs = new Select(findElementt(CreateUserObject.design));
				designs.selectByValue("1");

				extentTest.info("The create user with data is ",
						MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());

			} else {
				System.err.println("createUserPage size is not matched");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveCreateUsrDataOptions() {
		try {
			if ((re.readExcel("CreateUser_Data", 18, 1).equals("1"))) {
				if (findElementt(CreateUserObject.saveNewBTN).isDisplayed()) {
					click(CreateUserObject.saveNewBTN, "saveNewBTN");
					sleep(1500);
					extentTest.pass("Post clicking on save and new button is",
							MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
				} else {
					System.err.println("saveNewBTN is not displayed");
				}
			} else if (re.readExcel("CreateUser_Data", 18, 1).equals("2")) {
				if (findElementt(CreateUserObject.saveBTN).isDisplayed()) {
					click(CreateUserObject.saveBTN, "saveBTN");
					sleep(1500);
					extentTest.pass("Post clicking on save button is",
							MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());

				} else {
					System.err.println("saveBTN is not displayed");
				}

			} else if (re.readExcel("CreateUser_Data", 18, 1).equals("3")) {
				List<WebElement> cancelBTNs = findElementts(CreateUserObject.cancelBTN);
				if (cancelBTNs.size() > 0) {

					for (WebElement eachCancelBTN : cancelBTNs) {
						if (eachCancelBTN.isDisplayed()) {
							eachCancelBTN.click();
							click(CreateUserObject.cancelYesBTN, "cancelYesBTN");
							break;
						} else {
							System.err.println("eachCancelBTN is not displayed");
						}
					}
				} else {
					System.err.println("cancelBTNs size not matched");
				}

			} else {
				System.err.println("Invalid save options :: it must be in 1 or 2 or 3");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
