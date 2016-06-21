package com.dusannesic.algoritmi;

public class Dete {

	private String ime;
	private int brojKoraka;
	private Dete sledeciIgrac;
	
	public Dete() {}
	
	public Dete(String ime, int brojKoraka) {
		this.ime = ime;
		this.brojKoraka = brojKoraka;
		this.sledeciIgrac = null;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public int getBrojKoraka() {
		return brojKoraka;
	}

	public void setBrojKoraka(int brojKoraka) {
		this.brojKoraka = brojKoraka;
	}

	public Dete getSledeciIgrac() {
		return sledeciIgrac;
	}

	public void setSledeciIgrac(Dete sledeciIgrac) {
		this.sledeciIgrac = sledeciIgrac;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + brojKoraka;
		result = prime * result + ((ime == null) ? 0 : ime.hashCode());
		result = prime * result + ((sledeciIgrac == null) ? 0 : sledeciIgrac.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dete other = (Dete) obj;
		if (brojKoraka != other.brojKoraka)
			return false;
		if (ime == null) {
			if (other.ime != null)
				return false;
		} else if (!ime.equals(other.ime))
			return false;
		if (sledeciIgrac == null) {
			if (other.sledeciIgrac != null)
				return false;
		} else if (!sledeciIgrac.equals(other.sledeciIgrac))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Dete [ime=" + ime + ", brojKoraka=" + brojKoraka + "]";
	}
	
}
