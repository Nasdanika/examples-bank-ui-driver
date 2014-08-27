package org.nasdanika.examples.bank.ui.driver.pages.customer;

import org.nasdanika.webtest.Page;
import org.openqa.selenium.WebDriver;

/**
 * Base interface for customer pages.
 * @author Pavel Vlasov
 *
 */
public interface CustomerPage extends Page<WebDriver> {
	
	/**
	 * Clicks sign-out link.
	 */
	CustomerPage clickSignOut();
	
	/**
	 * Clicks OK or Cancel in sign-out confirmation dialog.
	 * @param confirm
	 * @return
	 */
	Page<WebDriver> confirmSignOut(boolean confirm);	
	
	/**
	 * @return Text in the nav-bar banner.
	 */
	String getBanner();
	

}
