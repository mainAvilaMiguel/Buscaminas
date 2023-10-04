package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelTablero extends JPanel{
	private JButton[][] matrizBotones;
	
	public PanelTablero(ActionListener ac, Dimension dimensiones) {
		this.inicializarComponentes(ac,dimensiones);
	}
	public void inicializarComponentes(ActionListener ac, Dimension dimensiones) {
		crearTableroBotones(ac,dimensiones.height,dimensiones.width);
	}
	public void crearTableroBotones(ActionListener ac,int numFil, int numCol) {
		matrizBotones = new JButton[numFil][numCol];
		this.setLayout(new GridLayout(numFil,numCol));
		JButton boton;
		for (int i = 0; i < numFil; i++) {
			for (int j = 0; j < numCol; j++) {
				boton = new JButton();
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
	
}
