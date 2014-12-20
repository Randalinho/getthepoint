package de.hdm.getthepoint.client.ui.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Fragenpool extends Composite {

	private static FragenpoolUiBinder uiBinder = GWT
			.create(FragenpoolUiBinder.class);

	interface FragenpoolUiBinder extends UiBinder<Widget, Fragenpool> {
	}

	public Fragenpool() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
