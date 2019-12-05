package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class CandlesPage extends TestBase {

	
	//Define Page factory or Object repository
	@FindBy(xpath="//*[@id=\"resultSet\"]/div[5]/section/a/p/span/span")
	WebElement vanilaCandle;
	
	@FindBy(xpath="//div[@id='orderby_menu']")
	WebElement orderBy;
	
	@FindBy(xpath="//a[@data-orderby='rating']")
	WebElement starRating;
	
	public CandlesPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public AddToBag sortByStarRating() throws InterruptedException
	{
		Actions action= new Actions(driver);
		action.moveToElement(orderBy).perform();
		Thread.sleep(5000);
		starRating.click();
		Thread.sleep(5000);
		vanilaCandle.click();
		return new AddToBag();
		
		
	}
	
}
