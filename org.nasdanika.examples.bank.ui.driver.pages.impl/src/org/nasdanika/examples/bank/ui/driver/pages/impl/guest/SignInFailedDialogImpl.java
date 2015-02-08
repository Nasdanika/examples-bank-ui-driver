package org.nasdanika.examples.bank.ui.driver.pages.impl.guest;

import org.nasdanika.examples.bank.ui.driver.pages.guest.SignInFailedDialog;
import org.nasdanika.webtest.ReflectivePageFragmentBase;
import org.nasdanika.webtest.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Wait(id="authentication-failed-modal")
public class SignInFailedDialogImpl extends ReflectivePageFragmentBase<WebDriver> implements SignInFailedDialog {
	
	private WebDriver driver;

	public SignInFailedDialogImpl(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(id = "authentication-failed-modal")
	private WebElement dialog;

	@Override
	public WebDriver getWebDriver() {
		return driver;
	}

}
