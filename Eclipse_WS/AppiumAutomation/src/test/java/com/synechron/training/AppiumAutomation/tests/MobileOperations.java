package com.synechron.training.AppiumAutomation.tests;

import java.net.MalformedURLException;

import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;
import com.synechron.training.AppiumAutomation.utils.DriverUtils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MobileOperations extends DriverUtils
{
	@BeforeMethod
	public void initDriver() throws MalformedURLException
	{
		driver = getRealDeviceDriver();
	}

	
	
	@Test
	public void verifyLandScapeMode() throws InterruptedException
	{
		driver.setClipboardText("Aravind-Wifi");
		System.out.println(driver.getClipboardText());
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
		
		DeviceRotation landScape = new DeviceRotation(0, 0, 90);

		driver.rotate(landScape);
		
		WebElement checkBox = driver.findElement(AppiumBy.id("android:id/checkbox"));
		 Boolean checked = Boolean.valueOf(checkBox.getAttribute("checked"));
		 WebElement wifiSettings = null;
		if(!checked)
		{
			checkBox.click();
			wifiSettings = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"WiFi settings\")"));
		
			System.out.println("Wifi Setting is Enabled : " + wifiSettings.getAttribute("enabled"));
			wifiSettings.click();
		}
		else
		{
			System.out.println("Wifi Setting is Enabled : " + wifiSettings.getAttribute("enabled"));
			wifiSettings.click();
			
		}
		Thread.sleep(2000);
		driver.findElement(AppiumBy.id("android:id/edit")).clear();
		driver.findElement(AppiumBy.id("android:id/edit")).sendKeys(driver.getClipboardText());
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(2000);
		driver.findElement(AppiumBy.id("android:id/button1")).click();
		
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		Thread.sleep(5000);
		
	}
	
	
	@Test
	public void longPressAction() throws InterruptedException
	{
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"Views\"))")).click();
	
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		
		WebElement element = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"People Names\")"));
		
		driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId()
			));
		
		
		Thread.sleep(5000);
//		driver.longPressKey(new KeyEvent(AndroidKey.BACK));
		
		
	}
	
	
	@Test
	public void mobileGestureAutomation() throws InterruptedException
	{
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"Views\"))")).click();
		
		
		System.out.println("Package : " +  driver.getCurrentPackage());
		System.out.println("Activity : " + driver.currentActivity());
		System.out.println("Orientation : " + driver.getOrientation());
		System.out.println("Keyboard status : " + driver.isKeyboardShown());
		System.out.println(driver.isAppInstalled("io.appium.android.apis"));
		System.out.println("Locked " + driver.isDeviceLocked());
		 
	
	}

}
