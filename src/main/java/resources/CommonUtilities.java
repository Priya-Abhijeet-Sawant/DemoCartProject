package resources;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CommonUtilities {
	public static WebDriver driver;
	
		//WebElement obj=driver.findElement(By.xpath("//p[@class=\"price\"]"));
		//String iphonePrice=obj.getText();
		//String[]a=iphonePrice.split("\\s+");
		//String withDollar=a[0];
		//String withoutDollar = withDollar.replaceAll("[$,]", "");
		//double d1=Double.parseDouble(withoutDollar);
		
		public static double handleWebelement(WebElement element,String s) { //String s=webelement.getText
			String[]a=s.split("\\s+");
			String withDollar=a[0];
			String withoutDollar = withDollar.replaceAll("[$,]", "");
			double d=Double.parseDouble(withoutDollar);
			return d;
		}	
}