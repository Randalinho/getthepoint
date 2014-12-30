package de.hdm.getthepoint.shared;
import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.hdm.getthepoint.shared.bo.FrageBo;
import de.hdm.getthepoint.shared.bo.KategorieBo;

public interface GetThePointAsync {

	void getAllKategorien(AsyncCallback<List<KategorieBo>> callback);

	void getFragenByKategorie(int kategorie_id,
			AsyncCallback<List<FrageBo>> callback);
	
}
