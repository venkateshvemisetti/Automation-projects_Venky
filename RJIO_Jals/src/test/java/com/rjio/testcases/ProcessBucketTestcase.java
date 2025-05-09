package com.rjio.testcases;

import org.testng.annotations.Test;

import com.rjio.accelator.ActionWrappers;
import com.rjio.pages.ProcessBucketPage;

public class ProcessBucketTestcase extends ActionWrappers {
	ProcessBucketPage pbp=new ProcessBucketPage();

	@Override
	protected boolean hasChildTest() throws Exception {
		return true;
	}
	@Override
	protected String getParentTestName() {
		return "ProcessBuckets";
	}
	
	
	@Test(priority = 1)
	public void createProcessBucket() {
		try {
			pbp.processBucketLink();
			sleep(1000);
			pbp.createProcessBucket(getRowData(pbp.getClass().getSimpleName(), 1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 2)
	public void editProcessBucket() {
		try {
			pbp.editProcessBucket(getRowData(pbp.getClass().getSimpleName(), 4));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test(priority = 3)
	public void startProcessBucket(){
		try {
			pbp.startProcessBucket(getRowData(pbp.getClass().getSimpleName(), 1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority =4)
	public void stopProcessBucket() {
		try {
			pbp.stopProcessBucket(getRowData(pbp.getClass().getSimpleName(), 1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
