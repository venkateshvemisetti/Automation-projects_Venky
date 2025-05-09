package com.intense.pages;

import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.intense.accelator.ActionWrappers;
import com.intense.accelator.ExcelOperations;
import com.intense.objects.EditUserObject;

public class EditUserPage extends ActionWrappers {
	ExcelOperations re=new ExcelOperations();

	public void editIcon() {
		try {
			if (findElementts(EditUserObject.editIcon).size() == 1) {
				if (findElementt(EditUserObject.editIcon).isDisplayed()) {
					if (findElementt(EditUserObject.editIcon).isEnabled()) {
						click(EditUserObject.editIcon, "editIcon");
					} else {
						System.err.println("editIcon is not enabled");
						extentTest.info("editIcon is not enabled",
								MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
					}
				} else {
					System.err.println("editIcon is not displayed");
					extentTest.info("editIcon is not displayed",
							MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
				}
			} else {
				System.err.println("editIcon size is not matched");
				extentTest.info("editIcon size is not matched",
						MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void editUserData() {
		try {
			if (findElementts(EditUserObject.editUserPage).size()==1) {
				Select pwdpolicy = new Select(findElementt(EditUserObject.policyName));
				pwdpolicy.selectByVisibleText(re.readExcel("CreateUser_Data", 5, 1));
				
			} else {
System.err.println("editUserPage size not matched");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
