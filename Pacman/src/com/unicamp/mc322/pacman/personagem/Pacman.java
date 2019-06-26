package com.unicamp.mc322.pacman.personagem;

import com.unicamp.mc322.pacman.posicionamento.Direcao;
import com.unicamp.mc322.pacman.posicionamento.ParOrdenado;
import com.unicamp.mc322.pacman.posicionamento.Quadrado;
import com.unicamp.mc322.parede.ParedeController;

import java.awt.event.KeyEvent;

import com.unicamp.mc322.pacman.funcionalities.*;

public class Pacman extends Personagem {
	Direcao ultimaPosicao = Direcao.DIREITA;
	
	public Pacman(Quadrado colider, String pathPraSkin) {
		super(colider, pathPraSkin);
		this.velocidade = 4;
	}
	
	public void irParaProximaPosicao(ParedeController paredeController)
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
		}
	}
	
}
