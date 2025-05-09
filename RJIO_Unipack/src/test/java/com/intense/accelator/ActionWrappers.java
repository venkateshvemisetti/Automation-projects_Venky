package com.intense.accelator;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ActionWrappers {
	ReadProperties re=new ReadProperties();
	public static WebDriver driver = null;
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	

	@SuppressWarnings("deprecation")
	public void setBrowserType() {
		try {
			String cdriverpath=re.readPro("ChromeDriverPath");
			System.out.println("start of method :: setBrowserType()");
			System.setProperty("webdriver.chrome.driver", cdriverpath);
			driver = new ChromeDriver();
			System.out.println(driver);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("End of method :: setBrowserType()");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void openAppURL(String baseurl) {
		try {

			System.out.println("calling of method :: openAppURL() :: " + baseurl);
			driver.get(baseurl);
			driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void click(By path, String lablename) {
		try {
			// findElementts(path).size();
			driver.findElement(path).click();
			System.out.println("click action on :: " + lablename);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void sendKeys(By path, String lablename, String value) {
		try {

			// driver.findElement(path).sendKeys(value);
			findElementt(path).sendKeys(value);
			System.out.println("sendkeys action on :: " + lablename + " value :: " + value);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void clear(By path, String lablename) {
		try {
			findElementt(path).clear();
			System.out.println("clear action on ::" + lablename);
		} catch (Exception e) {
			e.printStackTrace();
		}

		catch (Throwable t) {
			t.printStackTrace();

		}

	}

	public WebElement findElementt(By path) {
		WebElement wb;
		wb = driver.findElement(path);
		return wb;

	}

	public List<WebElement> findElementts(By path) {
		List<WebElement> wb;
		wb = driver.findElements(path);
		return wb;

	}

	public void sleep(long sec) {
		try {
			Thread.sleep(sec);
			System.err.println("paused : " + sec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@BeforeSuite
	public void extentReportStart() {
		try {
			Date date = new Date();
			//String path = "D:\\\\Automation-Projects\\\\UnipackReports\\\\";
			String reportpath=re.readPro("ReportsPath");
			File file = new File(reportpath + date.getDate());
			file.mkdir();
			
			// ExtentHtmlReporter htmlReporter = new
			// ExtentHtmlReporter("E:\\AutomationProjects\\Reports\\unipack.html");
			int ranNum = ThreadLocalRandom.current().nextInt();
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
					reportpath + date.getDate() + "//unipack_" + ranNum + ".html");
			htmlReporter.setAppendExisting(false);
			/*
			 * Random random = new Random(); random.nextLong();
			 */
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@BeforeMethod
	public void extentTest(Method m) {
		try {
			extentTest = extent.createTest(m.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@AfterSuite
	public void extentReportEnd() {
		try {
			extent.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String takeScreenShot() {
		try {
			String filename = re.readPro("ScreeShotsPath") + System.currentTimeMillis()
					+ ".png";
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File(filename));
			return filename;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
