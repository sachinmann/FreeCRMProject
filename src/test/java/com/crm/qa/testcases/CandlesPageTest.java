package com.crm.qa.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AddToBag;
import com.crm.qa.pages.CandlesPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class CandlesPageTest extends TestBase {

	
	LoginPage loginpage;
	HomePage homepage;
	CandlesPage candlepage;
	AddToBag addbag;
	
	public CandlesPageTest() 
	 {
		super();
	 }
	
	@BeforeTest
	public void setUp() throws InterruptedException
	{
		initialization();
		loginpage = new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(5000);
		candlepage=homepage.validateCandlesClick();
		
	}
	
	@Test
	public void sortByStarRatingTest() throws InterruptedException
	{
		addbag=candlepage.sortByStarRating();
		System.out.println("Passed-Navigated to add to bag page");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
