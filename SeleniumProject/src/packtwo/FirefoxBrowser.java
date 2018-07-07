package packtwo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowser {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver",
				"C:/Users/welcome/Desktop/Seleneium Webdriver/Jars/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://wwww.facebook.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("vinay");

	}

}
