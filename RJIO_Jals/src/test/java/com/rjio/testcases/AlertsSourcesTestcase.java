package com.rjio.testcases;

import org.testng.annotations.Test;

import com.rjio.accelator.ActionWrappers;
import com.rjio.pages.AlertsSourcesPage;

public class AlertsSourcesTestcase extends ActionWrappers {
	AlertsSourcesPage asp = new AlertsSourcesPage();
	@Override
	protected boolean hasChildTest() throws Exception {
		return true;
	}
	@Override
	protected String getParentTestName() {
		return "AlertsSources";
	}
	@Test
	public void creationsource() {
		try {
			asp.alertSourceLink();
			sleep(1000);
			asp.createSource(getRowData(asp.getClass().getSimpleName(), 1));
		} catch (Exception e) {

		}
	}

	@Test(priority = 2)
	public void editSource() {
		try {
//			/asp.alertSourceLink();
			asp.editSource(getRowData(asp.getClass().getSimpleName(), 4));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 3)
	public void startSource() {
		try {
			asp.startSource(getRowData(asp.getClass().getSimpleName(), 1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 4)
	public void stopSource() {
		try {
			asp.stopSource(getRowData(asp.getClass().getSimpleName(), 1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 5)
	public void deleteSource() {
		try {
			asp.deleteSource(getRowData(asp.getClass().getSimpleName(), 1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
