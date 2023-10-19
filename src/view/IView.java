package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public interface IView {
    public void inicializarComponentes(ActionListener ac);
    public void configurarFrame();
    public void agregarAMenuNiveles();
    public void crearPanelTablero(ActionListener ac);

    public void reset(ActionListener ac);

    public void eventoBotones(ArrayList<String[]> info);

    public void eventoBotones(String[] info);

}
