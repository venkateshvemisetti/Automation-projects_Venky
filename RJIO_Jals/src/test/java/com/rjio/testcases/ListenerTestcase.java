package com.rjio.testcases;

import org.testng.annotations.Test;

import com.rjio.accelator.ActionWrappers;
import com.rjio.pages.ListenersPage;

public class ListenerTestcase extends ActionWrappers {
	
	ListenersPage lp=new ListenersPage();
	
	@Override
	protected boolean hasChildTest() throws Exception {
		return true;
	}
	@Override
	protected String getParentTestName() {
		return "Listeners";
	}
	
	/*---------------File-----*/
	
	@Test(priority = 1)
	public void createFileListener() {
		try {
			sleep(1000);
			lp.listenerLink();
			lp.createFileListener(getRowData(lp.getClass().getSimpleName(), 1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	@Test(priority = 2)
	public void editFileListener(){
		try {
			lp.editFileListener(getRowData(lp.getClass().getSimpleName(), 4));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test(priority = 3)
	public void startListener(){
		try {
			lp.startListener(getRowData(lp.getClass().getSimpleName(), 1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority =4)
	public void stopListener() {
		try {
			lp.stopListener(getRowData(lp.getClass().getSimpleName(), 1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 5)
	public void deleteListener() {
		try {
			lp.deleteListener(getRowData(lp.getClass().getSimpleName(), 1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/*---------------JMS-----*/
	
	@Test(priority = 1 , groups = {"AMQP"})
	
	public void createAMQPListener() {
		try {
			sleep(1000);
			lp.listenerLink();
			lp.createAMQPListener(getRowData(lp.getClass().getSimpleName(), 7));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test(priority = 2 , groups = {"AMQP"})
	public void editAMQPListener(){
		try {
			lp.editAMQPListener(getRowData(lp.getClass().getSimpleName(), 10));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 3 , groups = {"AMQP"})
	public void startAMQPListener(){
		try {
			lp.startListener(getRowData(lp.getClass().getSimpleName(), 7));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority =4 , groups = {"AMQP"})
	public void stopAMQPListener() {
		try {
			lp.stopListener(getRowData(lp.getClass().getSimpleName(), 7));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 5 , groups = {"AMQP"})
	public void deleteAMQPListener() {
		try {
			lp.deleteListener(getRowData(lp.getClass().getSimpleName(), 7));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
