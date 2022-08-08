package stepDefinations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.Factory.DriverFactory;
import com.Utilities.ConfigUtil;
import com.pageObjects.HomePage;
import com.pageObjects.Indexpage;
import com.pageObjects.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;


public class LoginPageSteps 
{
	Indexpage indexpage;
	LoginPage loginPage;
	String loginpagetitle;
	String homePageTitle;
	HomePage homePage;
	WebDriver driver;	
	
	@Before
	public void init()
	{
		String browsername=ConfigUtil.getbrowser();
		DriverFactory driverFactory=new DriverFactory();
	    driver=driverFactory.init_Driver(browsername);
		System.out.println("heloooooooo "+ConfigUtil.getbrowser()+"  "+ConfigUtil.getBaseUrl()+" "+ConfigUtil.getUsername());
	}
	@After
	public void tearDown()
	{
		System.out.println("After heloooooooo "+ConfigUtil.getbrowser()+"  "+ConfigUtil.getBaseUrl());
		driver.quit();
		
	}
	
	
	
	@Given("user opens browser")
	public void user_opens_browser() 
	{
		
	   
	}

	@When("user enters url as {string}")
	public void user_enters_url_as(String urlString) 
	{
		driver.get(urlString);
	  
	}

	@Then("user clicks signIn link")
	public void user_clicks_sign_in_link() 
	{
		indexpage=new Indexpage(driver);
		indexpage.clickOnSignIn();
		loginPage=new LoginPage(driver);
	  
	}

	@Given("User gets title of page")
	public void user_gets_title_of_page() 
	{
		
		loginpagetitle=loginPage.getTitle();
		System.out.println("Login page title is :"+loginpagetitle);
		
		
	  
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) 
	{
		Assert.assertEquals(loginpagetitle,title );
	   
	}

	@Given("forgot password should be present")
	public void forgot_password_should_be_present() 
	{
		boolean flag= loginPage.isForgotPasswordLinkPresent();
		Assert.assertTrue(flag);
	   
	}

	@Given("enter login detials")
	public void enter_login_detials()
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loginPage.enterUsername(ConfigUtil.getUsername());
		loginPage.enterPassword(ConfigUtil.getPassword());
	   
	}

	@Given("user clicks login button")
	public void user_clicks_login_button() 
	{
		loginPage.clickSubmitButton();
	  
	}

	@Given("user lands on home page and gets title of page")
	public void user_lands_on_home_page_and_gets_title_of_page()
	{
		homePage=new HomePage(driver);
		homePageTitle=homePage.getTitle();
	   
	}

	@Given("title of the page should be {string}")
	public void title_of_the_page_should_be(String titlestring) 
	{
		Assert.assertEquals(homePageTitle,titlestring);
	}

}
