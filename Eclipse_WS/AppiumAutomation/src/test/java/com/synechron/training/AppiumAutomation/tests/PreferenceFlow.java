package com.synechron.training.AppiumAutomation.tests;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.synechron.training.AppiumAutomation.utils.DriverUtils;

import io.appium.java_client.AppiumBy;

public class PreferenceFlow extends DriverUtils
{
	
	@BeforeMethod
	public void initDriver() throws MalformedURLException
	{
		driver = getRealDeviceDriver();
	}

	@Test
	public void verifySwitchValues()
	{
		//click on preferennces -> switches -> print all check box and on/off runtime values -> click on each item
		// and get the runtime value
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(AppiumBy.accessibilityId("9. Switch")).click();
		
		
		
		//android.widget.TextView[@resource-id="android:id/summary" and @text="This is a switch"]/ancestor::android.widget.LinearLayout//android.widget.Switch
		String xpathforFirstEle = "//android.widget.TextView[@resource-id=\"android:id/summary\" and @text=\"This is a switch\"]/ancestor::android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Switch";
		String xpathforSecEle = "//android.widget.TextView[@resource-id=\"android:id/summary\" and @text=\"This is a switch with custom text\"]/ancestor::android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Switch";
		
		WebElement cb  = driver.findElement(AppiumBy.id("android:id/checkbox"));
		
		WebElement sp = driver.findElement(AppiumBy.xpath(xpathforFirstEle));
		WebElement spwcText = driver.findElement(AppiumBy.xpath(xpathforSecEle));
		
		
		System.out.println("Current Status of Check box : " + cb.getAttribute("checked"));
		System.out.println("Current Status of First Custom Button : " + sp.getAttribute("checked"));
		System.out.println("Current Status of Second Custom Button : " + spwcText.getAttribute("checked"));
		
		cb.click();
		sp.click();
		spwcText.click();
		
		cb  = driver.findElement(AppiumBy.id("android:id/checkbox"));
		sp = driver.findElement(AppiumBy.xpath(xpathforFirstEle));
		spwcText = driver.findElement(AppiumBy.xpath(xpathforSecEle));
		
		System.out.println("Status of Check box after Click : " + cb.getAttribute("checked"));
		System.out.println("Status of First Custom Button after Click : " + sp.getAttribute("checked"));
		System.out.println("Status of Second Custom Button after Click : " + spwcText.getAttribute("checked"));
		
		
	}
	
	
	@Test
	public void advancedPreference()
	{
		//click on preferennces -> advanced preference -> get the value next to My preference -> 
		//click on My preference -> get the new value
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(AppiumBy.accessibilityId("6. Advanced preferences")).click();
		
		WebElement count = driver.findElement(AppiumBy.
				xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"My preference\"]/ancestor::android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView"));
		
		System.out.println("Count : " + count.getText());
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"My preference\")")).click();
		count = driver.findElement(AppiumBy.
					xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"My preference\"]/ancestor::android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView"));
			
			System.out.println("Count After Click : " + count.getText());
	}
	
	
	@Test
	public void verfiyDefaultValues() throws MalformedURLException
	{
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(AppiumBy.accessibilityId("4. Default values")).click();
		
		WebElement checkbox = driver.findElement(By.id("android:id/checkbox"));
		System.out.println("Before clicking on check-box "+ checkbox.getAttribute("checked"));
		checkbox.click();
		
		checkbox = driver.findElement(By.id("android:id/checkbox"));
		System.out.println("Before clicking on check-box "+ checkbox.getAttribute("checked"));
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Edit text preference\")")).click();
		//new UiSelector().text("Edit text preference")
		
		driver.findElement(AppiumBy.id("android:id/edit")).clear();
		driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("AravindaText");
		driver.findElement(AppiumBy.id("android:id/button1")).click();
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"List preference\")")).click();
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Alpha Option 01\")")).click();
		
	}
}
