package programa;

import Teclat.Pantalla;

public class MainBF {
	public static void main(String[] args) {
		
		
		Pantalla.titol("¡¡¡BENVINGUTS AL BINIDORM FEST!!!");
		
		int [][] tauler;
		tauler = FuncionsBF.creaTaulerDeVots();		
		
		FuncionsBF.fesVotacions(tauler);
	}

}
