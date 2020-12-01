package vivid.test;

import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.Uninterruptibles;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import vivid.Pages.LoginPage;
import vivid.base.base_driver;

public class LoginPageTest extends base_driver{
	
	public LoginPage login;
	
	@Before("@login")
	public void setLoginPage() {
		start_browser();
		login = new LoginPage();
	}
	
	@Given("^Enter username and password$")
	public void enter_username_and_password() throws Throwable {
	    login.LoginCredentials();
	}
	
	@After("@login")
	public void setBrowser() {
		Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
		driver.quit();
	}

}
