package com.hybridframework.homepage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hybridframework.testbase.TestBase;

public class TestDataDriverScript1 extends TestBase {
	
	@DataProvider(name="testData")
	public Object[][] dataSource()
	{
		return getData("TestData.xlsx", "RegistrationDetails");
	}
	
	@Test(dataProvider="testData")
	public void testLogin(String var1,String var2,String var3,String var4,String var5,String var6,String var7)
	{
		System.out.println("variable:-"+var1);
		System.out.println("variable:-"+var2);
		System.out.println("variable:-"+var3);
		System.out.println("variable:-"+var4);
		System.out.println("variable:-"+var5);
		System.out.println("variable:-"+var6);
		System.out.println("variable:-"+var7);
		
	}
}
