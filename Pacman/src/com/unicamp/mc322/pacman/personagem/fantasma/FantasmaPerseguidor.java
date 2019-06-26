package com.unicamp.mc322.pacman.personagem.fantasma;

import java.util.Random;

import com.unicamp.mc322.pacman.posicionamento.Direcao;
import com.unicamp.mc322.pacman.posicionamento.ParOrdenado;
import com.unicamp.mc322.pacman.posicionamento.Quadrado;
import com.unicamp.mc322.parede.ParedeController;
import java.math.*;

public class FantasmaPerseguidor extends Fantasma {
	
	private Direcao ultimaDir;
	
	public FantasmaPerseguidor(Quadrado colider) {
		super(colider,  "src/sprites/ghosts/fantasmaazul1.png");
		this.velocidade = 4;
	}
	
	private Direcao getPosMaisProx(ParOrdenado topoEsquerdo) {
		Direcao dir;
		ParOrdenado novaPos;
		ParOrdenado minhaPos = this.skin.getTopoEsquerdo();
		novaPos = new ParOrdenado(minhaPos.getX(), minhaPos.getY()-1);
		double distCima = novaPos.getDistancia(topoEsquerdo);
		novaPos = new ParOrdenado(minhaPos.getX(), minhaPos.getY()+1);
		double distBaixo = novaPos.getDistancia(topoEsquerdo);
		novaPos = new ParOrdenado(minhaPos.getX()+1, minhaPos.getY());
		double distDireita = novaPos.getDistancia(topoEsquerdo);
		novaPos = new ParOrdenado(minhaPos.getX()-1, minhaPos.getY());
		double distEsquerda = novaPos.getDistancia(topoEsquerdo);
		double minDir = Math.min(Math.min(distEsquerda, distDireita), Math.min(distCima, distBaixo));
		if (minDir == distCima)
			dir = Direcao.CIMA;
		else if (minDir == distBaixo)
			dir = Direcao.BAIXO;
		else if (minDir == distEsquerda)
			dir = Direcao.ESQUERDA;
		else
			dir = Direcao.DIREITA;
		return dir;
	}
	
	//No caso da posição mais próxima ser uma parede ele acha a segunda posição mais proxima;
	private Direcao getPosMaisProx(ParOrdenado topoEsquerdo, Direcao jaVisitou){
		Direcao dir;
		ParOrdenado novaPos;
		ParOrdenado minhaPos = this.skin.getTopoEsquerdo();
		double distCima = 1000;
		double distBaixo = 1000;
		double distDireita = 1000;
		double distEsquerda = 1000;
		if (jaVisitou != Direcao.CIMA) {
			novaPos = new ParOrdenado(minhaPos.getX()-1, minhaPos.getY());
			distCima = novaPos.getDistancia(topoEsquerdo);
		}
		if(jaVisitou != Direcao.BAIXO) {
			novaPos = new ParOrdenado(minhaPos.getX()+1, minhaPos.getY());
			distBaixo = novaPos.getDistancia(topoEsquerdo);
		}
		if(jaVisitou != Direcao.DIREITA) {
			novaPos = new ParOrdenado(minhaPos.getX(), minhaPos.getY()+1);
			distDireita = novaPos.getDistancia(topoEsquerdo);
		}
		if(jaVisitou != Direcao.ESQUERDA) {
			novaPos = new ParOrdenado(minhaPos.getX(), minhaPos.getY()-1);
			distEsquerda = novaPos.getDistancia(topoEsquerdo);
		}
		double minDir = Math.min(Math.min(distEsquerda, distDireita), Math.min(distCima, distBaixo));
		if (minDir == distCima)
			dir = Direcao.CIMA;
		else if (minDir == distBaixo)
			dir = Direcao.BAIXO;
		else if (minDir == distEsquerda)
			dir = Direcao.ESQUERDA;
		else
			dir = Direcao.DIREITA;
		return dir;
	}
	
	
	public void calculaPosicaoNova(ParedeController paredeController, ParOrdenado coord) {
		Direcao direcaoMovimento = getPosMaisProx(coord);
		mover(direcaoMovimento);
		if (paredeController.colidiuComQuadrado(this.colider))
		{
			Direcao aux = direcaoMovimento;
			direcaoMovimento = aux.getDirecaoOposta();
			mover(direcaoMovimento);
			calculaPosicaoNova(paredeController, coord, aux);
		}
	}

	public void calculaPosicaoNova(ParedeController paredeController, ParOrdenado coord, Direcao dir) {
		Direcao direcaoMovimento = getPosMaisProx(coord, dir);
		mover(direcaoMovimento);
		if (paredeController.colidiuComQuadrado(this.colider))
		{
			Direcao aux = direcaoMovimento;
			direcaoMovimento = aux.getDirecaoOposta();
			mover(direcaoMovimento);
			calculaPosicaoNova(paredeController, coord, aux);
		}
	}
	
	

}
