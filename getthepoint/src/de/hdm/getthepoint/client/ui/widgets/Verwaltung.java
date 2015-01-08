package de.hdm.getthepoint.client.ui.widgets;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.NoSelectionModel;
import com.google.gwt.view.client.SelectionChangeEvent;

import de.hdm.getthepoint.shared.GetThePoint;
import de.hdm.getthepoint.shared.GetThePointAsync;
import de.hdm.getthepoint.shared.bo.FrageBo;
import de.hdm.getthepoint.shared.bo.KategorieBo;

public class Verwaltung extends Composite {

	private static BackendUiBinder uiBinder = GWT.create(BackendUiBinder.class);

	@UiField
	LayoutPanel panWissenstest;

	@UiField
	LayoutPanel panFragenpool;

	interface BackendUiBinder extends UiBinder<Widget, Verwaltung> {
	}

	public Verwaltung() {

		Wissenstest wissenstestWidget = new Wissenstest();
		panWissenstest = new LayoutPanel();
		panWissenstest.add(wissenstestWidget);
		
		Fragenpool fragenpoolWidget = new Fragenpool();
		panFragenpool = new LayoutPanel();
		panFragenpool.add(fragenpoolWidget);

		initWidget(uiBinder.createAndBindUi(this));

		// coltext.setSortable(true);

	}

}
