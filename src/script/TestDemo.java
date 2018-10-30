package script;

import java.io.FileInputStream;

import java.io.FileOutputStream;



import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.testng.annotations.Test;

import generic.BaseTest;


public class TestDemo extends BaseTest{
	@Test
	public void testA() throws Exception {
		Workbook w = WorkbookFactory.create(new FileInputStream("./data/Resource Connections_AEP 6.0.xlsx"));
		int rc=w.getSheet("sheet1").getLastRowNum();
		for(int i=0;i<=rc;i++) {
			int cc=w.getSheet("sheet1").getRow(i).getLastCellNum();
			for(int j=0;j<cc;j++) {
			 String url1=w.getSheet("sheet1").getRow(i).getCell(j).getStringCellValue();
			 driver.get(url1);
			 String title=driver.getTitle();
			 Workbook w1 = WorkbookFactory.create(new FileInputStream("./result/Result.xlsx"));
				w1.getSheet("sheet1").getRow(1).getCell(0).setCellValue(title);
				w1.write(new FileOutputStream("./result/Result.xlsx"));
			 
				
			}
		
			
		}
	}
}




