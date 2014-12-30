package de.hdm.getthepoint.dbtest;

import java.util.List;

import org.junit.Test;

import de.hdm.getthepoint.server.db.DataAcces;
import de.hdm.getthepoint.server.db.model.Frage;

public class QueryTestingFrageByKategorie {

	@Test
	public void test() {

		DataAcces dataAcces = new DataAcces();

		List<Frage> liste = dataAcces.getFragenByKategorie(1);

		for (Frage frage : liste) {
			System.out.println(frage.getText());
		}
	}

}
