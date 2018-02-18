package com.KeximBank.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class NewRoleForm {
	// Element Properties
	// Role Name element
	@FindBy(id = "txtRname")
	WebElement rName;

	// Role Desc element
	@FindBy(id = "txtRDesc")
	WebElement rDesc;

	// Role Type Element
	@FindBy(id = "lstRtypeN")
	WebElement rType;

	// Role Submit button
	@FindBy(id = "btninsert")
	WebElement roleSubmitBtn;

	// Role Reset button
	@FindBy(id = "Btn_Reset")
	WebElement roleResetBtn;

	// Role Cancel Button
	@FindBy(id = "Btn_cancel")
	WebElement roleCanelBtn;

	// Element action
	// Role name action - enter value
	public void enterDatainRoleName(String rname) {
		rName.sendKeys(rname);
	}

	// Role Desc action - enter value
	public void enterDatainRoleDesc(String rdesc) {
		rDesc.sendKeys(rdesc);
	}

	// Role Tyepe action - Select value
	public void selectDatainRoleType(String rdesc) {
		Select roletype = new Select(rType);
		roletype.selectByVisibleText(rdesc);
	}

	// Role Submit button - click on submit button
	public void clickOnSubmitButton() {
		roleSubmitBtn.click();
	}

	// Role Reset button - click on submit button
	public void clickOnResetButton() {
		roleResetBtn.click();
	}

	// Role Cancel button - click on submit button
	public void clickOnCancelButton() {
		roleCanelBtn.click();
	}
}
