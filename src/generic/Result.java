package generic;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Result implements ITestListener,IAutoConst{
	public static int passCount=0,failCount=0;
	public void onTestSuccess(ITestResult result) {
		passCount++;
	}
	public void onTestFailure(ITestResult result) {
		failCount++;
	}
	public void onFinish(ITestContext context) {
		Utility.writeResultToXL(SUMMARY_PATH,"sheet1", passCount, failCount);
	}

	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}


}
