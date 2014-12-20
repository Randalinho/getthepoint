package de.hdm.getthepoint.server.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import de.hdm.getthepoint.server.db.mapper.KategorieMapper;
import de.hdm.getthepoint.server.db.model.Kategorie;
import de.hdm.getthepoint.shared.bo.KategorieBo;

public class DataAcces {

	KategorieMapper kategorieMapper;

	public DataAcces() {
		kategorieMapper = new KategorieMapper();
	}

	public List<KategorieBo> getAllKategorie() {

		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("getthepoint2");
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();

		List<Kategorie> list = entityManager.createQuery(
				"Select kategorie FROM Kategorie kategorie", Kategorie.class)
				.getResultList();

		entityManager.close();
		entityManagerFactory.close();

		return kategorieMapper.getModelsAsList(list);
	}

}
