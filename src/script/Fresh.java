package script;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Fresh {
	static {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		
	}

	public static void main(String[] args)throws Exception  {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Workbook w = WorkbookFactory.create(new FileInputStream("./data/sheet1.xlsx"));
		int rc=w.getSheet("sheet1").getLastRowNum();
		for(int i=0;i<=rc;i++) {
			String url=w.getSheet("sheet1").getRow(i).getCell(0).getStringCellValue();
			driver.get(url);
			String title=null;
					title=driver.getTitle();
			try {
				URL link = new URL(url);
				
				 HttpURLConnection httpConn =(HttpURLConnection)link.openConnection();

				 httpConn.setConnectTimeout(4000);

				 httpConn.connect();
				 if(httpConn.getResponseCode()>= 200) { 
					 System.out.println(url+" - "+"--"+driver.getTitle()+"--"+httpConn.getResponseMessage());
					 
					 
					 Workbook w2=null;
				 w2 = WorkbookFactory.create(new FileInputStream("./result/FinalResult.xlsx"));
				 
				 
					
					for(int j=0;j<1000;j++) {

							w2.getSheet("sheet1").getRow(j).getCell(1).setCellValue(url);
							w2.getSheet("sheet1").getRow(j).getCell(2).setCellValue(title);
							w2.getSheet("sheet1").getRow(j).getCell(3).setCellValue(httpConn.getResponseMessage());
							w2.write(new FileOutputStream("./result/FinalResult.xlsx"));	
						
					}
				
			}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		



	}

}
