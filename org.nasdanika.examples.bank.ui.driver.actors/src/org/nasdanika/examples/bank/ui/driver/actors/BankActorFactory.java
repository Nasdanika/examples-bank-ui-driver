package org.nasdanika.examples.bank.ui.driver.actors;

import org.nasdanika.examples.bank.ui.driver.pages.BankPageFactory;
import org.nasdanika.examples.bank.ui.driver.pages.customer.CustomerHome;
import org.openqa.selenium.WebDriver;

public interface BankActorFactory {
	
	BankPageFactory getPageFactory();
	
	Guest createGuest(WebDriver webDriver);

	Customer createCustomer(WebDriver webDriver, CustomerHome customerHome);		

}
