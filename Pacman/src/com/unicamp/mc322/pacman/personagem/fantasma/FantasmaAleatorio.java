package com.unicamp.mc322.pacman.personagem.fantasma;

import java.util.Random;

import com.unicamp.mc322.pacman.posicionamento.Direcao;
import com.unicamp.mc322.pacman.posicionamento.ParOrdenado;
import com.unicamp.mc322.pacman.posicionamento.Quadrado;
import com.unicamp.mc322.parede.ParedeController;

public class FantasmaAleatorio extends Fantasma {

	Direcao ultimaDirecao = Direcao.CIMA;
	private Integer countPos = 0;
	
	public FantasmaAleatorio(Quadrado colider) {
		super(colider,  "src/sprites/ghosts/fantasmavermelho1.png");
		this.velocidade = 4;
	}
	
	@Override
	public void calculaPosicaoNova(ParedeController paredeController, ParOrdenado posicaoPacman, ParOrdenado ... posicaoFantasmas) {
		if (countPos++ > 6 ) {
			countPos = 0;
			ultimaDirecao = Direcao.values()[(new Random()).nextInt(4)];
		}
		
		mover(ultimaDirecao);
		if (paredeController.colidiuComQuadrado(this.colider))
		{
			if (ultimaDirecao.ordinal()%2 == 0)
				ultimaDirecao = Direcao.values()[ultimaDirecao.ordinal()+1];
			else
				ultimaDirecao = Direcao.values()[ultimaDirecao.ordinal()-1];
			
			mover(ultimaDirecao);
			
			Direcao aux = Direcao.values()[(new Random()).nextInt(4)];
			while (aux == ultimaDirecao)
				aux = Direcao.values()[(new Random()).nextInt(4)];
			ultimaDirecao = aux;
		}
	}
	
	
	

}
