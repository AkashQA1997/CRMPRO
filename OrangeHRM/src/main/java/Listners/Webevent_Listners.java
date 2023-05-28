package Listners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Driver_Class.DriverClass;

public class Webevent_Listners extends DriverClass implements ITestListener{
	private ExtentReports extent;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		 test = extent.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		//test.pass(result.getMethod().getMethodName() + "Test Pass");
		test.log(Status.PASS, MarkupHelper.createLabel("Test failed", ExtentColor.GREEN));
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		test.fail("Checking Second log");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		test.skip("Checking Second log");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
		 extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("TestIndex.html");
		extent.attachReporter(spark);
		
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("MMT Test");
		spark.config().setReportName("Akash Test");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onFinish(context);
		
		extent.flush();
		/*
		 * try { Desktop.getDesktop().browse(new File ("TestIndex.html").toURI()); }
		 * catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
	}

	

	


	
	
}
