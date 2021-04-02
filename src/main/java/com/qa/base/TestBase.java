package com.qa.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;



public class TestBase {

	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	
	
	public TestBase(){
	
		try {
			prop= new Properties();
			FileInputStream ip=new FileInputStream("/Users/Mrinal Bhardwaj/eclipse-workspace/POM/src/main/java/com/qa/config/config.properties");
		    prop.load(ip);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
}
	
	public void intialization() {
		
	String browser=prop.getProperty("browser");
	
	
	
	    
  	
	if(browser.equals("chrome")) {
	System.setProperty("webdriver.chrome.driver", "/Users/Mrinal Bhardwaj/eclipse-workspace/POM/driver/driver/chromedriver.exe");
	
	driver= new ChromeDriver();
	}
	
	e_driver= new EventFiringWebDriver(driver);
    WebDriverlistener eventlistener = new WebDriverlistener();
    e_driver.register(eventlistener);
     driver=e_driver;
	  
	    
	    driver.manage().deleteAllCookies();
	    driver.manage().window().maximize();
	    
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	    
	    driver.get(prop.getProperty("url"));
	
	
	}

	public void popup() {
		 
		//Create a instance of ChromeOptions class
		ChromeOptions options = new ChromeOptions();

		//Add chrome switch to disable notification - "**--disable-notifications**"
		options.addArguments("--disable-notifications");

		
		//Pass ChromeOptions instance to ChromeDriver Constructor
		driver =new ChromeDriver(options);
	 }
  

}