package com.unicamp.mc322.pacman.pontos;

import java.awt.Graphics;
import java.util.ArrayList;

import com.unicamp.mc322.pacman.colisao.ColisorQuadrado;
import com.unicamp.mc322.pacman.posicionamento.ParOrdenado;

public class PowerUpController {
	private ArrayList<PowerUp> powerupNoMapa;
	private boolean ativo;
	private final int duracao = 3000;
	private int tempoRestante;
	//private ArrayList<Pontos> pontosColetados;
	
	public PowerUpController() {
		powerupNoMapa = new ArrayList();
		this.ativo = false;
		this.tempoRestante = 0;
	}
	
	public void adicionarPonto(PowerUp p) {
		this.powerupNoMapa.add(p);
	}
	
	public boolean estaAtivo() {
		return ativo;
	}
	
	public int getPosPowerUp(ParOrdenado coord) {
		int pos = 0;
		for (PowerUp p: powerupNoMapa) {
			if (p.getPosicao().equals(coord))
				break;
			pos++;
		}
		return pos;
	}
	
	//Mudar com relação ao colider??? Falar com o bird
	public int getPontos(ParOrdenado coord) {
		//Comeu o ponto 'x'
		int ponto = 0;
		int pos = getPosPowerUp(coord);
		try {
			ponto = powerupNoMapa.get(pos).getPontos();
			powerupNoMapa.remove(pos);
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("Posição inválida");
		}
		return ponto;
	}
	
	public void desenhaPowerUp(Graphics g) {
		for (PowerUp p: powerupNoMapa) {
			p.desenhaPowerup(g);
		}
	}
	
	public void diminiuTempo() {
		tempoRestante -= 50;
		if (tempoRestante == 0)
			ativo = false;
	}
	
	
	public boolean colidiuComQuadrado(ColisorQuadrado quadradao) {
		for (PowerUp p: powerupNoMapa) {
			if (quadradao.colidiuCom(p.getColider()))
			{
				ativo = true;
				tempoRestante = duracao;
				powerupNoMapa.remove(p);
				return true;
			}
		}
		return false;
	}
}
