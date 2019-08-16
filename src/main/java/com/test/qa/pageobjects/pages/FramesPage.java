package com.test.qa.pageobjects.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.test.qa.pageobjects.utils.PageBase;

/**
 * FramesPage.java - class to verify Frames Page functions Created by SrirankanK
 * on 10/3/2018.
 */
public class FramesPage extends PageBase {

	private static final Logger LOGGER = Logger.getLogger(FramesPage.class);

	private static By hdrFramesTest = By.xpath("//h3");
	private static By lnkNestedFrames = By.xpath("//a[@href='/nested_frames']");
	private static By lnkIFrames = By.xpath("//a[@href='/iframe']");
	private static By txtFrame = By.xpath("//html//body");
	private static By txtIFrame = By.xpath("//html//body//p");

	public static boolean isFramesPageDisplayed() {
		return getDriver().findElement(hdrFramesTest).isDisplayed();
	}

	public static void waitTillHeaderLoad() {
		waiTillVisible(hdrFramesTest, 2);
	}

	public static void clickNestedFrames() {
		getDriver().findElement(lnkNestedFrames).click();
	}

	public static void clickIFrames() {
		getDriver().findElement(lnkIFrames).click();
	}

	public static void switchToFrame(String name) {
		getDriver().switchTo().frame(name);
	}

	public static void switchToFrame(int index) {
		getDriver().switchTo().frame(index);
	}

	public static void switchToParentFrame() {
		getDriver().switchTo().parentFrame();
	}

	public static void switchToDefaultContent() {
		getDriver().switchTo().defaultContent();
	}

	public static String getText() {
		return getDriver().findElement(txtFrame).getText();
	}
	
	public static void setTextToIFrame(String text) {
		getDriver().findElement(txtIFrame).sendKeys(text);
	}
	
	public static String getTextToIFrame() {
		return getDriver().findElement(txtIFrame).getText();
	}
}
