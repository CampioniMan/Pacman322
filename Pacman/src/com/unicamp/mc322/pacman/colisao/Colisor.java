package com.unicamp.mc322.pacman.colisao;

import com.unicamp.mc322.pacman.posicionamento.ParOrdenado;
import com.unicamp.mc322.pacman.posicionamento.Quadrado;

public interface Colisor {
	public boolean colidiuCom(Quadrado quadrado);
	public boolean colidiuCom(ParOrdenado parOrdenado);
}
