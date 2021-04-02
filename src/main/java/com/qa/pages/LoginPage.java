package com.qa.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase{

	
	@FindBy(xpath="//div[@class=\"_6lux\"]//input[@placeholder=\"Email address or phone number\"]")
	WebElement email;
	
	@FindBy(xpath="//div[@class=\"_6lux\"]//input[@placeholder=\"Password\"]")
	WebElement password;
	
	@FindBy(xpath="//div[@class=\"_6ltg\"]//button[@name=\"login\"]")
	WebElement loginbtn;
	
	@FindBy(xpath="//img[@class=\"fb_logo _8ilh img\"]")
	WebElement image;
	
	@FindBy(xpath="//div[@class=\"_6ltj\"]//a[contains(text(),'Forgotten password?']")
     WebElement forgot;
	
    public LoginPage() {
    	PageFactory.initElements(driver,this);
	}
    
    public String validateTitle() {
    	return driver.getTitle();
    }
    
    public Boolean validateImage() {
		
    	return image.isDisplayed();
    	
    	
    }
    
    public HomePage login(String em, String pass) {
    	
    	email.sendKeys(em);
    	password.sendKeys(pass);
    	loginbtn.click();
		return new HomePage();
    }
}
