package com.unicamp.mc322.pacman.colisao;

import com.unicamp.mc322.pacman.posicionamento.ParOrdenado;
import com.unicamp.mc322.pacman.posicionamento.Quadrado;

public class ColisorQuadrado implements Colisor {
	private Quadrado colider;
	
	public ColisorQuadrado(Quadrado colider)
	{
		this.colider = colider;
	}
	
	public ColisorQuadrado(float topoEsquerdoX, float topoEsquerdoY, float valeDireitoX, float valeDireitoY)
	{
		this.colider = new Quadrado(topoEsquerdoX, topoEsquerdoY, valeDireitoX, valeDireitoY);
	}
	
	public boolean colidiuCom(ColisorQuadrado outroColisor)
	{
		return outroColisor.colidiuCom(this.colider);
	}
	
	public boolean colidiuCom(Quadrado outroColisor)
	{
		return (colider.getTopoEsquerdo().getX() < outroColisor.getValeDireito().getX() && 
			colider.getValeDireito().getX() > outroColisor.getTopoEsquerdo().getX() &&
			colider.getTopoEsquerdo().getY() < outroColisor.getValeDireito().getY() && 
			colider.getValeDireito().getY() > outroColisor.getTopoEsquerdo().getY());
	}
	
	public boolean colidiuCom(ParOrdenado outroColisor)
	{
		return (colider.getTopoEsquerdo().getX() < outroColisor.getX() && 
				colider.getValeDireito().getX() > outroColisor.getX() &&
				colider.getTopoEsquerdo().getY() < outroColisor.getY() && 
				colider.getValeDireito().getY() > outroColisor.getY());
	}
	
	
}
