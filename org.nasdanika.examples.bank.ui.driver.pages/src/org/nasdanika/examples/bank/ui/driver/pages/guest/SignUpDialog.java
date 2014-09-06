package org.nasdanika.examples.bank.ui.driver.pages.guest;

import org.nasdanika.webtest.Page;
import org.openqa.selenium.WebDriver;

/**
 * New customer sign-up dialog.
 * @author Pavel Vlasov
 *
 */
public interface SignUpDialog extends Page<WebDriver> {

	SignUpDialog enterOnlineId(String onlineId);

	SignUpDialog enterName(String name);

	SignUpDialog enterPassword(String password);

	SignUpDialog enterPasswordConfirmation(String passwordConfirmation);

	Page<WebDriver> clickSignUp();
	
	GuestHome clickCancel();

	String getErrorMessage();

}
