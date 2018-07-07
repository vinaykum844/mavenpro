package com.hybridframework.productDetailsPage;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hybridframework.PageObject.Homepage;
import com.hybridframework.PageObject.LoginPage;
import com.hybridframework.PageObject.ProductCategoryPage;
import com.hybridframework.helper.Logger.LoggerHelper;
import com.hybridframework.testbase.Config;
import com.hybridframework.testbase.TestBase;

public class VerifyProductCounts extends TestBase {
	
	private final Logger log=LoggerHelper.getLogger(VerifyProductCounts.class);
	LoginPage loginpage;
	Homepage homePage;
	
	
	@Test
	public void verifyProductCounts()
	{
		Config config=new Config(OR);
		driver.get(config.getWebsite());
		homePage=new Homepage(driver);
		
		ProductCategoryPage pCategoryPage=homePage.clickOnMenu(homePage.womenMenu);
		pCategoryPage.selectColor(pCategoryPage.Black);
		int p=pCategoryPage.getTotalProducts();
		
		if(p==2)
			log.info("count is matching");
		else
			Assert.assertTrue(false, "count is not matching");
		
	}
	
	

}
