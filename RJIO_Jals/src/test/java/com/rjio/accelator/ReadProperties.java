package com.rjio.accelator;

import java.util.*;

import org.testng.annotations.Test;

import java.io.*;

public class ReadProperties {

	public String readPro(String keyname) {

		try {
			FileReader fr = new FileReader("Configurations.properties");
			Properties p = new Properties();
			p.load(fr);
			return p.getProperty(keyname);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;

	}
	@Test
	public void m1() {
		System.err.println(readPro("ExcelPath1"));
	}
}
