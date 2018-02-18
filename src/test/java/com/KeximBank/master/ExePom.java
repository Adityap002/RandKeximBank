package com.KeximBank.master;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class ExePom {
	@Test
	public void pomRole(){
		String url = "http://srssprojects.in/home.aspx";
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.get(url);
		
		AdminHP adminHomePage = PageFactory.initElements(driver, AdminHP.class);
		KeximBankHP KeximHP = PageFactory.initElements(driver, KeximBankHP.class);
		RolesHP rolesHomePage = PageFactory.initElements(driver, RolesHP.class);
		NewRoleForm newRolesFormPage = PageFactory.initElements(driver, NewRoleForm.class);
		
		//Admin login
		KeximHP.login("Admin", "Admin");
		
		//click on Roles button on home page
		adminHomePage.clickOnRolesBtn();
		
		//Click on New Role button
		rolesHomePage.clickOnNewRoleBtn();
		
		//Create new Roles 
		newRolesFormPage.enterDatainRoleName("Java Engineer1");
		newRolesFormPage.selectDatainRoleType("E");
		newRolesFormPage.clickOnSubmitButton();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
		//back to home page
		rolesHomePage.clickOnRoleHomeBtn();
		
		driver.quit();
	}
	
	@Test
	public void pomEmp(){
		String url = "http://srssprojects.in/home.aspx";
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.get(url);
		
		AdminHP adminHomePage = PageFactory.initElements(driver, AdminHP.class);
		KeximBankHP KeximHP = PageFactory.initElements(driver, KeximBankHP.class);
		EmpHP empHomePage = PageFactory.initElements(driver, EmpHP.class);
		NewEmpForm newEmpFormPage = PageFactory.initElements(driver, NewEmpForm.class);
		
		//Admin login
		KeximHP.login("Admin", "Admin");
		
		//click on Employee button on home page
		adminHomePage.clickOnEmpBtn();
		
		//Click on New Emp button
		empHomePage.clickOnNewEmp();
		
		//Create new Roles from the admin 
		newEmpFormPage.enterEmpName("Pappu");
		newEmpFormPage.enterEmpPwd("@123Pappu");
		newEmpFormPage.enterEmpRoles("IT Head");
		newEmpFormPage.enterEmpBranch("madhapur123456");
		newEmpFormPage.clickOnSubmitBtn();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
		//back to home page
		empHomePage.clickOnHomeBtn();
		
		driver.quit();
	}

}
