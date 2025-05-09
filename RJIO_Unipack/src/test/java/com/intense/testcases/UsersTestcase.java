package com.intense.testcases;

import org.testng.annotations.Test;

import com.intense.accelator.ActionWrappers;
import com.intense.pages.UsersPage;

public class UsersTestcase extends ActionWrappers{

	UsersPage up=new UsersPage();
	
	@Test
	public void users() {
		try {
			sleep(1500);
			up.userMove();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
