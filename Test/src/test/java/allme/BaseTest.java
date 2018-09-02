package allme;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import constants.Constants;


public class BaseTest {

	public WebDriver driver;
		
	@BeforeMethod
	public void setup(){
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gevor\\Downloads\\chromedriver_win32\\chromedriver.exe");
		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("disable-infobars");
		 driver = new ChromeDriver(options);
		 driver.manage().window().maximize();
		 driver.get(Constants.URL);
	}
	
	@AfterMethod
	public void cleanUp(){
		driver.quit();

}
	
	}
