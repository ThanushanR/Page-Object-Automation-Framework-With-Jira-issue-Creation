package com.test.qa.pageobjects.pages;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.test.qa.pageobjects.utils.PageBase;

import java.io.File;
import java.io.IOException;

/**
 * FileDownloadPage.java - class to verify FileDownload Page functions Created by SrirankanK
 * on 10/3/2018.
 */
public class FileDownloadPage extends PageBase {

	private static final Logger LOGGER = Logger.getLogger(FileDownloadPage.class);

	private static By hdrFileDownload = By.xpath("//h3");
	private static String fileDownloadLink = "//div[@class='example']//a[text()='FILE_NAME']";

	public static boolean isFileDownloadPageDisplayed() {
		return getDriver().findElement(hdrFileDownload).isDisplayed();
	}

	public static void waitTillHeaderLoad() {
		waiTillVisible(hdrFileDownload, 2);
	}

	public static void clearDownloadDirectory() {
		try {
			FileUtils.cleanDirectory(new File(PageBase.downloadFilepath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void downloadFile(String fileName) {
	    getDriver().findElement(By.xpath(fileDownloadLink.replace("FILE_NAME", fileName))).click();
    }

    public static boolean isFileExist(String filename) {
		File file = new File(PageBase.downloadFilepath+File.separator+filename);
		return file.exists();
	}
}
