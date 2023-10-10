package view;

import java.awt.*;
import java.awt.event.ActionListener;

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

	public void eventoBotones(String [] info){
		String [] posicionBotones = info[0].split("/");
		System.out.println(posicionBotones[0] + "    Posicion");
		int accion = Integer.parseInt(info[1]);
		if (accion>0){
			this.remove(Integer.parseInt(posicionBotones[0]));
			add(new Label(String.valueOf(accion)),Integer.parseInt(posicionBotones[0]));
			this.updateUI();
		} else if (accion<0) {

		}else {
			for (int i = 0; i < posicionBotones.length-1; i++) {
				this.remove(Integer.parseInt(posicionBotones[i]));
			}
		}
	}


}
