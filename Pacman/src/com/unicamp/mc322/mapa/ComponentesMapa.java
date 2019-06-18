package com.unicamp.mc322.mapa;

public enum ComponentesMapa {
	PAREDE('#'), VAZIO('0'), COMIDA('.'), POWERUP('*');
	private final Character valor;
	
	ComponentesMapa(Character valor) {
		this.valor = valor;
	}
	
	public Character getValor() {
		return valor;
	}
}
