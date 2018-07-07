package packtwo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Expanded {
	@Test
	public void f() {
		System.setProperty("webdriver.gecko.driver",
				"C:/Users/welcome/Desktop/Seleneium Webdriver/Jars/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.hdfcbank.com/nri_banking/home.htm");
		for (int j = 1; j <= 3; j++) {

			String style = driver.findElement(By.xpath("//*[@id='expand_collapsed']/div[1]/ul/li[" + j + "]/h3"))
					.getCssValue("background-image");
			System.out.println(style);
			if (style.contains("bg_expand")) {
				Assert.assertTrue(true, style);
			} else {
				Assert.assertTrue(false, style);
			}
			driver.findElement(By.xpath("//*[@id='expand_collapsed']/div[1]/ul/li[" + j + "]/h3")).click();
			style = driver.findElement(By.xpath("//*[@id='expand_collapsed']/div[1]/ul/li[" + j + "]/h3"))
					.getCssValue("background-image");
			System.out.println(style);
			if (style.contains("bg_collapsed")) {
				Assert.assertTrue(true, style);
			} else {
				Assert.assertTrue(false, style);
			}

		}
	}
}
