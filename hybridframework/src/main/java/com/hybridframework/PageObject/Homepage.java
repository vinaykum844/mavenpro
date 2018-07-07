package com.hybridframework.PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hybridframework.helper.Logger.LoggerHelper;
import com.hybridframework.helper.Wait.WaitHelper;
import com.hybridframework.testbase.Config;
import com.hybridframework.testbase.TestBase;

public class Homepage {

	WebDriver driver;
	private final Logger log=LoggerHelper.getLogger(Homepage.class);
	WaitHelper waitHelper;
		String Tshirts="T-Shirts";
	String Blouses="Blouses";
	String CasualDress="Casual Dresses";
	
	@FindBy(xpath="//*[@id='block_top_menu']/ul/li[1]/a")
	public WebElement womenMenu;
	
	@FindBy(xpath="//*[@id='block_top_menu']/ul/li[2]/a")
	public WebElement dressesMenu;
	
	@FindBy(xpath="//*[@id='block_top_menu']/ul/li[3]/a")
	public WebElement tShirtsMenu;
	
	
	public Homepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		waitHelper=new WaitHelper(driver);
		waitHelper.waitForElement(driver, womenMenu, new Config(TestBase.OR).getExplicitWait());
	}
	
	public void mouseOver(String data)
	{
		log.info("Clicking on:"+data);
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[contains(text(),'"+data+"')]"))).build().perform();
	}
	
	public ProductCategoryPage clickOnIntem(String data){
		log.info("clickin on :"+data);
		driver.findElement(By.xpath("//*[contains(text(),'"+data+"')]")).click();
		return new ProductCategoryPage(driver);
	}
	
	public ProductCategoryPage clickOnMenu(WebElement element){
		log.info("clickin on : "+element.getText());
		element.click();
		return new ProductCategoryPage(driver);
	}

	
	
}


