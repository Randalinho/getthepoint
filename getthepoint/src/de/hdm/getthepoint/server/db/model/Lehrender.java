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
 * Lehrender generated by hbm2java
 */
@Entity
@Table(name = "Lehrender", catalog = "getthepointdb")
public class Lehrender implements java.io.Serializable {

	private int id;
	private String name;
	private String vorname;
	private Set<Wissenstest> wissenstests = new HashSet<Wissenstest>(0);
	private Set<Kategorie> kategories = new HashSet<Kategorie>(0);

	public Lehrender() {
	}

	public Lehrender(int id) {
		this.id = id;
	}

	public Lehrender(int id, String name, String vorname,
			Set<Wissenstest> wissenstests, Set<Kategorie> kategories) {
		this.id = id;
		this.name = name;
		this.vorname = vorname;
		this.wissenstests = wissenstests;
		this.kategories = kategories;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lehrender")
	public Set<Wissenstest> getWissenstests() {
		return this.wissenstests;
	}

	public void setWissenstests(Set<Wissenstest> wissenstests) {
		this.wissenstests = wissenstests;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lehrender")
	public Set<Kategorie> getKategories() {
		return this.kategories;
	}

	public void setKategories(Set<Kategorie> kategories) {
		this.kategories = kategories;
	}

}
