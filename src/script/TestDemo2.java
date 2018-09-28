package script;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Utility;

public class TestDemo2 extends BaseTest{
 @Test
 public void test2() {
	String data = Utility.getXLData(INPUT_PATH, "sheet1",0,0);
	Reporter.log("Data:"+data,true);
	 
	int r = Utility.getXLRowCount(INPUT_PATH, "sheet1");
	Reporter.log("Row:"+r,true);
	
	Assert.fail();	
 }
}




