package com.qa.pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//div[@class=\"bcvklqu9 nzypyw8j\"]//span[contain(text(),'Welcome to Facebook, Sourav']")
	WebElement welcomemsg;
	
	
	@FindBy(xpath="//span[contains(text(),'COVID-19 Information Centre')]")
	WebElement covid;
	

	
	
	public HomePage() {
		
		PageFactory.initElements(driver,this);
	}

	public String title() {
		return driver.getTitle();
	}
	
	public Boolean welcome() {
		Boolean b= welcomemsg.isDisplayed();
		return b;
		
	}
  public CovidInformation covidnews() {
	  
	  covid.click();
	  return new CovidInformation();
	  
  }
  




}
