package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Define Page factory or Object Repository for Login Page
	
	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement login;
	
	@FindBy(xpath="/html/body/div[2]/div/div[1]/a/img")
	WebElement logo;
	
	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement SignUp;
	
	//Initialize the Page factory by using PageFactory.InitElements method
	//Create the constructor
	
	//initElements- It means initialize elements with driver
	
	//this -it means initialize variables/webelements of current class
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions to be performed
	public String validateLoginPageTitle()
	{
		String title=driver.getTitle();
		return title;
	}
	
	public boolean validateCRMImage()
	{
		boolean flag =logo.isDisplayed();
		return flag;
	}
	
	public HomePage login(String un, String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		login.click();
		return new HomePage();
	}
	
	
	
}
