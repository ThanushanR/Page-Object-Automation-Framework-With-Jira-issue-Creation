package com.test.qa.test;

import java.awt.event.KeyEvent;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.test.qa.pageobjects.pages.Alerts;
import com.test.qa.pageobjects.pages.BasicAuthPage;
import com.test.qa.pageobjects.pages.FramesPage;
import com.test.qa.pageobjects.pages.HomePage;
import com.test.qa.pageobjects.pages.KeysPressPage;
import com.test.qa.pageobjects.pages.MultipleWindowsPage;
import com.test.qa.pageobjects.pages.NewWindowPage;
import com.test.qa.pageobjects.utils.Constants;
import com.test.qa.pageobjects.utils.PageBase;
import com.test.qa.utils.TestBase;

/**
 * UiAutomationTrainingMediumTest.java - class to execute Tests Created by
 * SrirankanK on 10/3/2018.
 */
public class UiAutomationTrainingMediumTest extends TestBase {

	/**
	 * Verify Alerts
	 */
	@Test(groups = "REGRESSION", priority = 1)
	public void testVerifyAlertAuths() {
		softAssert = new SoftAssert();
        softAssert.assertTrue(HomePage.isHomePageDisplayed(), "Home Page is not Displayed");
        PageBase.getDriver().get(Constants.BASIC_AUTH_URL.replace(Constants.USER_NAME, Constants.ADMIN_USER_NAME).replace(Constants.PASSWORD, Constants.ADMIN_PASSWORD));
        softAssert.assertTrue(BasicAuthPage.isBasicAuthPageIsDisplayed(), "Basic Auth Page is not Displayed");
        softAssert.assertTrue(BasicAuthPage.isSuccessMsgDisplayed(), "Succcess Message is not Displayed");
        softAssert.assertTrue(BasicAuthPage.getSuccessMsg().contains(Constants.BASIC_AUTH_SUCCESS_MESSAGE), "Basic Auth Success  Message is invalid");
		softAssert.assertAll();
	}

	@Test(groups = "REGRESSION", dependsOnMethods = "testVerifyAlertAuths")
	public void testVerifyAlerts() {
		softAssert = new SoftAssert();
        softAssert.assertTrue(HomePage.isHomePageDisplayed(), "Home Page is not Displayed");
        HomePage.clickLink(Constants.ALERT_LINK);
        Alerts.waitTillHeaderLoad();
        
        Alerts.clickAlertButton();
        softAssert.assertTrue(Alerts.isAlertPresent(), "Alert is not present");
        softAssert.assertEquals(Alerts.getText(), Constants.ALERT_MSG_ALERT, "Alert Message is invalid");
        Alerts.accept();
        softAssert.assertEquals(Alerts.getResult(), Constants.ALERT_SUCCES_MSG_ALERT, "Invalid Result Message");
        
        Alerts.clickAlertConfirm();
        softAssert.assertTrue(Alerts.isAlertPresent(), "Alert is not present");
        softAssert.assertEquals(Alerts.getText(), Constants.ALERT_MSG_CONFIRM, "Alert Message is invalid");
        Alerts.accept();
        softAssert.assertEquals(Alerts.getResult(), Constants.ALERT_SUCCES_MSG_CONFIRM.replace(Constants.RESULT, Constants.OK), "Invalid Result Message");
        
        Alerts.clickAlertConfirm();
        softAssert.assertTrue(Alerts.isAlertPresent(), "Alert is not present");
        softAssert.assertEquals(Alerts.getText(), Constants.ALERT_MSG_CONFIRM, "Alert Message is invalid");
        Alerts.dismiss();
        softAssert.assertEquals(Alerts.getResult(), Constants.ALERT_SUCCES_MSG_CONFIRM.replace(Constants.RESULT, Constants.CANCEL), "Invalid Result Message");
        
        Alerts.clickAlertPrompt();
        softAssert.assertTrue(Alerts.isAlertPresent(), "Alert is not present");
        softAssert.assertEquals(Alerts.getText(), Constants.ALERT_MSG_PROMPT, "Alert Message is invalid");
        Alerts.setText(Constants.ALERT_TEXT);
        Alerts.accept();
        softAssert.assertEquals(Alerts.getResult(), Constants.ALERT_SUCCES_MSG_PROMPT.replace(Constants.RESULT, Constants.ALERT_TEXT), "Invalid Result Message");
        
        PageBase.getDriver().get(Constants.BASIC_AUTH_URL.replace(Constants.USER_NAME, Constants.ADMIN_USER_NAME).replace(Constants.PASSWORD, Constants.ADMIN_PASSWORD));
        softAssert.assertTrue(BasicAuthPage.isBasicAuthPageIsDisplayed(), "Basic Auth Page is not Displayed");
        softAssert.assertTrue(BasicAuthPage.isSuccessMsgDisplayed(), "Succcess Message is not Displayed");
        softAssert.assertTrue(BasicAuthPage.getSuccessMsg().contains(Constants.BASIC_AUTH_SUCCESS_MESSAGE), "Basic Auth Success  Message is invalid");
		softAssert.assertAll();
	}

	@Test(groups = "REGRESSION", dependsOnMethods = "testVerifyAlerts")
	public void testVerifyNestedFrames() {
		softAssert = new SoftAssert();
		HomePage.clickLink(Constants.FRAMES_LINK);
		FramesPage.waitTillHeaderLoad();

		FramesPage.clickNestedFrames();
		PageBase.staticWait(2);
		
		FramesPage.switchToFrame(Constants.FRAMES_NAME_TOP);
		FramesPage.switchToFrame(Constants.FRAMES_NAME_LEFT);
		softAssert.assertEquals(FramesPage.getText(), Constants.LEFT, "Left Frames Text is incorrect");

		FramesPage.switchToParentFrame();
		FramesPage.switchToFrame(Constants.FRAMES_NAME_MIDDLE);
		softAssert.assertEquals(FramesPage.getText(), Constants.MIDDLE, "Middle Frames Text is incorrect");

		FramesPage.switchToParentFrame();
		FramesPage.switchToFrame(Constants.FRAMES_NAME_RIGHT);
		softAssert.assertEquals(FramesPage.getText(), Constants.RIGHT, "Right Frames Text is incorrect");

		FramesPage.switchToDefaultContent();
		FramesPage.switchToFrame(1);
		softAssert.assertEquals(FramesPage.getText(), Constants.BOTTOM, "Bottom Frames Text is incorrect");

		FramesPage.switchToDefaultContent();
		softAssert.assertAll();
	}

	@Test(groups = "REGRESSION", dependsOnMethods = "testVerifyNestedFrames")
	public void testVerifyIFrames() {
		softAssert = new SoftAssert();
		HomePage.clickLink(Constants.FRAMES_LINK);
		FramesPage.waitTillHeaderLoad();

		FramesPage.clickIFrames();
		FramesPage.switchToFrame(Constants.IFRAME_ID);
		softAssert.assertEquals(FramesPage.getText(), Constants.IFRAME_TEXT, "Invalid iframe text");

		FramesPage.switchToDefaultContent();
		softAssert.assertAll();
	}

	@Test(groups = "REGRESSION", dependsOnMethods = "testVerifyIFrames")
	public void testVerifyMultipleWindows() {
		softAssert = new SoftAssert();
		HomePage.clickLink(Constants.MULTIPLE_WINDOWS_LINK);
		MultipleWindowsPage.waitTillHeaderLoad();

		String multipleWindows = MultipleWindowsPage.getCurrentWindow();
		MultipleWindowsPage.openNewWindow();
		NewWindowPage.waitTillHeaderLoad();
		softAssert.assertEquals(NewWindowPage.getHeaderText(), Constants.NEW_WINDOW, "Invalid header text");
		
		NewWindowPage.navigateToWindow(multipleWindows);
		MultipleWindowsPage.waitTillHeaderLoad();
		softAssert.assertTrue(MultipleWindowsPage.isMultipleWindowsTestDisplayed(), "MultipleWindows Page is not Displayed");
		
		softAssert.assertAll();
	}

	@Test(groups = "REGRESSION", dependsOnMethods = "testVerifyMultipleWindows")
	public void testVerifyKeysPress() {
		softAssert = new SoftAssert();
		HomePage.clickLink(Constants.KEYS_PRESS_LINK);
		KeysPressPage.waitTillHeaderLoad();

		KeysPressPage.enterKeys(KeyEvent.VK_0);
		softAssert.assertEquals(KeysPressPage.getResultText(), Constants.KEY_PRESS_RESULT+KeyEvent.getKeyText(KeyEvent.VK_0), "Invalid result text 0");
		
		KeysPressPage.enterKeys(KeyEvent.VK_X);
		softAssert.assertEquals(KeysPressPage.getResultText(), Constants.KEY_PRESS_RESULT+KeyEvent.getKeyText(KeyEvent.VK_X), "Invalid result text X");
		
		KeysPressPage.enterKeys(KeyEvent.VK_SHIFT);
		softAssert.assertEquals(KeysPressPage.getResultText(), Constants.KEY_PRESS_RESULT+KeyEvent.getKeyText(KeyEvent.VK_SHIFT).toUpperCase(), "Invalid result text Shift");
	
		KeysPressPage.enterKeys(KeyEvent.VK_HOME);
		softAssert.assertEquals(KeysPressPage.getResultText(), Constants.KEY_PRESS_RESULT+KeyEvent.getKeyText(KeyEvent.VK_HOME).toUpperCase(), "Invalid result text Home");
		
		KeysPressPage.enterKeys(KeyEvent.VK_ENTER);
		softAssert.assertEquals(KeysPressPage.getResultText(), Constants.KEY_PRESS_RESULT+KeyEvent.getKeyText(KeyEvent.VK_ENTER).toUpperCase(), "Invalid result text Enter");
		
		softAssert.assertAll();
	}
}
