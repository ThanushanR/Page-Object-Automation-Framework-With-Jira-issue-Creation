package com.test.qa.pageobjects.pages;

import com.test.qa.pageobjects.utils.Constants;
import org.apache.bcel.classfile.Constant;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.test.qa.pageobjects.utils.PageBase;

import java.io.File;

/**
 * FileUploadPage.java - class to verify FileUpload Page functions Created by SrirankanK
 * on 10/3/2018.
 */
public class FileUploadPage extends PageBase {

	private static final Logger LOGGER = Logger.getLogger(FileUploadPage.class);

	private static By hdrFileUpload = By.xpath("//h3");
	private static By btnUpload = By.id("file-upload");
	private static By btnSubmit = By.id("file-submit");
	private static By pnlUploadFiles = By.id("uploaded-files");

	public static boolean isFileUploadPageDisplayed() {
		return getDriver().findElement(hdrFileUpload).isDisplayed();
	}

	public static void waitTillHeaderLoad() {
		waiTillVisible(hdrFileUpload, 2);
	}

	public static void uploadFile(String filename) {
		getDriver().findElement(btnUpload).sendKeys(PageBase.uploadFilepath+File.separator+ filename);
	}

	public static void submitFile() {
		getDriver().findElement(btnSubmit).click();
	}

	public static String getHeaderValue(){
		return getDriver().findElement(hdrFileUpload).getText();
	}

	public static String getUploadedFilesValue() {
		return getDriver().findElement(pnlUploadFiles).getText();
	}
}
