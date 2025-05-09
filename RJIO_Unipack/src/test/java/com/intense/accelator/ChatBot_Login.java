package com.intense.accelator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChatBot_Login {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D://Automation_Projects//Jars//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("https://botapi.intense.in:8444/IncPortal/welcome#");
			driver.manage().window().maximize();
			WebElement loginLink = driver.findElement(By.linkText("Login"));
			loginLink.click();
			String originalWindow = driver.getWindowHandle();
			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(originalWindow)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}
			WebElement emailInput = driver.findElement(By.id("email"));
			emailInput.sendKeys("lisscp.in10s2@gmail.com");
			WebElement passwordInput = driver.findElement(By.id("password"));
			passwordInput.sendKeys("Intense@123");
			WebElement loginButton = driver.findElement(By.linkText("Login"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", loginButton);
			loginButton.click();
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}