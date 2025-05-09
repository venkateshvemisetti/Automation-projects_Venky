package com.rjio.pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.fasterxml.jackson.databind.JsonNode;
import com.rjio.accelator.ActionWrappers;
import com.rjio.objects.ApplicationsObject;

public class ApplicationsPage extends ActionWrappers {
	

	public void alertApplicationLink() {
		try {
			sleep(1000);
			if (findElementts(ApplicationsObject.alertApplicationLink).size() > 0) {
				if (findElementt(ApplicationsObject.alertApplicationLink).isDisplayed()) {
					click(ApplicationsObject.alertApplicationLink, "alertApplicationLink");
					waitUntilSpinnerDisappers();
				} else {
					System.err.println("alertApplicationLink is not displayed");
				}
			} else {
				System.err.println("alertApplicationLink size is not matched");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createApplication(JsonNode node) {
		try {
			waitUntilSpinnerDisappers();
			String name_csv=node.get("name").asText();
			moveFrame("bodyframe");
			if (findElementts(ApplicationsObject.createApplication).size() > 0) {
				if (findElementt(ApplicationsObject.createApplication).isDisplayed()) {
					click(ApplicationsObject.createApplication, "createApplication");
					sleep(1000);
					sendKeys(ApplicationsObject.name, "name",name_csv);
					sendKeys(ApplicationsObject.description, "description", node.get("description").asText());
					sendKeys(ApplicationsObject.owner, "owner", node.get("owner").asText());
					sendKeys(ApplicationsObject.mobileNumber, "mobileNumber", node.get("mobileNumber").asText());
					sendKeys(ApplicationsObject.email, "email", node.get("email").asText());
					sendKeys(ApplicationsObject.mobileSenderIDP, "mobileSenderIDP",node.get("mobileSenderIDP").asText());
					sendKeys(ApplicationsObject.emailSenderIDP, "emailSenderIDP", node.get("emailSenderIDP").asText());
					sendKeys(ApplicationsObject.mobileSenderIDT, "mobileSenderIDT", node.get("mobileSenderIDT").asText());
					sendKeys(ApplicationsObject.emailSenderIDT, "emailSenderIDT", node.get("emailSenderIDT").asText());
					sendKeys(ApplicationsObject.RTTSSenderID, "RTTSSenderID", node.get("RTTSSenderID").asText());
					sendKeys(ApplicationsObject.applicationID, "applicationID", node.get("applicationID").asText());
					sendKeys(ApplicationsObject.apiKey, "apiKey", node.get("apiKey").asText());
					sendKeys(ApplicationsObject.secretKey, "secretKey", node.get("secretKey").asText());
					sendKeys(ApplicationsObject.templates, "templates", node.get("templates").asText());
					click(ApplicationsObject.templates, "templates");
					sendKeys(ApplicationsObject.templates, "templates", node.get("templates").asText());
					click(ApplicationsObject.templates, "templates");
					List<WebElement> tempNames = findElementts(ApplicationsObject.availableserachList);
					System.err.println("size--"+tempNames.size());
					if (findElementts(ApplicationsObject.availableserachList).size() > 0) {
						int tempNamei = 0;
						for (WebElement tempName : tempNames) {
							if (tempName.getText().equals(node.get("templates").asText())) {
								System.err.println("-000 "+tempName.getText());
								tempNames.get(tempNamei).click();
								break;
							} else {
								System.err.println("tempNames text failed");
							}
							tempNamei++;
						}
					} else {
						System.err.println("availableserachList size is not macthed");
					}

					sleep(1000);
					click(ApplicationsObject.addToTempSel, "addToTempSel");
					sleep(1000);
					extentTest.info("The Application data is : "+name_csv,
							MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
					click(ApplicationsObject.saveBTN, "saveBTN");
					sleep(500);
					extentTest.pass("Post The Application data is saved successfully : "+name_csv,
							MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
					click(ApplicationsObject.alertApplicationOK, "alertApplicationOK");
				} else {
					System.err.println("createApplication is not dispalyed");
				}

			} else {
				System.err.println("createApplication size is not matched");
			}
			backToFrame();
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			searchApplication(name_csv);
			backToFrame();
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			extentTest.info("Created application is : "+name_csv,
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
			sleep(500);
			clear(ApplicationsObject.searchfiled, "searchfiled");
			backToFrame();
			waitUntilSpinnerDisappers();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void searchApplication(String name) {
		try {
			sendKeys(ApplicationsObject.searchfiled, "searchfiled", name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void editApplication(JsonNode node) {
		try {
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			String applictionName=node.get("name").asText();
			searchApplication(applictionName);
			backToFrame();
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			sleep(2000);
			extentTest.info("The application is : "+applictionName,
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
			//click(ApplicationsObject.editIcon, "editIcon");
			if(findElementts(ApplicationsObject.editIcon).size()==1) {
			clickUsingJSE(findElementt(ApplicationsObject.editIcon));
			sleep(1000);
			extentTest.info("The application data is : "+applictionName,
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
			sendKeys(ApplicationsObject.description, "description", node.get("description").asText());
			sendKeys(ApplicationsObject.owner, "owner", node.get("owner").asText());
			sendKeys(ApplicationsObject.mobileNumber, "mobileNumber", node.get("mobileNumber").asText());
			sendKeys(ApplicationsObject.email, "email", node.get("email").asText());
			sendKeys(ApplicationsObject.mobileSenderIDP, "mobileSenderIDP",node.get("mobileSenderIDP").asText());
			sendKeys(ApplicationsObject.emailSenderIDP, "emailSenderIDP", node.get("emailSenderIDP").asText());
			sendKeys(ApplicationsObject.mobileSenderIDT, "mobileSenderIDT", node.get("mobileSenderIDT").asText());
			sendKeys(ApplicationsObject.emailSenderIDT, "emailSenderIDT", node.get("emailSenderIDT").asText());
			sendKeys(ApplicationsObject.RTTSSenderID, "RTTSSenderID", node.get("RTTSSenderID").asText());
			/*sendKeys(ApplicationsObject.applicationID, "applicationID", node.get("applicationID").asText());*/
			sendKeys(ApplicationsObject.apiKey, "apiKey", node.get("apiKey").asText());
			sendKeys(ApplicationsObject.secretKey, "secretKey", node.get("secretKey").asText());
			sendKeys(ApplicationsObject.templates, "templates", node.get("templates").asText());
			click(ApplicationsObject.templates, "templates");
			
			List<WebElement> tempNames = findElementts(ApplicationsObject.availableserachList);
			System.err.println("size--"+tempNames.size());
			if (findElementts(ApplicationsObject.availableserachList).size() > 0) {
				int tempNamei = 0;
				for (WebElement tempName : tempNames) {
					if (tempName.getText().equals(node.get("templates").asText())) {
						System.err.println("-000 "+tempName.getText());
						tempNames.get(tempNamei).click();
						break;
					} else {
						System.err.println("tempNames text failed");
					}
					tempNamei++;
				}
			} else {
				System.err.println("availableserachList size is not macthed");
			}

			sleep(1000);
			click(ApplicationsObject.addToTempSel, "addToTempSel");
			sleep(500);
			click(ApplicationsObject.updateBTN, "updateBTN");
			sleep(500);
			extentTest.pass("The applications data is updated successfully: "+applictionName,
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
			click(ApplicationsObject.alertApplicationOK, "alertApplicationOK");
			}
			else
			{
				System.out.println("Application : edit icon size is not matched");
			}
			sleep(1000);
			clear(ApplicationsObject.searchfiled, "searchfiled");
			backToFrame();
			waitUntilSpinnerDisappers();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteApplication(JsonNode node) {
		try {
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			String applictionName=node.get("name").asText();
			searchApplication(applictionName);
			backToFrame();
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			extentTest.info("Before deleting application is : "+applictionName,
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
			//click(ApplicationsObject.deleteIcon, "deleteIcon");
			if(findElementts(ApplicationsObject.deleteIcon).size()==1) {
			clickUsingJSE(findElementt(ApplicationsObject.deleteIcon));
			click(ApplicationsObject.yesBTN, "yesBTN");
			backToFrame();
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			searchApplication(applictionName);
			backToFrame();
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			extentTest.pass("Post deleted the application successfully",
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
		}
			else
			{
				System.out.println("Application : delete icon size is not matched");
			}
			clear(ApplicationsObject.searchfiled, "searchfiled");
			backToFrame();
			waitUntilSpinnerDisappers();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
