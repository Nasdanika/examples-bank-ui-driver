package org.nasdanika.examples.bank.ui.driver.actors;

import org.nasdanika.examples.bank.ui.driver.pages.guest.GuestHome;
import org.nasdanika.webtest.Actor;
import org.nasdanika.webtest.Description;
import org.openqa.selenium.WebDriver;

@Description("Unauthenticated user")
public interface Guest extends Actor<WebDriver> {
	
	/**
	 * 
	 * @param user
	 * @param password
	 * @return Actor for the authenticated user (Customer) if log-in succesful, 
	 * self otherwise.
	 */
	@Description("Enter Online ID and Password and click 'Sign in' button.")
	Actor<WebDriver> signIn(String onlineId, String password);

	/**
	 * Registers new customer.
	 * @param onlineId
	 * @param name
	 * @param password
	 * @param passwordConfirmation
	 * @return Customer if sign-up successful, Guest otherwise.
	 */
	Actor<WebDriver> signUp(String onlineId, String name, String password, String passwordConfirmation);

	GuestHome goHome();

}
