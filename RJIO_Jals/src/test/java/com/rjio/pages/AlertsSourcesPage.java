package com.rjio.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.fasterxml.jackson.databind.JsonNode;
import com.rjio.accelator.ActionWrappers;
import com.rjio.objects.AlertsSourcesObject;

public class AlertsSourcesPage extends ActionWrappers {
	public void alertSourceLink() {
		try {
			if (findElementts(AlertsSourcesObject.alertSourcLink).size() > 0) {
				if (findElementt(AlertsSourcesObject.alertSourcLink).isDisplayed()) {
					click(AlertsSourcesObject.alertSourcLink, "alertsourclink");
					waitUntilSpinnerDisappers();
				} else {
					System.err.println("alertSourcLink is not displayed");
				}
			} else {
				System.err.println("alertSourcLink size is not matched");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void alertAccept() {
		try {
			System.err.println("alert()::::::");
			List<WebElement> alerts = findElementts(AlertsSourcesObject.alertSourceOK);
			System.out.println("size:: " + alerts.size());
			if (alerts.size() > 0) {
				System.err.println("size----");
				if (!alerts.get(0).isDisplayed()) {
					sendKeys(AlertsSourcesObject.parameter, "parameter", "data1");
					return;
				} else {
					JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
					jsExecutor.executeScript("arguments[0].click();", alerts.get(0));
					System.out.println("alerttttttt");
					click(AlertsSourcesObject.parameter, "parameter");
					alertAccept();
				}
			} else {
				sendKeys(AlertsSourcesObject.parameter, "parameter", "data1");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createSource(JsonNode node) {
		try {
			waitUntilSpinnerDisappers();
			sleep(1000);
			moveFrame("bodyframe");
			customWait(findElementt(AlertsSourcesObject.addSourceDD));
			Select sources = new Select(findElementt(AlertsSourcesObject.addSourceDD));
			sources.selectByVisibleText("Custom");
			sleep(1000);
			String name_csv = node.get("name").asText();
			String description_csv = node.get("description").asText();
			sendKeys(AlertsSourcesObject.name, "name", name_csv);
			sendKeys(AlertsSourcesObject.description, "description", description_csv);
			// click(AlertsSourcesObject.addParametersBTN, "addParametersBTN");
			sleep(1000);
			extentTest.info("The source data is : " + name_csv,
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
			click(AlertsSourcesObject.saveBTN, "saveBTN");
			extentTest.pass("The source data is saved successfully : " + name_csv,
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
			sleep(1000);
			click(AlertsSourcesObject.alertSourceOK, "alertSourceOK");
			backToFrame();
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			sleep(1000);
			searchSource(name_csv);
			backToFrame();
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			sleep(1000);

			extentTest.info("Created source is : " + name_csv,
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
			sleep(1000);
			clear(AlertsSourcesObject.searchfiled, "searchfiled");
			backToFrame();
			waitUntilSpinnerDisappers();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void searchSource(String name) {
		try {
			sendKeys(AlertsSourcesObject.searchfiled, "searchfiled", name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void editSource(JsonNode node) {
		try {
			waitUntilSpinnerDisappers();
			sleep(1000);
			moveFrame("bodyframe");
			String sourceName = node.get("name").asText();
			searchSource(sourceName);
			backToFrame();
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			sleep(1500);
			extentTest.info("The source is : " + sourceName,
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
			// click(AlertsSourcesObject.editIcon, "editIcon");
			if (findElementts(AlertsSourcesObject.editIcon).size() == 1) {
				if (findElementt(AlertsSourcesObject.editIcon).getAttribute("title").contains("Edit")) {
					clickUsingJSE(findElementt((AlertsSourcesObject.editIcon)));
					sleep(1000);
					String description_csv = node.get("description").asText();
					extentTest.info("The source data is : " + sourceName,
							MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
					sendKeys(AlertsSourcesObject.description, "description", description_csv);
					sleep(1000);
					if (node.get("Edit").asText().equalsIgnoreCase("yes")) {
						click(AlertsSourcesObject.updateBTN, "updateBTN");
					} else {
						System.err.println("cancel required here--");
					}
					sleep(2000);
					extentTest.pass("The source data is updated successfully : " + sourceName,
							MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
					click(AlertsSourcesObject.alertSourceOK, "alertSourceOK");
				} else {
					System.err.println("edit text btn not there : " + sourceName);
					extentTest.info("edit text btn not there : " + sourceName);
				}
			} else {
				System.out.println("Source editIcon size is not matched" + sourceName);
				extentTest.info("Source editIcon size is not matched" + sourceName);
			}
			backToFrame();
			waitUntilSpinnerDisappers();
			sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void startSource(JsonNode node) {
		try {
			waitUntilSpinnerDisappers();
			sleep(1500);
			moveFrame("bodyframe");
			String sourceName = node.get("name").asText();
			sleep(1500);
			searchSource(sourceName);
			backToFrame();
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			extentTest.info("Source name is : " + sourceName);
			sleep(1000);

			if (findElementts(AlertsSourcesObject.startIcon).size() > 0) {
				if (findElementt(AlertsSourcesObject.startIcon).getAttribute("title").contains("Start")) {
					extentTest.info("Before Source starting : " + sourceName,
							MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
					// click(AlertsSourcesObject.startIcon, "startIcon");
					clickUsingJSE(findElementt(AlertsSourcesObject.startIcon));
					sleep(1500);
					extentTest.info("Confirmation message is : " + sourceName,
							MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
					click(AlertsSourcesObject.yesBTN, "yesBTN");

				} else {
					System.err.println("Already Started" + sourceName);
					extentTest.info("Already Started" + sourceName);
				}

			} else {
				System.out.println("Start icon size is not matched");
				extentTest.info("Start icon size is not matched" + sourceName);
			}
			backToFrame();
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			// click(AlertsSourcesObject.alertSourceOK, "alertSourceOK");
			sleep(1000);
			searchSource(sourceName);
			backToFrame();
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			sleep(1000);
			extentTest.pass("Post source is started : " + sourceName,
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
			sleep(2000);
			clear(AlertsSourcesObject.searchfiled, "searchfiled");
			sleep(1000);
			backToFrame();
			waitUntilSpinnerDisappers();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void stopSource(JsonNode node) {
		try {
			waitUntilSpinnerDisappers();
			sleep(1500);
			moveFrame("bodyframe");
			String sourceName = node.get("name").asText();
			sleep(2000);
			searchSource(sourceName);
			backToFrame();
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			extentTest.info("Source name is : " + sourceName);
			sleep(2000);
			if (findElementts(AlertsSourcesObject.stopIcon).size() > 0) {
				if (findElementt(AlertsSourcesObject.stopIcon).getAttribute("title").contains("Pause")) {
					extentTest.info("Before Source stopping : " + sourceName,
							MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
					// click(AlertsSourcesObject.stopIcon, "stopIcon");
					clickUsingJSE(findElementt(AlertsSourcesObject.stopIcon));
					sleep(2000);
					extentTest.info("Confirmation message is : " + sourceName,
							MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
					click(AlertsSourcesObject.yesBTN, "yesBTN");
					sleep(1500);
					// click(AlertsSourcesObject.alertSourceOK, "alertSourceOK");
				} else {
					System.err.println("Already Stopped" + sourceName);
					extentTest.info("Already Stopped" + sourceName);
				}

			} else {
				System.out.println("Stop icon size is not matched");
				extentTest.info("Stop icon size is not matched" + sourceName);
			}
			backToFrame();
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			sleep(1000);
			searchSource(sourceName);
			backToFrame();
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			sleep(1000);
			extentTest.pass("Post source is stopped : " + sourceName,
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
			sleep(1000);
			clear(AlertsSourcesObject.searchfiled, "searchfiled");
			sleep(1000);
			backToFrame();
			waitUntilSpinnerDisappers();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteSource(JsonNode node) {
		try {
			waitUntilSpinnerDisappers();
			sleep(1000);
			moveFrame("bodyframe");
			String sourceName = node.get("name").asText();
			searchSource(sourceName);
			backToFrame();
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			sleep(1000);
			extentTest.info("Before deleting source is : " + sourceName,
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
			// click(AlertsSourcesObject.deleteIcon, "deleteIcon");
			clickUsingJSE(findElementt(AlertsSourcesObject.deleteIcon));
			sleep(1000);
			extentTest.info("The deletion confirmation message is : " + sourceName,
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
			click(AlertsSourcesObject.yesBTN, "yesBTN");

			backToFrame();
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			sleep(1000);
			searchSource(sourceName);
			backToFrame();
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			sleep(1500);
			extentTest.pass("Post deleted source is : " + sourceName,
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
			sleep(1000);
			clear(AlertsSourcesObject.searchfiled, "searchfiled");
			backToFrame();
			waitUntilSpinnerDisappers();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
