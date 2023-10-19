package model;

import java.awt.*;
import java.util.ArrayList;

public interface ITablero {
    public void crearTableroCasillas();
    public void asignarMinas();
    public void contarBombasCerca();
    public void imprimirCasillas();
    public int verificarRadio(int fila,int columna);
    public ArrayList<Point> vaciosCercanos(ArrayList<Point> verificacionVacios);
    public ArrayList<Point> numerosCercaAVaciosCercanos(ArrayList<Point> verificacionVacios);
    public void resetTablero();
    public ArrayList<String[]> checkVacios(int fila, int columna);
    public ArrayList<String[]> obtenerPosicionMinas();

}
