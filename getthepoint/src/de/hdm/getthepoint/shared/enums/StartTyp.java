package de.hdm.getthepoint.shared.enums;

public enum StartTyp {

	Random("Zuf�llig"), Normal("Normal");

	private String text;

	private StartTyp(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

}
