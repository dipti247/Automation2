package script;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo2 {
	static {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		
	}

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://mediaspace.honeywell.com/media/Aero+Risk+Management+Database/1_t93plcy3/78083811");
		String title=driver.getTitle();
		Thread.sleep(1000);
		System.out.println(title);
		

	}

}
