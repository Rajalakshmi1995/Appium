package org.project;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;

public class practise {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		
		DesiredCapabilities capabilites = new DesiredCapabilities();
		capabilites.setCapability("deviceName", "GalaxyF62");
		capabilites.setCapability("platformName", "Android");
		capabilites.setCapability("platformVersion", "13");
		capabilites.setCapability("appPackage", "com.NokAir.app");
		capabilites.setCapability("appActivity", "com.NokAir.app.MainActivity");
		
		URL service = new URL("http://localhost:4723/wd/hub");
		 
		AppiumDriver driver = new AppiumDriver(service, capabilites);
		
		System.out.println("Application launched");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		//driver.quit();
		
		
		WebElement OnlineCheckIn = driver.findElement(By.id("open_check_in"));
		
		OnlineCheckIn.click();
		
		WebElement BookingNo = driver.findElement(By.xpath("\r\n" + 
				"(//*[@class=\"android.widget.EditText\"])[1]"));
		
		BookingNo.sendKeys("101010");
		
		WebElement LastName = driver.findElement(By.xpath("(//*[@class=\"android.widget.EditText\"])[2]"));
		
		LastName.sendKeys("raji");
		
		WebElement checkin = driver.findElement(By.xpath("//*[@class=\"android.widget.Button\"]"));
		
		checkin.click();
		
		System.out.println("Application is closed");
		
		WebElement errorMessage = driver.findElement(By.xpath("//*[@class=\"android.widget.TextView\"]"));
		
		String FailureMessage = errorMessage.getText();
		
		System.out.println(FailureMessage);
	}

}
