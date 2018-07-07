package testcustomlistener;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestLogin extends TestBase {

	@Test
	public void testlistener() throws InterruptedException {
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='header_logo']/a/img"))));
		driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a")).click();
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("vinay");
		driver.findElement(By.xpath("//*[@id='passwd']")).sendKeys("vinay");
		driver.findElement(By.xpath("//*[@id='SubmitLogin']")).click();

	}
}
