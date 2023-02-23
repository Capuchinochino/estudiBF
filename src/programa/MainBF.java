package programa;

import Teclat.Pantalla;

public class MainBF {
	public static void main(String[] args) {

		Pantalla.titol("¡¡¡VOTACIONS DEL BENIDORM FEST!!!");

		// *****************CRIDA A LA FUNCIÓ PER A CREAR EL TAULER+++++++++++++++
		int[][] tauler;
		tauler = FuncionsBF.creaTaulerDeVots();

		// *****************CRIDA PER A FER LES VOTACIONS+++++++++++++++
		FuncionsBF.fesVotacions(tauler);

		// ******CRIDA PER MOSTRAR LES PUNTUACIONS DE CADAJUTGE+++++

		FuncionsBF.mostraPuntuacions(tauler);

		// *****CRIDES PER A MOSTRAR EL CANTANT GUANYADOR I ELS SEUS PUNTS+++++++

		int guanyador = FuncionsBF.guanyador(tauler);
		int punts = FuncionsBF.puntsCantant(tauler, guanyador);
		System.out.println();
		Pantalla.titol("GUANYADOR, CANTANT " + guanyador + " AMB " + punts + " PUNTS.");

		// ++++++++++CRIDA PER MOSTRAR "*" SEGONS PUNTS DE FORMA RECURSIVA+++++++++
		FuncionsBF.liniaPunts(punts);

		// ++++++++CRIDA PER MOSTRAR EL TIPUS DE CANTANT SEGONS VOTACIONS+++++++
		System.out.println();
		Pantalla.titolet("Tipus de cantants:");
		for (int cantant = 1; cantant < tauler[0].length; cantant++) {

			String catCantant = FuncionsBF.tipusCantant(tauler, cantant);
			System.out.println("El cantant " + cantant + " és: " + catCantant);
		}

		// +++++++++++CRIDA PER MOSTRAR ALGUN CANTANT SENSE VOTS**********
		System.out.println();
		boolean noVotats = FuncionsBF.hiHaNoVotats(tauler);
		if (noVotats) {
			Pantalla.titolet("Hi ha algun cantant no votat.");
			System.out.println();
		} else {
			Pantalla.titolet("Tots els cantans han tingut vots.");
		}

	}

}
