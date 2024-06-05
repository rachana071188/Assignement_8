package com.assign.utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.assign.base.Parent;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Actions extends Parent{
	static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;

	
	public void takeScreenshot(String locfileName) {
	       try {
	           File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	           FileUtils.copyFile(screenshotFile, new File(locfileName));
	       } catch (Exception e) {
	           e.printStackTrace(); // For logging other exceptions
	       }
	   }
	
	
	public ExtentTest report(String testname) {
		if(extent==null) {
		htmlReporter = new ExtentHtmlReporter("extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		}
		ExtentTest test;
		test=extent.createTest(testname);
		return test;

	}
	//The report method is called with the parameter "homePagetitle".
	//If the extent object is null, it initializes ExtentReports and sets up the HTML reporter.
	//An ExtentTest object for the test case "homePagetitle" is created and returned.
	//In the test1 method, the returned ExtentTest object is used to log the steps
	// and results of the test, such as passing the step where the homepage title is printed.
}
