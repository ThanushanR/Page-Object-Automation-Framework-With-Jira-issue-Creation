//package com.test.qa.pageobjects.pages;
//
//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpGet;
//
//import org.apache.log4j.Logger;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//
//import com.test.qa.pageobjects.utils.PageBase;
//
///**
// * BrokenImagePage.java - class to verify BrokenImage Page functions Created by SrirankanK
// * on 10/3/2018.
// */
//public class BrokenImagePage extends PageBase {
//
//	private static final Logger LOGGER = Logger.getLogger(BrokenImagePage.class);
//
//	private static By hdrBrokenImage = By.xpath("//h3");
//	private static By imgFirst = By.xpath("//img[@src='asdf.jpg']");
//	private static By imgSecond = By.xpath("//img[@src='hjkl.jpg']");
//	private static By imgThird = By.xpath("//img[@src='img/avatar-blank.jpg']");
//
//	public static boolean isBrokenImagePageDisplayed() {
//		return getDriver().findElement(hdrBrokenImage).isDisplayed();
//	}
//
//	public static void waitTillHeaderLoad() {
//		waiTillVisible(hdrBrokenImage, 2);
//	}
//
//	public static boolean verifyFirstImage() {
//		return verifyImageAction(getDriver().findElement(imgFirst));
//	}
//
//	public static boolean verifySecondImage() {
//		return verifyImageAction(getDriver().findElement(imgSecond));
//	}
//
//	public static boolean verifyThirdImage() {
//		return verifyImageAction(getDriver().findElement(imgThird));
//	}
//
//	public static boolean verifyImageAction(WebElement imageElement){
//		boolean status = false;
//        try{
//            HttpClient client = HttpClientBuilder.create().build();
//            HttpGet request = new HttpGet(imageElement.getAttribute("src"));
//            HttpResponse response = client.execute(request);
//            if (response.getStatusLine().getStatusCode() == 200){
//            	status = true;
//            }
//        }catch (Exception e){
//        	status = false;
//        }
//        return status;
//    }
//}
