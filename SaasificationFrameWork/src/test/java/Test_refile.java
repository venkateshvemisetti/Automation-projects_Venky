import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Test_refile {

    private ExtentReports extent;
    private ExtentTest test;

    @BeforeSuite
    public void setUp() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("D:\\TC's\\testsampleextent.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @Test
    public void test1() {
        test = extent.createTest("Test Case 1", "Sample test case");
        test.log(Status.INFO, "Starting test case");
        // Your test steps here
        test.log(Status.PASS, "Test case is passed");
    }

    @Test
    public void test2() {
        test = extent.createTest("Test Case 2", "Sample test case");
        test.log(Status.INFO, "Starting test case");
        // Your test steps here
        test.log(Status.FAIL, "Test case is failed");
    }

    @AfterSuite
    public void tearDown() {
        extent.flush();
    }
}
