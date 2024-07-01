package com.synechron.training.AppiumAutomation.tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class BasicOperations {

	@Test
	public void formFill() throws MalformedURLException, InterruptedException {
		AndroidDriver driver = null;

		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("platformName", "android");
		cap.setCapability("appium:automationName", "uiautomator2");
		cap.setCapability("appium:udid", "01abd5130382753e");
		cap.setCapability("appium:deviceName", "Nexus 5");
		cap.setCapability("appium:app", new File("apps/ApiDemos-debug.apk").getAbsolutePath());

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), cap);
		
		Thread.sleep(5000);
		//driver.findElement(AppiumBy.accessibilityId("Access'ibility")).click();
		//driver.findElement(AppiumBy.id("android:id/text1")).click();
		//driver.findElement(AppiumBy.className("android.widget.TextView")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Accessibility']")).click();
		Thread.sleep(5000);

		
	
	
	
	}
}
