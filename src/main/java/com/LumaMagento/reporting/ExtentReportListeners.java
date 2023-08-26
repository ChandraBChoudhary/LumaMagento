package com.LumaMagento.reporting;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.LumaMagento.config.ExtendReport;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.reactivex.rxjava3.internal.util.AtomicThrowable;



public class ExtentReportListeners implements ITestListener {

	ExtentReports extentReport;
	ExtentTest extentTest;
	WebDriver driver;
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println("Execution for project started");
		try {
			extentReport = ExtendReport.generateExtendReport();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}	
	
	@Override
	public void onTestStart(ITestResult result) {
		
		extentTest = extentReport.createTest(result.getName());
		extentTest.log(Status.INFO, result.getName()+"started execution");
		
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest = extentReport.createTest(result.getName());
		//Screen Shot 
		System.out.println(result.getName()+"screenshot taken");
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String destinationSreenshotPath = ExtendReport.takeScreenShotAndAddToExtentReport(driver, result.getName());
		extentTest.addScreenCaptureFromPath(destinationSreenshotPath);
		extentTest.log(Status.PASS, result.getName()+"Passed execution");

	}

	@Override
	public void onTestFailure(ITestResult result)  {
		extentTest = extentReport.createTest(result.getName());
		System.out.println(result.getName()+"screenshot taken");
			try {
				driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String destinationSreenshotPath = ExtendReport.takeScreenShotAndAddToExtentReport(driver, result.getName());
			extentTest.addScreenCaptureFromPath(destinationSreenshotPath);
			extentTest.log(Status.INFO,result.getThrowable());
			extentTest.log(Status.FAIL, result.getName()+"Failed execution");
	}
	

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP,result.getName()+"got skipped" );
		
	}

	

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
		String reportPath = System.getProperty("user.dir")+"\\test-output\\testResults\\report.html";
		File extentReport = new File(reportPath);
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}