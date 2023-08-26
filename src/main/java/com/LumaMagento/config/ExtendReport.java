package com.LumaMagento.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendReport {
	static ExtentReports extentReport;
	static ExtentTest extentTest;

	public static ExtentReports generateExtendReport() throws IOException{
		Date date =new Date();
		//String timestamp = date.toString().replace(" ","").replace(":","");
		ExtentReports extentReports = new ExtentReports();
		File extentReportFile = new File(System.getProperty("user.dir")+ "\\test-output\\testResults\\report.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		sparkReporter.config().setTheme(Theme.STANDARD);

		sparkReporter.config().setReportName("LUMA Magento Test Execution Report");
		sparkReporter.config().setDocumentTitle("LUMA Magento Test Result");
		//sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
			
			extentReports.attachReporter(sparkReporter);
			
			Properties configProp = new Properties();
			File congigPropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\LumaMagento\\TestData\\testData.properties");
			FileInputStream fiscongigProp = new FileInputStream(congigPropFile);
			configProp.load(fiscongigProp);
			
			
			extentReports.setSystemInfo("Application URL",configProp.getProperty("app"));
			extentReports.setSystemInfo("Browser NAme", configProp.getProperty("browser"));
			extentReports.setSystemInfo("Email", configProp.getProperty("emailAddress"));
			extentReports.setSystemInfo("password", configProp.getProperty("password"));
			extentReports.setSystemInfo("OS", System.getProperty("os.name"));
			extentReports.setSystemInfo("User name", System.getProperty("user.name"));
			extentReports.setSystemInfo("Java version", System.getProperty("java.version"));
			
			return extentReports;
	}
	
	public static String takeScreenShotAndAddToExtentReport(WebDriver driver, String testName) {
		File srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationSreenshotPath = System.getProperty("user.dir")+"\\Test Result Screeshots\\"+testName+".png";
		try {
			FileHandler.copy(srcScreenshot,new File(destinationSreenshotPath));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return destinationSreenshotPath;
		
	}
	}


