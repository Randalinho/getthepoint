package de.hdm.getthepoint.server.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import de.hdm.getthepoint.server.db.mapper.KategorieMapper;
import de.hdm.getthepoint.server.db.model.Kategorie;
import de.hdm.getthepoint.shared.bo.KategorieBo;

/**
 * Klasse f&uuml;r alle Datenbankzugriffe.
 * 
 * @author Fabian
 *
 */
public class DataAcces {

	private EntityManagerFactory entityManagerFactory = null;

	private EntityManager entityManager = null;

	private static final String PERSISTENCEUNIT = "getthepoint";

	private KategorieMapper kategorieMapper;

	public DataAcces() {
		kategorieMapper = new KategorieMapper();
	}

/**
	 * Methode zum Abrugen aller {@link Kategorie). Diese werden direkt in eine Liste von KategorieBo gemappt.
	 * @return
	 */
	public List<KategorieBo> getAllKategorie() {

		getEntityManager();

		List<Kategorie> list = entityManager.createQuery(
				"Select kategorie FROM Kategorie kategorie", Kategorie.class)
				.getResultList();

		closeEntityManagerAndFactory();

		return kategorieMapper.getModelsAsList(list);
	}

	/**
	 * Erstellt eine neue {@link EntityManagerFactory} und einen neuen
	 * {@link EntityManager}.
	 * 
	 * @return
	 */
	private void getEntityManager() {
		entityManagerFactory = Persistence
				.createEntityManagerFactory(PERSISTENCEUNIT);
		entityManager = entityManagerFactory.createEntityManager();
	}

	/**
	 * Schlieﬂt den {@link EntityManager} und die {@link EntityManagerFactory};
	 */
	private void closeEntityManagerAndFactory() {
		entityManager.close();
		entityManagerFactory.close();
	}

}
