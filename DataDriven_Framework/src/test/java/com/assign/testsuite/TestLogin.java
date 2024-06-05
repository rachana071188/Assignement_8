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
import com.assign.ele.LoginPage;
import com.assign.utility.Actions;
import com.assign.utility.Fileinfo;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class TestLogin extends Parent {

	public Fileinfo fg;
	public static LoginPage cs;
	public Actions act;
	private static Logger logger = LogManager.getLogger();

	@BeforeMethod
	public void init() throws IOException {
		intialization();
	}

	@Test
	public void test3() throws IOException, EncryptedDocumentException, InterruptedException {
		open();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		cs = new LoginPage(driver);
		fg = new Fileinfo();
		act = new Actions();
		ExtentTest test = act.report("LoginChecking");
		test.pass("clicking the login button");
		logger.info("click the login button");
		test.pass("switching to the new window");
		logger.info("switch to the new window");
		test.pass("enter Invalid Username and Password");
		logger.info("enter the Invalid Username and Password");
		test.pass("clicking the login button");
		logger.info("click the login button to checking the login in credentials");
		cs.loginCredentials(fg.datau("login_credentials", 1, 0), fg.datau("login_credentials", 1, 1));
		test.pass("switching to the alert window");
		logger.info("switch to alert window");
		test.pass("Capture the text present in alert window and printing in the console");
		logger.info("Capture the text present in alert window and printing in the console");
		act.takeScreenshot("C://Users//Admin//Desktop//screenshots//login2.png");
		act.extent.flush();
	}

	@AfterMethod
	public void at3() {
		driver.close();
	}
}
