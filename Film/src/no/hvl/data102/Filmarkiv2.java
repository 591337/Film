package no.hvl.data102;

import no.hvl.data102.adt.*;

public class Filmarkiv2 implements FilmarkivADT {
	 private int antall;
	 private LinearNode<Film> start;
	 
	@Override
	public Film[] hentFilmTabell() {
		Film[] tabell = new Film[antall];
		LinearNode<Film> node = start;
		for (int i=0; i<antall; i++) {
			tabell[i] = node.getElement();
			node = node.getNeste();
		}
		return tabell;
	}
	@Override
	public void leggTilFilm(Film nyFilm) {
		if (antall == 0) {
			start = new LinearNode<Film>(nyFilm);
		} else {
			LinearNode<Film> husk = start;
			start = new LinearNode<Film>(nyFilm);
			start.setNeste(husk);
		}
		antall++;
	}
	@Override
	public boolean slettFilm(int filmnr) {
		Boolean funnet = false;
		if (start.getElement().getFilmnr()==filmnr) {
			start = start.getNeste();
			funnet = true;
		} else {
			LinearNode<Film> husk = start;
			LinearNode<Film> node = start;
			while (node!=null) {
				if (node.getElement().getFilmnr()==filmnr) {
					node = node.getNeste();
					husk.setNeste(node);
					funnet=true;
					break;
				} else {
					husk = node;
					node = node.getNeste();
				}
			}
		}
		if (funnet) {
			antall--;
		}
		return funnet;
	}
	@Override
	public Film[] soekTittel(String delstreng) {
		Film[] tabell = new Film[antall];
		int ind = 0;
		LinearNode<Film> node = start;
		while (node!=null) {
			if (node.getElement().getTittel().contains(delstreng)) {
				tabell[ind] = node.getElement();
				ind++;
			}
			node = node.getNeste();
		}
		Film[] nyFilm = new Film[ind];
		for (int i=0; i < ind; i++) {
			nyFilm[i] = tabell[i];
		}
		return nyFilm;
	}
	@Override
	public Film[] soekProdusent(String delstreng) {
		Film[] tabell = new Film[antall];
		int ind = 0;
		LinearNode<Film> node = start;
		while (node!=null) {
			if (node.getElement().getProdusent().contains(delstreng)) {
				tabell[ind] = node.getElement();
				ind++;
			}
			node = node.getNeste();
		}
		Film[] nyFilm = new Film[ind];
		for (int i=0; i < ind; i++) {
			nyFilm[i] = tabell[i];
		}
		return nyFilm;
	}
	@Override
	public int antall(Sjanger sjanger) {
		int ant = 0;
		LinearNode<Film> node = start;
		while (node!=null) {
			if (node.getElement().getSjanger()==sjanger) {
				ant++;
			}
			node = node.getNeste();
		}
		return ant;
	}
	@Override
	public int antall() {
		return antall;
	}
}
