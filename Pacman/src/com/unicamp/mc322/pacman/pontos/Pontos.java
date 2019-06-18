package com.unicamp.mc322.pacman.pontos;

import java.awt.Graphics;

import com.unicamp.mc322.pacman.funcionalities.Imagem;
import com.unicamp.mc322.pacman.posicionamento.ParOrdenado;
import com.unicamp.mc322.pacman.posicionamento.Quadrado;

public class Pontos {
	private Quadrado colider;
	private Imagem skin;
	private ParOrdenado posicao;
	private final int valor = 1;
	
	public Pontos(Quadrado colider, String pathPraSkin, ParOrdenado posicao) {
		this.skin = new Imagem(pathPraSkin, posicao, colider);
		this.colider = colider;
		this.posicao = posicao;
	}
	
	public int getPonto() {
		return this.valor;
	}
	
	public ParOrdenado getPosicao() {
		return this.posicao;
	}
	
	public Imagem getSkin() {
		return this.skin;
	}
	
	public void setPosicao(ParOrdenado novaPosicao) {
		this.posicao = novaPosicao;
		this.skin.setTopoEsquerdo(novaPosicao);
	}
	
	public void desenhaPonto(Graphics g) {
		this.skin.draw(g);
	}
}
