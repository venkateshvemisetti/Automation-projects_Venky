package com.rjio.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.fasterxml.jackson.databind.JsonNode;
import com.rjio.accelator.ActionWrappers;
import com.rjio.objects.AlertsActionsObject;

public class AlertsActionsPage extends ActionWrappers {

	public void alertActionLink() {
		try {
			sleep(1000);
			if (findElementts(AlertsActionsObject.alertActionLink).size() > 0) {
				if (findElementt(AlertsActionsObject.alertActionLink).isDisplayed()) {
					click(AlertsActionsObject.alertActionLink, "alertActionLink");
					waitUntilSpinnerDisappers();
					waitUntilSpinnerDisappers();
				} else {
					System.err.println("alertActionLink is not displayed");
				}
			} else {
				System.err.println("alertActionLink size is not matched");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createSMSAction(JsonNode node) {
		try {
			sleep(2000);
			driver.switchTo().frame("bodyframe");

			Select actions = new Select(findElementt(AlertsActionsObject.addActionDD));
			actions.selectByVisibleText("Sms");
			sleep(1500);
			sendKeys(AlertsActionsObject.name, "name", node.get("name").asText());
			sendKeys(AlertsActionsObject.description, "description", node.get("description").asText());
			sendKeys(AlertsActionsObject.source, "source", "2000EN");
			sleep(1500);
			click(AlertsActionsObject.account, "account");
			sleep(1000);
			click(AlertsActionsObject.accountList, "accountList");
			sleep(1000);
			click(AlertsActionsObject.flashMessage, "flashMessage");
			sleep(500);
			click(AlertsActionsObject.flashMessageList, "flashMessageList");
			sendKeys(AlertsActionsObject.to, "to", "@{source.mobile}");
			sendKeys(AlertsActionsObject.message, "message", "767767767message6");
			sleep(1500);
			extentTest.info("The AlertAction data is ",
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
			click(AlertsActionsObject.saveBTN, "saveBTN");
			sleep(1500);
			extentTest.info("The AlertAction is saved",
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
			click(AlertsActionsObject.alerActiontOK, "alerActiontOK");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createAction(String actionTypeName, JsonNode node) {
		try {
			sleep(2000);
			moveFrame("bodyframe");
			customWait(findElementt(AlertsActionsObject.addActionDD));
			;
			Select actions = new Select(findElementt(AlertsActionsObject.addActionDD));
			actions.selectByVisibleText(actionTypeName);
			sleep(1500);
			String name_csv = node.get("name").asText();
			extentTest.info("Name of " + actionTypeName.toUpperCase() + " action is : " + name_csv);
			sendKeys(AlertsActionsObject.name, "name", name_csv);
			String description_csv = node.get("description").asText();
			sendKeys(AlertsActionsObject.description, "description", description_csv);
			sendKeys(AlertsActionsObject.source, "source", node.get("source").asText());
			sleep(1500);
			click(AlertsActionsObject.account, "account");
			sleep(2000);
			List<WebElement> accountNames = findElementts(AlertsActionsObject.accountList);
			int accountnamei = 0;
			for (WebElement accountName : accountNames) {
				sleep(300);
				System.out.println("Account name is : " + accountName.getText());
				if (accountName.getText().equalsIgnoreCase(node.get("account").asText())) {
					accountNames.get(accountnamei).click();
					break;
				} else {
					System.err.println("checking for account names :: comparison");
					accountnamei++;
					continue;
				}
			}
			sleep(1000);
			// sendKeys(AlertsActionsObject.rule,"rule",node.get("rule").asText());
			if (actionTypeName.equalsIgnoreCase("sms")) {
				// sendKeys(AlertsActionsObject.priority, "priority",
				// node.get("priority").asText());
				click(AlertsActionsObject.unicode, "unicode");
				sleep(1000);
				List<WebElement> unicodes = findElementts(AlertsActionsObject.unicodeList);
				System.err.println("unicodes size " + unicodes.size());
				if (unicodes.size() > 0) {
					int unicodei = 0;
					for (WebElement unicode : unicodes) {
						System.out.println("unicodes are " + unicode.getText());
						if (unicodes.get(unicodei).getText().equalsIgnoreCase(node.get("unicode").asText())) {
							unicodes.get(unicodei).click();
							break;
						} else {
							System.err.println("checking for unicodes :: comparison");
						}
					}
				} else {
					System.err.println("unicodeList size not macthed");
				}
				sleep(1000);
				click(AlertsActionsObject.flashMessage, "flashMessage");
				sleep(1000);
				List<WebElement> flashMessages = findElementts(AlertsActionsObject.flashMessageList);
				int flashMessagei = 0;
				for (WebElement flashMessage : flashMessages) {
					System.out.println("flashMessage are " + flashMessages.get(flashMessagei).getText());
					sleep(300);
					System.out.println("flashMessage are " + flashMessage.getText());
					if (flashMessage.getText().equalsIgnoreCase(node.get("flashMessage").asText())) {
						flashMessages.get(flashMessagei).click();
						break;
					} else {
						System.err.println("checking for flashMessage names :: comparison");
					}
					flashMessagei++;
				}

			} else {
				System.err.println("priority : unicode : flashMessage :: skipped");
			}
			sendKeys(AlertsActionsObject.senderID, "senderID", node.get("senderID").asText());
			sendKeys(AlertsActionsObject.to, "to", node.get("to").asText());

			if (actionTypeName.equalsIgnoreCase("email")) {
				/*
				 * sendKeys(AlertsActionsObject.cc, "cc", node.get("cc").asText());
				 * sendKeys(AlertsActionsObject.bcc, "bcc", node.get("bcc").asText());
				 */
				sendKeys(AlertsActionsObject.subject, "subject", node.get("subject").asText());
				/*
				 * sendKeys(AlertsActionsObject.attachementFilePath,"attachementFilePath",node.
				 * get("attachementFilePath").asText());
				 */
				click(AlertsActionsObject.contentType, "contentType");
				List<WebElement> contentTypes = findElementts(AlertsActionsObject.contentTypeList);
				int contentTypei = 0;
				for (WebElement contentType : contentTypes) {
					if (contentType.getText().equalsIgnoreCase(node.get("contentType").asText())) {
						contentTypes.get(contentTypei).click();
						break;
					} else {
						System.err.println("checking for contentType :: comparison");
					}
					contentTypei++;
				}
				if (node.get("deleteAttachmentafteremailsent").asText().equalsIgnoreCase("yes")) {
					if (findElementts(AlertsActionsObject.deleteAttachmentafteremailsent).size() > 0) {
						if (!findElementt(AlertsActionsObject.deleteAttachmentafteremailsent).isSelected()) {
							click(AlertsActionsObject.deleteAttachmentafteremailsent, "deleteAttachmentafteremailsent");
						} else {
							System.err.println("deleteAttachmentafteremailsent already selected");
						}
					} else {
						System.err.println("deleteAttachmentafteremailsent size is not macthed");
					}
				} else {
					System.err.println("deleteAttachmentafteremailsent option is NO by user input file");
				}
			} else {
				System.err.println(
						"cc : bcc: subject : contenttype : attachementFilePath : deleteAttachmentafteremailsent :: skipped");
			}
			extentTest.info("The action " + actionTypeName.toUpperCase() + " data is ",
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
			if (actionTypeName.equalsIgnoreCase("sms")) {
				sendKeys(AlertsActionsObject.message, "message", node.get("message").asText());
			} else if (actionTypeName.equalsIgnoreCase("email")) {
				click(AlertsActionsObject.openEditor, "openEditor");
				sleep(1000);
				moveFrame("mailbody-iframeEl");
				sendKeys(AlertsActionsObject.messageEmail, "messageEmail", node.get("message").asText());
				extentTest.info("The Email body message is",
						MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
				backToFrame();
				moveFrame("bodyframe");
				click(AlertsActionsObject.saveEmailMessage, "saveEmailMessage");

			}
			{
				System.err.println("message :: not macthed ;;000");
			}

			sleep(1500);
			if (node.get("Save").asText().equalsIgnoreCase("yes")) {
				click(AlertsActionsObject.saveBTN, "saveBTN");
				sleep(1500);
				extentTest.pass("The action is saved sucessfully : " + name_csv,
						MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
				click(AlertsActionsObject.alerActiontOK, "alerActiontOK");
			} else {
				click(AlertsActionsObject.cancelBTN, "cancelBTN");
				System.out.println("clicked on cancal btn for action creation");
			}
			sleep(1000);
			backToFrame();
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			searchAction(name_csv);
			backToFrame();
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			sleep(1000);
			extentTest.info("The created action : " + name_csv,
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
			clear(AlertsActionsObject.searchfiled, "searchfiled");
			backToFrame();
			waitUntilSpinnerDisappers();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void editAction(JsonNode node) {
		try {
			waitUntilSpinnerDisappers();
			sleep(2000);
			moveFrame("bodyframe");
			String actionName = node.get("name").asText();
			searchAction(actionName);
			if (findElementts(AlertsActionsObject.searchResult).size() == 1) {
				String searchActionName = findElementt(AlertsActionsObject.searchActionName).getText();
				extentTest.info("The found action is : " + searchActionName);
				String actionTypeName = findElementt(AlertsActionsObject.searchActionType).getText();
				if (findElementts(AlertsActionsObject.editAction).size() == 1) {
					if (findElementt(AlertsActionsObject.editAction).getAttribute("title").contains("Edit")) {
						System.err.println(
								"ediititiititi " + findElementt(AlertsActionsObject.editAction).getAttribute("title"));
						extentTest.info(actionTypeName + " AlertAction name is : " + actionName,
								MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("arguments[0].click();", findElementt(AlertsActionsObject.editAction));
						// click(AlertsActionsObject.editAction, "editAction");
						sleep(1000);
						/*--------------------------------------------------------vvvs*/
						String description_csv = node.get("description").asText();
						sendKeys(AlertsActionsObject.description, "description", description_csv);
						sendKeys(AlertsActionsObject.source, "source", node.get("source").asText());
						sleep(1500);
						click(AlertsActionsObject.account, "account");
						sleep(3000);
						List<WebElement> accountNames = findElementts(AlertsActionsObject.accountList);

						boolean accCheckflag = false;
						if (accountNames.size() > 0) {
							System.err.println("account list size " + accountNames.size());
							accCheckflag = true;
						}
						if (!accCheckflag) {
							click(AlertsActionsObject.account, "account");
						}
						int accountnamei = 0;
						for (WebElement accountName : accountNames) {
							sleep(300);
							System.out.println(actionTypeName + " : " + "Account name is :: "
									+ accountName.getAttribute("innerText") + "csv from value : "
									+ node.get("account").asText());
							if (accountName.getAttribute("innerText").trim()
									.equalsIgnoreCase(node.get("account").asText())) {
								click(AlertsActionsObject.account, "account");
								JavascriptExecutor js1 = (JavascriptExecutor) driver;
								js1.executeScript("arguments[0].click();", accountNames.get(accountnamei));
								break;

							} else {
								System.err.println("checking for account names :: comparison"
										+ accountName.getAttribute("innerText"));
							}
							accountnamei++;
						}
						sleep(1000);
						// sendKeys(AlertsActionsObject.rule,"rule",node.get("rule").asText());
						if (actionTypeName.equalsIgnoreCase("sms")) {
							// sendKeys(AlertsActionsObject.priority, "priority",
							// node.get("priority").asText());
							click(AlertsActionsObject.unicode, "unicode");
							sleep(1000);
							List<WebElement> unicodes = findElementts(AlertsActionsObject.unicodeList);
							System.err.println("unicodes size " + unicodes.size());
							if (unicodes.size() > 0) {
								int unicodei = 0;
								for (WebElement unicode : unicodes) {
									System.out.println("unicodes are " + unicode.getText());
									if (unicodes.get(unicodei).getText()
											.equalsIgnoreCase(node.get("unicode").asText())) {
										unicodes.get(unicodei).click();
										break;
									} else {
										System.err.println("checking for unicodes :: comparison");
									}
									unicodei++;
								}
							} else {
								System.err.println("unicodeList size not macthed");
							}
							sleep(1000);
							click(AlertsActionsObject.flashMessage, "flashMessage");
							sleep(1000);
							List<WebElement> flashMessages = findElementts(AlertsActionsObject.flashMessageList);
							int flashMessagei = 0;
							for (WebElement flashMessage : flashMessages) {
								sleep(300);
								System.out.println("flashMessage are " + flashMessage.getText());
								if (flashMessage.getText().equalsIgnoreCase(node.get("flashMessage").asText())) {
									flashMessages.get(flashMessagei).click();
									break;
								} else {
									System.err.println("checking for flashMessage names :: comparison");
								}
								flashMessagei++;
							}

						} else {
							System.err.println("priority : unicode : flashMessage :: skipped");
						}
						sendKeys(AlertsActionsObject.senderID, "senderID", node.get("senderID").asText());
						sendKeys(AlertsActionsObject.to, "to", node.get("to").asText());

						if (actionTypeName.equalsIgnoreCase("email")) {
							/*
							 * sendKeys(AlertsActionsObject.cc, "cc", node.get("cc").asText());
							 * sendKeys(AlertsActionsObject.bcc, "bcc", node.get("bcc").asText());
							 */
							sendKeys(AlertsActionsObject.subject, "subject", node.get("subject").asText());
							/*
							 * sendKeys(AlertsActionsObject.attachementFilePath,"attachementFilePath",node.
							 * get("attachementFilePath").asText());
							 */
							click(AlertsActionsObject.contentType, "contentType");
							List<WebElement> contentTypes = findElementts(AlertsActionsObject.contentTypeList);
							int contentTypei = 0;
							for (WebElement contentType : contentTypes) {
								if (contentType.getText().equalsIgnoreCase(node.get("contentType").asText())) {
									contentTypes.get(contentTypei).click();
									break;
								} else {
									System.err.println("checking for contentType :: comparison");
								}
								contentTypei++;
							}
							if (node.get("deleteAttachmentafteremailsent").asText().equalsIgnoreCase("yes")) {
								if (findElementts(AlertsActionsObject.deleteAttachmentafteremailsent).size() > 0) {
									if (!findElementt(AlertsActionsObject.deleteAttachmentafteremailsent)
											.isSelected()) {
										click(AlertsActionsObject.deleteAttachmentafteremailsent,
												"deleteAttachmentafteremailsent");
									} else {
										System.err.println("deleteAttachmentafteremailsent already selected");
									}
								} else {
									System.err.println("deleteAttachmentafteremailsent size is not macthed");
								}
							} else {
								System.err.println("deleteAttachmentafteremailsent option is NO by user input file");
							}
						} else {
							System.err.println(
									"cc : bcc: subject : contenttype : attachementFilePath : deleteAttachmentafteremailsent :: skipped");
						}
						extentTest.info("The AlertAction of " + actionTypeName.toUpperCase() + " data is ",
								MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
						if (actionTypeName.equalsIgnoreCase("sms")) {
							sendKeys(AlertsActionsObject.message, "message", node.get("message").asText());
						} else if (actionTypeName.equalsIgnoreCase("email")) {
							click(AlertsActionsObject.openEditor, "openEditor");
							sleep(1000);
							moveFrame("mailbody-iframeEl");
							sendKeys(AlertsActionsObject.messageEmail, "messageEmail", node.get("message").asText());
							extentTest.info("The Email body message is",
									MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
							backToFrame();
							moveFrame("bodyframe");
							click(AlertsActionsObject.saveEmailMessage, "saveEmailMessage");

						}
						{
							System.err.println("message :: not macthed");
						}

						sleep(2000);
						if (node.get("Edit").asText().equalsIgnoreCase("yes")) {
							click(AlertsActionsObject.updateBTN, "updateBTN");
							sleep(2000);
							extentTest.info("The AlertAction is updated sucessfully : " + actionName,
									MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
							click(AlertsActionsObject.alerActiontOK, "alerActiontOK");
							sleep(2000);
						} else {
							click(AlertsActionsObject.cancelBTN, "cancelBTN");
							System.out.println("clicked on cancal btn for action creation");
						}

						/*--------------------vvsvsvs*/

					} else {
						System.err.println("edit text btn not there " + actionName);
						extentTest.info("edit text btn not there " + actionName);
					}
				} else {
					System.err.println("edit btn size not matched");
				}
			} else {
				System.err.println("searchResult :: no records found");
				extentTest.info("searchResult :: no records found " + actionName);

			}
			backToFrame();
			waitUntilSpinnerDisappers();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void searchAction(String name) {
		try {
			sleep(3000);
			sendKeys(AlertsActionsObject.searchfiled, "searchfiled", name);
			sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enableAction(JsonNode node) {
		try {
			sleep(2000);
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			String actionName = node.get("name").asText();
			searchAction(actionName);
			backToFrame();
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			sleep(2000);
			if (findElementts(AlertsActionsObject.searchResult).size() == 1) {
				if (findElementts(AlertsActionsObject.enableAction).size() == 1) {
					if (findElementt(AlertsActionsObject.enableAction).getAttribute("title").contains("Enable")) {
						extentTest.info("Before enabling the action : " + actionName,
								MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("arguments[0].click();", findElementt(AlertsActionsObject.enableAction));
						// click(AlertsActionsObject.enableAction, "enableAction");
						sleep(3000);
						backToFrame();
						waitUntilSpinnerDisappers();
						moveFrame("bodyframe");
						extentTest.info("The confirmation for enabling the action",
								MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
						click(AlertsActionsObject.yesBTN, "yesBTN");
						backToFrame();
						waitUntilSpinnerDisappers();
						moveFrame("bodyframe");
						searchAction(actionName);
						backToFrame();
						waitUntilSpinnerDisappers();
						moveFrame("bodyframe");
						if (findElementt(AlertsActionsObject.disableAction).getAttribute("title").contains("Disable")) {
							extentTest.pass("Post enabled action successfully : " + actionName,
									MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
						} else {
							extentTest.fail("The post enabling action",
									MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
						}
					} else {
						System.err.println("Already enabled " + actionName);
						extentTest.info("Already enabled " + actionName);
					}
				} else {
					System.err.println("enable btn size not matched");
				}
			} else {
				System.err.println("searchResult :: no records found");
				extentTest.info("searchResult :: no records found " + actionName);

			}
			clear(AlertsActionsObject.searchfiled, "searchfiled");
			backToFrame();
			waitUntilSpinnerDisappers();
		} catch (Exception e) {
			e.printStackTrace();
			extentTest.fail(e);

		}
	}

	public void disableAction(JsonNode node) {
		try {
			sleep(2000);
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			String actionName = node.get("name").asText();
			searchAction(actionName);
			backToFrame();
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			sleep(2000);
			if (findElementts(AlertsActionsObject.searchResult).size() == 1) {
				if (findElementts(AlertsActionsObject.disableAction).size() == 1) {
					if (findElementt(AlertsActionsObject.disableAction).getAttribute("title").contains("Disable")) {
						extentTest.info("Before disabling the action : " + actionName,
								MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
						// click(AlertsActionsObject.disableAction, "disableAction");
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("arguments[0].click();", findElementt(AlertsActionsObject.disableAction));
						sleep(3000);
						waitUntilSpinnerDisappers();
						extentTest.info("The confirmation for disabling the action",
								MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
						click(AlertsActionsObject.yesBTN, "yesBTN");
						backToFrame();
						waitUntilSpinnerDisappers();
						moveFrame("bodyframe");
						searchAction(actionName);
						backToFrame();
						waitUntilSpinnerDisappers();
						moveFrame("bodyframe");
						sleep(1000);
						if (findElementt(AlertsActionsObject.enableAction).getAttribute("title").contains("Enable")) {
							extentTest.pass("The post disabling action successfully : " + actionName,
									MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
						} else {
							extentTest.fail("The post disabled action",
									MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
						}
					} else {
						System.err.println("Already enabled " + actionName);
						extentTest.info("Already enabled " + actionName);
					}

				} else {
					System.err.println("disable btn size not matched");
				}
			} else {
				System.err.println("searchResult :: no records found " + actionName);
				extentTest.info("searchResult :: no records found " + actionName);

			}
			clear(AlertsActionsObject.searchfiled, "searchfiled");
			backToFrame();
			waitUntilSpinnerDisappers();

		} catch (Exception e) {
			e.printStackTrace();
			extentTest.fail(e);
		}
	}

	public void deleteAction(JsonNode node) {
		try {
			sleep(2000);
			waitUntilSpinnerDisappers();
			moveFrame("bodyframe");
			String actionName = node.get("name").asText();
			searchAction(actionName);
			waitUntilSpinnerDisappers();
			sleep(2000);
			if (findElementts(AlertsActionsObject.searchResult).size() == 1) {
				if (findElementts(AlertsActionsObject.deleteAction).size() == 1) {
					extentTest.info("Before deleting : " + actionName,
							MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
					// click(AlertsActionsObject.deleteAction, "deleteAction");
					/*
					 * JavascriptExecutor js=(JavascriptExecutor)driver;
					 * js.executeScript("arguments[0].click();",
					 * findElementt(AlertsActionsObject.deleteAction));
					 */
					clickUsingJSE(findElementt(AlertsActionsObject.deleteAction));
					sleep(2000);
					click(AlertsActionsObject.yesBTN, "yesBTN");
					backToFrame();
					waitUntilSpinnerDisappers();
					moveFrame("bodyframe");
					sleep(1000);
					searchAction(actionName);
					backToFrame();
					waitUntilSpinnerDisappers();
					moveFrame("bodyframe");
					sleep(1000);
					extentTest.pass("Post deleted the action successfully : " + actionName,
							MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
				} else {
					System.err.println("delete btn size not matched");
				}
			}

			else {
				System.err.println("searchResult :: no records found " + actionName);
				extentTest.info("searchResult :: no records found " + actionName);
			}

			clear(AlertsActionsObject.searchfiled, "searchfiled");
			backToFrame();
			waitUntilSpinnerDisappers();
		} catch (Exception e) {
			e.printStackTrace();
			extentTest.fail(e);
		}
	}
}
