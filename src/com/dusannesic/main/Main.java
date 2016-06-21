package com.dusannesic.main;

import java.util.Scanner;

import com.dusannesic.algoritmi.Dete;
import com.dusannesic.algoritmi.IdeMacaOkoTebe;

public class Main {

	public static void main(String[] args) {
		
		int brojDece = 0;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Unesite broj dece:");
		brojDece = scan.nextInt();

		IdeMacaOkoTebe igra = new IdeMacaOkoTebe(brojDece);
		
		Scanner unosIgraca = new Scanner(System.in);
		
		for (int i = 0; i < brojDece; i++) {
			String ime = "";
			int brojKoraka = 0;
			System.out.println("Unesite ime igraca:");
			ime = unosIgraca.next();
			System.out.println("Unesite broj koraka:");
			brojKoraka = unosIgraca.nextInt();
			
			Dete noviIgrac = new Dete(ime, brojKoraka);
			
			igra.dodajIgraca(noviIgrac);
		}
		
		igra.igrajIgru();
		
		scan.close();
		unosIgraca.close();
	}
	
}
