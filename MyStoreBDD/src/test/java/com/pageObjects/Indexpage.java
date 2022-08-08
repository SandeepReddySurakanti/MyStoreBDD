package com.pageObjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.dockerjava.api.command.PullImageCmd;

public class Indexpage 
{
	@FindBy(xpath="//a[@class='login']")
	WebElement signIn;
	WebDriver rdriver;
	
	public Indexpage(WebDriver ldriver)
	{
		rdriver=ldriver;
		PageFactory.initElements(rdriver, this);
		
	}
	public void clickOnSignIn()
	{
		signIn.click();
		
	}
	
		
	

}
