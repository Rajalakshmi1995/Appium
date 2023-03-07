package org.project;

import java.awt.Point;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Sleeper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class Uber {

	
	public static AppiumDriver driver;
	
	public static TouchAction action;
	
	public static void scrollDown() {
		
		Dimension size = driver.manage().window().getSize();
		
		int height = size.getHeight();
		int endheight =  (int) (height * 0.1);
		int startheight = (int) (height*0.8);
		 action =  new TouchAction(driver);
		 
		 
		action.longPress(PointOption.point(0, startheight)).moveTo(PointOption.point(0, endheight)).release().perform();
      
	}
	
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		

		DesiredCapabilities capabilites = new DesiredCapabilities();
		capabilites.setCapability("deviceName", "GalaxyF62");
		capabilites.setCapability("platformName", "Android");
		capabilites.setCapability("platformVersion", "13");
		capabilites.setCapability("appPackage", "com.ubercab");
		capabilites.setCapability("appActivity", "com.ubercab.presidio.app.core.root.RootActivity");
		
		URL service = new URL("http://localhost:4723/wd/hub");
		 
		 driver = new AppiumDriver(service, capabilites);
		
		System.out.println("Application launched");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		//driver.quit();
	
		WebElement preciseLocation = driver.findElement(By.xpath("(//*[@class=\"android.widget.RadioButton\"])[1]"));
		
		preciseLocation.click();
		
		
		WebElement whileusingThisApp = driver.findElement(By.xpath("(//*[@class=\"android.widget.Button\"])[1]"));
		
		whileusingThisApp.click();
		
		WebElement GetStarted = driver.findElement(By.id("welcome_screen_continue"));
		GetStarted.click();

		WebElement PhoneNumber = driver.findElement(By.xpath("(//*[@class=\"android.widget.LinearLayout\"])[3]"));
		PhoneNumber.click();
		
		//WebElement Continuebtn = driver.findElement(By.xpath("(//*[@class=\"android.widget.Button\"])[1]"));
		//Continuebtn.click();
		
		WebElement Google = driver.findElement(By.xpath("(//*[@class=\"android.widget.Button\"])[2]"));
		Google.click();
		
		WebElement gmail = driver.findElement(By.xpath( "(//*[@class= \"android.widget.LinearLayout\"])[5]"));
		gmail.click();
		System.out.println("uber is launched");
		
		
		Thread.sleep(9000);
		
		action = new TouchAction(driver);
		
		action.tap(PointOption.point(574, 682)).perform();
		
		Thread.sleep(5000);
		WebElement FoodBtn = driver.findElement(By.xpath("(//*[@class=\"android.widget.ImageView\"])[2]"));
		FoodBtn.click();
		Thread.sleep(9000);
		
		WebElement search = driver.findElement(By.xpath("(//*[@class=\"android.widget.Button\"])[5]"));
		search.click();	
		scrollDown();
		
		WebElement Indian = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Indian\"]"));
		Indian.click();
		Thread.sleep(9000);
		scrollDown();
		
		
		WebElement BriyaniPot = driver.findElement(By.xpath("(//*[@class=\"android.view.View\"])[37]"));
		BriyaniPot.click();
		
		 //action = new TouchAction(driver);
		
			//	action.tap(PointOption.point(504, 671)).perform();
		
		
		
		Thread.sleep(9000);
		System.out.println("food is launched");
		
		
		
		
		
	}

}
