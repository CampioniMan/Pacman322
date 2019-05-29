package com.unicamp.mc322.mapa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Objects;

public class Mapa {
	
	private Double altura;
	private Double largura;
	private Character[][] mapa;
	
	
	public Mapa(Double altura, Double largura) {
		this.altura = altura;
		this.largura = largura;
	}
	
	public void leMapa() throws Exception{
		File file = new File("arquivo.txt");
		FileReader reader = new FileReader(file);
		BufferedReader buff = new BufferedReader(reader);
		String line = null;
		altura = .0;
		line = buff.readLine();
		for (int j = 0; Objects.nonNull(line); j++) {
			for(int i = 0; i < line.length();i++) {
				mapa[j][i] = line.charAt(i);
			}
		} 
	
		buff.close();
		reader.close();
	}
	public void geraMapa() throws Exception {
		File file = new File("arquivo.txt");
		FileWriter writer = new FileWriter(file) ;
		BufferedWriter buff = new BufferedWriter(writer);
		System.out.print(file.getAbsolutePath());
		for (int i = 0; i < altura;i++) {
			for (int j = 0; j< largura; j++) {
				buff.write("#");
			}
			buff.write("\n");
		}
		buff.close();
		writer.close();
	}
	public Double getAltura() {
		return altura;
	}
	public void setAltura(Double altura) {
		this.altura = altura;
	}
	public Double getLargura() {
		return largura;
	}
	public void setLargura(Double largura) {
		this.largura = largura;
	}
	
	

}
