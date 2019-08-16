package com.test.qa.pageobjects.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.test.qa.pageobjects.utils.PageBase;

/**
 * LoginPage.java - class to verify Login Page functions Created by SrirankanK
 * on 10/3/2018.
 */
public class LoginPage extends PageBase {

		private static final Logger LOGGER = Logger.getLogger(LoginPage.class);
		private static By hdrLogin = By.xpath("//h2");
		private static By txtUserName = By.id("username");
		private static By txtPassword = By.id("password");
		private static By btnSubmit = By.className("radius");
		private static By alertLogoutSuccess = By.id("flash");
		public static boolean isLoginPageDisplayed() {
			return getDriver().findElement(btnSubmit).isDisplayed();
		}
		public static void setUseraName(String username) {
			getDriver().findElement(txtUserName).sendKeys(username);
		}
		public static void setPassword(String password) {
			getDriver().findElement(txtPassword).sendKeys(password);
		}
		public static void clickSubmit() {
			getDriver().findElement(btnSubmit).click();
		}
		public static boolean isAlertMessageDisplayed() {
			return getDriver().findElement(alertLogoutSuccess).isDisplayed();
		}
		public static String getAlertMessage() {
			return getDriver().findElement(alertLogoutSuccess).getText();
		}
	}