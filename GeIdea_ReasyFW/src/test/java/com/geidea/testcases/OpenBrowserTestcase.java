package com.geidea.testcases;

import org.testng.annotations.Test;

import com.geidea.accelator.ActionWrappers;
import com.geidea.pages.OpenBrowserPage;

public class OpenBrowserTestcase extends ActionWrappers {
	OpenBrowserPage obp = new OpenBrowserPage();

	@Test
	public void openApplication() {
		try {
			obp.setBrowser();
			obp.openURL(getRowData("LoginPage", 1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
