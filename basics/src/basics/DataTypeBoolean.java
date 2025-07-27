package basics;

public class DataTypeBoolean {
	// main szó + CTRL + space +enter
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Boolean - logikai típus
		// két értéket vehet fel igaz vagy hamis - true vagy false
		// java-ban nem ugyanaz, mint a 0 vagy 1
		// példákban: olyan esetekben ahol 2 állapot
		// akciós/nem akciós, aktív/inaktív
		// Elágazásoknál könnyen használható a feltételnél
		// ctrl+shift+f - gyorsformázás

		// boolean kezdetű változót is-el kezdünk (konvenció szerint)
		// deklaráció: változó létrejön tipussal
		// definició: értéket is kap
		// deklaráció és definició egyben
		boolean isRegistered = false;
//		boolean isRegistered2 = 0; --> type mismatch 
		// boolean isRegistered = true; --> a változónak az adott hatókörön belül
		// egyedinek kell lennie !!
		isRegistered = true;
		System.out.println("Regisztrált -e : " + isRegistered);

		// CTRL + Sapce automatikus kiegészítés
		if (isRegistered) {
			System.out.println(" Már regisztrált");
		} else {
			System.out.println("Még nem regisztrált");
		}

		boolean isSale; // deklaráció : a változó létrejön , kap tipust de nem kap értéket
		isSale = true;
		// logikai hiba - szemantikai hiba
//		if (!isSale) {
//			System.out.println("akciós");
//		} else {
//			System.out.println("nem akciós");
//		}

		if (!isSale) {
			System.out.println("nem akciós");
		} else {
			System.out.println("akciós");
		}

	}
}
