package org.nasdanika.examples.bank.ui.driver.pages.guest;

import org.nasdanika.webtest.Description;
import org.nasdanika.webtest.Page;
import org.nasdanika.webtest.Title;

@Title("Guest Home Page")
@Description("Page class for testing guest home page")
public interface GuestHome extends Page {
	
	/**
	 * Navigates to the home page.
	 */
	@Description("Navigates to the home page")
	void open();
	
	void enterOnlineId(String onlineId);
	
	void enterPassword(String password);
	
	/**
	 * Clicks sign-in button.
	 * @return Customer home if sign-in was successful, this page if input validation fails, or authentication failed dialog 
	 * if incorrect credentials were provided.
	 */
	Page clickSignIn();

	SignUpDialog clickSignUp();	

}
