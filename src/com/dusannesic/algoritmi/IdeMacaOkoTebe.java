package com.dusannesic.algoritmi;

public class IdeMacaOkoTebe implements KruznaLinkovanaLista {

	private Dete prvi;
	private Dete trenutniIgrac;
	
	public IdeMacaOkoTebe(int brojDece) {}
	
	@Override
	public void dodajIgraca(Dete noviIgrac) {
		Dete trenutni = prvi;
		
		if (prvi == null) {
			prvi = noviIgrac;
		} else {
			if (trenutni.getSledeciIgrac() == null) {
				trenutni.setSledeciIgrac(prvi);
			} else {
				while (trenutni.getSledeciIgrac() != prvi) {
					trenutni = trenutni.getSledeciIgrac();
				}			
			}
			
			noviIgrac.setSledeciIgrac(prvi);
			trenutni.setSledeciIgrac(noviIgrac);
		}
		
	}
	
	@Override
	public void prikaziIgrace() {
		Dete trenutni = prvi;
		
		System.out.println("Igraci su: ");
		
		//Regulisanje liste koja ima samo jedan element
		if (trenutni.getSledeciIgrac() == null) {
			System.out.println("Igrac: " + trenutni.getIme());
		} else {
			while (trenutni.getSledeciIgrac() != prvi) {
				if (trenutni.getIme().equals(prvi.getIme())) {
					System.out.println("Igrac: " + trenutni.getIme());
				} else {
					System.out.println("Igrac: " + trenutni.getIme());					
				}
				trenutni = trenutni.getSledeciIgrac();
			}
			System.out.println("Igrac: " + trenutni.getIme());
		}
	}

	@Override
	public void zapocniIgru() {
		trenutniIgrac = prvi;
		
		Dete noviPrvi = prvi.getSledeciIgrac();
		
		Dete trenutni = prvi;
		while (trenutni.getSledeciIgrac() != prvi) {
			trenutni = trenutni.getSledeciIgrac();
		}
		
		trenutni.setSledeciIgrac(noviPrvi);
		prvi = noviPrvi;
		
		System.out.println("Trenutni igrac je: " + trenutniIgrac.getIme());
		prikaziIgrace();
	}
	
	public void tokIgre() {
		int ponavljanja = trenutniIgrac.getBrojKoraka();
		
		if (ponavljanja == 0) {
			throw new RuntimeException("Dete ne ume da peva!");
		} else {
			int korak = 1;
			Dete trenutni = prvi;
			
			while (korak < ponavljanja) {
				trenutni = trenutni.getSledeciIgrac();
				korak++;
			}
			
			System.out.println("Nakon prve runde, prvi igrac dosao je do: " + trenutni.getIme());
		}
	}
}
