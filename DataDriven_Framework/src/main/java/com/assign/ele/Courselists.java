package com.assign.ele;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.assign.base.Parent;

public class Courselists extends Parent {
	public Courselists(WebDriver driver) {
		Parent.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@id='dropdownMenuButton']")
	private WebElement dropdown;
	@FindBy(xpath = "//ul[@class='BA']/div/div/div/li")
	private List<WebElement> subitems;

	public void selectlist() {

		Actions ac = new Actions(driver);
		ac.moveToElement(dropdown).build().perform();
	}

	public void listofsubitems() {
		System.out.println("The BA Courses List is:");
		List<WebElement> lsf = subitems;
		for (WebElement sg : lsf) {
			 String sa = sg.getText().trim();
			if (sa.isEmpty()) {
				break;
			}
			System.out.println(sa);			
		}

	}
	

}
