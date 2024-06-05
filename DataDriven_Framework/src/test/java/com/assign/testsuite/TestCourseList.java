package com.assign.testsuite;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.assign.base.Parent;
import com.assign.ele.Courselists;
import com.assign.utility.Actions;
import com.assign.utility.Fileinfo;
import com.aventstack.extentreports.ExtentTest;

public class TestCourseList extends Parent {
	public Fileinfo fg;
	public static Courselists cs;
	public Actions acr;
	private static Logger logger = LogManager.getLogger();

	@BeforeMethod
	public void init() throws IOException {
		intialization();
	}

	@Test
	public void test2() throws IOException, EncryptedDocumentException, InterruptedException {
		open();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		cs = new Courselists(driver);
		fg = new Fileinfo();
		acr = new Actions();
		ExtentTest test = acr.report("BA Courses List");
		cs.selectlist();
		test.pass("The DropDown of all courses is displayed");
		logger.info("the BA Courses list is displayed");
		cs.listofsubitems();
		test.pass("The List of BA Courses are printing in the console");
		logger.info("the BA Courses list is displayed in the console");
		acr.takeScreenshot("C://Users//Admin//Desktop//screenshots//courselist.png");
	}

	@AfterMethod
	public void at2() {
		driver.close();
	}

}
