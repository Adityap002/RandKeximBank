package com.KeximBank.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class KeximBankHP {
	//Element properties
	
	//Branch list
	@FindBy (id = "drlist")
	WebElement loginBranchDD;
	
	//UserName element
	@FindBy (id = "txtuId") 
	WebElement userName;
	
	//Enter password
	@FindBy (id = "txtPword") 
	WebElement pwd;
	
	//Enter password
	@FindBy (id = "login") 
	WebElement login;
	
	//Login with valid user
	public void selectBranch(String text) {
		Select branchDD = new Select(loginBranchDD);
		branchDD.selectByVisibleText(text);
		
	}
	
	public void login(String username, String password){
		userName.sendKeys(username);
		pwd.sendKeys(password);
		login.click();
	}
}
