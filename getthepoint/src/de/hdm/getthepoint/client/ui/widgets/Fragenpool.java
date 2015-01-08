package de.hdm.getthepoint.client.ui.widgets;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
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

public class Fragenpool extends Composite {

	private static FragenpoolUiBinder uiBinder = GWT
			.create(FragenpoolUiBinder.class);

	GetThePointAsync getThePoint = GWT.create(GetThePoint.class);
	
	List<KategorieBo> katContainer = new ArrayList<KategorieBo>();
	List<FrageBo> fraContainer = new ArrayList<FrageBo>();
	
	@UiField
	DataGrid<FrageBo> dataGrid = new DataGrid<FrageBo>();
	
	@UiField
	ListBox libkategorie;
	
	@UiHandler("libkategorie")
	void onChange(ChangeEvent e) {
		dataGrid.setRowCount(0);
		if (libkategorie.getSelectedIndex() != 0) {

			AsyncDataProvider<FrageBo> dataProvider = new AsyncDataProvider<FrageBo>() {

				@Override
				protected void onRangeChanged(final HasData<FrageBo> display) {

					getThePoint.getFragenByKategorie(
							katContainer.get(
									libkategorie.getSelectedIndex() - 1)
									.getId(),
							new AsyncCallback<List<FrageBo>>() {

								@Override
								public void onFailure(Throwable caught) {
									// TODO Auto-generated method stub

								}

								@Override
								public void onSuccess(List<FrageBo> result) {

									fraContainer = result;
									int start = display.getVisibleRange()
											.getStart();
									int end = start
											+ display.getVisibleRange()
													.getLength();
									end = end >= fraContainer.size() ? fraContainer
											.size() : end;
									List<FrageBo> sub = fraContainer.subList(
											start, end);
									updateRowData(start, sub);

								}
							});

				}
			};

			dataProvider.addDataDisplay(dataGrid);
			dataProvider.updateRowCount(fraContainer.size(), true);

		} else {

			AsyncDataProvider<FrageBo> dataProvider = new AsyncDataProvider<FrageBo>() {

				@Override
				protected void onRangeChanged(final HasData<FrageBo> display) {

					getThePoint
							.getAllFragen(new AsyncCallback<List<FrageBo>>() {

								@Override
								public void onFailure(Throwable caught) {
									// TODO Auto-generated method stub

								}

								@Override
								public void onSuccess(List<FrageBo> result) {
									fraContainer = result;
									int start = display.getVisibleRange()
											.getStart();
									int end = start
											+ display.getVisibleRange()
													.getLength();
									end = end >= fraContainer.size() ? fraContainer
											.size() : end;
									List<FrageBo> sub = fraContainer.subList(
											start, end);
									updateRowData(start, sub);

								}
							});

				}
			};

			dataProvider.addDataDisplay(dataGrid);
			dataProvider.updateRowCount(fraContainer.size(), true);

		}

		final NoSelectionModel<FrageBo> selectionModel = new NoSelectionModel<FrageBo>();
		selectionModel
				.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {

					@Override
					public void onSelectionChange(SelectionChangeEvent event) {
						FrageBo selFrage = selectionModel
								.getLastSelectedObject();

					}
				});

		dataGrid.setSelectionModel(selectionModel);

	}
	
	interface FragenpoolUiBinder extends UiBinder<Widget, Fragenpool> {
	}

	public Fragenpool() {
		initWidget(uiBinder.createAndBindUi(this));
		
		getThePoint.getAllKategorien(new AsyncCallback<List<KategorieBo>>() {

			@Override
			public void onSuccess(List<KategorieBo> result) {
				katContainer = result;
				libkategorie.addItem("(alle)");
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

		dataGrid.addColumn(coltext, "Frage");
		dataGrid.addColumn(colschwierigkeit, "Schwierigkeit");

//		dataGrid.setVisibleRange(0, 3);
		// katContainer.get(libkategorie.getSelectedIndex()).getId()

		AsyncDataProvider<FrageBo> dataProvider = new AsyncDataProvider<FrageBo>() {

			@Override
			protected void onRangeChanged(final HasData<FrageBo> display) {

				getThePoint.getAllFragen(new AsyncCallback<List<FrageBo>>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onSuccess(List<FrageBo> result) {
						fraContainer = result;
						int start = display.getVisibleRange().getStart();
						int end = start + display.getVisibleRange().getLength();
						end = end >= fraContainer.size() ? fraContainer.size()
								: end;
						List<FrageBo> sub = fraContainer.subList(start, end);
						updateRowData(start, sub);

					}
				});

			}
		};
		dataProvider.addDataDisplay(dataGrid);
		dataProvider.updateRowCount(fraContainer.size(), true);
	}

}
