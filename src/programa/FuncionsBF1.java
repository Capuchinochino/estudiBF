package programa;

import java.util.ArrayList;
import java.util.HashMap;

import Teclat.*;

public class FuncionsBF1 {

	// Funció creaTaulerDeVots;

	/**
	 * Funció que arreplega 2 enters. En quests enters recorrem 2 bucles for i creem
	 * una matriu de eixes dimensions.
	 * 
	 * @return La matriu creada de nom tauler.
	 */
	static int[][] creaTaulerDeVots() {

		int qCantants = Teclat.lligInt("Quants cantants tindrà la competició: ", 1);

		int qJutges = Teclat.lligInt("Quants jutges tindrà la competició: ", 1);

		int[][] tauler = new int[qCantants + 1][qJutges + 1];

		for (int cantant = 1; cantant <= qJutges; cantant++) {
			for (int jutge = 1; jutge <= cantant; jutge++) {
				tauler[cantant][jutge] = 0;

			}
		}
		return tauler;

	}

	// Funció fesVotacions

	/**
	 * Funció que rep com a paràmetre un tauler, en una quantitat de files iguals a
	 * cantants i columnes igual a jutges. Aquesta funció crida a altra de nom
	 * votaJutge, tantes vegades com jutges hi ha.
	 * 
	 * @param tauler, matriu de files per columnes = cantants, jutges.
	 */
	static void fesVotacions(int[][] tauler) {
		for (int jutge = 1; jutge < tauler.length - 1; jutge++) {

			votaJutge(tauler, jutge);
		}

	}

	// Funció votaJutge

	static void votaJutge(int[][] tauler, int jutge) {
		System.out.println();
		Pantalla.titolet("VOTA EL JUTGE NÚMERO: " + jutge);
		System.out.println();

//		int numVotacionsJutge = 0;
		int prefPunts = 0;
//		while (numVotacionsJutge < 4) {
//			prefPunts++;
//			numVotacionsJutge++;
		votaJutgeACantant(tauler, jutge, prefPunts);

	}
//		numVotacionsJutge = 0;

	// Funció votaJutgeACantant

	static void votaJutgeACantant(int[][] tauler, int jutge, int prefPunts) {
		int punts = puntsSegonsOrdre(prefPunts);
		int nCantant = Teclat.lligInt("-- " + punts + " punts per al cantant ", 1, tauler.length - 1);
		if (tauler[nCantant][jutge] == punts) {
			System.out.println("Este jutge ja ha votat eixe cantant. Dis-me un altre.");
		}
		tauler[nCantant][jutge] = punts;

	}

	// Funció puntsSegonsOrdre

	static int puntsSegonsOrdre(int prefPunts) {

		int puntsOrdre[] = { 0, 2, 4, 5, 6, 7, 8, 10, 12 };

		return puntsOrdre[prefPunts];

	}

	// Funció mostraPuntuacions

	static void mostraPuntuacions(int[][] tauler) {
		System.out.println("\t");
		for (int jutge = 1; jutge < tauler[0].length; jutge++) {
			System.out.print(" " + jutge + "\t");
		}
		System.out.println(" ");

		for (int cantant = 1; cantant < tauler.length; cantant++) {
			System.out.print(cantant + "\t");
			for (int jutge = 1; jutge < tauler[0].length; jutge++) {
				System.out.print(" " + tauler[cantant][jutge] + "\t");

			}
			System.out.println(" ");
		}

	}
}
