package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;




public abstract class BaseTest {
	public WebDriver driver;
	
	
	static {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		
	}
	@BeforeMethod(alwaysRun=true)
	public void openApp() {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

	}
	@AfterMethod(alwaysRun=true)
	public void closeApp() {
	
		driver.quit();
	}
}





