package org.nasdanika.examples.bank.ui.driver.actors;

import org.nasdanika.webtest.Actor;

public interface Customer extends Actor {
	
	Actor signOut(boolean confirm);

}
