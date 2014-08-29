package org.nasdanika.examples.bank.ui.driver.pages.impl.customer;

import org.nasdanika.examples.bank.ui.driver.pages.customer.CustomerHome;
import org.nasdanika.webtest.Wait;
import org.openqa.selenium.WebDriver;

@Wait(id="banner")
public class CustomerHomeImpl extends CustomerPageImpl implements CustomerHome {

	public CustomerHomeImpl(WebDriver driver) {
		super(driver);
	}


}
