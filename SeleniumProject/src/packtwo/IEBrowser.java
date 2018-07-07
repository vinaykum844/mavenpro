package packtwo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEBrowser {

	public static void main(String[] args) {
		System.setProperty("webdriver.ie.driver", "C:/Users/welcome/Desktop/Seleneium Webdriver/Jars/IEDriverServer.exe");
		WebDriver driver=new InternetExplorerDriver();
		driver.get("http://wwww.facebook.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("vinay");

	}

}
