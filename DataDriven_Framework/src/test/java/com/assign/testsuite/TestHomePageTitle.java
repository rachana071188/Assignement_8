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
import com.assign.ele.Homepage;
import com.assign.utility.Actions;
import com.assign.utility.Fileinfo;
import com.aventstack.extentreports.ExtentTest;

public class TestHomePageTitle extends Parent {
	public Homepage hm;
	public Fileinfo fg;
	public Actions ac;
	private static Logger logger = LogManager.getLogger();

	@BeforeMethod
	public void init() throws IOException {
		intialization();
	}

	@Test
	public void test1() throws IOException, EncryptedDocumentException, InterruptedException {
		open();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		hm = new Homepage(driver);
		ac = new Actions();
		ExtentTest test = ac.report("homePagetitle");
		hm.titlePage();
		test.pass("The Title of the Homepage is Printed in the console");
		logger.info("the Home page title is printing");
		ac.takeScreenshot("C://Users//Admin//Desktop//screenshots//homepagetitle.png");

	}

	@AfterMethod
	public void at1() {

		driver.close();
	}

}
