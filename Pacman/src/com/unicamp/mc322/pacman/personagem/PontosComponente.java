package com.unicamp.mc322.pacman.personagem;

public enum PontosComponente {
	PAREDE(0), VAZIO(0), COMIDA(1), POWERUP(10);
	private final int valor;
	
	PontosComponente(int valor) {
		this.valor = valor;
	}
	
	public int getValor() {
		return valor;
	}
}
