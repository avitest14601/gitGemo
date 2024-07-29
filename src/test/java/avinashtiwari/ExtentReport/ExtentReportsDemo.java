package avinashtiwari.ExtentReport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportsDemo {
	ExtentReports extent;
	@BeforeTest
	public void config() {
		String path = System.getProperty("user.dir") + "\\report\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Report");
		reporter.config().setDocumentTitle("Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Avinash Tiwari");
	}
	
	@Test
	public void initialDemo() {
		ExtentTest test = extent.createTest("Intial Demo");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/");
		System.out.print(driver.getTitle());
		driver.close();
		
		test.fail("Result don't match");
		extent.flush();
	}
}
