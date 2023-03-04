package generics;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot implements Utlity {

	public static void takeScreenshot(WebDriver driver, String imagename)
	{
		Date d= new Date();
		SimpleDateFormat formate_date= new SimpleDateFormat("dd_MM_yyyy");
		String execution_date = formate_date.format(d);
		TakesScreenshot s=(TakesScreenshot)driver;
		File src = s.getScreenshotAs(OutputType.FILE);
		File dest= new File(imagepath+imagename+"_"+execution_date+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (Exception e) {
			
		}
		
	}
	
}
