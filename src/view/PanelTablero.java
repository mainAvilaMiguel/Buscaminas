package view;

import model.Casilla;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelTablero extends JPanel{

	public PanelTablero(ActionListener ac, Dimension dimensiones) {
		this.inicializarComponentes(ac,dimensiones);
	}
	public void configuracion(Dimension dimensiones){
		this.setLayout(new GridLayout(dimensiones.height,dimensiones.width,3,3));
	}
	public void inicializarComponentes(ActionListener ac, Dimension dimensiones) {
		crearTableroBotones(ac,dimensiones);
	}
	public void crearTableroBotones(ActionListener ac,Dimension dimensiones) {
		this.setLayout(new GridLayout(dimensiones.height,dimensiones.width,2,2));
		JButton boton;
		for (int i = 0; i < dimensiones.height; i++) {
			for (int j = 0; j < dimensiones.width; j++) {
				boton = new JButton();
				if(j%2==0 && i%2==0) {
					boton.setBackground(Color.BLACK);
				}else if(j%2!=0 && i%2!=0) {
					boton.setBackground(Color.BLACK);
				}else {
					boton.setBackground(Color.GRAY);
				}
				boton.setActionCommand(i+","+j);
				boton.addActionListener(ac);
				add(boton);
			}
		}
	}

	public void eventoBotones(ArrayList<String[]> info){
		int accion;
		int posicion;
		for (String[] tmp:info) {
			posicion = Integer.parseInt(tmp[0]);
			accion = Integer.parseInt(tmp[1]);
			if (accion>0){
				System.out.println("Chuta");
				this.remove(posicion);
				add(new Label(String.valueOf(accion)),posicion);
				this.updateUI();
			} else if (accion<0) {
				System.out.println("Chuta X2");
			}else {
				this.remove(posicion);
				this.updateUI();
			}
		}

		/*
		String [] posicionBotones = info[0].split("/");
		System.out.println(posicionBotones[0] + "    Posicion");
		int accion = Integer.parseInt(info[1]);
		//lo ultimo agregado al evento, este if y su else
		if(posicionBotones.length>1){
			accion=Integer.parseInt(posicionBotones[1]);
		}else{
			String[] posicion=posicionBotones[0].split(",");
		}

		 */

	}

	public void eventoBotones(String[] info) {
		int posicion = Integer.parseInt(info[0]);
		this.remove(posicion);
		add(new Label(info[1]),posicion);
		this.updateUI();
	}
}