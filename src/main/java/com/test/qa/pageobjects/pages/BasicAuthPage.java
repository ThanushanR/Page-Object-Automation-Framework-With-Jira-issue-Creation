package com.test.qa.pageobjects.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.test.qa.pageobjects.utils.PageBase;

/**
 * BasicAuthPage.java - class to verify BasicAuth Page functions Created by
 * SrirankanK on 10/3/2018.
 */
public class BasicAuthPage extends PageBase {

	private static final Logger LOGGER = Logger.getLogger(BasicAuthPage.class);

	private static By hdrBasicAuth = By.xpath("//h3");
	private static By lblSuccessMsg = By.xpath("//p");

	public static boolean isBasicAuthPageIsDisplayed() {
		return getDriver().findElement(hdrBasicAuth).isDisplayed();
	}

	public static boolean isSuccessMsgDisplayed() {
		return getDriver().findElement(lblSuccessMsg).isDisplayed();
	}

	public static String getSuccessMsg() {
		return getDriver().findElement(lblSuccessMsg).getText();
	}
}
