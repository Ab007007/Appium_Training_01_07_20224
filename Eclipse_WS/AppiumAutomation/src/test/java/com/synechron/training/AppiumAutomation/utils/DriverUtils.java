package com.synechron.training.AppiumAutomation.utils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class DriverUtils 
{
	public AndroidDriver driver = null;
	public DesiredCapabilities cap = null;
	
	public AndroidDriver getRealDeviceDriver() throws MalformedURLException
	{
		System.out.println("--Creating a driver for Real Device--");
		cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
//		cap.setCapability("browserName", "chrome");
		cap.setCapability("appium:automationName", "uiautomator2");
		cap.setCapability("appium:udid", GlobalVariables.REAL_DEVICE_UDID);
		cap.setCapability("appium:deviceName", GlobalVariables.REAL_DEVICE_NAME);
		cap.setCapability("appium:app", new File("apps/ApiDemos-debug.apk").getAbsolutePath());

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), cap);
		
		return driver;
	
	}
	
	
	public AndroidDriver getVirtualDeviceDriver() throws MalformedURLException
	{
		System.out.println("--Creating a driver for Virtual  Device--");
		cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("appium:automationName", "uiautomator2");
		cap.setCapability("appium:udid", GlobalVariables.VIRTUAL_DEVICE_UDID);
		cap.setCapability("appium:deviceName", GlobalVariables.VIRTUAL_DEVICE_NAME);
		cap.setCapability("appium:app", new File("apps/ApiDemos-debug.apk").getAbsolutePath());
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), cap);
		return driver;

	}
}
