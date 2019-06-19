package com.unicamp.mc322.pacman.funcionalities;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.unicamp.mc322.pacman.posicionamento.ParOrdenado;
import com.unicamp.mc322.pacman.posicionamento.Quadrado;

public class Imagem {
	BufferedImage img;
	ParOrdenado topoEsquerdo;
	Quadrado tamanhoFinal;
	
	public Imagem(String path, ParOrdenado topoEsquerdo, Quadrado tamanhoFinal) {
		this.topoEsquerdo = topoEsquerdo;
		this.tamanhoFinal = tamanhoFinal;
		try {
			this.img = ImageIO.read(new File(path));
			this.img = resize(this.img, getAltura(), getLargura());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Algo de errado ocorreu ao criar a imagem " + path);
			e.printStackTrace();
		}
	}
	
	private static BufferedImage resize(BufferedImage img, int height, int width) {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }
	
	public ParOrdenado getTopoEsquerdo() {
		return topoEsquerdo;
	}

	public void setTopoEsquerdo(ParOrdenado topoEsquerdo) {
		this.topoEsquerdo = topoEsquerdo;
	}

	public int getX() {
		return (int)(this.topoEsquerdo.getX());
	}
	
	public int getY() {
		return (int)(this.topoEsquerdo.getY());
	}
	
	public void setX(int novoX) {
		topoEsquerdo.setX(novoX);
	}
	
	public void setY(int novoX) {
		topoEsquerdo.setY(novoX);
	}
	
	private int getAltura() {
		return (int)(tamanhoFinal.getAltura());
	}
	
	private int getLargura() {
		return (int)(tamanhoFinal.getLargura());
	}
	
	public void draw(Graphics g) {
		g.drawImage(img, getX(), getY(), null);
	}
}
