//package utils;
//
//import java.io.File;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.DesiredCapabilities;
//
//
//public class DriverUtils {
//
//	public static WebDriver driver = null;
//
//	public DriverUtils() {
//		
//	}
//	public DriverUtils(WebDriver driver ) {
//		this.driver = driver;
//	
//	}
////	public static WebDriver<WebElement> getDriver(String deviceName, String app, String udid)
////			throws MalformedURLException {
////
////		DesiredCapabilities cap = new DesiredCapabilities();
////		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
////		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
////		cap.setCapability(MobileCapabilityType.APP, new File(app).getAbsolutePath());
////		cap.setCapability(MobileCapabilityType.UDID, udid);
////		cap.setCapability("autoAcceptAlerts", true);
////		driver = new WebDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
////		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
////
////		return driver;
////	}
////
////	public static WebDriver<WebElement> getDriver(String deviceName, String apppackage, String appActivity,
////			String udid) throws MalformedURLException {
////
////		DesiredCapabilities cap = new DesiredCapabilities();
////		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
////		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
////		cap.setCapability("appPackage", apppackage);
////		cap.setCapability("appActivity", appActivity);
////
////		cap.setCapability(MobileCapabilityType.UDID, udid);
////		cap.setCapability("autoAcceptAlerts", true);
////		driver = new WebDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
////		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
////		return driver;
////	}
////
////	public static WebDriver<WebElement> getDriverForRealDevice() throws MalformedURLException {
////		DesiredCapabilities cap = new DesiredCapabilities();
////		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 5");
////		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
////		cap.setCapability("appPackage", "io.appium.android.apis");
////		cap.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
////
////		cap.setCapability(MobileCapabilityType.UDID, "01abd5130382753e");
////
////		cap.setCapability("autoAcceptAlerts", true);
////		driver = new WebDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
////		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
////		return driver;
////	}
////
////	public static WebDriver<WebElement> getDriverForVirtualDevice() throws MalformedURLException {
////		DesiredCapabilities cap = new DesiredCapabilities();
////		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Aravind");
////		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
////		// cap.setCapability(MobileCapabilityType.APP, new
////		// File("apps//ApiDemos-debug.apk").getAbsolutePath());
////
////		cap.setCapability("appPackage", "io.appium.android.apis");
////		cap.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
////
////		cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
////
////		cap.setCapability("autoAcceptAlerts", true);
////		driver = new WebDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
////		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
////		return driver;
////	}
//	/***
//	 * @author Aravind
//	 * @param identifier - id, access-id , name , classname , xpath , androidui
//	 * @param value  - webelement 
//	 * @return
//	 */
//	public static WebElement getElement(String identifier, String value) {
//		WebElement ele = null;
//		System.out.println("Finding Element using  " + identifier + " : " + value);
//		switch (identifier) {
//		case "id":
//			ele = (WebElement) driver.findElement(Appd(value);
//			break;
//
//		case "access-id":
//			ele = (WebElement) driver.findElementByAccessibilityId(value);
//			break;
//
//		case "name":
//			ele = (WebElement) driver.findElementByName(value);
//			break;
//
//		case "classname":
//			ele = (WebElement) driver.findElementByClassName(value);
//			break;
//
//		case "xpath":
//			ele = (WebElement) driver.findElementByXPath(value);
//			break;
//		case "androidui":
//			ele = (WebElement) driver.findElementByAndroidUIAutomator(value);
//			break;
//
//		default:
//			System.out.println("Pease contact Framework develoopment team ");
//			break;
//		}
//
//		return ele;
//	}
//	/***
//	 * @author Aravind
//	 * @param identifier - id, access-id , name , classname , xpath , androidui
//	 * @param value  - 
//	 * @return
//	 */
//	public static void type(String identifier, String value, String text) {
//		System.out.println("Entering Value" + text + " using  " + identifier + " : " + value);
//		getElement(identifier, value).sendKeys(text);
//	}
//	/***
//	 * @author Aravind
//	 * @param identifier - id, access-id , name , classname , xpath , androidui
//	 * @param value  - webelement 
//	 * @return
//	 */
//	public static void click(String identifier, String value) {
//		System.out.println("Performing Click on  " + identifier + " : " + value);
//		getElement(identifier, value).click();
//	}
//	/***
//	 * @author Aravind
//	 * @param identifier - id, access-id , name , classname , xpath , androidui
//	 * @param value  - webelement 
//	 * @return
//	 */
//	public static String getAttribute(String identifier, String value, String attr) {
//		String attrValue = null;
//		System.out.println("Gettring Value for " + attr + " using  " + identifier + " : " + value);
//		attrValue = getElement(identifier, value).getAttribute(attr);
//		return attrValue;
//	}