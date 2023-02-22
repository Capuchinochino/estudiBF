package programa;

import java.util.ArrayList;
import java.util.HashMap;

import Teclat.*;

public class FuncionsBF {

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

		int[][] tauler = new int[qJutges + 1][qCantants + 1];

		for (int jutge = 1; jutge <= qJutges; jutge++) {
			for (int cantant = 1; cantant <= qCantants; cantant++) {
				tauler[jutge][cantant] = 0;

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
		for (int jutge = 1; jutge < tauler.length; jutge++) {

			votaJutge(tauler, jutge);
		}

	}

	// Funció votaJutge

	static void votaJutge(int[][] tauler, int jutge) {
		System.out.println();
		Pantalla.titolet("VOTA EL JUTGE NÚMERO: " + jutge);
		System.out.println();

		int prefPunts = 1;
		for (int i = 1; i <= 8; i++) {
			votaJutgeACantant(tauler, jutge, prefPunts);
			prefPunts++;
		}

	}

	// Funció votaJutgeACantant

	static void votaJutgeACantant(int[][] tauler, int jutge, int prefPunts) {

		boolean cantantVotat = false;
		int punts = puntsSegonsOrdre(prefPunts);

		while (cantantVotat == false) {

			int nCantant = Teclat.lligInt("-- " + punts + " punts per al cantant ", 1, tauler[0].length - 1);

			if (tauler[jutge][nCantant] == punts) {
				System.out.println("Eixe jutge ja ha votat a eixe cantant, des-me altre.");

			} else {
				tauler[jutge][nCantant] = punts;
				cantantVotat = true;
			}

		}

	}

	// Funció puntsSegonsOrdre

	static int puntsSegonsOrdre(int prefPunts) {

		int puntsOrdre[] = { 0, 2, 4, 5, 6, 7, 8, 10, 12 };

		return puntsOrdre[prefPunts];

	}

	// Funció mostraPuntuacions

	static void mostraPuntuacions(int[][] tauler) {
		System.out.print("\t");
		for (int jutge = 1; jutge < tauler.length; jutge++) {
			System.out.print(jutge + "\t");
		}
		System.out.println(" ");

		for (int cantant = 1; cantant < tauler[0].length; cantant++) {
			System.out.print(cantant + "\t");
			for (int jutge = 1; jutge < tauler.length; jutge++) {
				System.out.print(tauler[jutge][cantant] + "\t");

			}
			System.out.println();
		}

//		System.out.print("\t");
//		for (int jutge = 1; jutge < tauler.length; jutge++) {
//			System.out.print("(" + jutge + ")\t");
//		}
//		System.out.println();
//
//		for (int cantant = 1; cantant < tauler[0].length; cantant++) {
//			System.out.print("(" + cantant + ")\t");
//			for (int jutge = 1; jutge < tauler.length; jutge++) {
//				System.out.print(tauler[jutge][cantant] + "\t");
//			}
//			System.out.println();
//		}
	}
}
