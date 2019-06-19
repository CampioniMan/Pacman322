package com.unicamp.mc322.pacman.colisao;

import com.unicamp.mc322.pacman.posicionamento.ParOrdenado;
import com.unicamp.mc322.pacman.posicionamento.Quadrado;

public class ColisorQuadrado implements Colisor {
	private Quadrado area;
	
	public ColisorQuadrado(Quadrado colider)
	{
		this.area = colider;
	}
	
	public ColisorQuadrado(float topoEsquerdoX, float topoEsquerdoY, float valeDireitoX, float valeDireitoY)
	{
		this.area = new Quadrado(topoEsquerdoX, topoEsquerdoY, valeDireitoX, valeDireitoY);
	}
	
	public boolean colidiuCom(ColisorQuadrado outroColisor)
	{
		return outroColisor.colidiuCom(this.area);
	}
	
	public boolean colidiuCom(Quadrado outroColisor)
	{
		return (area.getTopoEsquerdo().getX() < outroColisor.getValeDireito().getX() && 
				area.getValeDireito().getX() > outroColisor.getTopoEsquerdo().getX() &&
				area.getTopoEsquerdo().getY() < outroColisor.getValeDireito().getY() && 
				area.getValeDireito().getY() > outroColisor.getTopoEsquerdo().getY());
	}
	
	public boolean colidiuCom(ParOrdenado outroColisor)
	{
		return (area.getTopoEsquerdo().getX() < outroColisor.getX() && 
				area.getValeDireito().getX() > outroColisor.getX() &&
				area.getTopoEsquerdo().getY() < outroColisor.getY() && 
				area.getValeDireito().getY() > outroColisor.getY());
	}

	public Quadrado getAreaTotal() {
		return area;
	}	
}
