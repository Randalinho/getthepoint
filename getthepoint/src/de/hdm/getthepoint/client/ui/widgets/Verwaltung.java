package de.hdm.getthepoint.client.ui.widgets;

import java.util.Arrays;
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

import de.hdm.getthepoint.shared.bo.KategorieBo;

public class Verwaltung extends Composite {

	private static BackendUiBinder uiBinder = GWT.create(BackendUiBinder.class);

	private static class Contact {
		private final String address;
		private final String name;

		public Contact(String name, String address) {
			this.name = name;
			this.address = address;
		}
	}

	private static List<Contact> CONTACTS = Arrays.asList(new Contact("John",
			"123 Fourth Road"), new Contact("Mary", "222 Lancer Lane"),
			new Contact("Zander", "94 Road Street"));

	GetThePointAsync getThePoint = GWT.create(GetThePoint.class);

	// Create a CellTable.
	@UiField
	CellTable<Contact> cellTable = new CellTable<Contact>();

	@UiField
	ListBox libkategorie;

	interface BackendUiBinder extends UiBinder<Widget, Verwaltung> {
	}

	public Verwaltung() {

		initWidget(uiBinder.createAndBindUi(this));

		libkategorie.addItem("Test");

		getThePoint.getTestString(new AsyncCallback<String>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(String result) {

			}
		});

		getThePoint.getAllKategorien(new AsyncCallback<List<KategorieBo>>() {

			@Override
			public void onSuccess(List<KategorieBo> result) {
				for (KategorieBo kategorie : result) {
					libkategorie.addItem(kategorie.getBezeichnung());
				}

			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}
		});

		// Display 10 rows in one page
		cellTable.setPageSize(10);

		// Create name column.
		TextColumn<Contact> nameColumn = new TextColumn<Contact>() {
			@Override
			public String getValue(Contact contact) {
				return contact.name;
			}
		};

		// Make the name column sortable.
		nameColumn.setSortable(true);

		// Create address column.
		TextColumn<Contact> addressColumn = new TextColumn<Contact>() {
			@Override
			public String getValue(Contact contact) {
				return contact.address;
			}
		};

		// Add the columns.
		cellTable.addColumn(nameColumn, "Name");
		cellTable.addColumn(addressColumn, "Adresse");

		// Set the total row count. You might send an RPC request to determine
		// the
		// total row count.
		cellTable.setRowCount(CONTACTS.size(), true);

		// Set the range to display. In this case, our visible range is smaller
		// than
		// the data set.
		cellTable.setVisibleRange(0, 3);

		// Associate an async data provider to the table
		// XXX: Use AsyncCallback in the method onRangeChanged
		// to actaully get the data from the server side
		AsyncDataProvider<Contact> provider = new AsyncDataProvider<Contact>() {
			@Override
			protected void onRangeChanged(HasData<Contact> display) {
				int start = display.getVisibleRange().getStart();
				int end = start + display.getVisibleRange().getLength();
				end = end >= CONTACTS.size() ? CONTACTS.size() : end;
				List<Contact> sub = CONTACTS.subList(start, end);
				updateRowData(start, sub);
			}
		};

		provider.addDataDisplay(cellTable);
		provider.updateRowCount(CONTACTS.size(), true);

		SimplePager pager = new SimplePager();
		pager.setDisplay(cellTable);

		// VerticalPanel vp = new VerticalPanel();
		// vp.add(cellTable);
		// vp.add(pager);
		//
		// // Add it to the root panel.
		// RootPanel.get().add(vp);

	}

}
