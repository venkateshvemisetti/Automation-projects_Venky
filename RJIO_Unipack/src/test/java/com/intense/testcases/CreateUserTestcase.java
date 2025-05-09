package com.intense.testcases;



import org.testng.annotations.Test;

import com.intense.accelator.ActionWrappers;
import com.intense.pages.CreateUserPage;

public class CreateUserTestcase extends ActionWrappers {

	CreateUserPage cup = new CreateUserPage();

	@Test
	public void createUserOption() {
		try {
			sleep(1000);
			cup.createUserOption();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void frameMove() {
		try {
			cup.frameMove();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void createNewUserData() {
		try {
			cup.createNewUserData();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void saveCreateUsrDataOptions() {
		try {
			cup.saveCreateUsrDataOptions();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
