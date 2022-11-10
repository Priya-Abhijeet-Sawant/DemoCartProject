package testcases;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TotalCode {
	@Test
	public void VerifySumofProducts() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\abhic\\Desktop\\ChromeDrivers\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/");
		
		//iphone code
		driver.findElement(By.xpath(" //input[@name='search']")).sendKeys("Iphone");
		driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
		
		WebElement obj=driver.findElement(By.xpath("//p[@class=\"price\"]"));
		String iphonePrice=obj.getText();
		//System.out.println(iphonePrice);
		
		String[]a=iphonePrice.split("\\s+");
		//System.out.println(Arrays.toString(a));
		
		String withDollar=a[0];
		//System.out.println(withDollar);
		
		String withoutDollar = withDollar.replaceAll("[$,]", "");
		//System.out.println(withoutDollar);
		
		//convert the string to double
		double d1=Double.parseDouble(withoutDollar);
		Thread.sleep(2000);
		
		//iphone added to cart
		driver.findElement(By.xpath("(//i[@class=\"fa fa-shopping-cart\"])[3]")).click();	
		Thread.sleep(2000);
		
		//samsungcode
		driver.findElement(By.xpath(" //input[@name='search']")).clear();
		driver.findElement(By.xpath(" //input[@name='search']")).sendKeys("Samsung");
		driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
		Thread.sleep(2000);
		
		WebElement obj1=driver.findElement(By.xpath("(//p[@class=\"price\"])[2]"));
		String samsungPrice=obj1.getText();
		//System.out.println(samsungPrice);
		
		String[]b=samsungPrice.split("\\s+");
		//System.out.println(Arrays.toString(b));
		
		String samsungwithDollar=b[0];
		//System.out.println(samsungwithDollar);
		
		String samsungwithoutDollar = samsungwithDollar.replaceAll("[$,]", "");
		//System.out.println(samsungwithoutDollar);
		
		//convert the string to double
		double d2=Double.parseDouble(samsungwithoutDollar);
		Thread.sleep(2000);
		
		//samsung added to cart
		driver.findElement(By.xpath("(//i[@class=\"fa fa-shopping-cart\"])[5]")).click();	
		Thread.sleep(2000);
		
		//total cost=iphone+samsung
		double d=d1+d2;	
		//System.out.println(d); 
		String t=("$"+d);
		System.out.println(t);
		
		//code for total in the Cart
		driver.findElement(By.xpath("//span[@id=\"cart-total\"]")).click();
		WebElement CartTotal=driver.findElement(By.xpath("(//td[@class=\"text-right\"])[12]"));
		String T=CartTotal.getText();
		System.out.println(T);
		
		//comparing if both prices matches
		if(t.equals(T)) {
			System.out.println("Total amount is matching successfully");
		}else {
			System.out.println("Amount is not matching");
		}	
}
}
