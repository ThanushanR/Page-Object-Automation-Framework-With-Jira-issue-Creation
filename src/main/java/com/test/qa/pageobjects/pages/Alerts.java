package com.test.qa.pageobjects.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;

import com.test.qa.pageobjects.utils.PageBase;

/**
 * Alerts.java - class to verify Alerts functions Created by SrirankanK on
 * 10/3/2018.
 */
public class Alerts extends PageBase {

	private static final Logger LOGGER = Logger.getLogger(Alerts.class);

	private static By hdrAlertTest = By.xpath("//h3");
	private static By jsAlertButton = By.xpath("//button[@onclick='jsAlert()']");
	private static By jsConfirmButton = By.xpath("//button[@onclick='jsConfirm()']");
	private static By jsPromptButton = By.xpath("//button[@onclick='jsPrompt()']");
	private static By lblResult = By.id("result");

	public static boolean isAlertPageDisplayed() {
		return getDriver().findElement(hdrAlertTest).isDisplayed();
	}

	public static void waitTillHeaderLoad() {
		waiTillVisible(hdrAlertTest, 2);
	}

	public static void accept() {
		getDriver().switchTo().alert().accept();
	}

	public static void dismiss() {
		getDriver().switchTo().alert().dismiss();
	}

	public static void setText(String text) {
		getDriver().switchTo().alert().sendKeys(text);
	}

	public static String getText() {
		return getDriver().switchTo().alert().getText();
	}

	public static void clickAlertButton() {
		getDriver().findElement(jsAlertButton).click();
	}

	public static void clickAlertConfirm() {
		getDriver().findElement(jsConfirmButton).click();
	}

	public static void clickAlertPrompt() {
		getDriver().findElement(jsPromptButton).click();
	}

	public static boolean isAlertPresent() {
		try {
			getDriver().switchTo().alert();
			return true;
		} catch (NoAlertPresentException Ex) {
			return false;
		}
	}

	public static String getResult() {
		return getDriver().findElement(lblResult).getText();
	}
}
