package vivid.commonUtilties;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.util.concurrent.Uninterruptibles;

public class commonUtility extends commonComponent {
	
	public WebDriverWait wait;
	public WebDriver driver;
	
	public commonUtility(WebDriver driver) {
		wait = new WebDriverWait(driver,30);
		this.driver = driver;
	}

	@Override
	public void sleep() {
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
	}

	@Override
	public boolean isDisplayed(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.isDisplayed();
	}


}
