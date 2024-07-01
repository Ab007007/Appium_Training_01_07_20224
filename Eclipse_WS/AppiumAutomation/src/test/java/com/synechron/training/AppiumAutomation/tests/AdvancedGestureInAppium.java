package com.synechron.training.AppiumAutomation.tests;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;
import com.synechron.training.AppiumAutomation.utils.DriverUtils;

import io.appium.java_client.AppiumBy;

public class AdvancedGestureInAppium extends DriverUtils {

	@BeforeMethod
	public void gotoViewsPage()  throws MalformedURLException
	{
		driver = getRealDeviceDriver();
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"Views\"))")).click();
		
	}
	
	public void scrollingDemoUsingUIScrollable() {
		//
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"TextFields\"))")).click();

	}

	@Test
	public void swipeDemo() {
//		driver = getRealDeviceDriver();
//		driver.findElement(AppiumBy.androidUIAutomator(
//				"new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"Views\"))")).click();

		driver.executeScript("mobile: swipeGesture", ImmutableMap.of("left", 100, "top", 100, "width", 200, "height",
				200, "direction", "up", "percent", 0.75));

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void swipeUsingElementDemo()  {
	
		driver.executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
				driver.findElement(AppiumBy.id("android:id/list")), "direction", "up", "percent", 0.75));

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void swipeLeftDemo()  {
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"Gallery\"))")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();

		driver.executeScript("mobile: swipeGesture", ImmutableMap.of("elementId", driver.findElement(AppiumBy.xpath(
				"//android.widget.Gallery[@resource-id=\"io.appium.android.apis:id/gallery\"]/android.widget.ImageView[1]")),
				"direction", "left", "percent", 0.75));

	}

	@Test
	public void swipeLeftAndThenRightDemo() {
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"Gallery\"))")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();

		List<WebElement> photos = driver.findElements(AppiumBy.xpath(
				"//android.widget.Gallery[@resource-id=\"io.appium.android.apis:id/gallery\"]/android.widget.ImageView"));

		driver.executeScript("mobile: swipeGesture",
				ImmutableMap.of("elementId", photos.get(0), "direction", "left", "percent", 0.75));

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		photos = driver.findElements(AppiumBy.xpath(
				"//android.widget.Gallery[@resource-id=\"io.appium.android.apis:id/gallery\"]/android.widget.ImageView"));

		driver.executeScript("mobile: swipeGesture",
				ImmutableMap.of("elementId", photos.get(photos.size() - 1), "direction", "right", "percent", 0.75));

	}

	@Test
	public void scrollDemoUsingGesture() 
	{
		boolean canScrollMore = (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of("left", 100,
				"top", 100, "width", 200, "height", 200, "direction", "down", "percent", 1.0));
	}

	@Test
	public void scrollTillLastElementUsingGesture() 
	{
		boolean canScrollMore = true;
		int i = 1;
		while (canScrollMore) {
			System.out.println("Scrolling..."  + i++);
			canScrollMore = (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of("left", 100, "top",
					100, "width", 200, "height", 200, "direction", "down", "percent", 1.0));

		}
		
	}
	
	
	@Test
	public void scrollTillLastAndGoTillBegining() throws MalformedURLException, InterruptedException {
		
		boolean canScrollMore = true;
		int i = 1;
		while (canScrollMore) {
			System.out.println("Scrolling down..."  + i++);
			canScrollMore = (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of("left", 100, "top",
					100, "width", 200, "height", 200, "direction", "down", "percent", 1.0));

		}
		
		
		Thread.sleep(5000);
		boolean canScrollUp = true;
		while (canScrollUp) {
			canScrollUp = (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of("elementId",
					driver.findElement(AppiumBy.id("android:id/list")), "direction", "up", "percent", 0.75));
			Thread.sleep(2000);
		}
		
//		
//		canScrollMore = true;
//		i = 1;
//		while (canScrollMore) {
//			System.out.println("Scrolling up ..."  + i++);
//			canScrollMore = (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of("left", 100, "top",
//					100, "width", 200, "height", 200, "direction", "up", "percent", 1.0));
//
//		}
		
	}

	
	@Test
	public void dragAndDropDemo() throws MalformedURLException, InterruptedException {
		
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"Drag and Drop\"))")).click();
		WebElement srcEle = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
		
		driver.executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) srcEle).getId(),
			    "endX", 700,
			    "endY", 630
			));

	}
	
	
		
}
