package com.hybridframework.homepage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hybridframework.testbase.TestBase;

public class TestDataDriverScript extends TestBase {
	
	@DataProvider(name="testData")
	public Object[][] dataSource()
	{
		return getData("TestData.xlsx", "LoginDetails");
	}
	
	@Test(dataProvider="testData")
	public void testLogin(String UserName,String Password,String runMode)
	{
		System.out.println("UserName:-"+UserName);
		System.out.println("Password:-"+Password);
		System.out.println("runMode:-"+runMode);
	}
}
