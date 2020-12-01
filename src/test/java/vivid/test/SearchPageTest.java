package vivid.test;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import vivid.Pages.LoginPage;
import vivid.Pages.MainPage;
import vivid.Pages.SearchPage;
import vivid.base.base_driver;

public class SearchPageTest extends base_driver {
	
	public LoginPage login;
	public MainPage main;
	public SearchPage search;
	
	@Before("@search")
	public void setSearchPage() {
		start_browser();
		login = new LoginPage();
		main = login.LoginCredentials();
		search = main.searchBox();
	}
	
	@Given("^click follow link$")
	public void click_follow_link() throws Throwable {
		search.clickFollow();
	}

	@When("^follow the users$")
	public void follow_the_users() throws Throwable {
		search.addFollowers();
	}
	
	@After("@search")
	public void tearDown() {
		driver.quit();
	}

}
