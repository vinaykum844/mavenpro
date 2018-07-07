package packtwo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyText {
	WebDriver driver;

	@Test
	public void f() {
		System.setProperty("webdriver.gecko.driver",
				"C:/Users/welcome/Desktop/Seleneium Webdriver/Jars/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		ArrayList<String> Expectedarrayleft = new ArrayList<String>();
		ArrayList<String> Expectedarrayright = new ArrayList<String>();
		Expectedarrayleft.add("Apply Now");
		Expectedarrayleft.add("Help me decide...");
		Expectedarrayleft.add("Need customer support?");
		Expectedarrayright.add("Products & Services");
		Expectedarrayright.add("Send money to India");
		Expectedarrayright.add("Looking to invest in India");
		driver.get("https://www.hdfcbank.com/nri_banking/home.htm");
		List<WebElement> totalleft = driver.findElements(By.xpath("//*[@id='expand_collapsed']/div[2]/ul/li"));
		Iterator<WebElement> itrl = totalleft.iterator();
		List<WebElement> totalright = driver.findElements(By.xpath("//*[@id='expand_collapsed']/div[1]/ul/li"));
		Iterator<WebElement> itrr = totalright.iterator();

		ArrayList<String> Actualarrayl = new ArrayList<String>();
		ArrayList<String> Actualarrayr = new ArrayList<String>();
		while (itrl.hasNext()) {
			Actualarrayl.add(itrl.next().getText());
		}
		while (itrr.hasNext()) {
			Actualarrayr.add(itrr.next().getText());
		}
		System.out.println(Actualarrayl);
		System.out.println(Expectedarrayleft);
		System.out.println(Actualarrayr);
		System.out.println(Expectedarrayright);

		Assert.assertEquals(Actualarrayl, Expectedarrayleft);
		Assert.assertEquals(Actualarrayr, Expectedarrayright);
	}
}
