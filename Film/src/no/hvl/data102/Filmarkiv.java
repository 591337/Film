package no.hvl.data102;

import no.hvl.data102.adt.FILMarkivADT;

public class Filmarkiv implements FILMarkivADT {
	
	private Film[] filmTabell;
	private int antall;
	
	//sdandard-konstruktør
	public Filmarkiv() {
		this(10);
	}
	
	//konstruktør
	public Filmarkiv(int lengde) {
		filmTabell = new Film[lengde];
		antall = 0;
	}
	
	
	//Interface metoder
	//Henter tabell av filmer
	public Film[] hentFilmTabell() {
		Film[] utTabell = new Film[antall];
		for (int i=0; i<antall; i++) {
			utTabell[i] = filmTabell[i];
		}
		return utTabell;
	}
	
	//Legger til Film
	public void leggTilFilm(Film nyFilm) {
		if (antall < filmTabell.length) {
			filmTabell[antall] = nyFilm;
			antall++;
		} else {
			utvid();
			filmTabell[antall] = nyFilm;
			antall++;
		}
	}
	
	//sletter film
	public boolean slettFilm(int filmnr) {
		for (int i=0; i<antall; i++) {
			if (filmnr == filmTabell[i].getFilmnr()) {
				antall--;
				filmTabell[i] = filmTabell[antall];
				filmTabell[antall] = null;
				return true;
			}
		}
		return false;
	}
	
	//Søk i tittel
	public Film[] soekTittel(String delstreng) {
		Film[] storFilm = new Film[antall];
		int ant = 0;
		
		for (int i=0; i<antall; i++) {
			if (filmTabell[i].getTittel().contains(delstreng)) {
				storFilm[ant] = filmTabell[i];
				ant++;
			}
		}
		
		Film[] returTabell = new Film[ant];
		for (int i=0; i<ant; i++) {
			returTabell[i] = storFilm[i];
		}
		return returTabell;
	}

	//Søk i produsent
	public Film[] soekProdusent(String delstreng) {
		Film[] storFilm = new Film[antall];
		int ant = 0;
		
		for (int i=0; i<antall; i++) {
			if (filmTabell[i].getProdusent().contains(delstreng)) {
				
				storFilm[ant] = filmTabell[i];
				ant++;
			}
		}
		
		Film[] returTabell = new Film[ant];
		for (int i=0; i<ant; i++) {
			returTabell[i] = storFilm[i];
		}
		return returTabell;
	}

	//Antall sjangre
	public int antall(Sjanger sjanger) {
		int ant = 0;
		for (int i=0; i<antall; i++) {
			if(filmTabell[i].getSjanger()==sjanger) {
				ant++;
			}
		}
		return ant;
	}

	//antall
	public int antall() {
		return antall;
	}
	
	//Hjelpemetoder
	//Utvider tabellen med 10% (minimum 1)
	private void utvid() {
		int len = filmTabell.length;
		
		int nyLen = (int) (len*1.1);
		if (nyLen == len) {
			nyLen++;
		}
		
		Film[] nyTabell = new Film[nyLen];
		for (int i=0; i<len; i++) {
			nyTabell[i] = filmTabell[i];
		}
		
		filmTabell = nyTabell;
	}

}
