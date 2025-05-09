package com.intense.testcases;

import org.testng.annotations.Test;

import com.intense.als.ALS_NEService;

public class ALS_TestCase {

	ALS_NEService als = new ALS_NEService();

	@Test
	public void alsNE() {
		try {
			als.writeReqXML();
			Thread.sleep(1000);
			als.sendRequestTOservice();
			Thread.sleep(1000);
			als.readResXML();
			Thread.sleep(1000);
			als.transMasterValidate();
			Thread.sleep(1000);
			als.transInfoValidate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
