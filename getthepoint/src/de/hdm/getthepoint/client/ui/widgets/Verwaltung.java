package de.hdm.getthepoint.client.ui.widgets;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.HasData;

import de.hdm.getthepoint.shared.GetThePoint;
import de.hdm.getthepoint.shared.GetThePointAsync;
import de.hdm.getthepoint.shared.bo.FrageBo;
import de.hdm.getthepoint.shared.bo.KategorieBo;

public class Verwaltung extends Composite {

	private static BackendUiBinder uiBinder = GWT.create(BackendUiBinder.class);

	List<KategorieBo> katContainer = null;
	List<FrageBo> fraContainer = null;

	GetThePointAsync getThePoint = GWT.create(GetThePoint.class);

	@UiField
	CellTable<FrageBo> cellTable = new CellTable<FrageBo>();

	@UiField
	ListBox libkategorie;

	interface BackendUiBinder extends UiBinder<Widget, Verwaltung> {
	}

	public Verwaltung() {

		getThePoint.init(new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(Void result) {
				// TODO Auto-generated method stub

			}
		});

		initWidget(uiBinder.createAndBindUi(this));

		// coltext.setSortable(true);

		getThePoint.getAllKategorien(new AsyncCallback<List<KategorieBo>>() {

			@Override
			public void onSuccess(List<KategorieBo> result) {
				katContainer = result;
				for (KategorieBo kategorie : result) {
					libkategorie.addItem(kategorie.getBezeichnung());
				}

			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}
		});

		TextColumn<FrageBo> coltext = new TextColumn<FrageBo>() {

			@Override
			public String getValue(FrageBo object) {
				// TODO Auto-generated method stub
				return object.getText();
			}
		};

		TextColumn<FrageBo> colschwierigkeit = new TextColumn<FrageBo>() {

			@Override
			public String getValue(FrageBo object) {
				// TODO Auto-generated method stub
				return String.valueOf(object.getSchwierigkeit());
			}
		};

		cellTable.addColumn(coltext, "Frage");
		cellTable.addColumn(colschwierigkeit, "Schwierigkeit");

		cellTable.setVisibleRange(0, 3);
		// katContainer.get(libkategorie.getSelectedIndex()).getId()

		getThePoint.getFragenByKategorie(1, new AsyncCallback<List<FrageBo>>() {

			@Override
			public void onSuccess(List<FrageBo> result) {
				fraContainer = result;

			}

			@Override
			public void onFailure(Throwable caught) {
				System.out.println("Fehler");

			}
		});

		AsyncDataProvider<FrageBo> dataProvider = new AsyncDataProvider<FrageBo>() {

			@Override
			protected void onRangeChanged(HasData<FrageBo> display) {

//				int start = display.getVisibleRange().getStart();
//				int end = start + display.getVisibleRange().getLength();
//				end = end >= fraContainer.size() ? fraContainer.size() : end;
//				List<FrageBo> sub = fraContainer.subList(start, end);
//				updateRowData(start, sub);

			}
		};

//		dataProvider.addDataDisplay(cellTable);
//		dataProvider.updateRowCount(fraContainer.size(), true);

		SimplePager pager = new SimplePager();
		pager.setDisplay(cellTable);

		// // Make the name column sortable.
		// nameColumn.setSortable(true);
		//
		// // Create address column.
		// TextColumn<Contact> addressColumn = new TextColumn<Contact>() {
		// @Override
		// public String getValue(Contact contact) {
		// return contact.address;
		// }
		// };
		//
		// // Add the columns.
		// cellTable.addColumn(nameColumn, "Name");
		// // cellTable.addColumn(addressColumn, "Adresse");
		//
		// // Set the total row count. You might send an RPC request to
		// determine
		// // the
		// // total row count.
		// cellTable.setRowCount(CONTACTS.size(), true);
		//
		// // Set the range to display. In this case, our visible range is
		// smaller
		// // than
		// // the data set.
		// cellTable.setVisibleRange(0, 3);
		//
		// // Associate an async data provider to the table
		// // XXX: Use AsyncCallback in the method onRangeChanged
		// // to actaully get the data from the server side
		// AsyncDataProvider<Contact> provider = new
		// AsyncDataProvider<Contact>() {
		// @Override
		// protected void onRangeChanged(HasData<Contact> display) {
		// int start = display.getVisibleRange().getStart();
		// int end = start + display.getVisibleRange().getLength();
		// end = end >= CONTACTS.size() ? CONTACTS.size() : end;
		// List<Contact> sub = CONTACTS.subList(start, end);
		// updateRowData(start, sub);
		// }
		// };
		//
		// provider.addDataDisplay(cellTable);
		// provider.updateRowCount(CONTACTS.size(), true);
		//
		// SimplePager pager = new SimplePager();
		// pager.setDisplay(cellTable);
		//
		// // VerticalPanel vp = new VerticalPanel();
		// // vp.add(cellTable);
		// // vp.add(pager);
		// //
		// // // Add it to the root panel.
		// // RootPanel.get().add(vp);

	}

}
