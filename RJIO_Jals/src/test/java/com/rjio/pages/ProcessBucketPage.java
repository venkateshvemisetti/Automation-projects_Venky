package com.rjio.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.fasterxml.jackson.databind.JsonNode;
import com.rjio.accelator.ActionWrappers;
import com.rjio.objects.ProcessBucketsObject;

public class ProcessBucketPage extends ActionWrappers {

	public void processBucketLink() {
		try {
			sleep(1000);
			if (findElementts(ProcessBucketsObject.processBucketLink).size() > 0) {
				if (findElementt(ProcessBucketsObject.processBucketLink).isDisplayed()) {
					click(ProcessBucketsObject.processBucketLink, "processBucketLink");
					waitUntilSpinnerDisappers();
				} else {
					System.err.println("processBucketLink is not displayed");
				}
			} else {
				System.err.println("processBucketLink size is not matched");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createProcessBucket(JsonNode node) {
		try {
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			String bucketName=node.get("bucketName").asText();
			Select listeners = new Select(findElementt(ProcessBucketsObject.addBucketDD));
			listeners.selectByVisibleText("bucket");
			sleep(1000);
			sendKeys(ProcessBucketsObject.bucketName, "bucketName",bucketName);
			sendKeys(ProcessBucketsObject.description, "description", node.get("description").asText());
			sendKeys(ProcessBucketsObject.workerSize, "workerSize", node.get("workerSize").asText());
			sendKeys(ProcessBucketsObject.priority, "priority", node.get("priority").asText());
			sendKeys(ProcessBucketsObject.ruleDefinition, "ruleDefinition", node.get("ruleDefinition").asText());
			click(ProcessBucketsObject.account, "account");
			sleep(1000);
			List<WebElement> accountNames = findElementts(ProcessBucketsObject.accountList);
			int accountnamei = 0;
			for (WebElement accountName : accountNames) {
				sleep(500);
				System.out.println("name are " + accountName.getText());
				if (accountName.getText().equalsIgnoreCase(node.get("account").asText())) {
					accountNames.get(accountnamei).click();
					break;
				} else {
					System.err.println("checking for account names :: comparison");
				}
				accountnamei++;
			}

			sleep(1000);
			if (node.get("useAccountCheck").asText().equalsIgnoreCase("yes")) {
				if (!findElementt(ProcessBucketsObject.useAccountCheck).isSelected()) {
					click(ProcessBucketsObject.useAccountCheck, "useAccountCheck");
				} else {
					System.err.println("useAccountCheck already selected");
				}
			} else {
				System.err.println("useAccountCheck option is NO input file");
			}

			sleep(1500);

			extentTest.info("The process bucket data is : "+bucketName,
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
			if (node.get("Save").asText().equalsIgnoreCase("yes")) {
				click(ProcessBucketsObject.saveBTN, "saveBTN");
				extentTest.info("The process bucket is saved successfully : "+bucketName,
						MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
				click(ProcessBucketsObject.alertBucketOK, "alertBucketOK");
			} else {
				click(ProcessBucketsObject.cancelBTN, "cancelBTN");
			}
			sleep(1000);
			backToFrame();
			waitUntilSpinnerDisappers();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void searchProcessBucket(String name) {
		try {
			sendKeys(ProcessBucketsObject.searchfiled, "searchfiled", name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void editProcessBucket(JsonNode node) {
		try {
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			String bucketName = node.get("bucketName").asText();
			searchProcessBucket(bucketName);
			backToFrame();
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			if(findElementts(ProcessBucketsObject.editIcon).size()==1) {
			extentTest.info("The ProcessBuckets is : ",
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
			//click(ProcessBucketsObject.editIcon, "editIcon");
			clickUsingJSE(findElementt(ProcessBucketsObject.editIcon));
			sleep(1000);
			extentTest.info("Process Bucket data is : "+bucketName,
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
			sendKeys(ProcessBucketsObject.description, "description", node.get("description").asText());
			sendKeys(ProcessBucketsObject.workerSize, "workerSize", node.get("workerSize").asText());
			sendKeys(ProcessBucketsObject.priority, "priority", node.get("priority").asText());
			sendKeys(ProcessBucketsObject.ruleDefinition, "ruleDefinition", node.get("ruleDefinition").asText());
			click(ProcessBucketsObject.account, "account");
			sleep(1000);
			List<WebElement> accountNames = findElementts(ProcessBucketsObject.accountList);
			int accountnamei = 0;
			for (WebElement accountName : accountNames) {
				sleep(500);
				System.out.println("name are " + accountName.getText());
				if (accountName.getText().equalsIgnoreCase(node.get("account").asText())) {
					accountNames.get(accountnamei).click();
					break;
				} else {
					System.err.println("checking for account names :: comparison");
				}
				accountnamei++;
			}

			sleep(1000);
			if (node.get("useAccountCheck").asText().equalsIgnoreCase("yes")) {
				if (!findElementt(ProcessBucketsObject.useAccountCheck).isSelected()) {
					click(ProcessBucketsObject.useAccountCheck, "useAccountCheck");
				} else {
					System.err.println("useAccountCheck already selected");
				}
			} else {
				System.err.println("useAccountCheck option is NO in input file");
			}
			sleep(1000);
			if (node.get("Edit").asText().equalsIgnoreCase("yes")) {
				click(ProcessBucketsObject.updateBTN, "updateBTN");
				extentTest.pass("Process bucket is updated successfully : "+bucketName,
						MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
				click(ProcessBucketsObject.alertBucketOK, "alertBucketOK");
			} else {
				click(ProcessBucketsObject.cancelBTN, "cancelBTN");
			}
			}
			else
			{
				System.out.println("Process bucket : edit icon is not matched");
			}
			sleep(1000);
			backToFrame();
			waitUntilSpinnerDisappers();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void startProcessBucket(JsonNode node) {
		try {
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			String bucketName = node.get("bucketName").asText();
			searchProcessBucket(bucketName);
			backToFrame();
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			if(findElementts(ProcessBucketsObject.enableIcon).size()==1) {
			extentTest.info("Process bucket name is : "+bucketName);
			extentTest.info("Before process bucket enabling : "+bucketName,
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
			//click(ProcessBucketsObject.enableIcon, "enableIcon");
			clickUsingJSE(findElementt(ProcessBucketsObject.enableIcon));
			sleep(2000);
			extentTest.info("Processbucket message confirmation is : "+bucketName,
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
			click(ProcessBucketsObject.yesBTN, "yesBTN");
			sleep(1500);
			searchProcessBucket(bucketName);
			sleep(3000);
			extentTest.pass("Post processbucket enabled successfully : "+bucketName,
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
			}
			else
			{
				System.out.println("Process bucket enable icon is not matched");
			}
			clear(ProcessBucketsObject.searchfiled, "searchfiled");
			backToFrame();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void stopProcessBucket(JsonNode node) {
		try {
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			String bucketName = node.get("bucketName").asText();
			searchProcessBucket(bucketName);
			backToFrame();
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			if (findElementts(ProcessBucketsObject.disableIcon).size()==1) {
			extentTest.info("Process bucket name is : "+bucketName);
			extentTest.info("Before processbucket disabling : "+bucketName,
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
			//click(ProcessBucketsObject.disableIcon, "disableIcon");
			clickUsingJSE(findElementt(ProcessBucketsObject.disableIcon));
			sleep(1000);
			extentTest.info("Bucket confirmation is : "+bucketName,
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
			click(ProcessBucketsObject.yesBTN, "yesBTN");
			sleep(1000);
			searchProcessBucket(bucketName);
			backToFrame();
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			extentTest.pass("Post processbucket disabled successfully : "+bucketName,
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
			}
			else
			{
				System.out.println("Process bucket : disable icon size is not matched");
			}
			clear(ProcessBucketsObject.searchfiled, "searchfiled");
			backToFrame();
			waitUntilSpinnerDisappers();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
