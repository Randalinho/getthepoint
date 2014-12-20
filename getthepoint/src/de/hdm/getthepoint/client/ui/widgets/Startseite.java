package de.hdm.getthepoint.client.ui.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class Startseite extends Composite implements HasText {

	private static StartseiteUiBinder uiBinder = GWT
			.create(StartseiteUiBinder.class);

	@UiField Hyperlink hyperlink_1;
	Verwaltung wiVerwaltung = new Verwaltung();

	interface StartseiteUiBinder extends UiBinder<Widget, Startseite> {
	}

	public Startseite() {
		initWidget(uiBinder.createAndBindUi(this));
	}


	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setText(String text) {
		// TODO Auto-generated method stub
		
	}
	@UiHandler("hyperlink_1")
	void onHyperlink_1Click(ClickEvent event) {
		RootPanel.get("quiz").add(wiVerwaltung);
	}
}
