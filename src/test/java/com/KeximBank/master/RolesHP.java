package com.KeximBank.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RolesHP {
	//Element properties
	
	//new role button
	@FindBy(id = "btnRoles" )
	WebElement newRoleBtn;
	
	//new Role home page Button
	@FindBy (xpath = "//a[@href='adminflow.aspx']")
	WebElement roleHomeButton;
	
	//Element action
	public void clickOnNewRoleBtn(){
		newRoleBtn.click();
	}
	
	public void clickOnRoleHomeBtn(){
		roleHomeButton.click();
	}


}
