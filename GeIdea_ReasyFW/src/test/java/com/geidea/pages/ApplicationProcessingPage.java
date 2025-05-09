package com.geidea.pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.fasterxml.jackson.databind.JsonNode;
import com.geidea.accelator.ActionWrappers;
import com.geidea.objects.ApplicationProcessingObject;

public class ApplicationProcessingPage extends ActionWrappers {

	public void findApplication(JsonNode node) {
		try {
			sleep(2000);
			String email = node.get("email").asText();
			List<WebElement> searchfiled = findElementts(ApplicationProcessingObject.searchbox);
			if (searchfiled.size() > 0) {
				if (searchfiled.get(0).isEnabled()) {
					searchfiled.get(0).clear();
					searchfiled.get(0).sendKeys(email);
					sleep(2000);
					List<WebElement> emailfrmAPP = findElementts(ApplicationProcessingObject.emailName);
					if (emailfrmAPP.size() == 1) {
						if (emailfrmAPP.get(0).getText().equals(email)) {
							extentTest.pass("The application is : " + emailfrmAPP.get(0).getText(),
									MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
						} else {
							System.out.println("application is not found");
						}
					} else {
						System.out.println("application records size is not matched");
					}
				} else {
					System.out.println("searchfiled is not enabled");
				}
			} else {
				System.out.println("searchfiled size is not matched");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void editClick(JsonNode node) {
		try {
			sleep(2000);
			String email = node.get("email").asText();
			List<WebElement> emailfrmAPP = findElementts(ApplicationProcessingObject.emailName);
			if (emailfrmAPP.get(0).getText().equals(email)) {
				// extentTest.pass("The application is : "+emailfrmAPP.get(0).getText(),
				// MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
				//mouseOverToElement(findElementt(ApplicationProcessingObject.editIcon));
				List<WebElement> editicon = findElementts(ApplicationProcessingObject.editIcon);
				if (editicon.size() == 1) {
					if (editicon.get(0).isDisplayed() && editicon.get(0).isEnabled()) {
						editicon.get(0).click();
						sleep(2000);
					} else {
						System.out.println("editicon is not enabled/displayed");
					}

				} else {
					System.out.println("editicon size is not matched");
				}

			} else {
				System.out.println("application is not found");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addProducts() {
		try {
			sleep(2000);
			List<WebElement> products = findElementts(ApplicationProcessingObject.productaddBTN);
			if (products.size() > 0) {
				for (WebElement product : products) {
					sleep(2000);
					product.click();
					sleep(2000);
				}
			} else {
				System.out.println("productaddBTN size in not matched");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveConClick() {
		try {
			sleep(2000);
			List<WebElement> savecontinue = findElementts(ApplicationProcessingObject.saveConBTN);
			savecontinue.get(0).click();
			sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
