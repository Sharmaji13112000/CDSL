package Pages;

import java.io.IOException;

import org.openqa.selenium.By;

import Bases.CDSL_Base;

public class Login_Page extends CDSL_Base {
	
	public String getTitle() {
		System.out.println("Title are same");
		return driver.getTitle();
	}
	
	public boolean getLogo() {
		System.out.println("Logo Is Displayed");
		return driver.findElement(By.xpath(prop.getProperty("WebsiteLogo"))).isDisplayed();
		
	}
	public boolean getLoginPage() throws IOException {
		driver.findElement(By.xpath(prop.getProperty("Usernamexpath"))).sendKeys(prop.getProperty("Username"));
		driver.findElement(By.xpath(prop.getProperty("Passwordxpath"))).sendKeys(prop.getProperty("Password"));
		driver.findElement(By.xpath(prop.getProperty("Loginxpath"))).click();
		System.out.println("Login Done");
		return driver.findElement(By.xpath(prop.getProperty("DashBoardIsDisplayed"))).isDisplayed();
		
	}
	public boolean ForgotPassword() {
		driver.findElement(By.xpath(prop.getProperty("FrgetPasswordxpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("ForgetUsernamexpath"))).sendKeys(prop.getProperty("ForgetUsername"));
		driver.findElement(By.xpath(prop.getProperty("ForgetSubmitxpath"))).click();
		System.out.println("Password Reset Done");
		return driver.findElement(By.xpath(prop.getProperty("ResetPasswordDisplayedxpath"))).isDisplayed();
		
	}

}
