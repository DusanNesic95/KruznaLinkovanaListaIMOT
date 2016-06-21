package com.dusannesic.algoritmi;

public class IdeMacaOkoTebe implements KruznaLinkovanaLista {

	private Dete prvi;
	private Dete trenutniIgrac;
	
	public IdeMacaOkoTebe(int brojDece) {}
	
	@Override
	public void dodajIgraca(Dete noviIgrac) {
		Dete trenutni = prvi;
		
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
					System.out.println(trenutni.getIme());					
				}
				trenutni = trenutni.getSledeciIgrac();
			}
			System.out.println(trenutni.getIme());
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
		
		System.out.println(prvi.getIme());
		prikaziIgrace();
	}
	
}
