package testNG;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;
public class ReadDataFromPropertyFileTest {

	@Test
	public void eadDataFromPropertyFile() throws IOException {
		// step 1:open the document in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		// step2: create object of properties class from java.util
		Properties p = new Properties();
		// step3: load the file input stream to properties class
		p.load(fis);
		//step4 : provoide the key and read the value
		String value = p.getProperty("username");
		System.out.println(value);
	
		

	}

}
