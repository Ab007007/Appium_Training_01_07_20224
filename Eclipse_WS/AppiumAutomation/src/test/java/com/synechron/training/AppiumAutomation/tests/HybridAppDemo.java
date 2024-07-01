package com.synechron.training.AppiumAutomation.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.synechron.training.AppiumAutomation.utils.GlobalVariables;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class HybridAppDemo {
	public AndroidDriver driver = null;
	
	@Test
	public void automateHypridApp() throws MalformedURLException, InterruptedException
	{
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("andriod");
		options.setAutomationName("uiautomator2");
		options.setUdid(GlobalVariables.REAL_DEVICE_UDID);
		options.setDeviceName(GlobalVariables.REAL_DEVICE_NAME);
		options.setAppPackage("com.snc.test.webview2");
//		options.setApp(new File("apps/WebViewTest.apk").getAbsolutePath());
		options.setAppActivity("com.snc.test.webview.activity.MainActivity");
		options.setChromedriverExecutable("D:\\Appium_Training_26_06\\Eclipse_WS\\AppiumAutomation\\drivers\\95\\chromedriver.exe");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		System.out.println("Package : " +  driver.getCurrentPackage());
		System.out.println("Activity : " + driver.currentActivity());
		
		
		driver.findElement(AppiumBy.accessibilityId("Open navigation drawer")).click();
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"WebView\")")).click();
		
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(30));
		
		WebElement goButton = wait.until(ExpectedConditions.visibilityOf(driver.findElement(AppiumBy.id("android:id/button1"))));
		
		goButton.click();
		
		Set<String> contextType = driver.getContextHandles();
		for (String context : contextType) {
			System.out.println(context);
		}
//		System.out.println("Window id " + );
		
		driver.context("WEBVIEW_com.snc.test.webview2");
		Thread.sleep(5000);
		driver.findElement(By.name("q")).sendKeys("Txting from appium");
		Thread.sleep(5000);
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		List<WebElement> links = driver.findElements(By.tagName("a"));
		Thread.sleep(15000);
		for (WebElement linkElement : links) {
			System.out.println(linkElement.getText());
		}
		Thread.sleep(6000);
		
	}

}
