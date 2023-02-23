package programa;

import java.util.ArrayList;
import java.util.HashMap;

import Teclat.*;

public class FuncionsBF {

	// ********************CREACIÓ DE LA MATRIU DE VOTS***********************

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

	// *****************INTRODUCCIÓ DE LES DADES DELS VOTS**************************

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

	/**
	 * Funcio que rep 2 paràmetres, el tauler que és la matriu creada. Files =
	 * cantants, columnes = jutges, i el número de jutge de la funció fesVotacions.
	 * Aquesta funció crida a una altra, votaJutgeCantant, que li passa com a
	 * paràmetres la matriu, el número de jutge i la preferència de punts. Recorre
	 * amb un bucle for, fins que el jutge vote 8 vegades.
	 * 
	 * 
	 * @param tauler la matriu de cantants i jutges
	 * @param jutge  numérod e jutge que rep de la funció feVotaions
	 */
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

	/**
	 * Funció que demana per teclat a quin número de cantant que existesca en la
	 * matriu vol votar. Si el número de jutge ja ha votat es torna a demanar fins
	 * que siga correcte.
	 * 
	 * @param tauler
	 * @param jutge
	 * @param prefPunts
	 */
	static void votaJutgeACantant(int[][] tauler, int jutge, int prefPunts) {

		int punts = puntsSegonsOrdre(prefPunts);

		boolean cantantVotat = false;
		while (cantantVotat == false) {

			int nCantant = Teclat.lligInt("-- " + punts + " punts per al cantant ", 1, tauler[0].length - 1);

			if (tauler[jutge][nCantant] != 0) {
				System.out.println("Eixe jutge ja ha votat a eixe cantant. Dis-me altre.");

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

	// *****************MOSTREM ELS RESULTATS*****************************

	// Funció mostraPuntuacions

	static void mostraPuntuacions(int[][] tauler) {
		System.out.println();
		System.out.println("******************************************************");
		System.out.println();
		Pantalla.titolet("RESULTATS DE LES VOTACIONS");
		System.out.print("\t");
		for (int jutge = 1; jutge < tauler.length; jutge++) {
			System.out.print("(" + jutge + ")\t");
		}
		System.out.println();

		for (int cantant = 1; cantant < tauler[0].length; cantant++) {
			System.out.print("(" + cantant + ")\t");
			for (int jutge = 1; jutge < tauler.length; jutge++) {
				System.out.print(tauler[jutge][cantant] + "\t");
			}
			System.out.println();
		}
	}

	// Funció puntsCantant

	static int puntsCantant(int[][] tauler, int cantant) {

		int totalPunstCantant = 0;
		for (int jutge = 1; jutge < tauler.length; jutge++) {
			totalPunstCantant += tauler[jutge][cantant];
		}
		return totalPunstCantant;
	}

	// Funció guanyador

	static int guanyador(int[][] tauler) {
		int cantantGuanyador = 0;
		int puntsGuanyador = 0;

		for (int cantant = 1; cantant < tauler[0].length; cantant++) {
			int sumaPunts = puntsCantant(tauler, cantant);
			if (sumaPunts > puntsGuanyador) {
				puntsGuanyador = sumaPunts;
				cantantGuanyador = cantant;
			}

		}
		return cantantGuanyador;

	}

	// Funció liniaPunts

	static void liniaPunts(int quantitat) {

	}

	// Funció hiHaNoVotats

	static boolean hiHaNoVotats(int[][] tauler) {
		for (int cantant = 1; cantant < tauler[0].length; cantant++) {
			int noVotat = puntsCantant(tauler, cantant);
			if (noVotat == 0) {
				return true;

			}
		}
		return false;

	}

	// Funció tipusCantant

	static String tipusCantant(int[][] tauler, int cantant) {

		int punts = puntsCantant(tauler, cantant);

		if (punts <= 10) {
			return "roin";
		}
		if (punts <= 20) {
			return "regular";

		}
		if (punts <= 30) {
			return "bo";

		}
		return "crak";
	}
}
