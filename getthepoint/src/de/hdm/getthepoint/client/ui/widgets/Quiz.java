package de.hdm.getthepoint.client.ui.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class Quiz extends Composite implements HasText {

	private static QuizUiBinder uiBinder = GWT.create(QuizUiBinder.class);
	@UiField Hyperlink hyperlink;
		
	Verwaltung wiVerwaltung = new Verwaltung();
	

	interface QuizUiBinder extends UiBinder<Widget, Quiz> {
	}

	public Quiz() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	Button button;
	
	public Quiz(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		button.setText(firstName);
	}

	public void setText(String text) {
		button.setText(text);
	}

	public String getText() {
		return button.getText();
	}

	@UiHandler("hyperlink")
	void onHyperlinkClick(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(wiVerwaltung);
	}
}
