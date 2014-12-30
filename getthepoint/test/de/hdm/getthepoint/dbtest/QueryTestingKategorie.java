package de.hdm.getthepoint.dbtest;

import java.util.List;

import org.junit.Test;

import de.hdm.getthepoint.server.db.DataAcces;
import de.hdm.getthepoint.shared.bo.KategorieBo;

public class QueryTestingKategorie {

	@Test
	public void test() {

		DataAcces dataAcces = new DataAcces();

		List<KategorieBo> liste = dataAcces.getAllKategorie();

		for (KategorieBo kategorieBo : liste) {
			System.out.println(kategorieBo.getBezeichnung());
		}

	}
}
