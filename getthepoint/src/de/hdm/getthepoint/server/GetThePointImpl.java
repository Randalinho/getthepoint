package de.hdm.getthepoint.server;

import java.util.List;

import org.omg.CORBA.DATA_CONVERSION;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.hdm.getthepoint.server.db.DataAcces;
import de.hdm.getthepoint.shared.GetThePoint;
import de.hdm.getthepoint.shared.bo.FrageBo;
import de.hdm.getthepoint.shared.bo.KategorieBo;

@SuppressWarnings("serial")
public class GetThePointImpl extends RemoteServiceServlet implements
		GetThePoint {

	@Override
	public List<KategorieBo> getAllKategorien() throws IllegalArgumentException {
		List<KategorieBo> resultList = new DataAcces().getAllKategorie();
		return resultList;
	}
	
	public List<FrageBo> getFragenByKategorie(int kategorie_id) throws IllegalArgumentException {
		List<FrageBo> resultList = new DataAcces().getFragenByKategorie(kategorie_id);
		return resultList;
	}

}
