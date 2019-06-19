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
		this.getTopoEsquerdo().addX(variacaoEixoX);
		this.getValeDireito().addX(variacaoEixoX);
	}
	
	private void moverEixoY(float variacaoEixoY) {
		this.getTopoEsquerdo().addY(variacaoEixoY);
		this.getValeDireito().addY(variacaoEixoY);
	}
	
	public void draw(Graphics g) {
		this.skin.draw(g);
	}

	public ColisorQuadrado getColider() {
		return colider;
	}
	
	public ParOrdenado getTopoEsquerdo() {
		return colider.getAreaTotal().getTopoEsquerdo();
	}
	
	public ParOrdenado getValeDireito() {
		return colider.getAreaTotal().getValeDireito();
	}

	public float getVelocidade() {
		return velocidade;
	}
}
