package de.hdm.getthepoint.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

import de.hdm.getthepoint.client.ui.widgets.Verwaltung;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Getthepoint implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	final Verwaltung verw = new Verwaltung();

	/**
	 * This is the entry point method.
	 */
	@Override
	public void onModuleLoad() {

		RootPanel.get("content").add(verw);
	}
}