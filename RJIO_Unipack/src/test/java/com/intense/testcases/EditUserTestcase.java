package com.intense.testcases;

import java.security.spec.ECParameterSpec;

import org.testng.annotations.Test;

import com.intense.accelator.ActionWrappers;
import com.intense.pages.EditUserPage;

public class EditUserTestcase extends ActionWrappers {

	EditUserPage eup = new EditUserPage();

	@Test
	public void editIcon() {
		try {
			eup.editIcon();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void editUserData() {
		try {
			eup.editUserData();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
