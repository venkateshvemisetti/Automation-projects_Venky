package com.rjio.testcases;

import org.testng.annotations.Test;

import com.rjio.accelator.ActionWrappers;
import com.rjio.pages.AlertsQueuesPage;

public class AlertsQueuesTestcase extends ActionWrappers {
	
	AlertsQueuesPage aqp=new AlertsQueuesPage();
	@Override
	protected boolean hasChildTest() throws Exception {
		return true;
	}
	@Override
	protected String getParentTestName() {
		return "AlertsQueues";
	}
	
	@Test(priority = 1)
	public void createQueue() {
	try {
		aqp.alertQueueLink();
		sleep(1000);
		aqp.createQueue(getRowData(aqp.getClass().getSimpleName(), 1));
	} catch (Exception e) {
		e.printStackTrace();
	}	
	}
	
	@Test(priority = 2)
	public void editQueue() {
		try {
			aqp.editQueue(getRowData(aqp.getClass().getSimpleName(), 4));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 3)
	public void deleteQueue() {
		try {
			aqp.deleteQueue(getRowData(aqp.getClass().getSimpleName(), 1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	}


