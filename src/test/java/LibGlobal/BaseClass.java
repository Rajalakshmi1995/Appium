package LibGlobal;

import java.awt.Point;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class BaseClass {
	
	public static AppiumDriver driver;
	
	public static TouchAction action;

	
	public static void LaunchApp(String DeviceName, String platformName, String platformVersion, String appPackage, String appActivity) throws MalformedURLException {
		
		DesiredCapabilities capabilites = new DesiredCapabilities();
		capabilites.setCapability("deviceName", DeviceName);
		capabilites.setCapability("platformName", platformName );
		capabilites.setCapability("platformVersion", platformVersion);
		capabilites.setCapability("appPackage", appPackage);
		capabilites.setCapability("appActivity", appActivity );
		
		URL service = new URL("http://localhost:4723/wd/hub"); 
		driver = new AppiumDriver(service, capabilites);
		
		
	}
	
	
	public static void implicitWait() {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		

	}
	
	
	public static void click(WebElement element) {
		
		element.click();

	}

	
	
	public static void insertValue(WebElement element, String value) {
		
		element.sendKeys(value);

	}
	
	public static void tapByCoOrdinates(int xOffset, int yOffset) {
		
		action = new TouchAction(driver);
		
		action.tap(PointOption.point(xOffset, yOffset));
		
	}
	
	public static void taybyElement(ElementOption element) {
		
		action = new TouchAction(driver);
		action.tap(TapOptions.tapOptions().withElement(element));
		

	}
	
	
	public static void scrollDown() {
		
		action = new TouchAction(driver);
		
		driver.manage().logs().get("sf");
		
		Dimension size = driver.manage().window().getSize();
		
		int height = size.getHeight();
		
		
		int startheight = (int)(height*0.8);
		
		int endheight = (int)(height*0.2);		
		
		action.longPress(PointOption.point(0, startheight)).moveTo(PointOption.point(0, endheight)).release().perform();
	
	}
	
	
	
	public static void scrollTop() {
		
		action = new TouchAction(driver);
		
		Dimension size = driver.manage().window().getSize();
		
		int height = size.getHeight();
		
		int startHeight = (int)(height*0.2);
		
		int endHeight = (int)(height*0.8);
		
		action.longPress(PointOption.point(0, startHeight)).moveTo(PointOption.point(0, endHeight)).release().perform();
		
		


	}
	
	public static void scrollRight() {
		
		action = new TouchAction(driver);
		
		Dimension size = driver.manage().window().getSize();
		
		int width = size.getWidth();
		
		int startpoint = (int)(width*0.8);
		
		int endPoint = (int)(width*0.2);
		
		action.longPress(PointOption.point(startpoint, 0)).moveTo(PointOption.point(endPoint, 0)).release().perform();
	
	}
	
	
	public static void scrollLeft() {

		action = new TouchAction(driver);
		
		Dimension size = driver.manage().window().getSize();
		
		int width = size.getWidth();
		
		int startwidth = (int)(width*0.2);
		
		int endwidth = (int)(width*0.8);
		
		action.longPress(PointOption.point(startwidth, 0)).moveTo(PointOption.point(endwidth, 0)).release().perform();
		
	}
	
	
	public static void fillo() {
	

	}
	
	
	
	
	
	
	
	
	
	
	
}
