package com.rjio.pages;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.fasterxml.jackson.databind.JsonNode;
import com.rjio.accelator.ActionWrappers;
import com.rjio.objects.AlertsQueuesObject;

public class AlertsQueuesPage extends ActionWrappers {

	public void alertQueueLink() {
		try {
			sleep(1000);
			if (findElementts(AlertsQueuesObject.alertQueueLink).size() > 0) {
				if (findElementt(AlertsQueuesObject.alertQueueLink).isDisplayed()) {
					click(AlertsQueuesObject.alertQueueLink, "alertQueueLink");
					waitUntilSpinnerDisappers();
				} else {
					System.err.println("alertQueueLink is not displayed");
				}
			} else {
				System.err.println("alertQueueLink size is not matched");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createQueue(JsonNode node) {
		try {
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			if (findElementts(AlertsQueuesObject.createQueue).size() > 0) {
				if (findElementt(AlertsQueuesObject.createQueue).isDisplayed()) {
					click(AlertsQueuesObject.createQueue, "createQueue");
					sleep(1500);
					String name_csv = node.get("name").asText();
					String description_csv = node.get("description").asText();
					sendKeys(AlertsQueuesObject.name, "name", name_csv);
					sendKeys(AlertsQueuesObject.description, "description", description_csv);
					sleep(19000);
					extentTest.info("The Queue data is : " + name_csv,
							MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
					if (node.get("Save").asText().equalsIgnoreCase("yes")) {
						click(AlertsQueuesObject.saveBTN, "saveBTN");

					} else {
						System.err.println("no saving here --queue");
					}

					sleep(1000);
					extentTest.pass("The Queue data is saved successfully : " + name_csv,
							MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
					click(AlertsQueuesObject.alertQueueOK, "alertQueueOK");
				} else {
					System.err.println("createQueue is not dispalyed");
				}

			} else {
				System.err.println("createQueue size is not matched");
			}
			clear(AlertsQueuesObject.searchfiled, "searchfiled");
			backToFrame();
			waitUntilSpinnerDisappers();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void searchQueue(String name) {
		try {
			sendKeys(AlertsQueuesObject.searchfiled, "searchfiled", name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void editQueue(JsonNode node) {
		try {
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			String queueName = node.get("name").asText();
			searchQueue(queueName);
			backToFrame();
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			if(findElementts(AlertsQueuesObject.editIcon).size()==1) {
			extentTest.info("The Queue name is : " + queueName);
			extentTest.info("The Queue name is : " + queueName,
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
			// click(AlertsQueuesObject.editIcon, "editIcon");
			clickUsingJSE(findElementt(AlertsQueuesObject.editIcon));
			sleep(1000);
			String description_csv = node.get("description").asText();
			extentTest.info("The queue data is : " + queueName,
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
			sendKeys(AlertsQueuesObject.description, "description", description_csv);
			sleep(1000);
			if (node.get("Edit").asText().equalsIgnoreCase("yes")) {
				click(AlertsQueuesObject.updateBTN, "updateBTN");
			} else {
				System.err.println("cancel required here--");
			}

			sleep(500);
			extentTest.pass("The queue data is updated successfully : " + queueName,
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
			click(AlertsQueuesObject.alertQueueOK, "alertQueueOK");
		}
		else {
			System.out.println("Queue : delete icon size is not matched");
		}
			backToFrame();
			waitUntilSpinnerDisappers();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteQueue(JsonNode node) {
		try {
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			String queueName = node.get("name").asText();
			searchQueue(queueName);
			backToFrame();
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			if(findElementts(AlertsQueuesObject.deleteIcon).size()==1) {
			extentTest.info("Before deleting queue is : " + queueName,
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
			//click(AlertsQueuesObject.deleteIcon, "deleteIcon")
			clickUsingJSE(findElementt(AlertsQueuesObject.deleteIcon));
			sleep(1000);
			extentTest.info("The deletion confirmation is : " + queueName,
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
			click(AlertsQueuesObject.yesBTN, "yesBTN");
			backToFrame();
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			searchQueue(queueName);
			sleep(1000);
			extentTest.pass("Post deleted queue is : " + queueName,
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
		}
		else {
			System.out.println("Queue : delete icon size is not matched");
		}
			clear(AlertsQueuesObject.searchfiled, "searchfiled");
			backToFrame();
			waitUntilSpinnerDisappers();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
