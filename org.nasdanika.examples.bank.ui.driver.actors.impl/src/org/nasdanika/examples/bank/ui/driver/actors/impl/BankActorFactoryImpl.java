package org.nasdanika.examples.bank.ui.driver.actors.impl;

import org.nasdanika.examples.bank.ui.driver.pages.BankPageFactory;
import org.nasdanika.examples.bank.ui.driver.pages.customer.CustomerHome;
import org.nasdanika.examples.bank.ui.driver.actors.BankActorFactory;
import org.nasdanika.examples.bank.ui.driver.actors.Customer;
import org.nasdanika.examples.bank.ui.driver.actors.Guest;
import org.nasdanika.webtest.AbstractNasdanikaWebTestRunner;
import org.openqa.selenium.WebDriver;
import org.osgi.service.component.ComponentContext;

public class BankActorFactoryImpl implements BankActorFactory {

	private BankPageFactory pageFactory;

	public void setPageFactory(BankPageFactory pageFactory) {
		this.pageFactory = AbstractNasdanikaWebTestRunner.proxyPageFactory(pageFactory);
	}

	@Override
	public Guest createGuest(WebDriver webDriver) {		
		return new GuestImpl(this, webDriver);
	}

	@Override
	public BankPageFactory getPageFactory() {
		return pageFactory;
	}

	@Override
	public Customer createCustomer(WebDriver webDriver, CustomerHome customerHome) {
		return new CustomerImpl(this, webDriver, customerHome);
	}
	
	
	public void activate(ComponentContext context) {
		System.out.println("Bank Actor Factory Component activated");
	}

}
