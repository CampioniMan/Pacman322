package com.unicamp.mc322.pacman.personagem;

import com.unicamp.mc322.pacman.posicionamento.Direcao;
import com.unicamp.mc322.pacman.posicionamento.ParOrdenado;
import com.unicamp.mc322.pacman.posicionamento.Quadrado;
import com.unicamp.mc322.parede.ParedeController;

import java.awt.event.KeyEvent;

import com.unicamp.mc322.pacman.funcionalities.*;
import com.unicamp.mc322.pacman.pontos.PontosController;
import com.unicamp.mc322.pacman.pontos.PowerUpController;

public class Pacman extends Personagem {
	Direcao ultimaPosicao = Direcao.DIREITA;
	
	public Pacman(Quadrado colider, String pathPraSkin) {
		super(colider, pathPraSkin);
		this.velocidade = 4;
	}
	
	
	 //Retorna a pontuação que o user ganhou indo pra posição x
	public int irParaProximaPosicao(ParedeController paredeController, PontosController pontosController, PowerUpController pwController)
	{
		if (ControleBotao.isKeyPressed(KeyEvent.VK_W))
		{
			ultimaPosicao = Direcao.CIMA;
		}
		else if (ControleBotao.isKeyPressed(KeyEvent.VK_A))
		{
			ultimaPosicao = Direcao.ESQUERDA;
		}
		else if (ControleBotao.isKeyPressed(KeyEvent.VK_D))
		{
			ultimaPosicao = Direcao.DIREITA;
		}
		else if (ControleBotao.isKeyPressed(KeyEvent.VK_S))
		{
			ultimaPosicao = Direcao.BAIXO;
		}
		mover(ultimaPosicao);
		if (paredeController.colidiuComQuadrado(this.colider))
		{
			Direcao aux;
			if (ultimaPosicao.ordinal()%2 == 0)
				aux = Direcao.values()[ultimaPosicao.ordinal()+1];
			else
				aux = Direcao.values()[ultimaPosicao.ordinal()-1];
			mover(aux);
			return PontosComponente.PAREDE.getValor();
		}
		if (pontosController.colidiuComQuadrado(this.colider)) {
			return PontosComponente.COMIDA.getValor();
		}
		if (pontosController.colidiuComQuadrado(this.colider)) {
			return PontosComponente.COMIDA.getValor();
		}
		if (pwController.colidiuComQuadrado(this.colider)) {
			return PontosComponente.POWERUP.getValor();
		}
		if (ultimaPosicao == Direcao.DIREITA)
			this.skin = new Imagem("src/sprites/pacman/download.png", getTopoEsquerdo(), colider.getAreaTotal());
		else if (ultimaPosicao == Direcao.ESQUERDA)
			this.skin = new Imagem("src/sprites/pacman/download3.png", getTopoEsquerdo(), colider.getAreaTotal());
		else if (ultimaPosicao == Direcao.CIMA)
			this.skin = new Imagem("src/sprites/pacman/download2.png", getTopoEsquerdo(), colider.getAreaTotal());
		else if (ultimaPosicao == Direcao.BAIXO)
			this.skin = new Imagem("src/sprites/pacman/download4.png", getTopoEsquerdo(), colider.getAreaTotal());
		return PontosComponente.VAZIO.getValor();
		
	}
	
}
