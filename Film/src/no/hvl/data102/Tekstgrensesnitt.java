package no.hvl.data102;

import java.util.Scanner;
import no.hvl.data102.adt.*;

public class Tekstgrensesnitt {
	
	// lese opplysningene om en FILM fra tastatur
	public Film lesFilm() {
		Scanner leser = new Scanner(System.in);
		
		System.out.print("Filmnr: ");
		int filmnr = Integer.parseInt(leser.nextLine());
		
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
		
		leser.close();
		
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
	public void skrivUtFilmDelstrengITittel(FILMarkivADT filma, String delstreng) {
		Film[] tabell = filma.soekTittel(delstreng);
		for (Film f: tabell) {
			visFilm(f);
		}
	}
	
	// Skriver ut alle Filmer av en produsent / en gruppe
	public void skrivUtFilmProdusent(FILMarkivADT filma, String delstreng) {
		Film[] tabell = filma.soekProdusent(delstreng);
		for (Film f: tabell) {
			visFilm(f);
		}
	}
	
	// Skrive ut en enkel statistikk som inneholder antall Filmer totalt
	// og hvor mange det er i hver sjanger
	 public void skrivUtStatistikk(Filmarkiv filma) {
		 System.out.println("Totalt antall filmer: " + filma.antall());
		 for (Sjanger sj: Sjanger.values()) {
			 System.out.print(sj.toString() + ": " + filma.antall(sj));
		 }
	 }
	//… Ev. andre metoder
}
