package com.rjio.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.rjio.accelator.ActionWrappers;
import com.rjio.pages.AlertsActionsPage;

public class AlertsActionsTestcase extends ActionWrappers {
	AlertsActionsPage aap = new AlertsActionsPage();

	@Override
	protected boolean hasChildTest() throws Exception {
		return true;
	}

	@Override
	protected String getParentTestName() {
		return "AlertsActions";
	}

	public void alertActionLink() {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 1)
	@Parameters({ "actiontypeSms" })
	public void createSMSAction(String actiontype) {
		try {
			sleep(1500);
			aap.alertActionLink();
			sleep(1000);
			// aap.createSMSAction();
			aap.createAction(actiontype, getRowData(aap.getClass().getSimpleName(), 1));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 2)
	public void editSMSAction() {
		try {
			sleep(1500);
			//aap.alertActionLink();
			sleep(1000);
			aap.editAction(getRowData(aap.getClass().getSimpleName(), 4));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 3)
	public void enableSMSAction() {
		try {
			// aap.alertActionLink();
			aap.enableAction(getRowData(aap.getClass().getSimpleName(), 1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 4)
	public void disableSMSAction() {
		try {
			// aap.alertActionLink();
			aap.disableAction(getRowData(aap.getClass().getSimpleName(), 1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 5)
	public void deleteSMSAction() {
		try {
			aap.deleteAction(getRowData(aap.getClass().getSimpleName(), 1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 6)
	@Parameters({ "actiontypeEmail" })
	public void createEmailAction(String actiontype) {
		try {
			sleep(1500);
			//aap.alertActionLink();
			sleep(1000);
			aap.createAction(actiontype, getRowData(aap.getClass().getSimpleName(), 7));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 7)
	public void editEmailAction() {
		try {
			sleep(1500);
			aap.editAction(getRowData(aap.getClass().getSimpleName(), 10));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 8)
	public void enableEmailAction() {
		try {
			// aap.alertActionLink();
			aap.enableAction(getRowData(aap.getClass().getSimpleName(), 7));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 9)
	public void disableEmailAction() {
		try {
			// aap.alertActionLink();
			aap.disableAction(getRowData(aap.getClass().getSimpleName(), 7));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 10)
	public void deleteEmailAction() {
		try {
			aap.deleteAction(getRowData(aap.getClass().getSimpleName(), 7));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
