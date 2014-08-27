package org.nasdanika.examples.bank.ui.driver.actors.impl;

import org.junit.Assert;
import org.nasdanika.examples.bank.ui.driver.pages.customer.CustomerHome;
import org.nasdanika.examples.bank.ui.driver.pages.guest.GuestHome;
import org.nasdanika.examples.bank.ui.driver.actors.BankActorFactory;
import org.nasdanika.examples.bank.ui.driver.actors.Guest;
import org.nasdanika.webtest.Actor;
import org.nasdanika.webtest.Page;
import org.openqa.selenium.WebDriver;

class GuestImpl implements Guest {

	private BankActorFactory factory;
	private Page<WebDriver> currentPage;
	private WebDriver webDriver;

	GuestImpl(BankActorFactory factory, WebDriver webDriver) {
		this.factory = factory;
		this.webDriver = webDriver;
	}

	@Override
	public Page<WebDriver> getCurrentPage() {
		return currentPage;
	}

	@Override
	public Actor<WebDriver> signIn(String onlineId, String password) {
		GuestHome home = factory.getPageFactory().createGuestHome(webDriver);
		home.enterOnlineId(onlineId);
		home.enterPassword(password);
		currentPage = home.clickSignIn();
		if (currentPage instanceof CustomerHome) {
			return factory.createCustomer(webDriver, (CustomerHome) currentPage);
		}
		return this;
	}

	@Override
	public Actor<WebDriver> signUp(
			String onlineId, 
			String name, 
			String password,
			String passwordConfirmation) {
		GuestHome home = factory.getPageFactory().createGuestHome(webDriver);
		currentPage = home;
		Page<WebDriver> signUpResult = home.clickSignUp()
				.waitToAppear()
				.enterOnlineId(onlineId)
				.enterName(name)
				.enterPassword(password)
				.enterPasswordConfirmation(passwordConfirmation)
				.clickSignUp();

		if (signUpResult instanceof CustomerHome) {
			Assert.assertEquals(name, ((CustomerHome) signUpResult).getBanner());
			return factory.createCustomer(webDriver, (CustomerHome) signUpResult);
		} else {
			currentPage = signUpResult;
		}
		
		return this;
	}
	
	@Override
	public GuestHome goHome() {
		currentPage = factory.getPageFactory().createGuestHome(webDriver);
		((GuestHome) currentPage).open();
		return (GuestHome) currentPage;
	}
	

}
