package Utility;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	public static ExtentReports extent;
	
	public static ExtentHtmlReporter htmlrepoter;

	public static ExtentReports getInstance() {

		if (extent == null) {

			htmlrepoter = new ExtentHtmlReporter("./extentreport/ExtenthtmlReprt.html");
			htmlrepoter.config().setEncoding("utf-8");
			htmlrepoter.config().setDocumentTitle("LOginPOI");
			htmlrepoter.config().setReportName("LoginPOI");
			htmlrepoter.config().setTheme(Theme.STANDARD);

			extent = new ExtentReports();
			 extent.attachReporter(htmlrepoter);

			extent.setSystemInfo("Automation", "Danish");

		}

		return extent;

	}

}
