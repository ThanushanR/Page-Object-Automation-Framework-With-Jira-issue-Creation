package com.test.qa.pageobjects.pages;

import com.test.qa.pageobjects.utils.Constants;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.test.qa.pageobjects.utils.PageBase;

/**
 * MultipleWindowsPage.java - class to verify MultipleWindows Page functions
 * Created by SrirankanK on 10/3/2018.
 */
public class MultipleWindowsPage extends PageBase {

	private static final Logger LOGGER = Logger.getLogger(MultipleWindowsPage.class);

	private static By hdrMultipleWindows = By.xpath("//h3");
	private static By lnkClickHere = By.xpath("//a[@href='/windows/new']");

	public static boolean isMultipleWindowsTestDisplayed() {
		return getDriver().findElement(hdrMultipleWindows).isDisplayed();
	}

	public static void waitTillHeaderLoad() {
		waiTillVisible(hdrMultipleWindows, 2);
	}
	
	public static void openNewWindow() {
		getDriver().findElement(lnkClickHere).click();
		if(PageBase.driverType == Constants.FIREFOX)
			PageBase.staticWait(2);
		for(String winHandle : getDriver().getWindowHandles()){
			if(PageBase.driverType == Constants.FIREFOX)
				PageBase.staticWait(2);
			getDriver().switchTo().window(winHandle);
		}
	}
}
