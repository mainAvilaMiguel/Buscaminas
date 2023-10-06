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
					mina++;
					System.out.println("Fila: "+i+"  Columna: " + j + "  Numero mina: "+mina);
				}
			}
		}
	}
	public void contarBombasCerca() {
		for (int i = 0; i <numFilas-1; i++) {
			for (int j = 0; j < numColumnas-1; j++) {
				tablero[i][j].setNumero(verificarRadio(i,j));
				if (i >= 0 && i < numFilas && j >= 0 && j < numColumnas) {
					if(tablero[i][j].isBomba()) {

					}
				}
			}
		}

	}

	public int verificarRadio(int fila,int columna){
		int catMinas =0;
		if (fila==0 && columna==0){

		}else {

		}
		return catMinas;
	}

	public int verificarN(int fila,int columna){
		int counter=0;
		if (tablero[fila+1][columna].isBomba()) {
			counter++;
		}
		return counter;
	}

	public int verificarNE(int fila,int columna){
		int counter=0;
		if (tablero[fila+1][columna+1].isBomba()) {
			counter++;
		}
		return counter;
	}
	public int verificarNW(int fila,int columna){
		int counter=0;
		if (tablero[fila+1][columna-1].isBomba()) {
			counter++;
		}
		return counter;
	}

	public int verificarS(int fila,int columna){
		int counter=0;
		if (tablero[fila-1][columna].isBomba()) {
			counter++;
		}
		return counter;
	}

	public int verificarSE(){
		return 0;
	}

	public int verificarSW(){
		return 0;
	}

	public int verificarE(){
		return 0;
	}

	public int verificarW(){
		return 0;
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
