
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Active_mqData {

	@Test
	public void sendInput() {
		WebDriver driver = null;
		System.setProperty("webdriver.chrome.driver", "D://Automation_Projects//Jars//chromedriver.exe");
		driver = new ChromeDriver();
		String custom_url = "http://intense:\r\n" + "intense\r\n" + "@172.16.0.227:8161/admin/queues.jsp";
		//  http://intense:intense@172.16.0.227:8161/admin/queues.jsp
		driver.get(custom_url);
		driver.manage().window().maximize();

	}
}
