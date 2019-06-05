package com.unicamp.mc322.pacman.personagem;

import java.awt.Graphics;

import com.unicamp.mc322.pacman.funcionalities.*;
import com.unicamp.mc322.pacman.posicionamento.*;

public abstract class Personagem {
	private Quadrado colider;
	private Imagem skin;
	private ParOrdenado posicao;
	private float velocidade;
		
	public Personagem(Quadrado colider, String pathPraSkin) {
		this.colider = colider;
		this.skin = new Imagem(pathPraSkin, posicao, colider);
	}
	
	public void mover(Direcao direcao) {
		if (direcao == Direcao.CIMA) {
			this.moverEixoY(velocidade);
		}
		else if (direcao == Direcao.BAIXO) {
			this.moverEixoY(-velocidade);
		}
		else if (direcao == Direcao.DIREITA) {
			this.moverEixoX(velocidade);
		}
		else { // ESQUERDA
			this.moverEixoX(-velocidade);
		}
	}
	
	private void moverEixoX(float variacaoEixoX) {
		this.posicao.addX(variacaoEixoX);
	}
	
	private void moverEixoY(float variacaoEixoY) {
		this.posicao.addY(variacaoEixoY);
	}
	
	public void draw(Graphics g) {
		this.skin.draw(g);
	}	
}
