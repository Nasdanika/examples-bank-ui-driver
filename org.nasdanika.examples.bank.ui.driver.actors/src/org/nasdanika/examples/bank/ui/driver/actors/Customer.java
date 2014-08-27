package org.nasdanika.examples.bank.ui.driver.actors;

import org.nasdanika.webtest.Actor;
import org.openqa.selenium.WebDriver;

public interface Customer extends Actor<WebDriver> {
	
	Actor<WebDriver> signOut(boolean confirm);

}
