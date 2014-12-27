package de.hdm.getthepoint.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import de.hdm.getthepoint.client.ui.widgets.Quiz;
import de.hdm.getthepoint.shared.GetThePoint;
import de.hdm.getthepoint.shared.GetThePointAsync;
import de.hdm.getthepoint.shared.bo.FrageBo;

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
	GetThePointAsync getThePoint = GWT.create(GetThePoint.class);
	final Quiz myQuiz = new Quiz();
	FrageBo frage;
	String string;

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		// getThePoint.getFragebyId(1, new AsyncCallback<FrageBo>() {
		//
		// @Override
		// public void onSuccess(FrageBo result) {
		// frage = result;
		//
		// }
		//
		// @Override
		// public void onFailure(Throwable caught) {
		// System.out.println("Failed to Load Frage by Id");
		//
		// }
		// });
		
		// final Label errorLabel = new Label();
//		RootPanel.get().add(nameField);
		RootPanel.get().add(myQuiz);
	}
}