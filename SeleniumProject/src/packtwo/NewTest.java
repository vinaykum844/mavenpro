package packtwo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewTest {
	public WebDriver driver;

	@Test
	public void f() throws InterruptedException {
		driver.findElement(By.id("email")).sendKeys("vinay");
		driver.findElement(By.id("pass")).sendKeys("vinay");
		driver.findElement(By.name("firstname")).sendKeys("vinay");
		driver.findElement(By.name("lastname")).sendKeys("vinay");
		driver.findElement(By.name("reg_email__")).sendKeys("vinay");

		Select select = new Select(driver.findElement(By.xpath("//*[@id='day']")));
		select.selectByIndex(3);

		select = new Select(driver.findElement(By.id("month")));
		select.selectByVisibleText("May");

		select = new Select(driver.findElement(By.id("year")));
		select.selectByVisibleText("2015");
		Thread.sleep(5000);

	}

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/welcome/Desktop/Seleneium Webdriver/Jars/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://wwww.facebook.com");
		driver.manage().window().maximize();

	}

	@AfterClass
	public void afterClass() {
		driver.quit();

	}

}
