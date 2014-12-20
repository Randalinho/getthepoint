package de.hdm.getthepoint.server.db.model;

// Generated 28.11.2014 00:27:43 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Admin generated by hbm2java
 */
@Entity
@Table(name = "Admin", catalog = "getthepointdb")
public class Admin implements java.io.Serializable {

	private static final long serialVersionUID = 8051085953923999673L;
	private int id;
	private String login;
	private String passwort;

	public Admin() {
	}

	public Admin(int id) {
		this.id = id;
	}

	public Admin(int id, String login, String passwort) {
		this.id = id;
		this.login = login;
		this.passwort = passwort;
	}

	@Id
	@GeneratedValue
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "login", length = 45)
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "passwort", length = 45)
	public String getPasswort() {
		return this.passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

}
