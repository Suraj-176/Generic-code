package generics;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SuperTest {

	public WebDriver driver;
	
	@Parameters("browsername")
	@BeforeClass
	public void selectBrowser(String browsername)
	{
		if(browsername.equals("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			//WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}
		else if(browsername.equals("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else
		{
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(PropertyFile.getPropertyValue("appurl"));
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
	
	@AfterMethod
	public void getTestMethodExecutionStatus(ITestResult result)
	{
		int status = result.getStatus();
		String methodname = result.getName();
		if(status==1)
		{
			Reporter.log(result.getName()+"Execution passed",true);
		}
		else if(status==2)
		{
			Reporter.log(result.getName()+"Execution Failed",true);
			Screenshot.takeScreenshot(driver, methodname);
		}
		else
		{
			Reporter.log(result.getName()+"Execution Skipped",true);
		}
	}
}
