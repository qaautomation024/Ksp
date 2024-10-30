package com.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KidsPage {
	private WebDriver driver;
	
	@FindBy(xpath = "(//*[contains(text(),'Kids')])[1]")
	private WebElement Kids;
	
	
	public KidsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public WebDriver getDriver() {
		return driver;
	}


	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}


	public WebElement getKids() {
		return Kids;
	}


	public void setKids(WebElement kids) {
		Kids = kids;
	}
	
}
