package com.KeximBank.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class NewEmpForm {

	@FindBy(id = "txtUname")
	WebElement eName;
	
	@FindBy(id = "txtLpwd")
	WebElement ePwd;
	
	@FindBy(id = "lst_Roles")
	WebElement eRole;
	
	@FindBy(id = "lst_Branch")
	WebElement eBranch;
	
	@FindBy (id = "BtnSubmit")
	WebElement empSubmit;
	
	@FindBy (id = "btnreset")
	WebElement empReset;
	
	@FindBy (id = "btnCancel")
	WebElement empCancel;

	public void enterEmpName(String empname) {
		eName.sendKeys(empname);
	}

	public void enterEmpPwd(String emppwd) {
		ePwd.sendKeys(emppwd);
	}

	public void enterEmpRoles(String emproles) {
		Select empRoles = new Select(eRole);
		empRoles.selectByVisibleText(emproles);
	}

	public void enterEmpBranch(String emproles) {
		Select empBranch = new Select(eBranch);
		empBranch.selectByVisibleText(emproles);
	}
	
	public void clickOnSubmitBtn() {
		empSubmit.click();
	}
	
	public void clickOnResetBtn() {
		empReset.click();
	}
	
	public void clickOnCancelBtn() {
		empCancel.click();
	}

}
