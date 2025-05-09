package com.geidea.pages;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.fasterxml.jackson.databind.JsonNode;
import com.geidea.accelator.ActionWrappers;

public class OpenBrowserPage extends ActionWrappers {

	public void setBrowser() {
		try {
			setBrowserType();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void openURL(JsonNode node) {
		try {
			openAppURL(node.get("appURL").asText());
			
			extentTest.info("GEIdea Application is",
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
