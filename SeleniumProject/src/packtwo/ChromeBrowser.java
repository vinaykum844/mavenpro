package packtwo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowser {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Users/welcome/Desktop/Seleneium Webdriver/Jars/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://wwww.facebook.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("vinay");

	}

}
