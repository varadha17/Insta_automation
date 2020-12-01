package vivid.Pages;

import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.google.common.util.concurrent.Uninterruptibles;

import vivid.base.base_driver;
import vivid.commonUtilties.commonUtility;
import vivid.commonUtilties.excelUtility;

public class SearchPage extends base_driver {
	
	public commonUtility util;
	public excelUtility ex;
	
	public SearchPage() {
		util = new commonUtility(driver);
		ex = new excelUtility("C:\\Users\\Abinash\\eclipse-workspace\\vivid_instagram\\src\\main\\java\\vivid\\ExcelSheet\\credentials_searchResult.xlsx");
		PageFactory.initElements(driver, this);
	}
	
	public void clickFollow() {
		String value = ex.getCellDatafromExcel(1, 0, "search");
		String beforesearch = "//a[@href='/";
		String AfterSearch = "/followers/']";
		String fullxpath = beforesearch+value+AfterSearch;
		driver.findElement(By.xpath(fullxpath)).click();
	}
	
	public void addFollowers() {
		Uninterruptibles.sleepUninterruptibly(7, TimeUnit.SECONDS);
		//Scroll 15 times
		for(int i=0;i<15;i++) {
			EventFiringWebDriver event = new EventFiringWebDriver(driver);
			event.executeScript("document.querySelector(\"div[class='isgrP']\").scrollTop=9000");
			util.sleep();
			List<WebElement> ele = driver.findElements(By.cssSelector("button.sqdOP.L3NKy.y3zKF:nth-child(1)"));
			ListIterator<WebElement> it = ele.listIterator();
			Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);
			// Follow click
			try {
				for(int j=0;j<ele.size();j++) {
					if(ele != null) {
						WebElement elem = it.next();
						elem.click();
						util.sleep();
					} else {
						continue;
					}
				}
			}
				catch(Exception ex) {
					System.out.println(ex.getMessage());
				}
		}	
		Uninterruptibles.sleepUninterruptibly(6, TimeUnit.SECONDS);
		
	}

}
