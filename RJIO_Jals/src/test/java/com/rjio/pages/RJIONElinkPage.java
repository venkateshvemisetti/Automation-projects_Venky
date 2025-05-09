package com.rjio.pages;

import com.rjio.accelator.ActionWrappers;
import com.rjio.objects.RJIONElinkObject;

public class RJIONElinkPage extends ActionWrappers {

	public void RJIO_NELink() {
		try {

			if (findElementts(RJIONElinkObject.RJIONElink).size() > 0) {
				if (findElementt(RJIONElinkObject.RJIONElink).isDisplayed()) {
					click(RJIONElinkObject.RJIONElink, "RJIONElink");
				} else {
					System.err.println("RJIONElink is not displayed");
				}
			} else {
				System.err.println("RJIONElink size is not matched");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
