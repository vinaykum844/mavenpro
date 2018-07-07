package packtwo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DeleteEmailInbox {

	@Test
	public void deleteEmailInbox() throws InterruptedException

	{
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/welcome/Desktop/Seleneium Webdriver/Jars/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.sharklasers.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[@id='inbox-id']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@id='inbox-id']/input")).sendKeys("test");
		driver.findElement(By.xpath("//*[@id='inbox-id']/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[contains(text(),'team@doughbies.com ')]/preceding-sibling::td/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='del_button']")).click();

		// *[@id="inbox-id"]
	}
}
