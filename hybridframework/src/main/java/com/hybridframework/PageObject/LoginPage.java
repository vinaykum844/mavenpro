package com.hybridframework.PageObject;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hybridframework.helper.GenericHelper.GenericHelper;
import com.hybridframework.helper.Logger.LoggerHelper;
import com.hybridframework.helper.Wait.WaitHelper;
import com.hybridframework.testbase.Config;
import com.hybridframework.testbase.TestBase;

public class LoginPage {
	
	WebDriver driver;
	private final Logger log=LoggerHelper.getLogger(LoginPage.class);
	WaitHelper waitHelper;
	
	@FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement signin;
	
	@FindBy(xpath="//*[@id='email']")
	WebElement emailAddress;
	
	@FindBy(xpath="//*[@id='passwd']")
	WebElement password;
	
	@FindBy(xpath="//*[@id='SubmitLogin']")
	WebElement submitLogin;
	
	@FindBy(xpath="//*[@id='center_column']/p")
	WebElement successMsgObject;
	
	@FindBy(xpath="//*[@id='email_create']")
	WebElement registration;
	
	@FindBy(xpath="//*[@id='SubmitCreate']")
	WebElement createAnAccount;
	

	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		waitHelper=new WaitHelper(driver);
		waitHelper.waitForElement(driver, signin, new Config(TestBase.OR).getExplicitWait());
	}
	
	public void clickOnSignInLink()
	{
		log.info("clicking on sign in link:");
		signin.click();
	}
	
public void enterEmailAddress(String emailAddress)
{
	log.info("entering email address"+emailAddress);
	this.emailAddress.sendKeys(emailAddress);
}

public void enterPassword(String password)
{
	log.info("entering email address"+password);
	this.password.sendKeys(password);
}

public Homepage clickOnSubmit()
{
	log.info("clicking on sign in");
	submitLogin.click();
	return new Homepage(driver);
}

public boolean verifySuccessfullLoginMsg()
{
	return new GenericHelper().isDisplayed(successMsgObject);
}

public void enterRegistrationemail()
{
	log.info("entering email");
	String email=System.currentTimeMillis()+"@gmail.com";
	registration.sendKeys(email);
}

public RegistrationPage clickonCreateanAccount()
{
	log.info("clicking on createaccount");
	createAnAccount.click();
	return new RegistrationPage(driver);
}

public void loginToApplication(String emailAddress, String password)
{
	clickOnSignInLink();
	enterEmailAddress(emailAddress);
	enterPassword(password);
	clickOnSubmit();
}

}
