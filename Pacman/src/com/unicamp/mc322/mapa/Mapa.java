package com.unicamp.mc322.mapa;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Objects;
import java.util.Random;

import com.unicamp.mc322.pacman.funcionalities.Imagem;
import com.unicamp.mc322.pacman.posicionamento.ParOrdenado;
import com.unicamp.mc322.pacman.posicionamento.Quadrado;

public class Mapa {
	
	private Integer altura;
	private Integer largura;
	
	private Character[][] mapa;
	private final String pathParede = "src/sprites/wall/parede.png";
	private final String pathComidaPacman = "src/sprites/food/comida.png";
	
	
	public Mapa(Integer altura, Integer largura) {
		this.altura = altura;
		this.largura = largura;
		mapa = new Character[altura*16][largura*16];
	}
	
	public void desenhaMapa(Graphics g) {
		Imagem imagemParede = new Imagem(pathParede, new ParOrdenado(0,0), new Quadrado(0, 0, 16, 16));
		Imagem imagemComida = new Imagem(pathComidaPacman, new ParOrdenado(0,0), new Quadrado(0, 0, 16, 16));
 		for (int i = 0; i < this.largura; i++) {
			for (int j = 0; j < altura; j++) {
				if (mapa[i][j].equals(ComponentesMapa.PAREDE.getValor())) {
					imagemParede.setTopoEsquerdo(new ParOrdenado(i*16, j*16));
					imagemParede.draw(g);
				} else if (mapa[i][j].equals(ComponentesMapa.COMIDA.getValor())) {
					imagemComida.setTopoEsquerdo(new ParOrdenado(i*16, j*16));
					imagemComida.draw(g);
				}
			}
 		}
	}
	
	public void leMapa() throws Exception{
		File file = new File("arquivo.txt");
		FileReader reader = new FileReader(file);
		BufferedReader buff = new BufferedReader(reader);
		String line = null;
		altura = 0;
		line = buff.readLine();
		for (int j = 0; Objects.nonNull(line); j++) {
			altura++;
			for(int i = 0; i < line.length();i++) {
				mapa[i][j] = line.charAt(i);
			}
			line = buff.readLine();
		} 
	
		buff.close();
		reader.close();
	}
	
	private boolean inicioFantasma(int j, int i ) {
		return (j >= (largura/2)-3 && j <= (largura/2)+3) && (i >= (altura/2) && i <= (altura/2)) || ((j>=(largura/2)-1 && j<=(largura/2)+1) && i==(altura/2)-1);
	}
	
	private boolean paredeDefault(int j, int i) {
		return (j == 0 || i == 0 || j == altura -1 || i == largura -1) ||
				(j >= (largura/2)-4 && j <= (largura/2)+4) && (i >= (altura/2)-1 && i <= (altura/2)+1);
	}
	
	private boolean inicioPacman(int j, int i) {
		return (j == 1 && i == 1);
	}
	
	public void geraMapa() throws Exception {
		
		
		for (int i = 0; i < altura;i++) {
			for (int j = 0; j< largura; j++) {
				if (inicioFantasma(j, i) || inicioPacman(j,i))
					mapa[i][j] = ComponentesMapa.VAZIO.getValor();
				else if (paredeDefault(j,i)) 
					mapa[i][j] = ComponentesMapa.PAREDE.getValor();
				else {
					Random num =  new Random();
					if (num.nextInt(5) < 4 || i == 1 || j == 1 || i == altura -2 || j ==largura-2)
						mapa[i][j] = ComponentesMapa.COMIDA.getValor();
					else
						mapa[i][j] = ComponentesMapa.PAREDE.getValor();
				}
			}
		}

		File file = new File("maparquivo.txt");
		FileWriter writer = new FileWriter(file) ;
		BufferedWriter buff = new BufferedWriter(writer);
		System.out.print(file.getAbsolutePath());
		for (int i = 0; i < altura;i++) {
			for (int j = 0; j< largura; j++) {
				buff.write(mapa[i][j]);
			}
			buff.write("\n");
		}
		buff.close();
		writer.close();
	}
	public Integer getAltura() {
		return altura;
	}
	public void setAltura(Integer altura) {
		this.altura = altura;
	}
	public Integer getLargura() {
		return largura;
	}
	public void setLargura(Integer largura) {
		this.largura = largura;
	}
}
