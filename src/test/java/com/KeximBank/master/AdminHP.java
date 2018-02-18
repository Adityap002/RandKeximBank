package com.KeximBank.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminHP {
	
	//Element properties
	//Branches element for POM
	@FindBy (xpath = "//a[@href='admin_banker_master.aspx']")
	WebElement branchesBtn;
	
	//Roles Element
	@FindBy (xpath = "//a[@href='Admin_Roles_details.aspx']")
	WebElement rolesBtn;
	
	//Users Element
	@FindBy (xpath = "//a[@href='userdetails.aspx']")
	WebElement usersBtn;
	
	//Employee Element
	@FindBy (xpath = "//a[@href='Admin_Emp_details.aspx']")
	WebElement empBtn;
	
	//Element action
	public void clickOnBranchesBtn(){
		branchesBtn.click();
	}
	
	public void clickOnRolesBtn(){
		rolesBtn.click();
	}
	
	public void clickOnUsersBtn(){
		usersBtn.click();
	}
	
	public void clickOnEmpBtn(){
		empBtn.click();
	}

}
