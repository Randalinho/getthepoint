package de.hdm.getthepoint.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.hdm.getthepoint.shared.bo.KategorieBo;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void greetServer(String input, AsyncCallback<String> callback)
			throws IllegalArgumentException;

	void getAllKategorien(AsyncCallback<List<KategorieBo>> callback);
}
