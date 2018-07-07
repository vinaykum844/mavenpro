package packtwo;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Verifyfiters {
	WebDriver driver;

	/**
	 * @throws InterruptedException
	 * 
	 */
	@Test
	public void f() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/welcome/Desktop/Seleneium Webdriver/Jars/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.olx.in/hyderabad/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='cityField']")).click();
		driver.findElement(By.xpath("//*[@id='filterCities']")).sendKeys("Hyderabad");
		driver.findElement(By.xpath("//*[@id='filterCitiesAutosuggest']/li[1]/a")).click();
		// Selecting cars
		driver.findElement(By.xpath("//*[@id='main-category-choose-label']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@id='a-category-5']")).click();
		driver.findElement(By.xpath("//*[@id='search-text']")).sendKeys("swift");
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@id='autosuggest-div']/ul/li[1]")).click();
		Thread.sleep(5000);

		List<WebElement> cars = driver
				.findElements(By.xpath("//*[@id='offers_table']/tbody/tr/td/table/tbody/tr/td[2]/h3/a/span"));
		System.out.println(cars.size());
		Iterator<WebElement> itr = cars.iterator();
		while (itr.hasNext()) {
			String data = itr.next().getText();
			System.out.println(data);
			if (data.toLowerCase().contains("swift")) {
			} else {
				Assert.assertTrue(false, data);
			}
		}
		cars = driver.findElements(By.xpath(".//*[@id='promotedAd']/tbody/tr/td/table/tbody/tr/td[2]/h3/a/span"));
		// System.out.println(cars.size());
		itr = cars.iterator();
		while (itr.hasNext()) {
			String data = itr.next().getText();
			System.out.println(data);
			if (data.toLowerCase().contains("swift")) {
			} else {
				Assert.assertTrue(false, data);
			}
		}
	}
}