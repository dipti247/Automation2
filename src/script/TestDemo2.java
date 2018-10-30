package script;

import java.io.FileInputStream;

import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestDemo2 {

	
		static {
			System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
			
		}

		public static void main(String[] args) throws Exception {
			WebDriver driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			Workbook w = WorkbookFactory.create(new FileInputStream("./data/sheet1.xlsx"));
			int rc=w.getSheet("sheet1").getLastRowNum();
			for(int i=0;i<=rc;i++) {
				String url=w.getSheet("sheet1").getRow(i).getCell(0).getStringCellValue();
				//System.out.println(url);
				driver.get(url);
				String title=driver.getTitle();
				System.out.println(title);
				
				
			}
			
			//driver.close();
}
}

