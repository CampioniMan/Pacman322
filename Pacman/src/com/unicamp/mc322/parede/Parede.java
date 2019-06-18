package com.unicamp.mc322.parede;

import java.awt.Graphics;

import com.unicamp.mc322.pacman.funcionalities.Imagem;
import com.unicamp.mc322.pacman.posicionamento.ParOrdenado;
import com.unicamp.mc322.pacman.posicionamento.Quadrado;

public class Parede {
	private Quadrado colider;
	private Imagem skin;
	private ParOrdenado posicao;
	
	public Parede(Quadrado colider, String pathPraSkin, ParOrdenado posicao) {
		this.skin = new Imagem(pathPraSkin, posicao, colider);
		this.colider = colider;
		this.posicao = posicao;
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
