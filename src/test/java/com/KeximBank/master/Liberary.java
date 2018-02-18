package com.KeximBank.master;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Liberary {
	public static WebDriver driver;
	public static String expectedValue;
	public static String actualValue;
	public static Alert alert;
	public static Properties prop;
	public static FileInputStream fis;
	
	public void openApp() throws IOException{
		//Declare and load properties file
		String filePath = "G:\\KeximBank\\KeximBank\\src\\com\\KeximBank\\properties\\KeximBankOR.properties";
		
		prop = new Properties();
		fis = new FileInputStream(filePath);
		
		prop.load(fis);
		
		String expectedValue = "KEXIM Bank";
		
		//Instantiated FireFox browser
		driver = new FirefoxDriver();
		
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
	
	public void adminLogin(String username, String password){
		
		
		//Username element with action
		driver.findElement(By.id(prop.getProperty("uName"))).sendKeys(username);
		
		//Password element with action
		driver.findElement(By.id(prop.getProperty("uPwd"))).sendKeys(password);
		
		//Login button with action
		driver.findElement(By.id(prop.getProperty("loginBtn"))).click();
		
		//validation of login
		String expectedValue = "Welcome to Admin";
		String actualValue = driver.findElement(By.xpath(prop.getProperty("actualScript"))).getText();
		System.out.println(actualValue);
		
		if (actualValue.equals(expectedValue)){
			System.out.println("Admin successfully login");
		}else{
			System.out.println("Error in login");
		}
	}
	
	public String brnches(String bName, String address1, String zipcode, String country, String state, String city) throws InterruptedException{
		String expectedValue = "Sucessfully";
		
		//Click on Branches button
		driver.findElement(By.xpath(prop.getProperty("brnachesBtn"))).click();
		
		//Click on new Branch button
		driver.findElement(By.id(prop.getProperty("newBrnachBtn"))).click();	
		
		//Enter Branch Name
		driver.findElement(By.id(prop.getProperty("BranchName"))).sendKeys(bName);
				
		//Enter address1
		driver.findElement(By.id(prop.getProperty("Address1"))).sendKeys(address1);
		
		//Enter ZipCode
		driver.findElement(By.id(prop.getProperty("ZipCode"))).sendKeys(zipcode);
		
		Thread.sleep(1000);
		//Select value in Country
		Select cntry = new Select(driver.findElement(By.id(prop.getProperty("Country"))));
		cntry.selectByVisibleText(country);
		
		Thread.sleep(1000);
		//Select value in state
		Select bState = new Select(driver.findElement(By.id(prop.getProperty("State"))));
		bState.selectByVisibleText(state);
		
		Thread.sleep(1000);
		//Select value in City
		Select bCity = new Select(driver.findElement(By.id(prop.getProperty("City"))));
		bCity.selectByVisibleText(city);
		
		//Click on Submit button
		driver.findElement(By.id(prop.getProperty("SubmitBtn"))).click();
		
		Alert alert = driver.switchTo().alert();
		String actualValue = alert.getText();
		
			
		if(actualValue.contains(expectedValue)){
			System.out.println("Successfully new Branch created");
		}else{
			System.out.println("Branch is already exist");
		}
		alert.accept();
		
		//Back to home page
		driver.findElement(By.xpath(prop.getProperty("homepagelink"))).click();
		Thread.sleep(2000);
		return actualValue;	
	}
	
	public String roles(String rName, String rType) throws InterruptedException {
		String expectedValue = "Sucessfully";
		
		//Click on roles button
		driver.findElement(By.xpath(prop.getProperty("rolesBtn"))).click();
		
		//Click on new Roles button
		driver.findElement(By.id(prop.getProperty("newRolesBtn"))).click();
		
		//Enter Role Name
		driver.findElement(By.id(prop.getProperty("rolename"))).sendKeys(rName);
		
		//Select Role type
		Select roleType = new Select(driver.findElement(By.id(prop.getProperty("roletype"))));
		roleType.selectByVisibleText(rType);
		
		//Roles Submit button
		driver.findElement(By.id(prop.getProperty("roleSubmit"))).click();
		
		Alert alert = driver.switchTo().alert();
		String actualValue = alert.getText();
		
		if(actualValue.contains(expectedValue)){
			System.out.println("Successfully new Roles created");
		}else{
			System.out.println("Role is already exist");
		}
		alert.accept();
		
		
		//Back to home page
		driver.findElement(By.xpath(prop.getProperty("homepagelink"))).click();
		Thread.sleep(2000);
		return actualValue;
	}
	
	public void logoutApp(){
		String expectedValue = "KEXIM Bank";
		
		driver.findElement(By.xpath(prop.getProperty("logout"))).click();
		
		//Validation of user logout

		String actualValue = driver.findElement(By.xpath(prop.getProperty("launchpage"))).getText();
		
		if(expectedValue.equals(actualValue)){
			System.out.println("Admin is successfully logout");
		} else{
			System.out.println("Admin unable to logout");
		}
	}
	
	public void quitBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	
	public String employee(String eName, String pwd, String eRole, String eBranch) throws InterruptedException {
		String expectedValue = "Successfully";
		
		//Click on employee button
		driver.findElement(By.xpath(prop.getProperty("empBtn"))).click();
		
		//Click on new Employee button
		driver.findElement(By.id(prop.getProperty("newEmpBtn"))).click();
		
		//Enter Employee Name
		driver.findElement(By.id(prop.getProperty("empname"))).sendKeys(eName);
		
		//Enter Login Pwd
		driver.findElement(By.id(prop.getProperty("loginpwd"))).sendKeys(pwd);
		
		//Select emp Role type
		Select empRole = new Select(driver.findElement(By.id(prop.getProperty("emproles"))));
		empRole.selectByVisibleText(eRole);
		
		//Select Branch type
		Select empBranch = new Select(driver.findElement(By.id(prop.getProperty("empbranch"))));
		empBranch.selectByVisibleText(eBranch);
		
		//Roles Submit button
		driver.findElement(By.id(prop.getProperty("empSubmitBtn"))).click();
		
		Alert alert = driver.switchTo().alert();
		String actualValue = alert.getText();
		
		if(actualValue.contains(expectedValue)){
			System.out.println("Successfully new Employee created");
		}else{
			System.out.println("Employee is already exist");
		}
		alert.accept();
		
		
		//Back to home page
		driver.findElement(By.xpath(prop.getProperty("homepagelink"))).click();
		Thread.sleep(2000);
		return actualValue;
	}
}
