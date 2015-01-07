package de.hdm.getthepoint.client.ui.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Wissenstest extends Composite {

	private static WissenstestUiBinder uiBinder = GWT
			.create(WissenstestUiBinder.class);

	interface WissenstestUiBinder extends UiBinder<Widget, Wissenstest> {
	}

	public Wissenstest() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
