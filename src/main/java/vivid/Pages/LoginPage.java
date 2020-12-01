package vivid.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vivid.base.base_driver;
import vivid.commonUtilties.commonUtility;
import vivid.commonUtilties.excelUtility;

public class LoginPage extends base_driver {
	public commonUtility util;
	public excelUtility ex;
	
	public LoginPage() {
		util = new commonUtility(driver);
		ex = new excelUtility("C:\\Users\\Abinash\\eclipse-workspace\\vivid_instagram\\src\\main\\java\\vivid\\ExcelSheet\\credentials_searchResult.xlsx");
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[normalize-space()='Not Now']") WebElement notNow;
	
	public MainPage LoginCredentials() {
		util.sleep();
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		WebElement wb_user = (WebElement)js.executeScript(
				"return document.querySelector(\"input[name='username']\")"
				);
		wb_user.sendKeys(ex.getCellDatafromExcel(1, 0, "credentials")); 
		
		WebElement wb_pass = (WebElement)js.executeScript(
				"return document.querySelector(\"input[name='password']\")"
				);
		wb_pass.sendKeys(ex.getCellDatafromExcel(1, 1, "credentials"));
		
		WebElement wb_login = (WebElement)js.executeScript(
				"return document.querySelector(\"section._9eogI.E3X2T main.SCxLW.o64aR:nth-child(2) article._4_yKc div.rgFsT div.gr27e:nth-child(1) div.EPjEi form.HmktE div.Igw0E.IwRSH.eGOV_._4EzTm.kEKum > div.Igw0E.IwRSH.eGOV_._4EzTm.bkEs3.CovQj.jKUp7.DhRcB:nth-child(3)\")"
				);
		wb_login.click();
		
		util.sleep();
		util.isDisplayed(notNow);
		notNow.click();
		util.sleep();
		notNow.click();
		
		return new MainPage();

	}
	
}
