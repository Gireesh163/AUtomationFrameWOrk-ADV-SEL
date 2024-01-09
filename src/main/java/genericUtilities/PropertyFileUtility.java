package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
//(before writing class should write description with author compulsurly in utility class
/**
 * this class consists of reusable method related to property file
 * @author GIREESH C S
 *
 */
public class PropertyFileUtility {
	// after writting method completely should write description /** enter
	/**
	 * this method read data from property file and return value to caller
	 * @param key
	 * @return value //(we can type return type
	 * @throws IOException
	 */

	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
	
}
