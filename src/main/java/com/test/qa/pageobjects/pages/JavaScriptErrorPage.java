package com.test.qa.pageobjects.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.test.qa.pageobjects.utils.PageBase;

/**
 * JavaScriptErrorPage.java - class to verify JavaScriptError Page functions
 * Created by SrirankanK on 10/3/2018.
 */
public class JavaScriptErrorPage extends PageBase {

	private static final Logger LOGGER = Logger.getLogger(JavaScriptErrorPage.class);

	private static By hdrJavaScriptError = By.xpath("//h3");

	public static boolean isJavaScriptErrorPageDisplayed() {
		return getDriver().findElement(hdrJavaScriptError).isDisplayed();
	}

	public static void waitTillHeaderLoad() {
		waiTillVisible(hdrJavaScriptError, 2);
	}
}
