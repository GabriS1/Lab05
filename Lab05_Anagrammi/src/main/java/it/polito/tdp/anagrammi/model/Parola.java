package it.polito.tdp.anagrammi.model;

public class Parola {
	
	String testo;
	boolean correct;
	
	
	public Parola(String testo, boolean correct) {
		super();
		this.testo = testo;
		this.correct = correct;
	}
	
	
	public String getTesto() {
		return testo;
	}
	public void setTesto(String testo) {
		this.testo = testo;
	}
	public boolean isCorrect() {
		return correct;
	}
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	
	

}
