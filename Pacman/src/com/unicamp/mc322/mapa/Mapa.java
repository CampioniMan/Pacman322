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
import com.unicamp.mc322.pacman.pontos.Pontos;
import com.unicamp.mc322.pacman.pontos.PontosController;
import com.unicamp.mc322.pacman.pontos.PowerUp;
import com.unicamp.mc322.pacman.pontos.PowerUpController;
import com.unicamp.mc322.pacman.posicionamento.ParOrdenado;
import com.unicamp.mc322.pacman.posicionamento.Quadrado;
import com.unicamp.mc322.parede.Parede;
import com.unicamp.mc322.parede.ParedeController;

public class Mapa {
	
	private Integer altura;
	private Integer largura;
	
	private Character[][] mapa;
	private final String pathParede = "src/sprites/wall/parede.png";
	private final String pathComidaPacman = "src/sprites/food/comida.png";
	private final String pathPowerUpPacman = "src/sprites/food/powerup.png";
	private final String pathMapa = "src/map/randMap/mapa.txt";
	private final Integer qtdMapsDefault = 2;
	
	
	public Mapa(Integer altura, Integer largura) {
		this.altura = altura;
		this.largura = largura;
		mapa = new Character[altura*16][largura*16];
	}
	
	/*
	public void desenhaMapa(Graphics g,PontosController Controller) {
		Imagem imagemParede = new Imagem(pathParede, new ParOrdenado(0,0), new Quadrado(0, 0, 1, 1));
		Pontos p;
	}
	*/
	
	public void inicializaConteudoMapa(PontosController pController,PowerUpController pwController, ParedeController wController) {
		Parede w;
		Pontos p;
		PowerUp g;
		for (int i = 0; i < this.largura; i++) {
			for (int j = 0; j < altura; j++) {
				if (mapa[i][j].equals(ComponentesMapa.PAREDE.getValor())) {
					w = new Parede(new Quadrado(i*16, j*16, (i+1)*16, (j+1)*16),pathParede, new ParOrdenado(i*16,j*16));
					wController.adicionarParede(w);
				} else if (mapa[i][j].equals(ComponentesMapa.COMIDA.getValor())) {
					p = new Pontos(new Quadrado(i*16, j*16, (i+1)*16, (j+1)*16),pathComidaPacman, new ParOrdenado(i*16,j*16));
					pController.adicionarPonto(p);
				} else if (mapa[i][j].equals(ComponentesMapa.POWERUP.getValor())) {
					 g = new PowerUp(new Quadrado(i*16, j*16, (i+1)*16, (j+1)*16),pathPowerUpPacman, new ParOrdenado(i*16,j*16));
					pwController.adicionarPonto(g);
				}
			}
 		}
	}
	
	public void leMapa(String arquivo) throws Exception{
		File file = new File(arquivo);
		FileReader reader = new FileReader(file);
		BufferedReader buff = new BufferedReader(reader);
		String line = null;
		altura = 0;
		line = buff.readLine();
		for (int i = 0; Objects.nonNull(line); i++) {
			altura++;
			for(int j = 0; j < line.length();j++) {
				mapa[j][i] = line.charAt(j);
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
		return (j == 100 && i == 100);
	}
	
	private boolean powerupDefault(int j, int i) {
		return ((j == 1 && i == 1) || (j == 1 && i == 30));
	}
	
	private void colocarParedeL(int i, int j) {
		if (mapa[i][j]!=ComponentesMapa.PAREDE.getValor()) {
			Random num = new Random();
			int sentido = num.nextInt(4);
			if (sentido == 0) {
				if (j < altura-1) {
					mapa[i][j] = ComponentesMapa.PAREDE.getValor();
					mapa[i][j+1] = ComponentesMapa.PAREDE.getValor();
//					mapa[i][j+2] = ComponentesMapa.PAREDE.getValor();
					mapa[i+1][j] = ComponentesMapa.PAREDE.getValor();
//					mapa[i+2][j] = ComponentesMapa.PAREDE.getValor();
				}else
					colocarParedeL(i, j);
			}else if(sentido == 1) {
				if (j < altura-1) {
					mapa[i][j] = ComponentesMapa.PAREDE.getValor();
					mapa[i][j+1] = ComponentesMapa.PAREDE.getValor();
//					mapa[i][j+2] = ComponentesMapa.PAREDE.getValor();
					mapa[i+1][j+1] = ComponentesMapa.PAREDE.getValor();
//					mapa[i+2][j+2] = ComponentesMapa.PAREDE.getValor();
				}else
					colocarParedeL(i, j);
			} else if (sentido== 2) {
				if (i>0) {
					mapa[i][j] = ComponentesMapa.PAREDE.getValor();
					mapa[i][j+1] = ComponentesMapa.PAREDE.getValor();
//					mapa[i][j+2] = ComponentesMapa.PAREDE.getValor();
					mapa[i-1][j+1] = ComponentesMapa.PAREDE.getValor();
//					mapa[i-2][j+2] = ComponentesMapa.PAREDE.getValor();
				}else
					colocarParedeL(i, j);
			} else if (sentido== 2) {
				if (j>0) {
					mapa[i][j] = ComponentesMapa.PAREDE.getValor();
					mapa[i][j-1] = ComponentesMapa.PAREDE.getValor();
//					mapa[i][j-2] = ComponentesMapa.PAREDE.getValor();
					mapa[i+1][j] = ComponentesMapa.PAREDE.getValor();
//					mapa[i+2][j] = ComponentesMapa.PAREDE.getValor();
				}else
					colocarParedeL(i, j);
			}
			else {
				mapa[i][j] = ComponentesMapa.COMIDA.getValor();
			}
		}
	}
	
	public void getMapaAleatorio() throws Exception{
		for (int i = 0; i < altura/2;i++) {
			for (int j = 0; j< largura; j++) {
				if (inicioFantasma(i, j) || inicioPacman(i,j))
					mapa[i][j] = ComponentesMapa.VAZIO.getValor();
				else if (paredeDefault(i,j)) 
					mapa[i][j] = ComponentesMapa.PAREDE.getValor();
				else if (powerupDefault(i,j))
					mapa[i][j] = ComponentesMapa.POWERUP.getValor();
				else {
					Random num =  new Random();
					if (num.nextInt(100) < 90  && mapa[i][j] != ComponentesMapa.PAREDE.getValor())
						mapa[i][j] = ComponentesMapa.COMIDA.getValor();
					else
						colocarParedeL(i, j);
				}
					
			}
		}
		
		for (int i = altura-1,k=0; i >= altura/2;i--,k++) {
			for (int j = 0; j< largura; j++) {
				mapa[i][j] = mapa[k][j];
			}
		}
		
		salvaMapaArquivo(pathMapa);
	}
	
	public void getMapaArquivo() throws Exception {
		String arq = "src/map/defaults/mapa"+((new Random()).nextInt(qtdMapsDefault) + 1) + ".txt";
		leMapa(arq);
	}
	
	public void salvaMapaArquivo(String arquivo) throws Exception {

		File file = new File(arquivo);
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
