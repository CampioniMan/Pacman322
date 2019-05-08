package com.unicamp.mc322.pacman.funcionalities;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.unicamp.mc322.pacman.posicionamento.Ponto;

public class Imagem {
	BufferedImage img;
	Ponto topoEsquerdo, escala;
	
	public Imagem(String path, Ponto topoEsquerdo, Ponto escala) {
		
		this.escala = escala;
		this.topoEsquerdo = topoEsquerdo;
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
		return (int)(this.img.getHeight() * escala.getY());
	}
	
	private int getLargura() {
		return (int)(this.img.getWidth() * escala.getX());
	}
	
	public void draw(Graphics g) {
		g.drawImage(img, getX(), getY(), null);
	}
}
