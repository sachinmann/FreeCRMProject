package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//*[@id=\"accountLinks\"]/li[1]/span[1]/span")
	WebElement name;
	
	@FindBy(xpath="//*[@id=\"nav\"]/div[1]/ul[1]/li[4]/a")
	WebElement Skincare;
	
	@FindBy(xpath="//*[@id=\"homepagePromos\"]/div[1]/h2")
	WebElement bestsellers;
	
	@FindBy(xpath="//*[@id=\"nav\"]/div[1]/ul[1]/li[6]/a")
	WebElement hairCare;
	
	@FindBy(xpath="//*[@id=\"nav\"]/div[1]/ul[1]/li[8]/a/span[2]")
	WebElement candles;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String validateWelcomeName()
	{
		String s1=name.getText();
		return s1;
	}
	
	public SkinCare clickOnSkincare() throws InterruptedException
	{
		Thread.sleep(5000);
		Skincare.click();
		return new SkinCare();
	}
	
	public String validateHaircareLink()
	{
		String str=hairCare.getText();
		return str;
	}
	
	public String validateBestSellerText()
	{
		return bestsellers.getText();
		
	}
	
	public CandlesPage validateCandlesClick() throws InterruptedException
	{
		Thread.sleep(5000);
		candles.click();
		return new CandlesPage();
	}
	
	
	

}
