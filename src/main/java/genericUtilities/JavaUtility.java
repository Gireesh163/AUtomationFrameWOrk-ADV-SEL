package genericUtilities;

import java.util.Date;

/**
 * this class consists of reusable method related Java
 * @author GIREESH C S
 *
 */

public class JavaUtility {
	/**
	 * this method return the current system date in specific format
	 * @return
	 */
	public String getSystemDate()
	{
		Date d = new Date();
		String[] dArr = d.toString().split(" ");
		String currentDate = dArr[2]+"-"+dArr[1]+"-"+dArr[5]+" "+dArr[3].replace(":", "_");
		return currentDate;
	}
}
