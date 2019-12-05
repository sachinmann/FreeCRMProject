package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CandlesPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.SkinCare;

public class HomePageTest extends TestBase{

      LoginPage loginpage;
	  HomePage homepage;
	  SkinCare skincare;
	  CandlesPage candlepage;
	  
		public HomePageTest() 
		 {
			
			super();
			
		 }
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginpage = new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void validateWelcomeNameTest()
	{
		String str=homepage.validateWelcomeName();
		Assert.assertEquals(str, "SACHIN,");
	}
	
	@Test(priority=2)
	public void validateclickOnSkincare() throws InterruptedException
	{
		skincare=homepage.clickOnSkincare();
		System.out.println("Click on Skincare-Passed");
	}
	
	@Test(priority=3)
	public void validateBestSellerTextTest()
	{
		String s =homepage.validateBestSellerText();
		Assert.assertEquals(s, "BEST SELLERS");
	}
	
	@Test(priority=4)
	public void validateHaircareLinkTest() 
	{
		String s=homepage.validateHaircareLink();
		Assert.assertEquals(s, "HAIRCARE");
	}
	
	
	@Test(priority=5)
	public void validateCandlesClickTest() throws InterruptedException
	{
		candlepage=homepage.validateCandlesClick();
	}
	
	@AfterMethod()
	public void tearDown()
	{
		driver.quit(); 
	}
}
