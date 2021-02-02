package no.hvl.data102;

import no.hvl.data102.adt.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Fil {
	final static String SKILLE = "#"; // Eventuelt ha som parameter i
	// metodene.
	
	// Lese et Filmarkiv fra tekstfil
	public static FilmarkivADT lesFraFil(String filnavn) {
		FilmarkivADT filma;
		
		File fil = new File(filnavn);
		Scanner leser;
		
		try {
			leser = new Scanner(fil);
		} catch (FileNotFoundException e) {
			System.out.print("Fant ikke fil: "+filnavn);
			return new Filmarkiv();
		}
		
		int lengde = Integer.parseInt(leser.nextLine());
		filma = new Filmarkiv(lengde);
		
		while(leser.hasNextLine()) {
			String[] inn = leser.nextLine().split(SKILLE);
			Film film = new Film(Integer.parseInt(inn[0]), inn[1], inn[2], 
					Integer.parseInt(inn[3]), Sjanger.finnSjanger(inn[4]), inn[5]);
			filma.leggTilFilm(film);
		}
		leser.close();
		
		return filma;
		
	}
	// Lagre et Filmarkiv til tekstfil
	public static void skrivTilFil(FilmarkivADT filmarkiv, String filnavn) {
		try {
			FileWriter filmFil = new FileWriter(filnavn, false);
			
			PrintWriter utFil = new PrintWriter(filmFil);
			
			utFil.println(filmarkiv.antall());
			Film[] filmer = filmarkiv.hentFilmTabell();
			
			for (Film f: filmer) {
				utFil.print(f.getFilmnr() + SKILLE);
				utFil.print(f.getProdusent() + SKILLE);
				utFil.print(f.getTittel() + SKILLE);
				utFil.print(f.getAar() + SKILLE);
				utFil.print(f.getSjanger().toString() + SKILLE);
				utFil.print(f.getFilmselskap() + "\n");
			}
			
			utFil.close();
			
		} catch (IOException e) {
			System.out.println("Feil ved skriving til fil");
		}
		
	}

}//class
