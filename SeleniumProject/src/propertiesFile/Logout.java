package propertiesFile;

import org.testng.annotations.Test;

public class Logout extends TestBase {

	@Test
	public void logout()

	{
		System.out.println(OR.get("login.submit"));
		System.out.println(OR.get("login.username"));
		System.out.println(OR.get("login.password"));
		System.out.println(OR.get("url"));
		System.out.println(OR.get("Browser"));

	}

}
