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
	}
	public int contarBombasCerca(int fila, int columna) {
		int contador=0;
		for (int i = fila-1; i <=fila+1; i++) {
			for (int j = columna-1; j <= columna+1; j++) {
				if (i >= 0 && i < numFilas && j >= 0 && j < numColumnas) {
					if(tablero[i][j].isBomba()) {
						contador++;	
					}
				}
			}
		}
		return contador;
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
