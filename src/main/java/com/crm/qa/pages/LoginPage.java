package com.crm.qa.pages;

import java.util.Iterator;
import java.util.Set;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Define Page factory or Object Repository for Login Page
	
	//@FindBy(linkText="Sign In")
	@FindBy(xpath="//*[@id=\"accountLinks\"]/li[1]/a")
	WebElement SignIn;
	
	
	@FindBy(xpath="//*[@id=\"mv_user\"]")
	WebElement email;
	
	@FindBy(xpath="//input[@id='mvpassword']")
	WebElement password;
	
	@FindBy(xpath="//button[contains(text(),'Login')]")
	WebElement login;
	
	@FindBy(xpath="//img[@alt='Discount Fragrances, Perfume & Cologne at FragranceNet.com']")
	WebElement logo;

	@FindBy(xpath="//a[contains(text(),'Help')]")
	WebElement link;
	
	
	
	//Initialize the Page factory by using PageFactory.InitElements method
	//Create the constructor
	
	//initElements- It means initialize elements with driver
	
	//this -it means initialize variables/webelements of current class
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions to be performed
	
	//Method to return the Login Page title
	public String validateLoginPageTitle()
	{
		String title=driver.getTitle();
		return title;
	}
	
	
	//Method to validate the presence of Help link
	public String validateHelpLink()
	{
		String help=link.getText();
		return help;
	}
	
	// Method to check Fragnance logo on Login page
	
	public boolean validateFragnanceLogo()
	{
		boolean flag =logo.isDisplayed();
		return flag;
	}
	
	
	//Method to login to Fragnance.net and land to home page
	public HomePage login(String un, String pwd)
	{
		
		SignIn.click();
		
		        
		Set<String> winhandle= driver.getWindowHandles();
		
		
		Iterator<String> it = winhandle.iterator();
		while(it.hasNext())
		{
			String str = (String)it.next();
			driver.switchTo().window(str);
			
		}
		email.sendKeys(un);
		password.sendKeys(pwd);
		login.click();
		return new HomePage();
	}
	
	
	
}
