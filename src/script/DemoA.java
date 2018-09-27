package script;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class DemoA {

	@Test
	public void testA() {
		Reporter.log("testA",true);
		Assert.fail();
	}
	
	@Test
	public void testB() {
		Reporter.log("testB",true);
	}
	
	@AfterMethod
	public void closeApp(ITestResult result) {
		String name=result.getName();
		int status = result.getStatus();
		Reporter.log(name+" Status:"+status,true);
		Reporter.log("closeApp",true);
	}
}

