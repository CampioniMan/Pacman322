package com.unicamp.mc322.pacman.posicionamento;

public class Quadrado {
	ParOrdenado topoEsquerdo;
	ParOrdenado valeDireito;
	
	public Quadrado(ParOrdenado topoEsquerdo, ParOrdenado valeDireito) {
		super();
		this.topoEsquerdo = topoEsquerdo;
		this.valeDireito = valeDireito;
	}
	
	public Quadrado(float topoEsquerdoX, float topoEsquerdoY, float valeDireitoX, float valeDireitoY) {
		super();
		this.topoEsquerdo = new ParOrdenado(topoEsquerdoX, topoEsquerdoY);
		this.valeDireito = new ParOrdenado(valeDireitoX, valeDireitoY);
	}
	
	public ParOrdenado getTopoEsquerdo() {
		return topoEsquerdo;
	}
	
	public void setTopoEsquerdo(ParOrdenado topoEsquerdo) {
		this.topoEsquerdo = topoEsquerdo;
	}
	
	public ParOrdenado getValeDireito() {
		return valeDireito;
	}
	
	public void setValeDireito(ParOrdenado valeDireito) {
		this.valeDireito = valeDireito;
	}
	
	public float getAltura() {
		return Math.abs(this.topoEsquerdo.getX() - this.valeDireito.getX());
	}
	
	public float getLargura() {
		return Math.abs(this.topoEsquerdo.getY() - this.valeDireito.getY());
	}
}
