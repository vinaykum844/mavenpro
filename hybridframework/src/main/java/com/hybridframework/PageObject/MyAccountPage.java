package com.hybridframework.PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hybridframework.helper.AssertionHelper.VerificationHelper;
import com.hybridframework.helper.Logger.LoggerHelper;
import com.hybridframework.helper.Wait.WaitHelper;
import com.hybridframework.testbase.Config;
import com.hybridframework.testbase.TestBase;

public class MyAccountPage {
	
	WebDriver driver;
	private final Logger logger=LoggerHelper.getLogger(MyAccountPage.class);
	WaitHelper waitHelper;
	
	@FindBy(xpath="//*[contains(text(),'Welcome to your account. Here you can manage all of your personal information and orders.')]")
	WebElement successRegistrationMsg;
	
	@FindBy(xpath="//*[contains(text(),'Order history and details')]")
	WebElement OrderHistoryAndDetails;
	
	@FindBy(xpath="//*[contains(text(),'My personal information')]")
	WebElement MyPersonalInformation;
	
	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(driver, OrderHistoryAndDetails,new Config(TestBase.OR).getExplicitWait());
	}
	
	public boolean verifySuccessRegistrationMsg(){
		return VerificationHelper.verifyElementPresent(successRegistrationMsg);
	}
	

}