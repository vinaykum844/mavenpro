package packtwo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOverOperations {

	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://www.nseindia.com/");
		Actions w = new Actions(driver);
		WebElement l1 = driver.findElement(By.xpath("//*[@id='main_livemkt']/a"));
		w.moveToElement(l1).perform();

	}

}
