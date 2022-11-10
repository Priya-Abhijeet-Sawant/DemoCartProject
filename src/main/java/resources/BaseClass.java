package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public Properties prop;

	public void intializeDriver() throws IOException {

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\data.properties");
		prop = new Properties();
		prop.load(fis);

		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup(); // To run with latest browser
			driver = new ChromeDriver();
		} 
		else {
			System.out.println("Enter valid browser");
		}
	}
	@BeforeMethod()
	public void LaunchURL() throws IOException {
		intializeDriver();
		String url = prop.getProperty("url");
		driver.get(url);
}
}