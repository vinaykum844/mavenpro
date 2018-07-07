package com.hybridframework.productDetailsPage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hybridframework.PageObject.Homepage;
import com.hybridframework.PageObject.ProductCategoryPage;
import com.hybridframework.helper.Logger.LoggerHelper;
import com.hybridframework.testbase.Config;
import com.hybridframework.testbase.TestBase;

public class verifyLowestPriceFilter extends TestBase {
	
	private final Logger log=LoggerHelper.getLogger(verifyLowestPriceFilter.class);
	
	@Test
	public void verifyLowestPriceFilterlist_detailsPage() throws InterruptedException
	{
		Config config=new Config(OR);
		driver.get(config.getWebsite());
		
		Homepage homepage=new Homepage(driver);
	
		ProductCategoryPage pcategorypage= homepage.clickOnMenu(homepage.womenMenu);
		
		pcategorypage.selectSortByFilter("Price: Lowest first");
		
		Thread.sleep(3000);
		List<WebElement> w = pcategorypage.getAllProductsPrice();
		ArrayList<Double> array=new ArrayList<Double>();
		Iterator<WebElement> y = w.iterator();
		
		while(y.hasNext())
		{
			String p1=y.next().getText();
			if(p1.contains("$"))
			{
			String p2=p1.substring(1);
			double p3=Double.parseDouble(p2);
			array.add(p3);
			
			}
			
			System.out.println(array);
			
		}
		
		for(int i=0;i<array.size()-1;i++)
		{
			if(array.get(i)<=array.get(i+1))
			{
				System.out.println("obj.get(i) :-"+array.get(i));
				System.out.println("obj.get(i+1) :-"+array.get(i+1));
			}
			
			else
				Assert.assertTrue(false, "filte is not working");
		}
	}
	

}
