package packtwo;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ZoomInZoomOut {

	@Test
	public void zoomInZoomOut() throws InterruptedException

	{
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/welcome/Desktop/Seleneium Webdriver/Jars/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		((JavascriptExecutor) driver).executeScript("document.body.style.zoom='50%'");
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("document.body.style.zoom='100%'");
		Thread.sleep(5000);

	}

}
