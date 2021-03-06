package org.nasdanika.examples.bank.ui.driver.pages.impl.guest;

import org.nasdanika.examples.bank.ui.driver.pages.guest.GuestHome;
import org.nasdanika.examples.bank.ui.driver.pages.guest.SignUpDialog;
import org.nasdanika.examples.bank.ui.driver.pages.impl.BankPageFactoryImpl;
import org.nasdanika.examples.bank.ui.driver.pages.impl.customer.CustomerHomeImpl;
import org.nasdanika.webtest.Page;
import org.nasdanika.webtest.ReflectivePageFragmentBase;
import org.nasdanika.webtest.Screenshot;
import org.nasdanika.webtest.WebTestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GuestHomeImpl extends ReflectivePageFragmentBase<WebDriver> implements GuestHome {
		
	private BankPageFactoryImpl factory;
	private WebDriver webDriver;	
	private WebDriverWait webDriverWait;

	public GuestHomeImpl(WebDriver webDriver) {
		this.webDriver = webDriver;
		webDriverWait = new WebDriverWait(webDriver, 3);
	}
	
	public void setFactory(BankPageFactoryImpl factory) {
		this.factory = factory;
	}
	
	private WebElement onlineId;
	private WebElement password;
	private WebElement signInButton;
	
	private WebElement signUpMenuItem;
	
	@FindBy(css = "body > div.panel.panel-info > div.panel-body > nav > div > div.navbar-header > button")
	private WebElement navBarToggleButton;

	@Override
	public void enterOnlineId(String onlineId) {
		if (!this.onlineId.isDisplayed() && navBarToggleButton.isDisplayed()) {
			navBarToggleButton.click();
			webDriverWait.until(ExpectedConditions.visibilityOf(this.onlineId));
		}
		if (onlineId==null) {
			this.onlineId.clear();
		} else {
			this.onlineId.sendKeys(onlineId);
		}
	}

	@Override
	public void enterPassword(String password) {
		if (!this.password.isDisplayed() && navBarToggleButton.isDisplayed()) {
			navBarToggleButton.click();
			webDriverWait.until(ExpectedConditions.visibilityOf(this.password));
		}
		if (password==null) {
			this.password.clear();
		} else {
			this.password.sendKeys(password);
		}
	}

	@Override
	public Page<WebDriver> clickSignIn() {
		if (!signInButton.isDisplayed() && navBarToggleButton.isDisplayed()) {
			navBarToggleButton.click();
			webDriverWait.until(ExpectedConditions.visibilityOf(signInButton));
		}
		this.signInButton.click();
		try {
			return WebTestUtil.initElements(webDriver, CustomerHomeImpl.class);
		} catch (WebDriverException e) { 
			try {
				return WebTestUtil.initElements(webDriver, SignInFailedDialogImpl.class);
			} catch (WebDriverException e1) {
				return this;
			}
		}
	}

	@Override
	public WebDriver getWebDriver() {
		return webDriver;
	}

	/**
	 * Before screenshot is suppressed as it is irrelevant.
	 */
	@Override
	@Screenshot({Screenshot.When.AFTER, Screenshot.When.EXCEPTION})
	public void open() {
		getWebDriver().get(factory.getBaseURL()+"/index.html");
		new WebDriverWait(webDriver, 3).until(ExpectedConditions.visibilityOfElementLocated(By.id("main")));		
	}

	@Override
	public SignUpDialog clickSignUp() {
		if (!signUpMenuItem.isDisplayed() && navBarToggleButton.isDisplayed()) {
			navBarToggleButton.click();
			webDriverWait.until(ExpectedConditions.visibilityOf(signUpMenuItem));
		}
		signUpMenuItem.click();
		return WebTestUtil.initElements(webDriver, SignUpDialogImpl.class);
	}

}
