package view;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelTablero extends JPanel{
	private JButton[][] matrizBotones;
	
	public PanelTablero(ActionListener ac, Dimension dimensiones) {
		this.inicializarComponentes(ac,dimensiones);
	}
	public void inicializarComponentes(ActionListener ac, Dimension dimensiones) {
		crearTableroBotones(ac,dimensiones);
	}
	public void crearTableroBotones(ActionListener ac,Dimension dimensiones) {
		matrizBotones = new JButton[dimensiones.height][dimensiones.width];
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
				boton.addActionListener(ac);
				matrizBotones[i][j]= boton;
				this.add(matrizBotones[i][j]);
			}
		}
	}
	public JButton[][] getMatrizBotones() {
		return matrizBotones;
	}
	public void setMatrizBotones(JButton[][] matrizBotones) {
		this.matrizBotones = matrizBotones;
	}
	public Dimension getDimensiones() {
		int numFil = matrizBotones.length;
		int numCol = numFil > 0 ? matrizBotones[0].length : 0;
		return new Dimension(numFil, numCol);
	}
}
