package de.hdm.getthepoint.shared.bo;

import java.util.List;

import de.hdm.getthepoint.shared.enums.Schwierigkeit;

public class FrageBo extends BusinessObject {

	private static final long serialVersionUID = 1632688091736338890L;

	private String text;

	private KategorieBo kategorie;

	private List<AntwortBo> antwortmoeglichkeiten;

	private AntwortBo loesung;

	private String bild;

	private Schwierigkeit schwierigkeit;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public KategorieBo getKategorie() {
		return kategorie;
	}

	public void setKategorie(KategorieBo kategorie) {
		this.kategorie = kategorie;
	}

	public List<AntwortBo> getAntwortmoeglichkeiten() {
		return antwortmoeglichkeiten;
	}

	public void setAntwortmoeglichkeiten(List<AntwortBo> antwortmoeglichkeiten) {
		this.antwortmoeglichkeiten = antwortmoeglichkeiten;
	}

	public AntwortBo getLoesung() {
		return loesung;
	}

	public void setLoesung(AntwortBo loesung) {
		this.loesung = loesung;
	}

	public String getBild() {
		return bild;
	}

	public void setBild(String bild) {
		this.bild = bild;
	}

	public Schwierigkeit getSchwierigkeit() {
		return schwierigkeit;
	}

	public void setSchwierigkeit(Schwierigkeit schwierigkeit) {
		this.schwierigkeit = schwierigkeit;
	}

}
