package no.hvl.data102;

public enum Sjanger {
	ACTION, DRAMA, HISTORY, SCIFI;
	
	public static Sjanger finnSjanger(String str) {
		str=str.toUpperCase();
		Sjanger sjUt = null;
		for (Sjanger s: Sjanger.values()) {
			if (str.equals(s.toString())) {
				sjUt = s;
				break;
			}
		}
		return sjUt;
	}
	
}
