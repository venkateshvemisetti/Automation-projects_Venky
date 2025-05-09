package com.intense.testcases;

import org.testng.annotations.Test;

import com.intense.accelator.ActionWrappers;
import com.intense.pages.SearchUserPage;

public class SearchUserTestcase extends ActionWrappers {
	
	SearchUserPage sup=new SearchUserPage();
	
	@Test
	public void serachUser() {
		try {
			sup.searchUSR();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
