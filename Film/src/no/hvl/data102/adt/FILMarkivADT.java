package no.hvl.data102.adt;

import no.hvl.data102.Film;
import no.hvl.data102.Sjanger;

public interface FILMarkivADT {
	
	/**
	 * Returnere en tabell av Filmer
	 * @return tabell over Filmer
	 */
	Film[] hentFilmTabell();
	
	/**
	 * Legger til en ny Film
	 * @param ny film
	 */
	void leggTilFilm(Film nyFilm);
	
	/**
	 * Sletter en Film hvis den fins
	 * @param filmnr
	 * @return true om den ble sletter, false hvis ikke
	 */
	boolean slettFilm(int filmnr);
	
	/**
	 * Søker og henter Filmer med en gitt delstreng i tittelen
	 * @param delstreng
	 * @return tabell med Filmer
	 */
	Film[] soekTittel(String delstreng);
	
	/**
	 * Søker og henter produsenter med en gitt delstreng
	 * @param delstreng
	 * @return tabell med Filmer
	 */
	Film[] soekProdusent(String delstreng);
	
	/**
	 * Henter antall Filmer for en gitt sjanger
	 * @param sjanger
	 * @return antall Filmer
	 */
	int antall (Sjanger sjanger);
	
	/**
	 * Returnerer antall Filmer
	 * @return antall Filmer
	 */
	int antall();
	
	}//interface 