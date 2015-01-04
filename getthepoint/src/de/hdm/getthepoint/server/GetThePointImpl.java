package de.hdm.getthepoint.server;

import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.hdm.getthepoint.server.db.DataAcces;
import de.hdm.getthepoint.server.db.mapper.*;
import de.hdm.getthepoint.shared.GetThePoint;
import de.hdm.getthepoint.shared.bo.AntwortBo;
import de.hdm.getthepoint.shared.bo.FrageBo;
import de.hdm.getthepoint.shared.bo.KategorieBo;

@SuppressWarnings("serial")
public class GetThePointImpl extends RemoteServiceServlet implements
		GetThePoint {

	DataAcces dataAcces;
	KategorieMapper kategorieMapper;
	FrageMapper frageMapper;
	AntwortMapper antwortMapper;

	@Override
	public void init() throws IllegalArgumentException {
		dataAcces = new DataAcces();
		kategorieMapper = new KategorieMapper();
		frageMapper = new FrageMapper();
	}

	@Override
	public List<KategorieBo> getAllKategorien() throws IllegalArgumentException {
		return kategorieMapper.getModelsAsList(dataAcces.getAllKategorie());

	}

	@Override
	public List<FrageBo> getAllFragen() throws IllegalArgumentException {
		return frageMapper.getModelsAsList(dataAcces.getAllFrage());
	}

	public List<FrageBo> getFragenByKategorie(int kategorie_id)
			throws IllegalArgumentException {
		return frageMapper.getModelsAsList(dataAcces
				.getFragenByKategorie(kategorie_id));
	}

	@Override
	public List<AntwortBo> getAntwortenByFrage(int frage_id)
			throws IllegalArgumentException {
		return antwortMapper.getModelsAsList(dataAcces.getAntwortenByFrage(frage_id));
	}

	

}
