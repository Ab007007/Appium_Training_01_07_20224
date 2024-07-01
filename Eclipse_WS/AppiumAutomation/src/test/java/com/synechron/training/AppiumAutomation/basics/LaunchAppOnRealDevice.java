package com.synechron.training.AppiumAutomation.basics;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class LaunchAppOnRealDevice {

	
	@Test
	public void launchApp() throws MalformedURLException
	{
		AndroidDriver driver = null;

		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("platformName", "android");
		cap.setCapability("appium:automationName", "uiautomator2");
		cap.setCapability("appium:udid", "01abd5130382753e");
		cap.setCapability("appium:deviceName", "Nexus 5");
		cap.setCapability("appium:app", new File("apps/ApiDemos-debug.apk").getAbsolutePath());

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), cap);

		
	}
	
}
