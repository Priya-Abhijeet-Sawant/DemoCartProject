package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageObjectModel.LoginPageObject;
import resources.BaseClass;
import resources.CommonUtilities;
import resources.Constant;

public class VerfiyProductsInCart extends BaseClass{
	@Test
	public void login() throws IOException, InterruptedException {

		LoginPageObject obj = new LoginPageObject(driver);
//iphone Code
		obj.findSearchButton().sendKeys(Constant.iphone);
		obj.clickOnSearchButton().click();
		double i=CommonUtilities.handleWebelement(obj.findIphonePrice(),obj.findIphonePrice().getText() );
		Thread.sleep(2000);
		obj.clickonAddIphonetoCart().click();
		
//samsung Code
		obj.clearSearchBar().clear();
		obj.findSearchButton().sendKeys(Constant.samsung);
		obj.clickOnSearchButton().click();
		double j=CommonUtilities.handleWebelement(obj.findSamsungPrice(),obj.findSamsungPrice().getText());
		Thread.sleep(2000);
		obj.clickonaddsamsungtoCart().click();
		
//total cost=iphone+samsung
		double d=i+j;	
		String totalPrice=("$"+d);
		System.out.println(totalPrice);
		
//Total in cart
		Thread.sleep(2000);
		obj.ViewCart().click();											//View cart worked with this xpath--"//div[@id='cart']/button"	
		String TotatlPriceFromCart=obj.TotalinCart().getText();
		System.out.println(TotatlPriceFromCart);
     
//comparing both prices       
		if(totalPrice.equalsIgnoreCase(TotatlPriceFromCart)) 
        {
        	System.out.println("Amount is matching");
		}else {
			System.out.println("Amount is not matching");
		}	
		driver.close();
	}	
}
