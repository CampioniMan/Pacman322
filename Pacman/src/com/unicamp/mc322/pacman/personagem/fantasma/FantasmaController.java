package com.unicamp.mc322.pacman.personagem.fantasma;

import java.awt.Graphics;
import java.util.ArrayList;

import com.unicamp.mc322.pacman.colisao.ColisorQuadrado;
import com.unicamp.mc322.pacman.personagem.Pacman;
import com.unicamp.mc322.pacman.pontos.Pontos;
import com.unicamp.mc322.pacman.posicionamento.ParOrdenado;
import com.unicamp.mc322.pacman.posicionamento.Quadrado;
import com.unicamp.mc322.parede.ParedeController;

public class FantasmaController {
	private ArrayList<Fantasma> listFantasmas;

	public FantasmaController() {
		this.listFantasmas = new ArrayList();
		
		adicionaFantasma(new FantasmaAleatorio(new Quadrado(16*16, 16*16,17*16,17*16)));
		adicionaFantasma(new FantasmaPrestigiador(new Quadrado(16*16, 16*16,17*16,17*16)));
		adicionaFantasma(new FantasmaPerseguidor(new Quadrado(16*16, 16*16,17*16,17*16)));
		adicionaFantasma(new FantasmaEvasivo(new Quadrado(16*16, 16*16,17*16,17*16)));
		
	}
	
	public void adicionaFantasma(Fantasma fantasma){
		this.listFantasmas.add(fantasma);
	}
	
	private ParOrdenado[] getOutrosFantasmas(ArrayList<Fantasma> fantasmas) {
		ParOrdenado[] retorno = new ParOrdenado[fantasmas.size()];
		int i = 0;
		for (Fantasma f : fantasmas) {
			retorno[i] = f.getTopoEsquerdo();
			i++;
		}
		return retorno;
	}
	
	public void move( ParedeController paredeController, ParOrdenado pacman) {
		ArrayList<Fantasma> fantasmas;
		for (Fantasma f: this.listFantasmas) {
			fantasmas =(ArrayList<Fantasma>) listFantasmas.clone();
			fantasmas.remove(f);
			f.calculaPosicaoNova(paredeController, pacman, getOutrosFantasmas(fantasmas));
		}
	}
	
	public void desenhaFantasmas(Graphics g) {
		for (Fantasma f: this.listFantasmas) {
			f.draw(g);
		}
	}
	
	public boolean colidiuComQuadrado(ColisorQuadrado quadradao) {
		for (Fantasma f: listFantasmas) {
			if (quadradao.colidiuCom(f.getColider()))
				return true;
		}
		return false;
	}
	
	
}
