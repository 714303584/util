package com.ifreeshare.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *  Properties controll util
 * @author zhuss
 */
public class PropertiesUtil {
	
	/**
	 * Obtain the Properties from the file path
	 * @param properties
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static Properties getProperties(String properties) throws FileNotFoundException, IOException{
		Properties result = new Properties(); 
		result.load(new FileInputStream(properties));
		return result;
	}
	
}
