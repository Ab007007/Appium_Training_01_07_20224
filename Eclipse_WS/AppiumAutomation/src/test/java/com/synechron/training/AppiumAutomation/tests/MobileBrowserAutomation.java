package com.synechron.training.AppiumAutomation.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.synechron.training.AppiumAutomation.utils.GlobalVariables;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class MobileBrowserAutomation 
{
	AndroidDriver driver = null;
	
	@Test
	public void browserAutomation() throws MalformedURLException, InterruptedException {
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("andriod");
		options.setAutomationName("uiautomator2");
		options.setUdid(GlobalVariables.REAL_DEVICE_UDID);
		options.setDeviceName(GlobalVariables.REAL_DEVICE_NAME);
		options.setChromedriverExecutable("D:\\Appium_Training_26_06\\Eclipse_WS\\AppiumAutomation\\drivers\\106\\chromedriver.exe");
		options.setCapability("browserName", "chrome");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://facebook.com");
		
		driver.findElement(By.id("m_login_email")).sendKeys("facebookUserName");
		driver.hideKeyboard();
		Thread.sleep(2000);
		driver.findElement(By.id("m_login_password")).sendKeys("facebookUserName");
		driver.hideKeyboard();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@role='button']")).click();
		Thread.sleep(2000);
	}

}
