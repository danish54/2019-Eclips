package auto2020.customlistener;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import Utility.TestUtility;
import luxeregister.baseclassluxe;



public class CustomListener extends baseclassluxe implements ITestListener {

	
	@Override
	public void onStart(ITestContext context) {
		/*
		 * test=
		 * rep.createTest("Multiple Login Test with DataProvider and ITestListener");
		 * rep.flush();
		 */
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		String methodname = result.getMethod().getMethodName().toUpperCase();
		test.log(Status.PASS, methodname +"Passed" );
		rep.flush();
	}

	@Override
	public void onTestFailure(ITestResult result) {

		log.debug("Taking Screenshot");
		try {
			TestUtility.capturescreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String methodname = result.getMethod().getMethodName().toUpperCase();
		test.log(Status.FAIL, methodname + " Failed with Exception : " + result.getThrowable());
		try {
			test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath(TestUtility.ScreenshotPath).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		rep.flush();

	}

}
