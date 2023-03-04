package generics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile implements Utlity{

	public static String getPropertyValue(String key)
	{
		Properties p= new Properties();
		try {
			p.load(new FileInputStream(propertypath));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p.getProperty(key);
		
	}
}
