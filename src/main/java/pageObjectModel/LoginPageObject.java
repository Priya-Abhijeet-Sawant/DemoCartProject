package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObject {
	private WebDriver driver;
//iphone
	By searchbutton=By.xpath(" //input[@name='search']");
	By clickOnSearch=By.xpath("//i[@class='fa fa-search']");
	By iphonePrice=By.xpath("//p[@class='price']");
	By addIphonetoCart=By.xpath("(//i[@class=\"fa fa-shopping-cart\"])[3]");

//samsung
	By clearSearch=By.xpath(" //input[@name='search']");
	//By samsungPrice1=By.xpath("//p[@class='price'])[1]");
	By samsungPrice=By.xpath("(//p[@class='price'])[2]");
	By addsamsungtoCart=By.xpath("(//i[@class='fa fa-shopping-cart'])[5]");
	
//code for total in the Cart
	//By Cart=By.xpath("//span[@id=\"cart-total\"]");
	By Cart=By.xpath("//div[@id='cart']/button");
	By Total=By.xpath("(//td[@class='text-right'])[12]");
	
	public LoginPageObject(WebDriver driver2) {	//constructor is created here to give the scope to driver in VerifyLogin class
		this.driver = driver2;
	}
	public WebElement findSearchButton() {
		return driver.findElement(searchbutton);
	}
	public WebElement clickOnSearchButton() {
		return driver.findElement(clickOnSearch);
	}
	public WebElement findIphonePrice() {
		return driver.findElement(iphonePrice);
	}
	public WebElement clickonAddIphonetoCart() {
		return driver.findElement(addIphonetoCart);
	}
	public WebElement clearSearchBar() {
		return driver.findElement(clearSearch);
	}
	public WebElement findSamsungPrice() {
		return driver.findElement(samsungPrice);
	}
	public WebElement clickonaddsamsungtoCart() {
		return driver.findElement(addsamsungtoCart);
	}
	public WebElement ViewCart() {
		return driver.findElement(Cart);
	}
	public WebElement TotalinCart() {
		return driver.findElement(Total);
	}
}