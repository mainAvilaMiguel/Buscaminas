package model;

import java.util.Iterator;
import java.util.Random;

public class Tablero {
	private int numFilas;
	private int numColumnas;
	private Casilla[][]tablero;
	private int numMinas;
	
	public Tablero(int numFilas, int numColumnas, int numMinas) {
		this.numFilas = numFilas;
		this.numColumnas = numColumnas;
		this.numMinas = numMinas;
		tablero = new Casilla[numFilas][numColumnas];
	}
	public Tablero() {

	}
	public Casilla obtenerCasilla(int fila, int columna) {
		return tablero[fila][columna];
		
	}

	public void crearTableroCasillas() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[0].length; j++) {
				tablero[i][j]=new Casilla();
			}
		}
		this.asignarMinas();
	}


	public void asignarMinas() {
		Random rand = new Random();
		int minasLocalizadas=0;
		int fila=0;
		int columna=0;
		while(minasLocalizadas<numMinas) {
			fila = rand.nextInt(numFilas);
			columna = rand.nextInt(numColumnas);
			if(!tablero[fila][columna].isBomba()) {
				tablero[fila][columna].setBomba();
				minasLocalizadas++;
			}
		}
		imprimirCasillas();
		contarBombasCerca();
	}
	public void imprimirCasillas(){
		int mina=0;
		for (int i = 0; i < numFilas; i++) {
			for (int j = 0; j <numColumnas ; j++) {
				if (tablero[i][j].isBomba()){
					System.out.println("Mina el la fila: "+i+" columna :"+j+" numero de mina: "+mina);
					mina++;
				}
			}
		}
	}
	public void contarBombasCerca() {
		for (int i = 0; i <numFilas; i++) {
			for (int j = 0; j < numColumnas; j++) {
				if (!tablero[i][j].isBomba()){
					tablero[i][j].setNumero(verificarRadio(i,j));
					System.out.println(i+" "+j+" "+verificarRadio(i,j));
				}
			}
		}
	}

	public int verificarRadio(int fila,int columna){
		int catMinas =0;
		if (fila==0 && columna==0){
			catMinas = verificarE(fila,columna)+verificarSE(fila,columna)+verificarS(fila,columna);
		}else if (fila==(numFilas-1) && columna==0){
			catMinas = verificarN(fila, columna)+verificarNE(fila, columna)+verificarE(fila, columna);
		} else if (fila==0 && columna==(numColumnas-1)) {
			catMinas = verificarS(fila, columna)+verificarSW(fila, columna)+verificarW(fila, columna);
		} else if (fila==(numFilas-1)&&columna==(numColumnas-1)) {
			catMinas = verificarN(fila, columna)+verificarNW(fila, columna)+verificarW(fila, columna);
		} else if ((fila!=0 && fila<numFilas-1) && columna==0) {
			catMinas = verificarN(fila, columna)+verificarNE(fila, columna)+verificarE(fila, columna)
					+verificarSE(fila, columna)+verificarS(fila, columna);
		} else if (fila==0 && (columna!=0 && columna<numColumnas-1)) {
			catMinas = verificarS(fila, columna)+verificarSE(fila, columna)+verificarE(fila, columna)
					+verificarSW(fila, columna)+verificarW(fila, columna);
		} else if ((fila!=0 && fila<numFilas-1) && columna==numColumnas-1) {
			catMinas = verificarN(fila, columna)+verificarS(fila, columna)+verificarSW(fila, columna)
					+verificarW(fila, columna)+verificarNW(fila, columna);
		} else if (fila==numFilas-1 && (columna!=0 && columna<numColumnas-1)) {
			catMinas = verificarN(fila, columna)+verificarNE(fila, columna)+verificarE(fila, columna)
					+verificarNW(fila, columna)+verificarW(fila, columna);
		}else{
			catMinas = verificarN(fila, columna)+verificarNE(fila, columna)+verificarE(fila, columna)
					+verificarSE(fila, columna)+verificarS(fila, columna)+verificarSW(fila, columna)
					+verificarW(fila, columna) +verificarNW(fila, columna);
		}
		return catMinas;
	}

	public int verificarN(int fila,int columna){
		int counter=0;
		if (tablero[fila-1][columna].isBomba()) {
			counter++;
		}
		return counter;
	}

	public int verificarNE(int fila,int columna){
		int counter=0;
		if (tablero[fila-1][columna+1].isBomba()) {
			counter++;
		}
		return counter;
	}
	public int verificarNW(int fila,int columna){
		int counter=0;
		if (tablero[fila-1][columna-1].isBomba()) {
			counter++;
		}
		return counter;
	}

	public int verificarS(int fila,int columna){
		int counter=0;
		if (tablero[fila+1][columna].isBomba()) {
			counter++;
		}
		return counter;
	}

	public int verificarSE(int fila,int columna){
		int counter =0;
		if (tablero[fila+1][columna+1].isBomba()){
			counter++;
		}
		return counter;
	}

	public int verificarSW(int fila,int columna){
		int counter =0;
		if (tablero[fila+1][columna-1].isBomba()){
			counter++;
		}
		return counter;
	}

	public int verificarE(int fila,int columna){
		int counter =0;
		if (tablero[fila][columna+1].isBomba()){
			counter++;
		}
		return counter;
	}

	public int verificarW(int fila,int columna){
		int counter =0;
		if (tablero[fila][columna-1].isBomba()){
			counter++;
		}
		return counter;
	}

	public int getNumFilas() {
		return numFilas;
	}
	public void setNumFilas(int numFilas) {
		this.numFilas = numFilas;
	}
	public int getNumColumnas() {
		return numColumnas;
	}
	public void setNumColumnas(int numColumnas) {
		this.numColumnas = numColumnas;
	}
	public Casilla[][] getTablero() {
		return tablero;
	}
	public void setTablero(Casilla[][] tablero) {
		this.tablero = tablero;
	}
	public int getNumMinas() {
		return numMinas;
	}
	public void setNumMinas(int numMinas) {
		this.numMinas = numMinas;
	}
	
	
	
}
