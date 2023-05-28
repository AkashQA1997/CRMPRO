package Extendreport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendReporter {
	
	@Test
	public static void test1() throws IOException {
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("TestIndex.html");
		extent.attachReporter(spark);
		
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("MMT Test");
		spark.config().setReportName("Akash Test");
		
		
		ExtentTest test = extent.createTest("CRM_TEST");
		test.pass("Cheking Logs");
		test.log(Status.PASS, MarkupHelper.createLabel("Test passed", ExtentColor.GREEN));
		ExtentTest test1 = extent.createTest("CRM_TEST1");
		test.log(Status.FAIL, MarkupHelper.createLabel("Test failed", ExtentColor.RED));
		test1.fail("Checking Second log");
		
		
		
		extent.flush();
		Desktop.getDesktop().browse(new File ("TestIndex.html").toURI());
	}
	
	

}
