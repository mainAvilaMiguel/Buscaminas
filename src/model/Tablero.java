package model;

import java.awt.*;
import java.util.ArrayList;
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
				//	System.out.println("Mina el la fila: "+i+" columna :"+j+" numero de mina: "+mina);
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
					//System.out.println("Fila: "+i+ "   Columna: "+j+"    numero de minas:  "+ tablero[i][j].getNumero());
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
	public boolean verificarPunto(ArrayList<Point> points,Point p){
		boolean response = false;
		for (Point point:points) {
			if (points.equals(p)) {
				response = true;
			}
		}
        return response;
    }
	public ArrayList<Point> vaciosCercanos(ArrayList<Point> verificacionVacios){
		ArrayList<Point> tmp = verificacionVacios;
		Point aux;
		for (Point p:tmp) {
			if (p.x == 0 && p.y == 0) {
					aux = verificarVaciosE(p.x, p.y);
					if ((aux.x != -1) && (aux.y != -1) && !verificarPunto(verificacionVacios,aux)) {
							tmp.add(aux);
					}
					aux = verificarVaciosSE(p.x, p.y);
					if ((aux.x != -1) && (aux.y != -1) && !verificarPunto(verificacionVacios,aux)) {
						tmp.add(aux);
					}
					aux = verificarVaciosS(p.x, p.y);
					if ((aux.x != -1) && (aux.y != -1) && !verificarPunto(verificacionVacios,aux)) {
						tmp.add(aux);
					}
			} else if (p.x == (numFilas - 1) && p.y == 0) {
				aux= verificarVaciosN(p.x,p.y);
				if ((aux.x != -1) && (aux.y != -1)  && !verificarPunto(verificacionVacios,aux)) {
					tmp.add(aux);
				}
				aux= verificarVaciosNE(p.x,p.y);
				if ((aux.x != -1) && (aux.y != -1)  && !verificarPunto(verificacionVacios,aux)) {
					tmp.add(aux);
				}
				aux= verificarVaciosE(p.x,p.y);
				if ((aux.x != -1) && (aux.y != -1)  && !verificarPunto(verificacionVacios,aux)) {
					tmp.add(aux);
				}
			} else if (p.x == 0 && p.y == (numColumnas - 1)) {
				aux= verificarVaciosW(p.x,p.y);
				if ((aux.x != -1) && (aux.y != -1) && !verificarPunto(verificacionVacios,aux)) {
					tmp.add(aux);
				}
				aux= verificarVaciosSW(p.x,p.y);
				if ((aux.x != -1) && (aux.y != -1)  && !verificarPunto(verificacionVacios,aux)) {
					tmp.add(aux);
				}
				aux= verificarVaciosS(p.x,p.y);
				if ((aux.x != -1) && (aux.y != -1)  && !verificarPunto(verificacionVacios,aux)) {
					tmp.add(aux);
				}
			} else if (p.x == (numFilas - 1) && p.y == (numColumnas - 1)) {
				aux= verificarVaciosN(p.x,p.y);
				if ((aux.x != -1) && (aux.y != -1)  && !verificarPunto(verificacionVacios,aux)) {
					tmp.add(aux);
				}
				aux= verificarVaciosNW(p.x,p.y);
				if ((aux.x != -1) && (aux.y != -1)  && !verificarPunto(verificacionVacios,aux)) {
					tmp.add(aux);
				}
				aux= verificarVaciosW(p.x,p.y);
				if ((aux.x != -1) && (aux.y != -1) && !verificarPunto(verificacionVacios,aux)) {
					tmp.add(aux);
				}
			} else if ((p.x != 0 && p.x < numFilas - 1) && p.y == 0) {
				aux= verificarVaciosN(p.x,p.y);
				if ((aux.x != -1) && (aux.y != -1)  && !verificarPunto(verificacionVacios,aux)) {
					tmp.add(aux);
				}
				aux= verificarVaciosNE(p.x,p.y);
				if ((aux.x != -1) && (aux.y != -1)  && !verificarPunto(verificacionVacios,aux)) {
					tmp.add(aux);
				}
				aux= verificarVaciosE(p.x,p.y);
				if ((aux.x != -1) && (aux.y != -1)  && !verificarPunto(verificacionVacios,aux)) {
					tmp.add(aux);
				}
				aux= verificarVaciosSE(p.x,p.y);
				if ((aux.x != -1) && (aux.y != -1)  && !verificarPunto(verificacionVacios,aux)) {
					tmp.add(aux);
				}
				aux= verificarVaciosS(p.x,p.y);
				if ((aux.x != -1) && (aux.y != -1)  && !verificarPunto(verificacionVacios,aux)) {
					tmp.add(aux);
				}
			} else if (p.x == 0 && (p.y != 0 && p.y < (numColumnas - 1))) {
				aux= verificarVaciosW(p.x,p.y);
				if ((aux.x != -1) && (aux.y != -1) && !verificarPunto(verificacionVacios,aux)) {
					tmp.add(aux);
				}
				aux= verificarVaciosSW(p.x,p.y);
				if ((aux.x != -1) && (aux.y != -1)  && !verificarPunto(verificacionVacios,aux)) {
					tmp.add(aux);
				}
				aux= verificarVaciosS(p.x,p.y);
				if ((aux.x != -1) && (aux.y != -1)  && !verificarPunto(verificacionVacios,aux)) {
					tmp.add(aux);
				}
				aux= verificarVaciosSE(p.x,p.y);
				if ((aux.x != -1) && (aux.y != -1)  && !verificarPunto(verificacionVacios,aux)) {
					tmp.add(aux);
				}
				aux= verificarVaciosE(p.x,p.y);
				if ((aux.x != -1) && (aux.y != -1)  && !verificarPunto(verificacionVacios,aux)) {
					tmp.add(aux);
				}
			} else if ((p.x != 0 && p.x < numFilas - 1) && p.y == numColumnas - 1) {
				aux= verificarVaciosN(p.x,p.y);
				if ((aux.x != -1) && (aux.y != -1)  && !verificarPunto(verificacionVacios,aux)) {
					tmp.add(aux);
				}
				aux= verificarVaciosNW(p.x,p.y);
				if ((aux.x != -1) && (aux.y != -1)  && !verificarPunto(verificacionVacios,aux)) {
					tmp.add(aux);
				}
				aux= verificarVaciosW(p.x,p.y);
				if ((aux.x != -1) && (aux.y != -1)  && !verificarPunto(verificacionVacios,aux)) {
					tmp.add(aux);
				}
				aux= verificarVaciosSW(p.x,p.y);
				if ((aux.x != -1) && (aux.y != -1)  && !verificarPunto(verificacionVacios,aux)) {
					tmp.add(aux);
				}
				aux= verificarVaciosS(p.x,p.y);
				if ((aux.x != -1) && (aux.y != -1)  && !verificarPunto(verificacionVacios,aux)) {
					tmp.add(aux);
				}
			} else if (p.x == (numFilas - 1) && (p.y != 0 && p.y < numColumnas - 1)) {
				aux= verificarVaciosN(p.x,p.y);
				if ((aux.x != -1) && (aux.y != -1)  && !verificarPunto(verificacionVacios,aux)) {
					tmp.add(aux);
				}
				aux= verificarVaciosNW(p.x,p.y);
				if ((aux.x != -1) && (aux.y != -1)  && !verificarPunto(verificacionVacios,aux)) {
					tmp.add(aux);
				}
				aux= verificarVaciosW(p.x,p.y);
				if ((aux.x != -1) && (aux.y != -1)  && !verificarPunto(verificacionVacios,aux)) {
					tmp.add(aux);
				}
				aux= verificarVaciosE(p.x,p.y);
				if ((aux.x != -1) && (aux.y != -1)  && !verificarPunto(verificacionVacios,aux)) {
					tmp.add(aux);
				}
				aux= verificarVaciosNE(p.x,p.y);
				if ((aux.x != -1) && (aux.y != -1)  && !verificarPunto(verificacionVacios,aux)) {
					tmp.add(aux);
				}
			} else {
				aux= verificarVaciosN(p.x,p.y);
				if ((aux.x != -1) && (aux.y != -1) && !verificarPunto(verificacionVacios,aux)) {
					tmp.add(aux);
				}
				aux= verificarVaciosNW(p.x,p.y);
				if ((aux.x != -1) && (aux.y != -1) && !verificarPunto(verificacionVacios,aux)) {
					tmp.add(aux);
				}
				aux= verificarVaciosW(p.x,p.y);
				if ((aux.x != -1) && (aux.y != -1) && !verificarPunto(verificacionVacios,aux)) {
					tmp.add(aux);
				}
				aux= verificarVaciosSW(p.x,p.y);
				if ((aux.x != -1) && (aux.y != -1) && !verificarPunto(verificacionVacios,aux)) {
					tmp.add(aux);
				}
				aux= verificarVaciosS(p.x,p.y);
				if ((aux.x != -1) && (aux.y != -1) && !verificarPunto(verificacionVacios,aux)) {
					tmp.add(aux);
				}
				aux= verificarVaciosSE(p.x,p.y);
				if ((aux.x != -1) && (aux.y != -1) && !verificarPunto(verificacionVacios,aux)) {
					tmp.add(aux);
				}
				aux= verificarVaciosE(p.x,p.y);
				if ((aux.x != -1) && (aux.y != -1) && !verificarPunto(verificacionVacios,aux)) {
					tmp.add(aux);
				}
				aux= verificarVaciosNE(p.x,p.y);
				if ((aux.x != -1) && (aux.y != -1) && !verificarPunto(verificacionVacios,aux)) {
					tmp.add(aux);
				}
			}
		}
		return tmp;
	}

	public String checkVacios(int fila, int columna){
		String info = "";
		int size;
		ArrayList<Point> aux = new ArrayList<>();
		aux.add(new Point(fila,columna));
		System.out.println("llega a check?");

		do{
			size = aux.size();
			System.out.println("entra al do?");
			aux = vaciosCercanos((ArrayList<Point>) aux.clone());
			System.out.println("pasa el aux?");

		}while (size!=aux.size());
	/*	for (Casilla tmp:aux) {
			info += ","+tmp.getNumero()+"/";
		}*/
        return info;
    }
	public ArrayList<String[]> obtenerPosicionMinas() {
		String coordenadas[]=new String[2];
		ArrayList<String[]> infoMinas = new ArrayList<String[]>();
		for (int i = 0; i < numFilas; i++) {
			for (int j = 0; j < numColumnas; j++) {
				if(tablero[i][j].isBomba()) {
					coordenadas[0]=String.valueOf(i*numColumnas+j);
					coordenadas[1]=String.valueOf(-1);
					infoMinas.add(coordenadas);
				}
			}
		}
		return infoMinas;
	}
	private Point verificarVaciosN(int fila,int columna){
		Point aux = new Point(-1,-1);
		if (tablero[fila-1][columna].getNumero()==0) {
			aux.setLocation(fila-1,columna);
		}
		return aux;
	}

	private Point verificarVaciosNE(int fila,int columna){
		Point aux = new Point(-1,-1);
		if (tablero[fila-1][columna+1].isBomba()) {
			aux.setLocation(fila-1,columna+1);
		}
		return aux;
	}
	private Point verificarVaciosNW(int fila,int columna){
		Point aux = new Point(-1,-1);
		if (tablero[fila-1][columna-1].getNumero()==0) {
			aux.setLocation(fila-1,columna-1);
		}
		return aux;
	}

	private Point verificarVaciosS(int fila,int columna){
		Point aux = new Point(-1,-1);
		if (tablero[fila+1][columna].getNumero()==0) {
			aux.setLocation(fila+1,columna);
		}
		return aux;
	}

	private Point verificarVaciosSE(int fila,int columna){
		Point aux = new Point(-1,-1);
		if (tablero[fila+1][columna+1].getNumero()==0) {
			aux.setLocation(fila+1,columna+1);
		}
		return aux;
	}
	private Point verificarVaciosSW(int fila,int columna){
		Point aux = new Point(-1,-1);
		if (tablero[fila+1][columna-1].getNumero()==0) {
			aux.setLocation(fila+1,columna-1);
		}
		return aux;
	}

	private Point verificarVaciosE(int fila,int columna){
		Point aux = new Point(-1,-1);
		if (tablero[fila][columna+1].isBomba()){
			aux.setLocation(fila,columna+1);
		}
		return aux;
	}

	private Point verificarVaciosW(int fila,int columna){
		Point aux = new Point(-1,-1);
		if (tablero[fila][columna-1].isBomba()){
			aux.setLocation(fila,columna-1);
		}
		return aux;
	}

	private int verificarN(int fila,int columna){
		int counter=0;
		if (tablero[fila-1][columna].isBomba()) {
			counter++;
		}
		return counter;
	}

	private int verificarNE(int fila,int columna){
		int counter=0;
		if (tablero[fila-1][columna+1].isBomba()) {
			counter++;
		}
		return counter;
	}
	private int verificarNW(int fila,int columna){
		int counter=0;
		if (tablero[fila-1][columna-1].isBomba()) {
			counter++;
		}
		return counter;
	}

	private int verificarS(int fila,int columna){
		int counter=0;
		if (tablero[fila+1][columna].isBomba()) {
			counter++;
		}
		return counter;
	}

	private int verificarSE(int fila,int columna){
		int counter =0;
		if (tablero[fila+1][columna+1].isBomba()){
			counter++;
		}
		return counter;
	}

	private int verificarSW(int fila,int columna){
		int counter =0;
		if (tablero[fila+1][columna-1].isBomba()){
			counter++;
		}
		return counter;
	}

	private int verificarE(int fila,int columna){
		int counter =0;
		if (tablero[fila][columna+1].isBomba()){
			counter++;
		}
		return counter;
	}

	private int verificarW(int fila,int columna){
		int counter =0;
		if (tablero[fila][columna-1].isBomba()){
			counter++;
		}
		return counter;
	}

	public void resetTablero(){
        tablero = new Casilla[numFilas][numColumnas];
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
