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
			waitUntilSpinnerDisappers();
			String email = node.get("email").asText();
			List<WebElement> searchfiled = findElementts(ApplicationProcessingObject.searchbox);
			if (searchfiled.size() > 0) {
				if (searchfiled.get(0).isEnabled()) {
					searchfiled.get(0).clear();
					searchfiled.get(0).sendKeys(email);
					waitUntilSpinnerDisappers();
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
			waitUntilSpinnerDisappers();
			String email = node.get("email").asText();
			List<WebElement> emailfrmAPP = findElementts(ApplicationProcessingObject.emailName);
			if (emailfrmAPP.get(0).getText().equals(email)) {
				// extentTest.pass("The application is : "+emailfrmAPP.get(0).getText(),
				// MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
				mouseOverToElement(findElementt(ApplicationProcessingObject.editIcon));
				List<WebElement> editicon = findElementts(ApplicationProcessingObject.editIcon);
				if (editicon.size() == 1) {
					if (editicon.get(0).isDisplayed() && editicon.get(0).isEnabled()) {
						editicon.get(0).click();
						waitUntilSpinnerDisappers();
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

	public void productsDeatils(JsonNode node) {
		try {
			waitUntilSpinnerDisappers();
			List<WebElement> products = findElementts(ApplicationProcessingObject.productaddBTN);
			if (products.size() > 0) {
				for (WebElement product : products) {
					waitUntilSpinnerDisappers();
					product.click();
					waitUntilSpinnerDisappers();
				}
			} else {
				System.out.println("productaddBTN size in not matched");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void businessDetails(JsonNode node) {
		try {
			waitUntilSpinnerDisappers();
			if (node.get("governmententity").asText().equals("No")) {
				selectRequiredRadioBtnOrCheckBox(ApplicationProcessingObject.governmentEntityLabel,
						ApplicationProcessingObject.governmentEntityBTS, node.get("governmententity").asText());
			} else if (node.get("governmententity").asText().equals("Yes")) {
				saveConClick();
			} else {
				extentTest.info("governmententity value is invalid");
			}
			waitUntilSpinnerDisappers();
			if(true) {

			selectRequiredRadioBtnOrCheckBox(ApplicationProcessingObject.multinationalBusinessLabel,
					ApplicationProcessingObject.multinationalBusinessBTS, node.get("multinationalbusiness").asText());
			}
			else if(false) {
				
			}
			else
			{
				
			}
			selectValFromSelectCumTextBox(ApplicationProcessingObject.incorporationlocation,
					ApplicationProcessingObject.searchboxDD, node.get("incorporationlocation").asText());
			waitUntilSpinnerDisappers();
			selectValFromSelectCumTextBox(ApplicationProcessingObject.legalentitytype,
					ApplicationProcessingObject.searchboxDD, node.get("legalentitytype").asText());
			waitUntilSpinnerDisappers();
			uploadFile(ApplicationProcessingObject.browsefileorTake, ApplicationProcessingObject.browsefile,
					node.get("filepathTradeL").asText());
			waitUntilSpinnerDisappers();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveConClick() {
		try {
			waitUntilSpinnerDisappers();
			List<WebElement> savecontinue = findElementts(ApplicationProcessingObject.saveConBTN);
			savecontinue.get(0).click();
			extentTest.info("Clicked on Save & Continue Button");
			waitUntilSpinnerDisappers();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
