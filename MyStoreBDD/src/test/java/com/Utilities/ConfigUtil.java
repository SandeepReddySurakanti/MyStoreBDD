package com.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtil 
{
	static String browser;
	static String baseURL;
	static String usernameString;
	static String password;
	static Properties prop;
	
	static {
		System.out.println("I am in static block");
		prop=new Properties();
		try {
			FileInputStream inputStream=new FileInputStream("./src/test/resources/configFiles/config.properties");
			prop.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	 
	public static String getbrowser() 
	{
		browser=prop.getProperty("browser");
		
		return  browser;
		
	}
	
	public static String getUsername() 
	{
		return  prop.getProperty("username");
		
	}
	public static String getPassword() 
	{
		return  prop.getProperty("password");
		
	}
	public static String getBaseUrl()
	{
		return  prop.getProperty("baseurl");
		
	}



}
