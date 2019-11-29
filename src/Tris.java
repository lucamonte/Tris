import java.io.*;

public class Tris {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static String[][] griglia = new String[3][3];
	static String giocatore1 = "", giocatore2 = "", nome1 = "", nome2 = "";
	static boolean check = true;
	static int i = 1;
	static int vittorieX = 0, vittorieO = 0, pareggio = 0;

	public static void main(String[] args) {

		sceltaLettera();
		gioco(); 
	}

	/*------------------------------------------------------------------------*/
	public static void sceltaLettera() {

		try { //inserimento lettera dall'utente
			System.out.print("TRIS v. 1.3.3 ----> by BIFRIC && MONLUA");	
			System.out.print("\n\nCiao, benvenuto al gioco del tris\n\nGiocatore 1, come ti chiami? -> ");
			nome1 = reader.readLine();
			while(nome1.trim().equals("")) {
				System.out.print("Attenzione: � necessario inserire un nome -> ");
				nome1 = reader.readLine();
			}
			System.out.print("\nGiocatore 2, come ti chiami? -> ");
			nome2 = reader.readLine();
			while(nome2.trim().equals("")) {
				System.out.print("Attenzione: � necessario inserire un nome -> ");
				nome2 = reader.readLine();
			}
			
			System.out.print("\n" + nome1 + ", che lettera vuoi fare? (X/O) -> ");
			giocatore1 = reader.readLine().toUpperCase();	
			while (!((giocatore1.equals("X")) || (giocatore1.equals("O")))) {
				System.out.print("Lettera da te selezionata non fra le opzioni possibili. Riprova -> ");
				giocatore1 = reader.readLine().toUpperCase();
			}
		} catch (Exception e) {
			System.out.println("Errore durante l'inserimento della lettera" + e.getMessage());
		}

		//altro giocatore umano
		if (giocatore1.equals("X")) {
			giocatore2 = "O";


		} else if (giocatore1.equals("O")) {
			giocatore2 = "X";
		}

		System.out.println("\nGiocatore 1 (" + nome1 + "): " + giocatore1 + "\nGiocatore 2 (" + nome2 + "): " + giocatore2);
	}

	/*------------------------------------------------------------------------*/
	public static void gioco() {
		System.out.println("\nIn che posizione vuoi mettere la lettera?\n");
		System.out.println("1 | 2 | 3 ");
		System.out.println("4 | 5 | 6 ");
		System.out.println("7 | 8 | 9 ");

		for (int c = 0; c < 3; c++) {
			for (int r = 0; r < 3; r++) {
				griglia[c][r] = " - ";
			}
		}

		casella();


	}

	/*------------------------------------------------------------------------*/
	public static void casella() {

		String scelta = "";

		for (; i < 10; i++) {

			//ciclo per le 9 caselle della griglia
			//se per� la casella � gi� occupata reinserire il numuero
			try {// inserimento del numero con controllo che sia tale
				if(!((i%2) == 0)) {
					System.out.print("\n" + nome1 + " (" + giocatore1 + "), inserisci il numero della casella: -> ");
				} else if ((i%2) == 0) {
					System.out.print("\n" + nome2 + " (" + giocatore2 + "), inserisci il numero della casella: -> ");
				}

				scelta = reader.readLine();

				while (!((scelta.equals("1")) || (scelta.equals("2")) || (scelta.equals("3")) || (scelta.equals("4")) || (scelta.equals("5")) || (scelta.equals("6")) || (scelta.equals("7")) || (scelta.equals("8")) || (scelta.equals("9")))) {
					System.out.print("Errore: inserire un numero valido -> ");
					scelta = reader.readLine();
				}

				if(!((i%2) == 0)){
					g1(scelta);
				}

				if((i%2) == 0){
					g2(scelta);
				} 



			} catch (Exception e) {
				System.out.println("Errore inserimento numero " + e.getMessage());
			}

		}
	}

	//stampa della griglia





	/*------------------------------------------------------------------------*/
	public static void g1(String scelta) {
		int scelta_local = Integer.parseInt(scelta);
		String lettera = giocatore1;

		controllo(scelta_local, lettera);

	}

	/*------------------------------------------------------------------------*/
	public static void g2(String scelta) {

		int scelta_local = Integer.parseInt(scelta);
		String lettera = giocatore2;

		controllo(scelta_local, lettera);


	}

	/*------------------------------------------------------------------------*/
	public static void controllo(int c, String l) {

		if (l.equals("X")) {
			switch (c) {
			case 1:
				if (griglia[0][0].equals(" - ")) {
					griglia[0][0] = " X ";
					check = true;
					vittoria();
				} else {
					System.out.println("Casella gi� occupata");
					check = false;
					casella();

				}

				break;
			case 2:
				if (griglia[0][1].equals(" - ")) {
					griglia[0][1] = " X ";
					check = true;
					vittoria();
				} else {
					System.out.println("Casella gi� occupata");
					check = false;
					casella();

				}

				break;
			case 3:
				if (griglia[0][2].equals(" - ")) {
					griglia[0][2] = " X ";
					check = true;
					vittoria();
				} else {
					System.out.println("Casella gi� occupata");
					check = false;
					casella();


				}

				break;
			case 4:
				if (griglia[1][0].equals(" - ")) {
					griglia[1][0] = " X ";
					check = true;
					vittoria();
				} else {
					System.out.println("Casella gi� occupata");
					check = false;
					casella();

				}

				break;
			case 5:
				if (griglia[1][1].equals(" - ")) {
					griglia[1][1] = " X ";
					check = true;
					vittoria();
				} else {
					System.out.println("Casella gi� occupata");
					check = false;
					casella();

				}

				break;
			case 6:
				if (griglia[1][2].equals(" - ")) {
					griglia[1][2] = " X ";
					check = true;
					vittoria();
				} else {
					System.out.println("Casella gi� occupata");
					check = false;
					casella();

				}

				break;
			case 7:
				if (griglia[2][0].equals(" - ")) {
					griglia[2][0] = " X ";
					check = true;
					vittoria();
				} else {
					System.out.println("Casella gi� occupata");
					check = false;
					casella();

				}

				break;
			case 8:
				if (griglia[2][1].equals(" - ")) {
					griglia[2][1] = " X ";
					check = true;
					vittoria();
				} else {
					System.out.println("Casella gi� occupata");
					check = false;
					casella();

				}

				break;
			case 9:
				if (griglia[2][2].equals(" - ")) {
					griglia[2][2] = " X ";
					check = true;
					vittoria();
				} else {
					System.out.println("Casella gi� occupata");
					check = false;
					casella();

				}

				break;

			}

		}

		if (l.equals("O")) {

			switch (c) {
			case 1:
				if (griglia[0][0].equals(" - ")) {
					griglia[0][0] = " O ";
					check = true;
					vittoria();
				} else {
					System.out.println("Casella gi� occupata");
					check = false;
					casella();

				}

				break;
			case 2:
				if (griglia[0][1].equals(" - ")) {
					griglia[0][1] = " O ";
					check = true;
					vittoria();
				} else {
					System.out.println("Casella gi� occupata");
					check = false;
					casella();

				}

				break;
			case 3:
				if (griglia[0][2].equals(" - ")) {
					griglia[0][2] = " O ";
					check = true;
					vittoria();
				} else {
					System.out.println("Casella gi� occupata");
					check = false;
					casella();

				}

				break;
			case 4:
				if (griglia[1][0].equals(" - ")) {
					griglia[1][0] = " O ";
					check = true;
					vittoria();
				} else {
					System.out.println("Casella gi� occupata");
					check = false;
					casella();

				}

				break;
			case 5:
				if (griglia[1][1].equals(" - ")) {
					griglia[1][1] = " O ";
					check = true;
					vittoria();
				} else {
					System.out.println("Casella gi� occupata");
					check = false;
					casella();

				}

				break;
			case 6:
				if (griglia[1][2].equals(" - ")) {
					griglia[1][2] = " O ";
					check = true;
					vittoria();
				} else {
					System.out.println("Casella gi� occupata");
					check = false;
					casella();

				}

				break;
			case 7:
				if (griglia[2][0].equals(" - ")) {
					griglia[2][0] = " O ";
					check = true;
					vittoria();

				} else {
					System.out.println("Casella gi� occupata");
					check = false;
					casella();

				}

				break;
			case 8:
				if (griglia[2][1].equals(" - ")) {
					griglia[2][1] = " O ";
					check = true;
					vittoria();
				} else {
					System.out.println("Casella gi� occupata");
					check = false;
					casella();

				}

				break;
			case 9:
				if (griglia[2][2].equals(" - ")) {
					griglia[2][2] = " O ";
					check = true;
					vittoria();
				} else {
					System.out.println("Casella gi� occupata");
					check = false;
					casella();

				}

				break;

			}

		}
		printGrid();
	}



	/*------------------------------------------------------------------------*/
	public static void printGrid() {

		System.out.print("\n");

		for (int c = 0; c < 3; c++) {
			for (int r = 0; r < 3; r++) {
				System.out.print(griglia[c][r]);



			}
			System.out.print("\n");
		}

	}

	public static void vittoria() {


		for(int j=0;j<3;j++) {

			if((griglia[j][0].equals(" X "))&&(griglia[j][1].equals(" X "))&&(griglia[j][2].equals(" X "))) {
				System.out.println("Ha vinto "+nome1+" sulla riga: " + j+1);
				vittorieX=vittorieX+1;
				printGrid();
				richiestaGioco();

			}
			if((griglia[j][0].equals(" O "))&&(griglia[j][1].equals(" O "))&&(griglia[j][2].equals(" O "))) {
				System.out.println("Ha vinto "+nome2+" sulla riga: " + j+1);
				vittorieO=vittorieO+1;
				printGrid();
				richiestaGioco();
			}
		}

		for(int k=0;k<3;k++) {

			if((griglia[0][k].equals(" X "))&&(griglia[1][k].equals(" X "))&&(griglia[2][k].equals(" X "))) {
				System.out.println("Ha vinto "+nome1+" sulla riga: " + k+1);
				vittorieX=vittorieX+1;
				printGrid();
				richiestaGioco();


			}
			if((griglia[0][k].equals(" O "))&&(griglia[1][k].equals(" O "))&&(griglia[2][k].equals(" O "))) {
				System.out.println("Ha vinto "+nome2+" sulla riga: " + k+1);
				vittorieO=vittorieO+1;
				printGrid();
				richiestaGioco();

			}



			if((griglia[0][0].equals(" X "))&&(griglia[1][1].equals(" X "))&&(griglia[2][2].equals(" X "))) {
				System.out.println("Ha vinto "+nome1);
				vittorieX=vittorieX+1;
				printGrid();
				richiestaGioco();

			}
			if((griglia[0][0].equals(" O "))&&(griglia[1][1].equals(" O "))&&(griglia[2][2].equals(" O "))) {
				System.out.println("Ha vinto "+nome2);
				vittorieO=vittorieO+1;
				printGrid();
				richiestaGioco();
			}

			if((griglia[0][2].equals(" X "))&&(griglia[1][1].equals(" X "))&&(griglia[2][0].equals(" X "))) {
				System.out.println("Ha vinto "+nome1);
				vittorieX=vittorieX+1;
				printGrid();
				richiestaGioco();

			}
			if((griglia[0][2].equals(" O "))&&(griglia[1][1].equals(" O "))&&(griglia[2][0].equals(" O "))) {
				System.out.println("Ha vinto "+nome2);
				vittorieO = vittorieO + 1;
				printGrid();
				richiestaGioco();
			}

			if(i==9) {
				System.out.println("PAREGGIO");
				pareggio = pareggio+1;
				printGrid();
				richiestaGioco();
			}




		}

	}


	public static void stampaRisultato() {

		System.out.println("\n Vittorie di " + nome1 + ": " + vittorieX);
		System.out.println("\n Vittorie di " + nome2 + ": " + vittorieO);
		System.out.println("\n Pareggi: " + pareggio);
	}


	public static void richiestaGioco() {
		String richiesta = "", tmp = "";
	
		stampaRisultato();

		try {
			System.out.print("\n\nVuoi fare un altra partita? (S/N) -> ");
			richiesta = reader.readLine().toLowerCase();
			while(!(richiesta.equals("s"))&&!(richiesta.equals("n")))
			{
				System.out.print("\nErrore inserimento scelta, prego riprovare: (S/N) -> ");
				richiesta = reader.readLine().toLowerCase();
			}

			if(richiesta.equals("s")) {
				i=1;
				tmp = giocatore1;
				giocatore1 = giocatore2; 
				giocatore2 = tmp;
				tmp = nome1;
				nome1 = nome2;
				nome2 = tmp;
				gioco();
			} else if(richiesta.equals("n")) {
				System.out.println("Gioco terminato con successo.\n");
				for(int i = 5; i >= 0; i--) {
					
					System.out.print("L'app si chiuder� tra " + i +" secondi");

					}
					
					Thread.sleep(1000);
				if(i == 0) System.out.println("App chiusa.");
				}
				System.exit(0);
			
		} catch(Exception e) {
			System.out.println("Errore: " + e.getMessage());
		}
	}

}