package com.test.qa.pageobjects.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.test.qa.pageobjects.utils.PageBase;

/**
 * NewWindowPage.java - class to verify NewWindow Page functions Created by SrirankanK
 * on 10/3/2018.
 */
public class NewWindowPage extends PageBase {

	private static final Logger LOGGER = Logger.getLogger(NewWindowPage.class);

	private static By hdrNewWindow = By.xpath("//h3");

	public static boolean isNewWindowPageDisplayed() {
		return getDriver().findElement(hdrNewWindow).isDisplayed();
	}

	public static void waitTillHeaderLoad() {
		waiTillVisible(hdrNewWindow, 2);
	}
	
	public static String getHeaderText() {
		return getDriver().findElement(hdrNewWindow).getText();
	}
}
