package com.geidea.pages;



import java.util.List;

import org.openqa.selenium.WebElement;

import com.geidea.accelator.ActionWrappers;
import com.geidea.objects.AdminObject;

public class AdminPage extends ActionWrappers{
	
	public void ApplicationClick() {
		try {
			sleep(2000);
			List<WebElement> applink=findElementts(AdminObject.applicationLink);
			System.out.println(":::::: "+applink.get(0).getText() +" 0000QAA :  "+applink.size());
			if (applink.size()>0) {
				System.out.println("juhgghggg");
				if (applink.get(0).isDisplayed()) {
					applink.get(0).click();
					sleep(2000);
				} else {
                 System.out.println("applicationLink is not displayed");
				}
			} else {
             System.out.println("applicationLink size is not matched");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
