package model;

public class Casilla {
	private int numero;
	private boolean estado; //saber si la casilla esta destapada o no
	private String etiqueta;
	private boolean bomba;
	public Casilla() {
		numero=0;
		estado=false;
		etiqueta=" ";
		bomba= false;
	}

	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public boolean isBomba() {
		return bomba;
	}
	public void setBomba() {
		this.bomba = true;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}
	
	
}
