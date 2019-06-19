package com.unicamp.mc322.parede;
import java.awt.Graphics;
import java.util.ArrayList;

import com.unicamp.mc322.pacman.posicionamento.ParOrdenado;
import com.unicamp.mc322.pacman.posicionamento.Quadrado;

public class ParedeController {
	private ArrayList<Parede> paredeNoMapa;
	//private ArrayList<Pontos> pontosColetados;
	
	public ParedeController() {
		paredeNoMapa = new ArrayList();
	}
	
	public void adicionarParede(Parede p) {
		this.paredeNoMapa.add(p);
	}
	
	public int getPosParede(ParOrdenado coord) {
		int pos = 0;
		for (Parede p: paredeNoMapa) {
			if (p.getPosicao().equals(coord))
				break;
			pos++;
		}
		return pos;
	}
	
	public void desenhaParede(Graphics g) {
		for (Parede p: paredeNoMapa) {
			p.desenhaPonto(g);
		}
	}
}
