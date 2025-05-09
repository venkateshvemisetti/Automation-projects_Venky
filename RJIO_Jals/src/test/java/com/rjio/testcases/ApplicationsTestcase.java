package com.rjio.testcases;

import org.testng.annotations.Test;

import com.rjio.accelator.ActionWrappers;
import com.rjio.pages.ApplicationsPage;

public class ApplicationsTestcase extends ActionWrappers {
	ApplicationsPage ap = new ApplicationsPage();

	@Override
	protected boolean hasChildTest() throws Exception {
		return true;
	}

	@Override
	protected String getParentTestName() {
		return "Applications";
	}

	@Test(priority = 1)
	public void createApplication() {
		try {
			ap.alertApplicationLink();
			sleep(1000);
			ap.createApplication(getRowData(ap.getClass().getSimpleName(), 1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 2)
	public void editApplication() {
		try {
			ap.editApplication(getRowData(ap.getClass().getSimpleName(), 4));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 3)
	public void deleteApplication() {
		try {
			ap.deleteApplication(getRowData(ap.getClass().getSimpleName(), 1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
