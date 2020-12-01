package vivid.test;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import vivid.Pages.LoginPage;
import vivid.Pages.MainPage;
import vivid.base.base_driver;

public class MainPageTest extends base_driver {
	
	public LoginPage login;
	public MainPage main;
	
	@Before("@main")
	public void setMainPage() {
		start_browser();
		login = new LoginPage();
		main = login.LoginCredentials();
	}

	
	@Given("^enter value in search box$")
	public void enter_value_in_search_box() throws Throwable {
	   main.searchBox();
	}
	
	
	@After("@main")
	public void setBrowser() {
		driver.quit();
	}
}
