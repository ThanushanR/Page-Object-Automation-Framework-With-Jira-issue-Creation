package com.test.qa.pageobjects.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.test.qa.pageobjects.utils.PageBase;

/**
 * KeysPressPage.java - class to verify KeysPress Page functions Created by
 * SrirankanK on 10/3/2018.
 */
public class KeysPressPage extends PageBase {

	private static final Logger LOGGER = Logger.getLogger(KeysPressPage.class);

	private static By hdrKeysPress = By.xpath("//h3");
	private static By lblResult = By.id("result");

	public static boolean isKeysPressPageDisplayed() {
		return getDriver().findElement(hdrKeysPress).isDisplayed();
	}

	public static void waitTillHeaderLoad() {
		waiTillVisible(hdrKeysPress, 2);
	}
	
	public static String getResultText() {
		return getDriver().findElement(lblResult).getText();
	}
	
	public static void enterKeys(int key) {
		try {
			Robot robot = new Robot();
			 robot.keyPress(key);
			 robot.keyRelease(key);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
