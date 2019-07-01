package com.unicamp.mc322.pacman.personagem.fantasma;

import java.awt.Graphics;

import com.unicamp.mc322.pacman.funcionalities.Imagem;
import com.unicamp.mc322.pacman.personagem.Personagem;
import com.unicamp.mc322.pacman.posicionamento.Direcao;
import com.unicamp.mc322.pacman.posicionamento.ParOrdenado;
import com.unicamp.mc322.pacman.posicionamento.Quadrado;
import com.unicamp.mc322.parede.ParedeController;

public abstract class Fantasma extends Personagem {

	public Fantasma(Quadrado colider, String pathPraSkin) {
		super(colider, pathPraSkin);
		this.velocidade = 4;
	}
	
	public void calculaPosicaoNova(ParedeController paredeController, ParOrdenado posicaoPacman, ParOrdenado ... posicaoFantasmas) {
		mover(Direcao.CIMA);
	}
	
}
