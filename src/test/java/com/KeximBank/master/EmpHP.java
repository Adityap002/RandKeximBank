package com.KeximBank.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmpHP {
	// Element property
	// Emp home button for POM
	@FindBy(xpath = "//a[@href='adminflow.aspx']")
	WebElement empHomeBtn;

	// Emp new emp button
	@FindBy(id = "BtnNew")
	WebElement newEmp;

	// Element action
	// click on emp home btn
	public void clickOnHomeBtn() {
		empHomeBtn.click();
	}

	// Click on new Emp button
	public void clickOnNewEmp() {
		newEmp.click();
	}

}
