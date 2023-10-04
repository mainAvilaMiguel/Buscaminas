package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import model.Casilla;
import presenter.Presenter;
public class View extends JFrame{
	private PanelTablero panelTablero;
	public Dimension dimensiones;
	private JMenuBar mBar;
	private JMenu menuNiveles; 
	private JMenuItem nivelFacil;
	private JMenuItem nivelMedio;
	private JMenuItem nivelDificil;
	
//	public View(ActionListener ac, Dimension dimensiones) {
//		this.configurarFrame();
//		this.inicializarComponentes(ac);	
//	}
	public View(ActionListener ac, Dimension dimensiones) {
		this.configurarFrame();
		this.inicializarComponentes(ac);	
	}
	public void inicializarComponentes(ActionListener ac) {
		mBar = new JMenuBar();
		menuNiveles = new JMenu("Niveles");
		nivelFacil = new JMenuItem("Facil");
		nivelFacil.addActionListener(ac);
		nivelMedio = new JMenuItem("Medio");
		nivelMedio.addActionListener(ac);
		nivelDificil = new JMenuItem("Dificil");
		nivelDificil.addActionListener(ac);
		dimensiones = new Dimension(12,12);
		this.agregarAMenuNiveles();
		this.crearPanelTablero(ac);
		this.setVisible(true);
	}
	public void configurarFrame() {
		this.setTitle("Buscaminas");
		this.setSize(500,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	
	}
	public void agregarAMenuNiveles() {
		menuNiveles.add(nivelFacil);
		menuNiveles.add(nivelMedio);
		menuNiveles.add(nivelDificil);
		mBar.add(menuNiveles);
		this.add(mBar, BorderLayout.NORTH);
	}
	public void crearPanelTablero(ActionListener ac) {
		panelTablero = new PanelTablero(ac, dimensiones);
		this.add(panelTablero, BorderLayout.CENTER);
	}
	public void reset(ActionListener ac) {
		this.remove(panelTablero);
		crearPanelTablero(ac);
		this.repaint();
	}
//    public void mostrarContenido(Casilla casilla) {
//    	casilla=new Casilla();
//        JLabel labelContenido= new JLabel();
//        String contenido = casilla.getEtiqueta();
//        labelContenido.setText(contenido);
//	}
//    public void seleccionDeNivel() {
//    	JPopupMenu popMenu = new JPopupMenu();
//    	this.getMenuNiveles();
//    	popMenu.add(this.getNivelFacil());
//    	popMenu.add(this.getNivelMedio());
//    	popMenu.add(this.getNivelDificil());
//    	mBar.add(this.getMenuNiveles());
//    	setmBar(mBar);
//    	menuNiveles.setVisible(true);
//    }
	public JMenuBar getmBar() {
		return mBar;
	}
	public void setmBar(JMenuBar mBar) {
		this.mBar = mBar;
	}
	public JMenu getMenuNiveles() {
		return menuNiveles;
	}
	public void setMenuNiveles(JMenu menuNiveles) {
		this.menuNiveles = menuNiveles;
	}

	public JMenuItem getNivelFacil() {
		return nivelFacil;
	}
	public void setNivelFacil(JMenuItem nivelFacil) {
		this.nivelFacil = nivelFacil;
	}
	public JMenuItem getNivelMedio() {
		return nivelMedio;
	}
	public void setNivelMedio(JMenuItem nivelMedio) {
		this.nivelMedio = nivelMedio;
	}
	public JMenuItem getNivelDificil() {
		return nivelDificil;
	}
	public void setNivelDificil(JMenuItem nivelDificil) {
		this.nivelDificil = nivelDificil;
	}
	public Dimension getDimensiones() {
		return dimensiones;
	}
	public void setDimensiones(Dimension dimensiones) {
		this.dimensiones = dimensiones;
	}
	
	
	
	
}
