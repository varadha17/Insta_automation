package vivid.Pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import vivid.base.base_driver;
import vivid.commonUtilties.commonUtility;
import vivid.commonUtilties.excelUtility;

public class MainPage extends base_driver {
	
	public commonUtility util;
	public excelUtility ex;
	
	public MainPage() {
		util = new commonUtility(driver);
		ex = new excelUtility("C:\\Users\\Abinash\\eclipse-workspace\\vivid_instagram\\src\\main\\java\\vivid\\ExcelSheet\\credentials_searchResult.xlsx");
		PageFactory.initElements(driver, this);
	}

	
	public SearchPage searchBox(){
		
		util.sleep();
		String value = ex.getCellDatafromExcel(1, 0, "search");
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		WebElement wb_searchbox = (WebElement)js.executeScript(
				"return document.querySelector(\"input[placeholder='Search']\")"
				);
		wb_searchbox.sendKeys(value);
	
		String beforesearch = "//span[contains(text(),'";
		String AfterSearch = "')]";
		String fullxpath = beforesearch+value+AfterSearch;
		util.sleep();
		driver.findElement(By.xpath(fullxpath)).click();
		assertEquals(driver.getCurrentUrl(), "https://www.instagram.com/"+value+"/");
		util.sleep();
		return new SearchPage();
	}

}
