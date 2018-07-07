package propertiesFile;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeClass;

public class TestBase {
	public Properties OR;
	public File file;
	public FileReader filereader;

	public void setup() throws IOException {
		OR = new Properties();
		file = new File(System.getProperty("user.dir") + "\\src\\configproperites\\config.properties");
		filereader = new FileReader(file);
		OR.load(filereader);
		file = new File(System.getProperty("user.dir") + "\\src\\configproperites\\or.properties");
		filereader = new FileReader(file);
		OR.load(filereader);
	}

	@BeforeClass
	public void init() throws IOException {
		setup();
	}

}
