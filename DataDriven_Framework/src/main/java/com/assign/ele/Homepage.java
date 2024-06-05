package com.assign.ele;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.assign.base.Parent;


public class Homepage extends Parent {
	
	public Homepage(WebDriver driver) {
		Parent.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void titlePage() {
		driver.manage().window().maximize();
		String title=driver.getTitle();
		System.out.println("The title of the Home page is"+title);
	
	}
	
	
}
