package com.geidea.accelator;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ActionWrappers {
	ReadProperties rp = new ReadProperties();
	public static WebDriver driver = null;
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	public static ExtentTest extentParentTest;

	public void setBrowserType() {
		try {
			String cdriverpath = rp.readPro("ChromeDriverPath");
			System.out.println("start of method :: setBrowserType()");
			System.setProperty("webdriver.chrome.driver", cdriverpath);
			driver = new ChromeDriver();
			System.out.println(driver);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
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
			List<WebElement> element = findElementts(path);
			if (element.size() > 0) {
				if (element.get(0).isDisplayed() && element.get(0).isEnabled()) {
					element.get(0).click();
					System.out.println("click action on :: " + lablename);
				} else {
					System.out.println(lablename + " is not dispalyed/Enabled");
				}
			} else {
				System.out.println(lablename + " size is not matched");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void clickUsingJSE(WebElement eleJS) {
		try {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", eleJS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sendKeys(By path, String lablename, String value) {
		try {
			List<WebElement> sendkeys = findElementts(path);
			if (sendkeys.size() > 0) {
				clear(path, lablename);
				// findElementt(path).sendKeys(value);
				sendkeys.get(0).sendKeys(value);
				System.out.println("sendkeys action on :: " + lablename + " value :: " + value);
			} else {
				System.out.println("sendKeys :: findElementts size is not matched");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clear(By path, String lablename) {
		try {
			List<WebElement> clr = findElementts(path);
			if (clr.size() > 0) {
				clr.get(0).clear();
				// clr.get(0).getAttribute("value").equalsIgnoreCase("") ||
				// clr.get(0).getAttribute("value").equalsIgnoreCase(" ");
			} else {
				System.out.println("clear :: findElementts size is not matched");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public WebElement findElementt(By path) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
			WebElement wb;
			wb = driver.findElement(path);
			// return wb;

			if (wb != null) {
				return wb;
			} else {
				System.out.println(path + " : findelement is null");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return null;

	}

	public void customWait(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void customWait(List<WebElement> element) {
		try {
			System.out.println("custom wait calling:::: ");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
			wait.until(ExpectedConditions.visibilityOfAllElements(element));
			System.out.println("custom wait ended:::: ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<WebElement> findElementts(By path) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
			List<WebElement> wb;
			wb = driver.findElements(path);
			if (wb.size() > 0) {
				return wb;
			} else {
				System.out.println(path + " findelements size is not matched");
			}

			// return wb;

		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return null;

	}

	public void sleep(long sec) {
		try {
			Thread.sleep(sec);
			System.err.println("paused : " + sec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void moveFrame(String frameName) {
		try {
			System.out.println("change frame :: moveFrame() " + frameName);
			driver.switchTo().frame(frameName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void backToFrame() {
		try {
			System.out.println(" :: back to change frame :: backToFrame()");
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@BeforeSuite
	public void extentReportStart() {
		try {
			Date date = new Date();
			// String path = "D:\\\\Automation-Projects\\\\UnipackReports\\\\";
			String reportpath = rp.readPro("ReportsPath");
			File file = new File(reportpath + date.getDate());
			file.mkdir();
			String reportfilename = rp.readPro("Reportfilename");

			// ExtentHtmlReporter htmlReporter = new
			// ExtentHtmlReporter("E:\\AutomationProjects\\Reports\\unipack.html");
			int ranNum = ThreadLocalRandom.current().nextInt();

			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
					reportpath + date.getDate() + "//" + reportfilename + "_" + ranNum + ".html");
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

	/*-----------getClassName(lip.getClass().getName()),1)---*/
	public String getClassName(String name) {
		String classname = name.substring(name.lastIndexOf(".") + 1);
		return classname;

	}

	public JsonNode getRowData(String pageName, int rowNum) throws Exception {
		String csvFile = ".//GeIdea-Test_Data-Files//" + pageName + ".csv";
		String line = "";
		String cvsSplitBy = "\\|";
		int i = rowNum - 1;
		ArrayNode fields = null;
		File file = new File(csvFile);
		if (!file.exists()) {
			if (csvFile.contains("_")) {
				String[] arrayStrings = csvFile.split("-");
				if (arrayStrings.length > 1) {
					csvFile = ".//GeIdea-Test_Data-Files//" + pageName + "_" + arrayStrings[1] + ".csv";
				} else {
					System.err.println("arrayStrings size is not matched");
				}
			}
		}
		System.out.println("CSV file : " + csvFile);
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			int currentLine = 0;

			while (currentLine < rowNum - 1 && (line = br.readLine()) != null) {
				currentLine++;
			}
			if (currentLine == rowNum - 1) {
				while ((line = br.readLine()) != null) {
					String[] headers = line.split(cvsSplitBy);
					if (i == rowNum - 1) {
						fields = JSONUtils.createArrayNode();
						for (String head : headers) {
							fields.add(head.trim());
						}
						System.out.println("fields == " + fields);
						i++;
						continue;
					}
					if (i == rowNum) {
						ObjectNode rowData = JSONUtils.createObjectNode();
						int j = 0;
						for (String head : headers) {
							rowData.put(fields.get(j).asText(), head);
							j++;
						}
						System.out.println("rowData == " + rowData);
						return rowData;
					}
					i++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@BeforeMethod
	public void extentTest(Method m) {
		try {
			Test annonation = m.getAnnotation(Test.class);
			String description = annonation.description();
			if (!hasChildTest()) {
				extentTest = extent.createTest(m.getName());
			} else {
				extentTest = extentParentTest.createNode(m.getName(), description);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected boolean hasChildTest() throws Exception {
		return false;
	}

	protected String getParentTestName() {
		return this.getClass().getName();

	}

	@BeforeClass
	public void beforeClass() {
		try {
			if (hasChildTest()) {
				extentParentTest = extent.createTest(getParentTestName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Parameters({ "ZIPRequired" })
	@AfterTest
	public void extentReportEnd(String ZIPReq) {
		try {
			extent.flush();
			if (ZIPReq.equals("true")) {
				CreateExtentReportsZIP cezip = new CreateExtentReportsZIP();
				cezip.createExtentReportZip();
			}
			// driver.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String takeScreenShot() {
		try {
			Date date = new Date();
			File file = new File(rp.readPro("ScreeShotsPath") + date.getDate());
			file.mkdir();
			String filename = rp.readPro("ScreeShotsPath") + date.getDate() + "//" + System.currentTimeMillis()
					+ ".png";

			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File(filename));
			return filename;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	

	
	
	

	public void selectRequiredRadioBtnOrCheckBox(By labelKey, By radioBtnsKey, String inputData) {
		try {
			List<WebElement> labelKeyList = findElementts(labelKey);
			if (labelKeyList.size() > 0) {
				int count = 0;
				for (WebElement eachLabel : labelKeyList) {
					//mouseOverToElement(eachLabel);
					if (eachLabel.isDisplayed() || eachLabel.isEnabled()) {
						if (eachLabel.getText().trim().equalsIgnoreCase(inputData)) {
							List<WebElement> radioBtnsList = findElementts(radioBtnsKey);
							if (radioBtnsList.size() > 0) {
								if (radioBtnsList.get(count).isDisplayed() || radioBtnsList.get(count).isEnabled()) {
									// radioBtnsList.get(count).click();
									// javascriptClick(radioBtnsList.get(count));
									if(!radioBtnsList.get(count).isSelected()) {
									clickUsingJSE(radioBtnsList.get(count));
									extentTest.info("Required radio button/check box <b>" + inputData + "</b> is selected",
											MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
									break;
									}
									else
									{
										extentTest.warning(
												"Required radio button/check box is selected by default");
										extentTest.info(takeScreenShot());
									}
								}
							} else {
								extentTest.error("Radio buttons/check boxes are not loaded in page");
								extentTest.info(takeScreenShot());
							}
						}
					}
					count++;
				}
			} else {
				extentTest.error("Radio button/check boxe labels are not loaded in page");
				extentTest.info(takeScreenShot());
			}
		} catch (Exception e) {
			extentTest.error(e);
		}
	}

}
