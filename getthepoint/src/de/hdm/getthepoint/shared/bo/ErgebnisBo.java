package de.hdm.getthepoint.shared.bo;


public class ErgebnisBo extends BusinessObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2250934284088999510L;

	private WissenstestBo wissenstest;

	private StudentBo student;

	private FrageBo frage;
	
	private int frage_id;

	private AntwortBo antwort;
	
	private int antwort_id;

	private boolean richtig;

	public WissenstestBo getWissenstest() {
		return wissenstest;
	}

	public void setWissenstest(WissenstestBo wissenstest) {
		this.wissenstest = wissenstest;
	}

	public StudentBo getStudent() {
		return student;
	}

	public void setStudent(StudentBo student) {
		this.student = student;
	}

	public FrageBo getFrage() {
		return frage;
	}

	public void setFrage(FrageBo frage) {
		this.frage = frage;
	}
	
	public int getFrage_id() {
		return frage_id;
	}

	public void setFrage_id(int frage_id) {
		this.frage_id = frage_id;
	}

	public AntwortBo getAntwort() {
		return antwort;
	}

	public void setAntwort(AntwortBo antwort) {
		this.antwort = antwort;
	}

	public int getAntwort_id() {
		return antwort_id;
	}

	public void setAntwort_id(int antwort_id) {
		this.antwort_id = antwort_id;
	}

	public boolean isRichtig() {
		return richtig;
	}

	public void setRichtig(boolean richtig) {
		this.richtig = richtig;
	}

}
