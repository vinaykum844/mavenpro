package com.hybridframework.Loginpage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hybridframework.PageObject.LoginPage;
import com.hybridframework.helper.Logger.LoggerHelper;
import com.hybridframework.testbase.Config;
import com.hybridframework.testbase.TestBase;

public class LoginTest extends TestBase{
	
	private final Logger Log=LoggerHelper.getLogger(LoginTest.class);
	
	@Test
	public void testLoginToApplication()
	{
		Config config=new Config(OR);
		driver.get(config.getWebsite());
		driver.manage().window().maximize();
		LoginPage loginpage=new LoginPage(driver);
		loginpage.loginToApplication(config.getUserName(), config.getPassword());
		boolean  status=loginpage.verifySuccessfullLoginMsg();
		if(status)
		{
			Log.info("login is successful");
		}
		else{
			Assert.assertTrue(false, "login is unsuccessfull");
		}
			
	}

}
