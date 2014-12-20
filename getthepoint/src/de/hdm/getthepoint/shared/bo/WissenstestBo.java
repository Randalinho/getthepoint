	package de.hdm.getthepoint.shared.bo;
import java.util.Date;

import de.hdm.getthepoint.shared.enums.StartTyp;


/**
 * @author Fabian
 *
 */
public class WissenstestBo extends BusinessObject {

	private static final long serialVersionUID = -4218497524010213019L;

	private LehrenderBo lehrender;

	private Date startzeit;

	private Date endzeit;

	private int bearbeitungszeit;

	private boolean random;

	private StartTyp startTyp;

	private boolean aktiv;

	private boolean gestartet;

	public LehrenderBo getLehrender() {
		return lehrender;
	}

	public void setLehrender(LehrenderBo lehrender) {
		this.lehrender = lehrender;
	}

	public Date getStartzeit() {
		return startzeit;
	}

	public void setStartzeit(Date startzeit) {
		this.startzeit = startzeit;
	}

	public Date getEndzeit() {
		return endzeit;
	}

	public void setEndzeit(Date endzeit) {
		this.endzeit = endzeit;
	}

	public int getBearbeitungszeit() {
		return bearbeitungszeit;
	}

	public void setBearbeitungszeit(int bearbeitungszeit) {
		this.bearbeitungszeit = bearbeitungszeit;
	}

	public boolean isRandom() {
		return random;
	}

	public void setRandom(boolean random) {
		this.random = random;
	}

	public StartTyp getStartTyp() {
		return startTyp;
	}

	public void setStartTyp(StartTyp startTyp) {
		this.startTyp = startTyp;
	}

	public boolean isAktiv() {
		return aktiv;
	}

	public void setAktiv(boolean aktiv) {
		this.aktiv = aktiv;
	}

	public boolean isGestartet() {
		return gestartet;
	}

	public void setGestartet(boolean gestartet) {
		this.gestartet = gestartet;
	}

}
