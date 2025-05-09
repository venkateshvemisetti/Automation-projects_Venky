package com.geidea.pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.fasterxml.jackson.databind.JsonNode;
import com.geidea.accelator.ActionWrappers;
import com.geidea.objects.LoginObject;

public class LoginPage extends ActionWrappers {

	public void username(JsonNode node) {
		try {
			if (findElementts(LoginObject.username).size() > 0) {
				sendKeys(LoginObject.username, "username", node.get("username").asText());
				extentTest.info("Username is entered");
				// extentTest.info("Entered username is " + re.readExcel("Login", 5, 1));
			} else {
				System.err.println("username size is not matched");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void password(JsonNode node) {
		try {
			if (findElementts(LoginObject.password).size() > 0) {
				sendKeys(LoginObject.password, "password", node.get("password").asText());
				extentTest.info("Password is entered");
				// extentTest.info("Entered password is " + re.readExcel("Login", 6, 1));
			} else {
				System.err.println("password size is not matched");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loginUser(JsonNode node) {
		try {
			username(node);
			password(node);
			driver.switchTo().frame(0);
			click(LoginObject.robotCHK, "robotCHK");
			backToFrame();
			sleep(3000);
			List<WebElement> loginbts = findElementts(LoginObject.SigninBTN);
			if (loginbts.size() > 0) {
				if (loginbts.get(0).isEnabled() && loginbts.get(0).isDisplayed()) {
					 loginbts.get(0).click();
					extentTest.pass("Signin button is clicked",
							MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
					
				} else {
					System.err.println("SigninBTN is not enabled/displayed");
				}

			} else {
				System.out.println("SigninBTN size is not matched");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
