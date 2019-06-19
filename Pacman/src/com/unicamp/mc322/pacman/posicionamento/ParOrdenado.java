package com.unicamp.mc322.pacman.posicionamento;

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
	
	public boolean equals(ParOrdenado par) {
		if (this.x == par.getX() && this.y == par.getY()) {
			return true;
		}
		return false;
	}
}
