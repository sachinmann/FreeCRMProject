package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	
  public LoginPageTest() {
		
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginpage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String pagetitle= loginpage.validateLoginPageTitle();
		Assert.assertEquals(pagetitle, "Perfume, Cologne & Discount Perfume");
	}
	
	@Test(priority=2)
	public void helpLinkTest()
	{
		String str= loginpage.validateHelpLink();
		Assert.assertEquals(str, "HELP");
	}
	
	@Test(priority=3)
	public void fragnanceLogoTest()
	{
		boolean flag =loginpage.validateFragnanceLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=4)
	public void loginTest()
	{
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println("Passed");
	}
	
	
	
	@AfterMethod()
	public void tearDown()
	{
		driver.quit(); 
	}
	
}
