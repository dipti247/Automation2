package script;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;

import java.net.URL;

import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

 
public class BrokenLinks1 {
	public static int brokenLinks;
	public static int validLinks;
	static {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		
	}
	
 public static void main(String[] args) throws Exception {

	 WebDriver driver=new ChromeDriver();
 //driver.manage().window().maximize();
 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 Workbook w = WorkbookFactory.create(new FileInputStream("./data/sheet1.xlsx"));
	int rc=w.getSheet("sheet1").getLastRowNum();
	for(int i=0;i<=rc;i++) {
		String url=w.getSheet("sheet1").getRow(i).getCell(0).getStringCellValue();
	driver.get(url);
	try {
	URL link = new URL(url);
	
	
	 validLinks = brokenLinks = 0;
	 HttpURLConnection httpConn =(HttpURLConnection)link.openConnection();

	 httpConn.setConnectTimeout(4000);

	 httpConn.connect();
	 
	 if(httpConn.getResponseCode()>= 200) { 
		 System.out.println(url+" - "+"--"+driver.getTitle()+"--"+httpConn.getResponseMessage());
		 ++validLinks;
	 
//	 if(httpConn.getResponseCode()== 404) {
//		 System.out.println(url+" - "+"--"+driver.getTitle()+"--"+httpConn.getResponseMessage());
//	 
//	 if(httpConn.getResponseCode()== 400) { 
//		 System.out.println(url+" - "+"--"+driver.getTitle()+"--"+httpConn.getResponseMessage());
//	 
//	 if(httpConn.getResponseCode()== 401) { 
//		 System.out.println(url+" - "+"--"+driver.getTitle()+"--"+httpConn.getResponseMessage());
//	 
//	 if(httpConn.getResponseCode()== 500) { 
//		 System.out.println(url+" - "+"--"+driver.getTitle()+"--"+httpConn.getResponseMessage());
//	 
//	 if(httpConn.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)  
//     {
//         System.out.println(url+" - "+httpConn.getResponseMessage() + " - "+driver.getTitle()+ HttpURLConnection.HTTP_NOT_FOUND);
//      }
//	 }
//	 }
//	 }
//	 }
	 }
	
			try {
				Workbook w2 = WorkbookFactory.create(new FileInputStream("./result/FinalResult.xlsx"));
				int cc=1000;
				for(int j=1;j<=cc;j++) {
					
					w2.getSheet("sheet1").getRow(j).getCell(1).setCellValue(url);
					w2.getSheet("sheet1").getRow(j).getCell(2).setCellValue(driver.getTitle());
					w2.getSheet("sheet1").getRow(j).getCell(3).setCellValue(httpConn.getResponseMessage());
					w2.write(new FileOutputStream("./result/FinalResult.xlsx"));
					j++;
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	
	
//	 else {
//		 System.out.println(url+" - "+driver.getTitle()+"  ERROR");
//		
//		 ++brokenLinks;
//	 }
	 
	 
	
	
	 catch (Exception e) {
		 
     }
//	try {
//		Workbook w2 = WorkbookFactory.create(new FileInputStream("./result/FinalResult.xlsx"));
//		int cc=1000;
//		for(int j=1;j<=cc;j++) {
//			
//			w2.getSheet("sheet1").getRow(j).getCell(1).setCellValue(url);
//			w2.getSheet("sheet1").getRow(j).getCell(2).setCellValue(driver.getTitle());
//			w2.getSheet("sheet1").getRow(j).getCell(3).setCellValue(httpConn.getResponseMessage());
//			w2.write(new FileOutputStream("./result/FinalResult.xlsx"));
//			j++;
//		}
//	}
//	catch(Exception e) {
//		e.printStackTrace();
	}
}
//	System.out.println("Total broken links found# " + brokenLinks);
//	System.out.println("Total valid links found#" + validLinks);
	
	
	 
	
	
	
	 
 }


	
 
	 

