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
		JButton tmp2;
		JLabel aux;
		for (String[] tmp:info) {
			posicion = Integer.parseInt(tmp[0]);
			accion = Integer.parseInt(tmp[1]);
			if (accion==0) {
				tmp2 = (JButton) this.getComponent(posicion);
				tmp2.setEnabled(false);
				tmp2.setBackground(Color.WHITE);
				this.updateUI();
			}else if (accion<0){
				tmp2 = (JButton) this.getComponent(posicion);
				tmp2.setEnabled(false);
				tmp2.setBackground(Color.red);
				perdio();
				this.updateUI();
			}else{
				this.remove(posicion);
				aux = new JLabel(tmp[1]);
				aux.setBackground(Color.WHITE);
				add(aux,posicion);
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

	private void perdio(){
		for (int i = 0; i < 143; i++) {
			this.getComponent(i).setEnabled(false);
		}
	}

	public void eventoBotones(String[] info) {
		int posicion = Integer.parseInt(info[0]);
		this.remove(posicion);
		JLabel tmp = new JLabel(info[1]);
		tmp.setBackground(Color.WHITE);
		add(tmp,posicion);
		this.updateUI();
	}
}