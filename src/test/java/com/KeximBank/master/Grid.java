package com.KeximBank.master;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Grid {

	public static void main(String[] args) throws Exception {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("firefox");
		cap.setPlatform(Platform.WINDOWS);
		
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://10.1.76.175:4444/wd/hub"), cap);
		
			//Declare and load properties file
			String filePath = "G:\\KeximBank\\KeximBank\\src\\com\\KeximBank\\properties\\KeximBankOR.properties";
			
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(filePath);
			
			prop.load(fis);
			
			String expectedValue = "KEXIM Bank";
			
			//Maximize browser
			driver.manage().window().maximize();
			
			//Launch Application
			driver.get(prop.getProperty("URL"));
			
			String actualValue = driver.findElement(By.xpath(prop.getProperty("launchpage"))).getText();
			
			if(expectedValue.equals(actualValue)){
				System.out.println("Application successfully launch");
			} else{
				System.out.println("Application not launch need to check");
			}
		}
}
