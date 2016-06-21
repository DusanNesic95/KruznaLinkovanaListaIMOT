package com.dusannesic.algoritmi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	}
	
	private Dete tokIgre() {
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
			
			return trenutni;
		}
	}
	
	public void gotovaRunda(Dete sledeciIgrac) {
		prvi = sledeciIgrac;
		
		Dete trenutni = prvi;
		while (trenutni.getSledeciIgrac() != prvi) {
			trenutni = trenutni.getSledeciIgrac();
		}
		
		dodajIgraca(trenutniIgrac);		
	}
	
	public void igrajIgru() {
		List<Dete> decaKojaSuIgrala = new ArrayList<Dete>();
		
		Dete igrac = prvi;
		zapocniIgru();
		while (!decaKojaSuIgrala.contains(igrac)) {
			decaKojaSuIgrala.add(igrac);
			igrac = tokIgre();
			gotovaRunda(igrac);
			zapocniIgru();
		}
		
		dodajIgraca(igrac);
		
		prikaziIgrace();
	}
}
