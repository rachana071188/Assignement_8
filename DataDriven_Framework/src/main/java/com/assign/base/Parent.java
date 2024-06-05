package com.assign.base;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.assign.utility.Fileinfo;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Parent {
	protected Parent() {
		
	}
	public static WebDriver driver;
	public static final Fileinfo fi = new Fileinfo();

	public static void intialization() throws IOException {
			String ses="browser";
		if (fi.fileData(ses).equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		} else if (fi.fileData(ses).equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (fi.fileData(ses).equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("No Browser is Opening");
		}

	}

	public static void open() throws IOException {
		driver.get(fi.fileData("url"));
	}

}
