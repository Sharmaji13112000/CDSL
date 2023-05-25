package Test_Cases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Bases.CDSL_Base;
import Pages.Login_Page;

public class Login_ValidCredentials extends CDSL_Base {
	
Login_Page lp;
	
	@BeforeMethod
	public void BrowserCongifTest() {
		intialization();
		lp = new Pages.Login_Page();
	}
	
	@Test
	public void ValidateTitleTest() {
		String ExpTitle = "CDSL";
		String ActTitle = lp.getTitle();
		Assert.assertEquals(ExpTitle, ActTitle);
	}
	@Test
	public void ValidateLogoTest() {
		Assert.assertTrue(lp.getLogo());
	}
	@Test
	public void ValidateLoginPageTest() throws IOException {
		boolean check = lp.getLoginPage();
		Assert.assertTrue(check);
		
	}
	@Test
	public void forgotPasswordTest() {
		Assert.assertTrue(lp.ForgotPassword());
		
	}
	@AfterMethod
	public void BrowserCloseTest() {
		tearDown();
	}

}
