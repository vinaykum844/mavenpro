package com.hybridframework.Registration;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hybridframework.PageObject.LoginPage;
import com.hybridframework.PageObject.MyAccountPage;
import com.hybridframework.PageObject.RegistrationPage;
import com.hybridframework.helper.Logger.LoggerHelper;
import com.hybridframework.testbase.Config;
import com.hybridframework.testbase.TestBase;

public class Registration  extends TestBase {
	
	private final Logger Log=LoggerHelper.getLogger(Registration.class);
	LoginPage loginPage;
	RegistrationPage register;
	MyAccountPage myAccountpage;
	

	@Test
	public 	void loginToApplication()
	{
		Config config=new Config(OR);
		driver.get(config.getBrowser());
		
		loginPage=new LoginPage(driver);
		loginPage.clickOnSignInLink();
		loginPage.enterRegistrationemail();
		loginPage.clickonCreateanAccount();
		
		register=new RegistrationPage(driver);
		register.setMrRadioButton();
		register.setFirstName("firstname");
		register.setLastname("lastname");
		register.setPassword("password");
		register.setAddress("address");
		register.setDay("5");
		register.setMonth("June");
		register.setYear("2017");
		register.setYourAddressFirstName("yourAddressFirstName");
		register.setYourAddressLastName("yourAddressLastName");
		register.setYourAddressCompany("yourAddressCompany");
		register.setYourAddressCity("yourAddressCity");
		register.setYourAddressState("yourAddressState");
		register.setYourAddressPostCode("99501");
		register.setMobilePhone("9999999999");
		register.setAddressAlias("addressAlias");
		register.clickRegistration();
		
		myAccountpage=new MyAccountPage(driver);
		
		
		if(myAccountpage.verifySuccessRegistrationMsg())
			Log.info("registration is successfull");
		else
			Assert.assertTrue(false, "registration is not successfull");
		
		
		
	}
}
