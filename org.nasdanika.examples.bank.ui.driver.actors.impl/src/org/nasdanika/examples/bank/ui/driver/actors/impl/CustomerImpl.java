package org.nasdanika.examples.bank.ui.driver.actors.impl;

import org.nasdanika.examples.bank.ui.driver.actors.BankActorFactory;
import org.nasdanika.examples.bank.ui.driver.actors.Customer;
import org.nasdanika.examples.bank.ui.driver.pages.customer.CustomerHome;
import org.nasdanika.examples.bank.ui.driver.pages.customer.CustomerPage;
import org.nasdanika.webtest.Actor;
import org.nasdanika.webtest.Page;
import org.openqa.selenium.WebDriver;

class CustomerImpl implements Customer {
	
	private Page<WebDriver> currentPage;
	private WebDriver webDriver;
	private BankActorFactory factory;

	CustomerImpl(BankActorFactory factory, WebDriver webDriver, CustomerHome homePage) {
		this.factory = factory;
		this.currentPage = homePage;
		this.webDriver = webDriver;
	}

	@Override
	public Page<WebDriver> getCurrentPage() {
		return currentPage;
	}

	@Override
	public Actor<WebDriver> signOut(boolean confirm) {
		CustomerPage customerPage = (CustomerPage) currentPage;
		customerPage.clickSignOut();
		Page<WebDriver> page = customerPage.confirmSignOut(confirm);
		if (page instanceof CustomerPage) {
			currentPage = page;
			return this;
		}
		
		return factory.createGuest(webDriver); // Should have gone to the guest home.
	}
	

}
