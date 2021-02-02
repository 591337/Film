package no.hvl.data102;

import no.hvl.data102.adt.*;

public class Meny{
	private FilmarkivADT filma;
	private Tekstgrensesnitt tekstgr;
	private String filnavn;
	
	public Meny(FilmarkivADT filma) {
		tekstgr = new Tekstgrensesnitt();
		this.filma = filma;
	}
	
	public void start() {
		filnavn = tekstgr.filnavn();
		if (tekstgr.eksisterende()) {
			filma = Fil.lesFraFil(filnavn);
		}
	}
	
	public Boolean neste() {
		int alt = tekstgr.alternativ();
		switch(alt) {
		case 1:
			filma.leggTilFilm(tekstgr.lesFilm());
			break;
		case 2:
			tekstgr.skrivUtFilmDelstrengITittel(filma, tekstgr.soekeord());
			break;
		case 3:
			tekstgr.skrivUtFilmProdusent(filma, tekstgr.soekeord());
			break;
		case 4:
			tekstgr.skrivUtStatistikk(filma);
			break;
		case 5:
			return false;
		default:
			tekstgr.ikkeMulig(alt);
		}
		return true;
	}
	
	public void avslutt() {
		Fil.skrivTilFil(filma, filnavn);
	}
}//class
