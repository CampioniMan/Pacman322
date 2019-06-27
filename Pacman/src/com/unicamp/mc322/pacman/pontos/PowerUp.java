package com.unicamp.mc322.pacman.pontos;

import java.awt.Graphics;

import com.unicamp.mc322.pacman.funcionalities.Imagem;
import com.unicamp.mc322.pacman.posicionamento.ParOrdenado;
import com.unicamp.mc322.pacman.posicionamento.Quadrado;

public class PowerUp {
	private Quadrado colider;
	private Imagem skin;
	private ParOrdenado posicao;
	private final int valor = 10;
	private boolean ativo;
	
	public PowerUp(Quadrado colider, String pathPraSkin, ParOrdenado posicao) {
		this.skin = new Imagem(pathPraSkin, posicao, colider);
		this.colider = colider;
		this.posicao = posicao;
		this.ativo = false;
	}
	
	public Quadrado getColider() {
		return colider;
	}
	
	public int getPontos() {
		return valor;
	}
	
	public ParOrdenado getPosicao() {
		return this.posicao;
	}
	
	public void desenhaPowerup(Graphics g) {
		this.skin.draw(g);
	}
}
