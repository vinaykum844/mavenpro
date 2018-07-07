package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnTest {

	@Test
	public void login() {
		System.out.println("login");
		// Assert.assertTrue(false);
	}

	@Test(dependsOnMethods = { "login", "logout" })
	public void test2() {
		System.out.println("login" + "," + "logout");
	}

	@Test(dependsOnMethods = { "login" })
	public void logout() {
		System.out.println("logout");
		Assert.assertTrue(false);
	}

}
