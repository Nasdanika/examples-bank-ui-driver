package org.nasdanika.examples.bank.ui.driver.pages;

import org.nasdanika.examples.bank.ui.driver.pages.customer.CustomerHome;
import org.nasdanika.examples.bank.ui.driver.pages.guest.GuestHome;
import org.openqa.selenium.WebDriver;

public interface BankPageFactory {
	
	GuestHome createGuestHome(WebDriver webDriver);

	CustomerHome createCustomerHome(WebDriver webDriver);
	
}
