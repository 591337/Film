package no.hvl.data102;

import java.util.Scanner;
import no.hvl.data102.adt.*;

public class Tekstgrensesnitt {
	private Scanner leser;
	
	public Tekstgrensesnitt() {
		leser = new Scanner(System.in);
	}
	
	// leser inn filnavn
	public String filnavn() {
		System.out.print("Filnavn: ");
		String filnavn = leser.nextLine();
		System.out.println();
		
		return filnavn;
	}
	
	// skal en bruke en eksisterende liste
	public boolean eksisterende() {;
		System.out.println("Opprett nytt arkiv (1)\nBruk eksisterende (2)");
		System.out.print(": ");
		int alt = Integer.parseInt(leser.nextLine());
		
		if (alt == 2) {
			return true;
		}
		return false;
	}
	
	
	// lese opplysningene om en FILM fra tastatur
	public Film lesFilm() {
		System.out.println("Filmnr: ");
		String in = leser.nextLine();
		int filmnr = Integer.parseInt(in);
		
		System.out.print("Produsent: ");
		String produsent = leser.nextLine();
		
		System.out.print("Filmtittel: ");
		String tittel = leser.nextLine();
		
		System.out.print("Lanseringsår: ");
		int lanseringsår = Integer.parseInt(leser.nextLine());
		
		System.out.print("Sjanger: ");
		Sjanger sjanger = Sjanger.finnSjanger(leser.nextLine());
		
		System.out.print("Filmselskap: ");
		String filmselsakp = leser.nextLine();
		
		return new Film(filmnr, produsent, tittel,
				lanseringsår, sjanger, filmselsakp);
	}
	
	// vise en film med alle opplysninger på skjerm (husk tekst for sjanger)
	public void visFilm(Film film) {
		System.out.println("-------\nFilmnr: " + film.getFilmnr()
				+ "\nProdusent: " + film.getProdusent()
				+ "\nFilmtittel: " + film.getTittel()
				+ "\nLanseringsår: " + film.getAar()
				+ "\nSjanger: " + film.getSjanger().toString()
				+ "\nFilmselskap: " + film.getFilmselskap());
	}
	
	
	// Skrive ut alle Filmer med en spesiell delstreng i tittelen
	public void skrivUtFilmDelstrengITittel(FilmarkivADT filma, String delstreng) {
		Film[] tabell = filma.soekTittel(delstreng);
		for (Film f: tabell) {
			visFilm(f);
		}
	}
	
	// Skriver ut alle Filmer av en produsent / en gruppe
	public void skrivUtFilmProdusent(FilmarkivADT filma, String delstreng) {
		Film[] tabell = filma.soekProdusent(delstreng);
		for (Film f: tabell) {
			visFilm(f);
		}
	}
	
	// Skrive ut en enkel statistikk som inneholder antall Filmer totalt
	// og hvor mange det er i hver sjanger
	 public void skrivUtStatistikk(FilmarkivADT filma) {
		 System.out.println("Totalt antall filmer: " + filma.antall());
		 for (Sjanger sj: Sjanger.values()) {
			 System.out.print(sj.toString() + ": " + filma.antall(sj));
		 }
	 }
	 
	 public String soekeord() {
		 System.out.print("Søkeord: ");
		 String soek = leser.nextLine();
		 
		 return soek;
	 }
	
	 // velger mellom ulike alternativer
	 public int alternativ() {
		System.out.println("Legge til film (1)\n"
				+ "Søk etter film tittel (2)\n"
				+ "Søk etter film produsent (3)\n"
				+ "Statistikk (4)\n"
				+ "Avslutt (5)");
		System.out.print(": ");
		int alt = Integer.parseInt(leser.nextLine());
		
		return alt;
	 }
	 
	 public void ikkeMulig(int alt) {
		 System.out.println(alt + "er ikke et mulig alternativ");
	 }
}
