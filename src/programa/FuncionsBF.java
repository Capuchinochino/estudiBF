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

	static void fesVotacions(int[][] tauler) {
		for (int jutge = 1; jutge < tauler.length; jutge++) {

			votaJutge(tauler, jutge);
		}

	}

	// Funció votaJutge

	static void votaJutge(int[][] tauler, int jutge) {
		System.out.println("Vota el jutge número: " + jutge);

		for (int jut = 1; jut < tauler.length; jut++) {
			int preferencia = Teclat.lligInt("Ordre de preferència per als punts: ", 1, 8);
			votaJutgeACantant(tauler, jutge, preferencia);
		}

	}

	// Funció votaJutgeACantant

	static void votaJutgeACantant(int[][] tauler, int jutge, int pref) {

		int nCantant = Teclat.lligInt("Número de cantant a votar: ", 1, tauler[0].length - 1);

		int punts = puntsSegonsOrdre(pref);
		System.out.println(punts + " Punts per al cantant " + nCantant);
		tauler[jutge][nCantant] = punts;
		

	}

	// Funció puntsSegonsOrdre

	static int puntsSegonsOrdre(int pref) {
		int vots = 0;
		switch (pref) {

		case 1:
			vots = 2;
			break;

		case 2:
			vots = 4;
			break;
		case 3:
			vots = 5;
			break;

		case 4:
			vots = 6;
			break;
		case 5:
			vots = 7;
			break;

		case 6:
			vots = 8;
			break;
		case 7:
			vots = 10;
			break;

		case 8:
			vots = 12;
			break;
		}
		return vots;

	}

}
