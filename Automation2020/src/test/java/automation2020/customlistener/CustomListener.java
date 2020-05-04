package automation2020.customlistener;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

import Utility.TestUtility;
import luxeregister.baseclassluxe;

public class CustomListener extends baseclassluxe implements ITestListener{
	
	

@Override
public void onTestFailure(ITestResult result) {
// TODO Auto-generated method stub
ITestListener.super.onTestFailure(result);

		
		try {
			
			
			
			log.debug("Taking Screenshot");
			baseclassluxe.captureSnapShot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			test.log(LogStatus.FAIL, result.getName().toUpperCase()+ " Failed with Exception : "+result.getThrowable()  );
			test.log(LogStatus.FAIL, test.addScreenCapture(TestUtility.ScreenshotPath));
			rep.endTest(test);
			rep.flush();
		}
		
	}
	
	
}
