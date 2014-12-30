package de.hdm.getthepoint.dbtest;

import java.util.List;

import org.junit.Test;

import de.hdm.getthepoint.server.db.DataAcces;
import de.hdm.getthepoint.shared.bo.FrageBo;

public class QueryTesting {

	@Test
	public void test() {

		DataAcces dataAcces = new DataAcces();

		List<FrageBo> liste = dataAcces.getFragenByKategorie(1);

		for (FrageBo frageBo : liste) {
			System.out.println(frageBo.getText());
		}
	}

}
