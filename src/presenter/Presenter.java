package presenter;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;

import model.Casilla;
import model.Tablero;
import view.View;

public class Presenter implements ActionListener{
	private View view;
	private Tablero buscaminas;

	public Presenter() {
		this.buscaminas = new Tablero(12,12,15);
		this.view= new View(this, new Dimension(buscaminas.getNumFilas(),buscaminas.getNumColumnas()));
		reset();
		
	}
	public void run() {
	}
//	public void botonClic(int fila, int columna) {
//		Casilla casilla = buscaminas.obtenerCasilla(fila, columna);
//		view.mostrarContenido(casilla);  
//	}
	public void nivelFacil() {
		buscaminas.setNumFilas(12);
		buscaminas.setNumColumnas(12);
		buscaminas.setNumMinas(15);
	}
	public void nivelMedio() {
		buscaminas.setNumFilas(18);
		buscaminas.setNumColumnas(18);
		buscaminas.setNumMinas(40);
	}
	public void nivelDificil() {
		buscaminas.setNumFilas(24);
		buscaminas.setNumColumnas(24);
		buscaminas.setNumMinas(99);
	}
	public void reset() {
		view.setDimensiones(new Dimension(buscaminas.getNumFilas(),buscaminas.getNumColumnas()));
		view.reset(this);
		this.buscaminas.resetTablero();
		buscaminas.crearTableroCasillas();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Facil": 
			nivelFacil();
			reset();
			break;
		case "Medio":
			nivelMedio();
			reset();
			break;
		case "Dificil":
			nivelDificil();
			reset();
			break;			
		default:
			eventoBotones(e.getActionCommand().split(","));
			System.out.println("llega a evento?");
			//throw new IllegalArgumentException("Unexpected value: " + e.getActionCommand());
		}
		
//		JButton [][] matBotones = view.getMatrizBotones();
//		for (int i = 0; i < matBotones.length; i++) {
//			for (int j = 0; j < matBotones[i].length; j++) {
//				final int fila=i;
//				final int columna=j;
//				matBotones[i][j].addActionListener(new ActionListener() {
//					@Override
//					public void actionPerformed(ActionEvent e) {
//						botonClic(fila, columna);
//						matBotones[fila][columna].setVisible(false);
//						view.setMatrizBotones(matBotones);
//					
//					}
//				});

	}

	private void eventoBotones(String [] posicion){
		int fila = Integer.parseInt(posicion[0]);
		int columna = Integer.parseInt(posicion[1]);
		Casilla aux =buscaminas.getTablero()[fila][columna];
		aux.setEstado(true);
		if(aux.isBomba()){
			view.eventoBotones(infoMinas());
		}else{
			infoBotones(aux.getNumero(),fila,columna);
		}
	}


	private ArrayList<String[]> infoMinas(){
		ArrayList<String[]> minas = new ArrayList<>();

		return minas;
	}



	private void infoBotones(int accion,int fila,int columna){
		String [] aux= new String[2];
		System.out.println("los ptos botones");
		if (accion>0){
			aux[0] = String.valueOf(((fila)*buscaminas.getNumColumnas())+columna);
			aux[1] = String.valueOf(accion);
			view.eventoBotones(aux);
		} else{
				//Se envia ArrayList<String[]> que contiene la informadcion de los botones vacios
		}
	}

}	

