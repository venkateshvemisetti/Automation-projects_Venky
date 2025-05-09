package com.geidea.pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.fasterxml.jackson.databind.JsonNode;
import com.geidea.accelator.ActionWrappers;
import com.geidea.objects.AppRegistrationObject;

public class AppRegistrationPage extends ActionWrappers {
	
	public void createNewRegistrationLink() {
		try {
			sleep(2000);
			List<WebElement> createNewReg=findElementts(AppRegistrationObject.createNewApp);
			if (createNewReg.size()>0) {
				if (createNewReg.get(0).isEnabled()) {
					createNewReg.get(0).click();
					sleep(2000);
				} else {
                     extentTest.fail("createNewRegistrationLink is not enabled");
				}
			} else {
				 extentTest.fail("createNewRegistrationLink size is not matched");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void registartion(JsonNode node) {
		try {
			sleep(2000);
			sendKeys(AppRegistrationObject.firstname,"firstname",node.get("firstname").asText());
			sendKeys(AppRegistrationObject.lastname,"lastname",node.get("lastname").asText());
			sendKeys(AppRegistrationObject.email,"email",node.get("email").asText());
			sendKeys(AppRegistrationObject.mobilenum,"mobilenum",node.get("mobilenum").asText());
			sendKeys(AppRegistrationObject.businesslandlineNum,"businesslandlineNum",node.get("businesslandlineNum").asText());
			sendKeys(AppRegistrationObject.businessname,"businessname",node.get("businessname").asText());
			sendKeys(AppRegistrationObject.jobrole,"jobrole",node.get("jobrole").asText());
			sendKeys(AppRegistrationObject.address,"address",node.get("address").asText());
			//selectValFromSelectCumTextBox(AppRegistrationObject.natureofbusiness,AppRegistrationObject.searchbox,node.get("natureofbusiness").asText());
			sleep(2000);
			//selectValFromSelectCumTextBox(AppRegistrationObject.emirate,AppRegistrationObject.searchbox,node.get("emirate").asText());
			sleep(2000);
			//selectValFromSelectCumTextBox(AppRegistrationObject.city,AppRegistrationObject.searchbox,node.get("city").asText());
			sleep(2000);
			sendKeys(AppRegistrationObject.pobox,"pobox",node.get("pobox").asText());
			click(AppRegistrationObject.nextBTN, "nextBTN");
			sleep(2000);
			sendKeys(AppRegistrationObject.password, "password",node.get("password").asText());
			sendKeys(AppRegistrationObject.confirmpwd, "confirmpwd",node.get("confirmpwd").asText());
			clickUsingJSE(findElementt(AppRegistrationObject.termANDcon));
			selectRequiredRadioBtnOrCheckBox(AppRegistrationObject.sizeofbusinesslabel,AppRegistrationObject.sizeofbusinessBTN,node.get("sizeofbusiness").asText());
			sleep(2000);
			click(AppRegistrationObject.nextBTN_pwd, "nextBTN_pwd");
			sleep(2000);
			
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
