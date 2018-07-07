package packtwo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyPriceFilters {

	@Test
	public void verifyPriceFilters() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/welcome/Desktop/Seleneium Webdriver/Jars/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.findElement(By.xpath(".//*[@id='block_top_menu']/ul/li[2]/a")).click();
		Select select = new Select(driver.findElement(By.xpath(".//*[@id='selectProductSort']")));
		select.selectByVisibleText("Price: Lowest first");
		Thread.sleep(5000);
		// WebDriverWait wait=new WebDriverWait(driver,60);
		// wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Printed
		// Chiffon Dress']"))));

		List<WebElement> prices = driver
				.findElements(By.xpath("//*[@id='center_column']/ul/li/div/div[2]/div[1]/span[1]"));
		ArrayList<Integer> list = new ArrayList<Integer>();
		System.out.println(prices.size());
		// *[@id="center_column"]/ul/li[1]/div/div[1]/div/div[2]/span[1]

		Iterator<WebElement> itr = prices.iterator();

		while (itr.hasNext()) {
			String p = itr.next().getText();
			System.out.println(p);
			if (p.contains("$")) {
				String actual = p.substring(1);
				double p1 = Double.parseDouble(actual);
				int price = (int) (p1);
				list.add(price);

			}
		}
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i) < list.get(i + 1)) {
				System.out.println(list.get(i));
				System.out.println(list.get(i + 1));
			} else
				Assert.assertTrue(false);
		}
	}

}
