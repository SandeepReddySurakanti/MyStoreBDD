package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver driver;
	
	
	@FindBy(xpath="//input[@id='email']")
	WebElement usernameBox;
	@FindBy(xpath="//input[@id='passwd']")
	WebElement passwordBox;
	
	@FindBy(id="SubmitLogin")
	WebElement submitButton;
	
	@FindBy(xpath = "//a[@title='Recover your forgotten password']")
	WebElement forgotPasswordLink;
	
	public LoginPage(WebDriver ldriver)
	{
		System.out.println("22222222 I am in loginpage constructor");
		driver=ldriver;
		PageFactory.initElements(ldriver, this);
	}
	
	public void enterUsername(String username)
	{
		usernameBox.sendKeys(username);
		
	}
	public void enterPassword(String pass)
	{
		passwordBox.sendKeys(pass);
	}
	public void clickSubmitButton()
	{
		submitButton.click();
	}
	public boolean isForgotPasswordLinkPresent()
	{
		return forgotPasswordLink.isDisplayed();
	}
	public String getTitle()
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver.getTitle();
		
	}

}
