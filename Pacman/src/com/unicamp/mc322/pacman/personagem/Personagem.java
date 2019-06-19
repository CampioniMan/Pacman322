package com.unicamp.mc322.pacman.personagem;

import java.awt.Graphics;

import com.unicamp.mc322.pacman.colisao.ColisorQuadrado;
import com.unicamp.mc322.pacman.funcionalities.*;
import com.unicamp.mc322.pacman.posicionamento.*;

public abstract class Personagem {
	protected ColisorQuadrado colider;
	protected Imagem skin;
	protected float velocidade;
		
	public Personagem(Quadrado colider, String pathPraSkin) {
		this.colider = new ColisorQuadrado(colider);
		this.skin = new Imagem(pathPraSkin, colider.getTopoEsquerdo(), colider);
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
		this.colider.getAreaTotal().getTopoEsquerdo().addX(variacaoEixoX);
	}
	
	private void moverEixoY(float variacaoEixoY) {
		this.colider.getAreaTotal().getTopoEsquerdo().addY(variacaoEixoY);
	}
	
	public void draw(Graphics g) {
		this.skin.draw(g);
	}

	public ColisorQuadrado getColider() {
		return colider;
	}

	public float getVelocidade() {
		return velocidade;
	}
}
