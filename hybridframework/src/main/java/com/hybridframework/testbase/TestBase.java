package com.hybridframework.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.hybridframework.excelreader.Excel_Reader;
import com.hybridframework.helper.Wait.WaitHelper;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;




public class TestBase {
	public static final Logger logger=Logger.getLogger(TestBase.class.getName());
	public static WebDriver driver;
	public static Properties OR;
	public File f1;
	public FileInputStream file;
	
	public Excel_Reader excelreader;
	
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public ITestResult result;

	static
	{
		Calendar calendar=Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		extent =new ExtentReports(System.getProperty("user.dir")+"/src/main/java/com/hybridframework/report/test"+formater.format(calendar.getTime())+".html",false);
	}	
		
	@BeforeTest
	public void launchBrowser()
	{
		try {
			loadPropertiesData();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Config config=new Config(OR);
		getBrowser(config.getBrowser());
		WaitHelper waitHelper=new WaitHelper(driver);
		waitHelper.setImplicitWait(config.getImplicitWait(), TimeUnit.SECONDS);
		waitHelper.setPageLoadTimeout(config.getPageLoadTimeOut(), TimeUnit.SECONDS);
	}
		
	
	public void getBrowser(String browser){
		if(System.getProperty("os.name").contains("Window")){
			if(browser.equalsIgnoreCase("firefox")){
				//https://github.com/mozilla/geckodriver/releases
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("chrome")){
				//https://chromedriver.storage.googleapis.com/index.html
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}
		}
		else if(System.getProperty("os.name").contains("Mac")){
			System.out.println(System.getProperty("os.name"));
			if(browser.equalsIgnoreCase("firefox")){
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver");
				driver = new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver");
				driver = new ChromeDriver();
			}
		}
	}
	
	

	public String[][] getData(String excelName,String sheetName)
	{
		String excellocation=System.getProperty("user.dir")+"/src/main/java/com/hybridframework/data/" +excelName;
		System.out.println(excellocation);
		excelreader= new Excel_Reader();
		return excelreader.getExcelData(excellocation, sheetName);
		
	}
	public void loadPropertiesData()  throws IOException
	{
		String log4jConfPath="log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		OR = new Properties();
		
		f1 = new File(System.getProperty("user.dir") +"/src/main/java/com/hybridframework/config/config.properties");
		file = new FileInputStream(f1);
		OR.load(file);
		
		f1 = new File(System.getProperty("user.dir") +"/src/main/java/com/hybridframework/config/or.properties");
		file = new FileInputStream(f1);
		OR.load(file);
		logger.info("loading or.properties");
		
		f1 = new File(System.getProperty("user.dir") +"/src/main/java/com/hybridframework/properties/homepage.properties");
		file = new FileInputStream(f1);
		OR.load(file);
	}
	
	
	public String getScreenshot(String imageName) throws IOException
	{
		if(imageName.equals(""))
			imageName="blank";
		File image =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String imagelocation=System.getProperty("user.dir")+"/src/main/java/com/hybridframework/screenshot/";
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String actualImagename=imagelocation+imageName+"_"+formater.format(calendar.getTime())+".png";
		File destFile=new File(actualImagename);
		FileUtils.copyFile(image, destFile);
		return actualImagename;
		
	}
	
	public WebElement waitForElementWithPolling(WebDriver driver,long time, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.pollingEvery(5, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public WebElement waitForElement(WebDriver driver,long time, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void getResult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(LogStatus.PASS, result.getName() + " test is pass");
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, result.getName() + " test is skipped and skip reason is:-" + result.getThrowable());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, result.getName() + " test is failed" + result.getThrowable());
			String screen = getScreenshot("");
			test.log(LogStatus.FAIL, test.addScreenCapture(screen));
		} else if (result.getStatus() == ITestResult.STARTED) {
			test.log(LogStatus.INFO, result.getName() + " test is started");
		}
	}
	
	@AfterMethod()
	public void afterMethod(ITestResult result) throws IOException
	{
		getResult(result);
	}
	
	@BeforeMethod()
	public void beforeMethod(Method result)
	{
		test=extent.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName()+"test is started");
	}
	
   @AfterClass(alwaysRun=true)
	public void endTest()
	{
		//driver.quit();
		extent.endTest(test);
		extent.flush();
	}
	
	public WebElement getLocator(String Locator) throws Exception
	{
		String[] split=Locator.split(":");
		String locatorType=split[0];
		String locatorName=split[1];
		System.out.println(locatorType);
		System.out.println(locatorName);
		
		
		if(locatorType.toLowerCase().equals("id"))
			return driver.findElement(By.id(locatorName));
		else if(locatorType.toLowerCase().equals("name"))
			return driver.findElement(By.name(locatorName));
		else if((locatorType.toLowerCase().equals("class"))||(locatorType.toLowerCase().equals("classname")))
			return driver.findElement(By.className(locatorName));
		else if(locatorType.toLowerCase().equals("tagname"))
			return driver.findElement(By.tagName(locatorName));
		else if((locatorType.toLowerCase().equals("linktext"))||(locatorType.toLowerCase().equals("link")))
			return driver.findElement(By.linkText(locatorName));
		else if(locatorType.toLowerCase().equals("partiallinktext"))
			return driver.findElement(By.partialLinkText(locatorName));
		else if((locatorType.toLowerCase().equals("css"))||(locatorType.toLowerCase().equals("cssselector")))
			return driver.findElement(By.cssSelector(locatorName));
		else if(locatorType.toLowerCase().equals("xpath"))
			return driver.findElement(By.xpath(locatorName));
		else
			throw new Exception("Unknown locator type '" +locatorType+"'");
			
	}
	
	public List<WebElement> getLocators(String Locator) throws Exception
	{
		System.out.println(Locator);
		String[] split=Locator.split(":");
		String locatorType=split[0];
		String locatorName=split[1];
		
		if(locatorType.toLowerCase().equals("id"))
			return driver.findElements(By.id(locatorName));
		else if(locatorType.toLowerCase().equals("name"))
			return driver.findElements(By.name(locatorName));
		else if((locatorType.toLowerCase().equals("class"))||(locatorType.toLowerCase().equals("classname")))
			return driver.findElements(By.className(locatorName));
		else if(locatorType.toLowerCase().equals("tagname"))
			return driver.findElements(By.tagName(locatorName));
		else if((locatorType.toLowerCase().equals("linktext"))||(locatorType.toLowerCase().equals("link")))
			return driver.findElements(By.linkText(locatorName));
		else if(locatorType.toLowerCase().equals("partiallinktext"))
			return driver.findElements(By.partialLinkText(locatorName));
		else if((locatorType.toLowerCase().equals("css"))||(locatorType.toLowerCase().equals("cssselector")))
			return driver.findElements(By.cssSelector(locatorName));
		else if(locatorType.toLowerCase().equals("xpath"))
			return driver.findElements(By.xpath(locatorName));
		else
			throw new Exception("Unknown locator type '" +locatorType+"'");
			
	}
	
	public WebElement getWebElement(String locator) throws Exception
	{
		return getLocator(OR.getProperty(locator));
	}
	
	public List<WebElement> getWebElements(String locator) throws Exception
	{
		return getLocators(OR.getProperty(locator));
	}
	
	
	
	public static void main(String args[]) throws Exception
	{
		TestBase test=new TestBase();
		//test.getBrowser("chrome");
		test.loadPropertiesData();
		System.out.println(test.OR.getProperty("username"));
		//System.out.println(test.OR.getProperty("test1"));
		//test.getWebElement("username");
	}
	
}