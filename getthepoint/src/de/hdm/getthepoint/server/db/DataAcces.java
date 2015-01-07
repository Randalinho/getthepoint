package de.hdm.getthepoint.server.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import de.hdm.getthepoint.server.db.model.Frage;
import de.hdm.getthepoint.server.db.model.Kategorie;
import de.hdm.getthepoint.server.db.model.Wissenstest;

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

	public DataAcces() {
		getEntityManager();
	}

	/**
	 * Methode zum Abrufen aller {@link Wissenstest}.
	 * @return
	 */
	public List<Wissenstest> getAllWissentests() {
		List<Wissenstest> list = entityManager.createQuery(
				"Select wissenstest FROM Wissenstest wissenstest",
				Wissenstest.class).getResultList();
		return list;

	}

/**
	 * Methode zum Abrugen aller {@link Kategorie).
	 * @return
	 */
	public List<Kategorie> getAllKategorie() {

		List<Kategorie> list = entityManager.createQuery(
				"Select kategorie FROM Kategorie kategorie", Kategorie.class)
				.getResultList();

		return list;
	}

	public List<Frage> getAllFrage() {
		List<Frage> list = entityManager.createQuery(
				"SELECT frage FROM Frage frage", Frage.class).getResultList();
		return list;

	}

	public List<Frage> getFragenByKategorie(int kategorie_id) {

		List<Frage> list = entityManager.createQuery(
				"Select frage FROM Frage frage where frage.kategorie = "
						+ kategorie_id, Frage.class).getResultList();

		return list;
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
	public void closeEntityManagerAndFactory() {
		entityManager.close();
		entityManagerFactory.close();
	}

}
