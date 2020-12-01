package vivid.base;

import org.openqa.selenium.WebDriver;

import vivid.driverFactory.driverFactory;

public class base_driver {
	
	public static WebDriver driver;
	
	public static void start_browser() {
	
		driver = driverFactory.getDriver("chrome");
		driver.manage().window().maximize();
		driver.get(driverFactory.getURL("url"));
	}

}
