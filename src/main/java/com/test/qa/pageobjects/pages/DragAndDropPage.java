package com.test.qa.pageobjects.pages;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.test.qa.pageobjects.utils.PageBase;

import java.io.File;
import java.io.IOException;

/**
 * DragAndDropPage.java - class to verify DragAndDrop Page functions Created by
 * SrirankanK on 10/3/2018.
 */
public class DragAndDropPage extends PageBase {

	private static final Logger LOGGER = Logger.getLogger(DragAndDropPage.class);

	private static By hdrDragAndDrop = By.xpath("//h3");
	private static By divFirstDraggableElement = By.id("column-a");//By.xpath("(//div[@draggable='true'])[1]");
	private static By divSecondDraggableElement = By.id("column-b");//By.xpath("(//div[@draggable='true'])[2]");
	private static String jsFileLocation = File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"jsScript"+File.separator+"dragAndDrop.js";

	public static boolean isDragAndDropPageDisplayed() {
		return getDriver().findElement(hdrDragAndDrop).isDisplayed();
	}

	public static void waitTillHeaderLoad() {
		waiTillVisible(hdrDragAndDrop, 2);
	}
	
	public static String getTextFromFirstElement() {
		return getDriver().findElement(divFirstDraggableElement).getText();
	}
	
	public static String getTextFromSecondElement() {
		return getDriver().findElement(divSecondDraggableElement).getText();
	}
	
	public static void dragFirstToSecond() {
		dragAndDropElement(getDriver().findElement(divFirstDraggableElement), getDriver().findElement(divSecondDraggableElement));
	}
	
	public static void dragSecondToFirst() {
		dragAndDropElement(getDriver().findElement(divSecondDraggableElement), getDriver().findElement(divFirstDraggableElement));
	}
	
	public static void dragAndDropElement(WebElement from, WebElement to) {
        String jsScript = null;
        try {
            jsScript = Files.toString(new File(System.getProperty("user.dir")+jsFileLocation), Charsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript(jsScript+"$('#column-a').simulateDragDrop({ dropTarget: '#column-b'});");
	}
}
