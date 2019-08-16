package com.test.qa.pageobjects.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.test.qa.pageobjects.utils.PageBase;

/**
 * LoginSecurePage.java - class to verify LoginSecure Page functions Created by
 * SrirankanK on 10/3/2018.
 */
public class LoginSecurePage extends PageBase {

	private static final Logger LOGGER = Logger.getLogger(LoginSecurePage.class);

	private static By hdrSecureArea = By.xpath("//h2");
	private static By btnLogout = By.xpath("//a[@href='/logout']");
	private static By alertLoginSuccess = By.id("flash");

	public static boolean isLoginSecurePageDisplayed() {
		return getDriver().findElement(hdrSecureArea).isDisplayed();
	}

	public static void clickLogout() {
		getDriver().findElement(btnLogout).click();
	}

	public static boolean isLoginAlertDisplayed() {
		return getDriver().findElement(alertLoginSuccess).isDisplayed();
	}

	public static String getLoginAlertMessage() {
		return getDriver().findElement(alertLoginSuccess).getText();
	}
}
