package com.unicamp.mc322.pacman.posicionamento;

public enum Direcao {
	CIMA,
	BAIXO,
	ESQUERDA,
	DIREITA;
	
	public Direcao getDirecaoOposta()
	{
		if (this.ordinal()%2 == 0)
			return Direcao.values()[this.ordinal()+1];
		else
			return Direcao.values()[this.ordinal()-1];
	}
}
