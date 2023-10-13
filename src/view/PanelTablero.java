package view;

import model.Casilla;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

public class PanelTablero extends JPanel{

	public PanelTablero(ActionListener ac, Dimension dimensiones) {
		configuracion(dimensiones);
		this.inicializarComponentes(ac,dimensiones);
	}
	public void configuracion(Dimension dimensiones){
		this.setLayout(new GridLayout(dimensiones.height,dimensiones.width,3,3));
	}
	public void inicializarComponentes(ActionListener ac, Dimension dimensiones) {
		crearTableroBotones(ac,dimensiones);
	}
	public void crearTableroBotones(ActionListener ac,Dimension dimensiones) {
		this.setLayout(new GridLayout(dimensiones.height,dimensiones.width,3,3));
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
			System.out.println(info.size()   +"        tamano");
			posicion = Integer.parseInt(tmp[0]);
			accion = Integer.parseInt(tmp[1]);
			if (accion==0) {
				System.out.println("Remover: "+posicion);
				System.out.println("Accion: "+accion);
				add(new JLabel("V"),posicion);
				this.remove(posicion);
				this.updateUI();
			}else {
				this.remove(posicion);
				JLabel mina = new JLabel("Mina");
				mina.setBackground(Color.red);
				add(mina,posicion);
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