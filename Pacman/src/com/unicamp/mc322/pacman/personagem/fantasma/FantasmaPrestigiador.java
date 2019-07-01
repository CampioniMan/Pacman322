package com.unicamp.mc322.pacman.personagem.fantasma;

import java.util.Random;

import com.unicamp.mc322.pacman.colisao.ColisorQuadrado;
import com.unicamp.mc322.pacman.posicionamento.Direcao;
import com.unicamp.mc322.pacman.posicionamento.ParOrdenado;
import com.unicamp.mc322.pacman.posicionamento.Quadrado;
import com.unicamp.mc322.parede.ParedeController;

public class FantasmaPrestigiador extends Fantasma{
	private Integer countPos = 0;
	public FantasmaPrestigiador(Quadrado colider) {
		super(colider, "src/sprites/ghosts/fantasmaamarelo1.png");
	}

	private ColisorQuadrado calcularNovoColider() {
		Integer X = ((new Random()).nextInt(30)+1)*16;
		Integer Y = ((new Random()).nextInt(30)+1)*16;
		return new ColisorQuadrado(X,Y ,X + 16,Y +16);
	}
	@Override
	public void calculaPosicaoNova(ParedeController paredeController, ParOrdenado posicaoPacman, ParOrdenado ... posicaoFantasmas) {
		
		if (countPos++ > 10 ) {
		
			ColisorQuadrado colisorQuadrado = calcularNovoColider();
			if (paredeController.colidiuComQuadrado(colisorQuadrado))
			{
				calculaPosicaoNova(paredeController, posicaoPacman, posicaoFantasmas);
			}
			else
			{

				this.colider.getAreaTotal().getTopoEsquerdo().setX(colisorQuadrado.getAreaTotal().getTopoEsquerdo().getX());
				this.colider.getAreaTotal().getTopoEsquerdo().setY(colisorQuadrado.getAreaTotal().getTopoEsquerdo().getY());
				this.colider.getAreaTotal().getValeDireito().setX(colisorQuadrado.getAreaTotal().getValeDireito().getX());
				this.colider.getAreaTotal().getValeDireito().setY(colisorQuadrado.getAreaTotal().getValeDireito().getY());
			}
			countPos = 0;
		}
	}
	
	
}
