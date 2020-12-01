package vivid.driverFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class driverFactory {
	//Launch Browser
	public static final Supplier<WebDriver> chromeInitDriver = () -> {
		WebDriverManager.chromedriver().setup();
		return new ChromeDriver();
	};
	
	
	public static final Supplier<WebDriver> firefoxInitDriver = () -> {
		WebDriverManager.firefoxdriver().setup();
		return new FirefoxDriver();
	};
	
	public static final Map<String,Supplier<WebDriver>> map = new HashMap<String,Supplier<WebDriver>>();
	public static final Map<String,String> credentials = new HashMap<String,String>();
	
	//Change or add your Credentials inside static block
	static {
		map.put("chrome", chromeInitDriver);
		map.put("firefox", firefoxInitDriver);
		credentials.put("username", "vivid_hotel");
		credentials.put("password", "ananyaa_0904");
		credentials.put("url", "https://www.instagram.com/");
	}
	
	
	public static WebDriver getDriver(String browser) {
		return map.get(browser).get();
	}
	
	public static String getUserName(String username) {
		return credentials.get(username);
	}
	
	public static String getPassword(String password) {
		return credentials.get(password);
	}
	
	public static String getURL(String url) {
		return credentials.get(url);
	}
	
}
