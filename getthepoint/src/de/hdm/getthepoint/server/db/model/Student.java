package de.hdm.getthepoint.server.db.model;

// Generated 30.12.2014 21:24:32 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Student generated by hbm2java
 */
@Entity
@Table(name = "Student", catalog = "getthepointdb")
public class Student extends HibernateModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9181040556325482020L;
	private int id;
	private String matrikelNr;
	private String name;
	private String vorname;
	private String kuerzel;
	private Set<Ergebnis> ergebnises = new HashSet<Ergebnis>(0);

	public Student() {
	}

	public Student(int id) {
		this.id = id;
	}

	public Student(int id, String matrikelNr, String name, String vorname,
			String kuerzel, Set<Ergebnis> ergebnises) {
		this.id = id;
		this.matrikelNr = matrikelNr;
		this.name = name;
		this.vorname = vorname;
		this.kuerzel = kuerzel;
		this.ergebnises = ergebnises;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "matrikel_nr", length = 45)
	public String getMatrikelNr() {
		return this.matrikelNr;
	}

	public void setMatrikelNr(String matrikelNr) {
		this.matrikelNr = matrikelNr;
	}

	@Column(name = "name", length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "vorname", length = 45)
	public String getVorname() {
		return this.vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	@Column(name = "kuerzel", length = 45)
	public String getKuerzel() {
		return this.kuerzel;
	}

	public void setKuerzel(String kuerzel) {
		this.kuerzel = kuerzel;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
	public Set<Ergebnis> getErgebnises() {
		return this.ergebnises;
	}

	public void setErgebnises(Set<Ergebnis> ergebnises) {
		this.ergebnises = ergebnises;
	}

}
