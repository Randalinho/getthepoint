package de.hdm.getthepoint.shared.bo;

public class AntwortBo extends BusinessObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2078688206447859120L;

	private FrageBo frage;

	private String text;

	public FrageBo getFrage() {
		return frage;
	}

	public void setFrage(FrageBo frage) {
		this.frage = frage;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
