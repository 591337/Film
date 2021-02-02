package no.hvl.data102;

import no.hvl.data102.adt.*;

public class KlientFilmarkiv{
	
	 public static void main(String[] args) {
		 FilmarkivADT filma = new Filmarkiv();
		 Meny meny = new Meny(filma);
		 
		 meny.start();
		 
		 Boolean fortsett = true;
		 while (fortsett) {
			 fortsett = meny.neste();
		 }
		 
		 meny.avslutt();
	}
}//class