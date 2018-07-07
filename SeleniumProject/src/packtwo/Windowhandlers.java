package packtwo;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Windowhandlers {
	WebDriver driver;

	@Test
	public void f() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/welcome/Desktop/Seleneium Webdriver/Jars/chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("http://wwww.facebook.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.id("terms-link")).click();
		Set<String> wind = driver.getWindowHandles();
		Iterator<String> itr = wind.iterator();
		String parentwindow = itr.next();
		String childwindow = itr.next();
		driver.switchTo().window(childwindow);
		driver.findElement(By.xpath("//*[@id='blueBarDOMInspector']/div/div[2]/div/div/span/a")).click();
		Thread.sleep(5000);
		driver.close();
		driver.switchTo().window(parentwindow);
		driver.findElement(By.id("email")).sendKeys("vinay");

	}
}
