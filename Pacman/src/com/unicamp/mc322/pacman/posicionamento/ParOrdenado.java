package com.unicamp.mc322.pacman.posicionamento;
import java.math.*;


public class ParOrdenado {
	float x, y;

	public ParOrdenado(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}
	
	public void addX(float x) {
		this.x += x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	public void addY(float y) {
		this.y += y;
	}
	
	public double getDistancia(ParOrdenado par) {
		double dist = Math.sqrt((par.getX()- this.x)*(par.getX()- this.x) + (par.getY()- this.y)*(par.getY()- this.y));
		return dist;
	}
	
	public boolean equals(ParOrdenado par) {
		if (this.x == par.getX() && this.y == par.getY()) {
			return true;
		}
		return false;
	}
}
