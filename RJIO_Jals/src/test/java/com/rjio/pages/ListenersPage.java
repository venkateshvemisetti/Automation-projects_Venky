package com.rjio.pages;

import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.fasterxml.jackson.databind.JsonNode;
import com.rjio.accelator.ActionWrappers;
import com.rjio.objects.ListenersObject;

public class ListenersPage extends ActionWrappers {

	public void listenerLink() {
		try {
			if (findElementts(ListenersObject.listenerLink).size() > 0) {
				if (findElementt(ListenersObject.listenerLink).isDisplayed()) {
					click(ListenersObject.listenerLink, "listenerLink");
					waitUntilSpinnerDisappers();
				} else {
					System.err.println("listenerLink is not displayed");
				}
			} else {
				System.err.println("listenerLink size is not matched");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createListener(String listenertype, JsonNode node) {
		try {
			waitUntilSpinnerDisappers();
			sleep(1000);
			moveFrame("bodyframe");
			Select listeners = new Select(findElementt(ListenersObject.addListenerDD));
			listeners.selectByVisibleText(listenertype);
			sleep(1500);
			String name_csv = node.get("name").asText();
			extentTest.info("The name of listener : " + name_csv);
			sendKeys(ListenersObject.name, "name", node.get("name").asText());
			sendKeys(ListenersObject.description, "description", node.get("description").asText());
			sendKeys(ListenersObject.folderPath, "folderPath", node.get("folderPath").asText());
			sleep(1500);
			if (node.get("Save").asText().equalsIgnoreCase("yes")) {
				extentTest.info("Listener Data is : " + name_csv,
						MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
				click(ListenersObject.saveBTN, "saveBTN");
				sleep(2000);
				extentTest.pass("The Listener is saved successfully : " + name_csv,
						MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
				click(ListenersObject.alerListenerOK, "alerListenerOK");

			} else {
				System.err.println(" cancel required...");
			}

			backToFrame();
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			sleep(1000);
			searchListener(name_csv);
			backToFrame();
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			sleep(1500);
			extentTest.pass("Created Listener is : " + name_csv,
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
			sleep(1000);
			clear(ListenersObject.searchfiled, "searchfiled");
			backToFrame();
			waitUntilSpinnerDisappers();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	public void createFileListener(JsonNode node) {
		try {
			waitUntilSpinnerDisappers();
			sleep(1000);
			moveFrame("bodyframe");
			Select listeners = new Select(findElementt(ListenersObject.addListenerDD));
			listeners.selectByVisibleText("File");
			sleep(1500);
			String name_csv = node.get("name").asText();
			extentTest.info("The name of listener : " + name_csv);
			sendKeys(ListenersObject.name, "name", node.get("name").asText());
			sendKeys(ListenersObject.description, "description", node.get("description").asText());
			sendKeys(ListenersObject.folderPath, "folderPath", node.get("folderPath").asText());
			sleep(1500);
			if (node.get("Save").asText().equalsIgnoreCase("yes")) {
				extentTest.info("Listener Data is : " + name_csv,
						MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
				click(ListenersObject.saveBTN, "saveBTN");
				sleep(2000);
				extentTest.pass("The Listener is saved successfully : " + name_csv,
						MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
				click(ListenersObject.alerListenerOK, "alerListenerOK");

			} else {
				System.err.println(" cancel required...");
			}

			backToFrame();
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			sleep(1000);
			searchListener(name_csv);
			backToFrame();
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			sleep(1500);
			extentTest.pass("Created Listener is : " + name_csv,
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
			sleep(1000);
			clear(ListenersObject.searchfiled, "searchfiled");
			backToFrame();
			waitUntilSpinnerDisappers();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void searchListener(String name) {
		try {
			sendKeys(ListenersObject.searchfiled, "searchfiled", name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void editFileListener(JsonNode node) {
		try {
			waitUntilSpinnerDisappers();
			sleep(1000);
			moveFrame("bodyframe");
			String listenerName = node.get("name").asText();
			searchListener(listenerName);
			backToFrame();
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			if (findElementts(ListenersObject.editIcon).size() == 1) {
				//click(ListenersObject.editIcon, "editIcon");
				clickUsingJSE(findElementt(ListenersObject.editIcon));
				sleep(1000);
				if(findElementt(ListenersObject.name).getAttribute("value").equals(node.get("name").asText())) {
				sendKeys(ListenersObject.description, "description", node.get("description").asText());
				sendKeys(ListenersObject.folderPath, "folderPath", node.get("folderPath").asText());
				sleep(1500);
				if (node.get("Edit").asText().equalsIgnoreCase("yes")) {
					extentTest.info("The Listener is : " + listenerName,
							MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
					click(ListenersObject.saveBTN, "saveBTN");
					sleep(2000);
					extentTest.pass("The Listener is updated successfully",
							MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
					click(ListenersObject.alerListenerOK, "alerListenerOK");
				} else {
					System.err.println("no need edit : cancel required");
				}
				}
				else
				{
					extentTest.warning("Listerner :: Search :: not matched with name", 
							MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
               System.err.println("Listerner :: Search :: not matched with name");
				}
				
			}
			{
				extentTest.fail("Listener : edit icon size is not matched");
				System.out.println("Listener : edit icon size is not matched");
			}
			backToFrame();
			waitUntilSpinnerDisappers();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void startListener(JsonNode node) {
		try {
			waitUntilSpinnerDisappers();
			sleep(1000);
			moveFrame("bodyframe");
			String listenerName = node.get("name").asText();
			searchListener(listenerName);
			backToFrame();
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			sleep(1000);
			if (findElementts(ListenersObject.startIcon).size() == 1) {
				extentTest.info("Before Listener enabling : " +listenerName,
						MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
				// click(ListenersObject.startIcon, "startIcon");
				clickUsingJSE(findElementt(ListenersObject.startIcon));
				click(ListenersObject.yesBTN, "yesBTN");
				sleep(1000);
				extentTest.info("The confirmation message : " + listenerName,
						MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());

				click(ListenersObject.alerListenerOK, "alerListenerOK");
				backToFrame();
				waitUntilSpinnerDisappers();
				moveFrame("bodyframe");
				searchListener(listenerName);
				backToFrame();
				waitUntilSpinnerDisappers();
				moveFrame("bodyframe");
				extentTest.pass("Post Listener enabled successfully : " + listenerName,
						MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
			}
			else
			{
				extentTest.fail("Listener startIcon size is not matched");
				System.out.println("Listener startIcon size is not matched");
			}
			sleep(1000);
			clear(ListenersObject.searchfiled, "searchfiled");
			backToFrame();
			waitUntilSpinnerDisappers();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void stopListener(JsonNode node) {
		try {
			waitUntilSpinnerDisappers();
			sleep(1000);
			moveFrame("bodyframe");
			String listenerName = node.get("name").asText();
			backToFrame();
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			searchListener(listenerName);
			backToFrame();
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			if (findElementts(ListenersObject.stopIcon).size() == 1) {
				extentTest.info("Before Listener disabling : " + listenerName,
						MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
				// click(ListenersObject.stopIcon, "stopIcon");
				clickUsingJSE(findElementt(ListenersObject.stopIcon));
				click(ListenersObject.yesBTN, "yesBTN");
				sleep(1500);
				extentTest.info("The confirmation message : " + listenerName,
						MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
				click(ListenersObject.alerListenerOK, "alerListenerOK");
				backToFrame();
				waitUntilSpinnerDisappers();
				moveFrame("bodyframe");
				sleep(1000);
				searchListener(listenerName);
				sleep(3000);
				extentTest.pass("Post Listener disabled successfully : " + listenerName,
						MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
			}
			else
			{
				extentTest.fail("listerner stopIcon size is not matched");
				System.out.println("listerner stopIcon size is not matched");
			}
			clear(ListenersObject.searchfiled, "searchfiled");
			backToFrame();
			waitUntilSpinnerDisappers();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteListener(JsonNode node) {
		try {
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			String listenerName = node.get("name").asText();
			searchListener(listenerName);
			backToFrame();
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			if (findElementts(ListenersObject.deleteIcon).size() == 1) {
				extentTest.info("The Listener name is : " + listenerName);
				extentTest.info("Before listener deleting : " +listenerName,
						MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
				// click(ListenersObject.deleteIcon, "deleteIcon");
				clickUsingJSE(findElementt(ListenersObject.deleteIcon));
				sleep(1000);
				click(ListenersObject.yesBTN, "yesBTN");
				backToFrame();
				waitUntilSpinnerDisappers();
				moveFrame("bodyframe");
				searchListener(listenerName);
				sleep(1000);
				extentTest.pass("Post Listener deleted successfully : " + listenerName,
						MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
			} else {
				extentTest.fail("Listener delete icon size is not matched");
				System.out.println("Listener delete icon size is not matched");
			}
			clear(ListenersObject.searchfiled, "searchfiled");
			backToFrame();
			waitUntilSpinnerDisappers();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void createAMQPListener(JsonNode node) {
		try {
			waitUntilSpinnerDisappers();
			sleep(1000);
			moveFrame("bodyframe");
			Select listeners = new Select(findElementt(ListenersObject.addListenerDD));
			listeners.selectByVisibleText("AMQP");
			sleep(1500);
			String name_csv = node.get("name").asText();
			extentTest.info("The name of listener : " + name_csv);
			sendKeys(ListenersObject.amqpname, "amqpname", node.get("name").asText());
			sendKeys(ListenersObject.amqpdescription, "amqpdescription", node.get("description").asText());
			click(ListenersObject.AMQPvendor, "AMQPvendor");
			sleep(500);
			click(ListenersObject.AMQPvendorlistoption, "AMQPvendorlistoption");
			sendKeys(ListenersObject.amqphost, "amqphost", node.get("HostName").asText());
			sendKeys(ListenersObject.amqpport, "amqpport", node.get("Port").asText());
			sendKeys(ListenersObject.amqvirtualHost, "amqvirtualHost", node.get("VirtualHost").asText());
			sendKeys(ListenersObject.amqpuser, "amqpuser", node.get("UserName").asText());
			sendKeys(ListenersObject.amqppwd, "amqppwd", node.get("Password").asText());
			sendKeys(ListenersObject.amqpreqqueue, "amqpreqqueue", node.get("RequestQueue").asText());
			sleep(1500);
			if (node.get("Save").asText().equalsIgnoreCase("yes")) {
				extentTest.info("Listener data is : " + name_csv,
						MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
				click(ListenersObject.amqpSaveBTN, "amqpSaveBTN");
				sleep(2000);
				extentTest.pass("The Listener is saved successfully : " + name_csv,
						MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
				click(ListenersObject.alerListenerOK, "alerListenerOK");
			} else {
				System.err.println(" cancel required...");
			}
			backToFrame();
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			sleep(1000);
			searchListener(name_csv);
			backToFrame();
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			sleep(1500);
			extentTest.pass("Created Listener is : " + name_csv,
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
			sleep(1000);
			clear(ListenersObject.searchfiled, "searchfiled");
			backToFrame();
			waitUntilSpinnerDisappers();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void editAMQPListener(JsonNode node) {
		try {
			waitUntilSpinnerDisappers();
			sleep(1000);
			moveFrame("bodyframe");
			String listenerName = node.get("name").asText();
			searchListener(listenerName);
			backToFrame();
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			if (findElementts(ListenersObject.editIcon).size() == 1) {
				//click(ListenersObject.editIcon, "editIcon");
				clickUsingJSE(findElementt(ListenersObject.editIcon));
				sleep(1000);
				if(findElementt(ListenersObject.amqpname).getAttribute("value").equals(node.get("name").asText())) {
				sendKeys(ListenersObject.amqpdescription, "amqpdescription", node.get("description").asText());
				click(ListenersObject.AMQPvendor, "AMQPvendor");
				sleep(500);
				click(ListenersObject.AMQPvendorlistoption, "AMQPvendorlistoption");
				sendKeys(ListenersObject.amqphost, "amqphost", node.get("HostName").asText());
				sendKeys(ListenersObject.amqpport, "amqpport", node.get("Port").asText());
				sendKeys(ListenersObject.amqvirtualHost, "amqvirtualHost", node.get("VirtualHost").asText());
				sendKeys(ListenersObject.amqpuser, "amqpuser", node.get("UserName").asText());
				sendKeys(ListenersObject.amqppwd, "amqppwd", node.get("Password").asText());
				sendKeys(ListenersObject.amqpreqqueue, "amqpreqqueue", node.get("RequestQueue").asText());
				sleep(1500);
				if (node.get("Edit").asText().equalsIgnoreCase("yes")) {
					extentTest.info("The Listener is : " + listenerName,
							MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
					click(ListenersObject.amqpSaveBTN, "amqpSaveBTN");
					sleep(2000);
					extentTest.pass("The Listener is updated successfully",
							MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
					click(ListenersObject.alerListenerOK, "alerListenerOK");
				} else {
					System.err.println("no need edit : cancel required");
				}
				} else {
					extentTest.warning("Listerner :: Search :: not matched with name", 
							MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
               System.err.println("Listerner :: Search :: not matched with name");
				}
				
			}
			else
			{
				System.out.println("Listener : edit icon size is not matched");
			}
			
			backToFrame();
			waitUntilSpinnerDisappers();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
