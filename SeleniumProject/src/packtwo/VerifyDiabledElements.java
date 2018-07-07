package packtwo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyDiabledElements {

	@Test
	public void f() {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/welcome/Desktop/Seleneium Webdriver/Jars/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.olx.in/hyderabad/cars/q-swift/");
		String classname = driver.findElement(By.xpath("//*[@id='param_model']")).getAttribute("class");
		System.out.println(classname);
		Assert.assertEquals(classname, "param paramSelect disabled");
		driver.findElement(By.xpath("//*[@id='param_subcat']")).click();
		driver.findElement(By.xpath("//*[@id='param_subcat']/div[2]/ul/li[2]/a")).click();
		classname = driver.findElement(By.xpath("//*[@id='param_model']")).getAttribute("class");
		System.out.println(classname);
		Assert.assertEquals(classname, "param paramSelect ");

	}
}
