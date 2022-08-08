package com.Factory;

import org.apache.hc.core5.http.message.StatusLine.StatusClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory 
{
	public  WebDriver driver;
	public static ThreadLocal<WebDriver> threadLocal=new ThreadLocal<WebDriver>();
	public WebDriver  init_Driver(String browser)
	{
		System.out.println("In init method of driverfactory");
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeDriver dr=new ChromeDriver();
			threadLocal.set(dr);
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			
			threadLocal.set(new FirefoxDriver());
		}	
		
		driver=threadLocal.get();
		driver.manage().window().maximize();
		return driver;
		
	}
	public static  WebDriver getDriver()
	{
		
		 return threadLocal.get();
		
	}
}
