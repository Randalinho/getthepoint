package de.hdm.getthepoint.shared;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import de.hdm.getthepoint.shared.bo.FrageBo;
import de.hdm.getthepoint.shared.bo.KategorieBo;

@RemoteServiceRelativePath("getthepoint")
public interface GetThePoint extends RemoteService {

	public void init() throws IllegalArgumentException;

	public List<KategorieBo> getAllKategorien() throws IllegalArgumentException;
	
	public List<FrageBo> getAllFragen() throws IllegalArgumentException;

	public List<FrageBo> getFragenByKategorie(int kategorie_id)
			throws IllegalArgumentException;

}
