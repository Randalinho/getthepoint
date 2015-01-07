package de.hdm.getthepoint.dbtest;

import java.util.List;

import org.junit.Test;

import de.hdm.getthepoint.server.db.DataAcces;
import de.hdm.getthepoint.server.db.model.Kategorie;

public class QueryTestingKategorie {

	@Test
	public void test() {

		DataAcces dataAcces = new DataAcces();

		List<Kategorie> liste = dataAcces.getAllKategorie();

		for (Kategorie kategorie : liste) {
			System.out.println(kategorie.getBezeichnung());
			System.out.println(kategorie.getLehrender().getName());
		}

	}
}
