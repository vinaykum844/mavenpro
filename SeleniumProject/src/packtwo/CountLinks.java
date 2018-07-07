package packtwo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CountLinks {
	WebDriver driver;

	@Test
	public void f() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://www.facebook.com");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		int c = links.size();
		System.out.println("The total number of links in the page is " + links.size());
		Assert.assertEquals(c, 12);

	}

}
