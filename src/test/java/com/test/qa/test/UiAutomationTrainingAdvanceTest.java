//package com.test.qa.test;
//
//import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;
//
////import com.test.qa.pageobjects.pages.BrokenImagePage;
//import com.test.qa.pageobjects.pages.DragAndDropPage;
//import com.test.qa.pageobjects.pages.FileDownloadPage;
//import com.test.qa.pageobjects.pages.FileUploadPage;
//import com.test.qa.pageobjects.pages.HomePage;
//import com.test.qa.pageobjects.utils.Constants;
//import com.test.qa.utils.TestBase;
//
///**
// * UiAutomationTrainingAdvanceTest.java - class to execute Tests Created by
// * SrirankanK on 10/3/2018.
// */
//public class UiAutomationTrainingAdvanceTest extends TestBase {
//
//	@Test(groups = "REGRESSION", priority = 1)
//	public void testVerifyBrokenImage() {
//		softAssert = new SoftAssert();
//		HomePage.clickLink(Constants.BROKEN_IMAGES_LINK);
//		BrokenImagePage.waitTillHeaderLoad();
//
//		softAssert.assertFalse(BrokenImagePage.verifyFirstImage(), "Image 1 status in invalid");
//		softAssert.assertFalse(BrokenImagePage.verifySecondImage(), "Image 2 status in invalid");
//		softAssert.assertTrue(BrokenImagePage.verifyThirdImage(), "Image 3 status in invalid");
//
//		softAssert.assertAll();
//	}
//
//	@Test(groups = "REGRESSION", priority = 2)
//	public void testVerifyFileUplaod() {
//		softAssert = new SoftAssert();
//		HomePage.clickLink(Constants.FILE_UPLOAD_LINK);
//		FileUploadPage.waitTillHeaderLoad();
//
//        FileUploadPage.uploadFile(Constants.FILENAME_TXT);
//        FileUploadPage.submitFile();
//
//        softAssert.assertEquals(FileUploadPage.getHeaderValue(), Constants.UPLOAD_HEADER, "Invalid Header");
//        softAssert.assertEquals(FileUploadPage.getUploadedFilesValue(), Constants.FILENAME_TXT, "Invalid File Name");
//
//		softAssert.assertAll();
//	}
//
//	@Test(groups = "REGRESSION", priority = 3)
//	public void testVerifyFileDownload() {
//		softAssert = new SoftAssert();
//		FileDownloadPage.clearDownloadDirectory();
//
//		HomePage.clickLink(Constants.FILE_DOWNLOAD_LINK);
//		FileDownloadPage.waitTillHeaderLoad();
//
//		FileDownloadPage.downloadFile(Constants.FILENAME_TXT);
//		FileDownloadPage.staticWait(3);
//        softAssert.assertTrue(FileDownloadPage.isFileExist(Constants.FILENAME_TXT), "File is not donwloaded");
//
//		softAssert.assertAll();
//	}
//
//	@Test(groups = "REGRESSION", priority = 4)
//	public void testVerifyDragAndDrop() {
//		softAssert = new SoftAssert();
//		HomePage.clickLink(Constants.DRAG_AND_DROP_LINK);
//		DragAndDropPage.waitTillHeaderLoad();
//		softAssert.assertEquals(DragAndDropPage.getTextFromFirstElement(), Constants.A, "Invalid First Element Text 1");
//		softAssert.assertEquals(DragAndDropPage.getTextFromSecondElement(), Constants.B, "Invalid Second Element Text 1");
//
//		DragAndDropPage.dragFirstToSecond();
//		softAssert.assertEquals(DragAndDropPage.getTextFromFirstElement(), Constants.B, "Invalid First Element Text 2");
//		softAssert.assertEquals(DragAndDropPage.getTextFromSecondElement(), Constants.A, "Invalid Second Element Text 2");
//
//		DragAndDropPage.dragSecondToFirst();
//		softAssert.assertEquals(DragAndDropPage.getTextFromFirstElement(), Constants.A, "Invalid First Element Text 3");
//		softAssert.assertEquals(DragAndDropPage.getTextFromSecondElement(), Constants.B, "Invalid Second Element Text 3");
//
//		softAssert.assertAll();
//	}
//}
