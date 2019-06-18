package com.unicamp.mc322.pacman;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.util.HashMap;

import com.unicamp.mc322.mapa.Mapa;
import com.unicamp.mc322.pacman.funcionalities.*;
import com.unicamp.mc322.pacman.posicionamento.ParOrdenado;
import com.unicamp.mc322.pacman.posicionamento.Quadrado;

public class Game implements Runnable {
	private Display display;
    private boolean running;
    private Thread t;
    
    private final int tamanhoTela = 512;
    private final String pathProPlanoDeFundo = "/home/cc2018-ceb/ra214777/Downloads/7b000e9a5060837b7e018c42bf166486e66ed44cr1-1150-2048v2_128.jpg";
    private ControleBotao controleBotao = new ControleBotao();
    Imagem planoDeFundo;
    private Mapa mapa = new Mapa(32,32);
    
    public synchronized void start() {
        if (running) {
        	return;
        }
        
        try {
        //	mapa.getMapaAleatorio();
        	mapa.getMapaArquivo();
        } catch (Exception e) {
			// TODO: handle exception
		}
        
        running = true;
        
        t = new Thread(this);
        t.start();
    }

    public synchronized void stop() {
        if (!running) {
            return;
        }
        
        running = false;
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
	
	@Override
    public void run() {
        init();
        while (running) {
        	tick();
        	display.panel.repaint();
        }
        stop();
    }
	
	public void render(Graphics g) {		
		
        planoDeFundo.draw(g);
        mapa.desenhaMapa(g);
        
        display.panel.addKeyListener(controleBotao.getKeyAdapter());  
        display.panel.setFocusable(true);
        display.panel.requestFocusInWindow();
        System.out.println(controleBotao.isKeyPressed(65));
    }
	
	private void tick() {
    	try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			System.err.println("Erro no sleep maroto");
			e.printStackTrace();
		}
    }
	
	private void init() {
		planoDeFundo = new Imagem(pathProPlanoDeFundo, new ParOrdenado(0,0), new Quadrado(0, 0, 16, 16));
        display = new Display("draw image", tamanhoTela, tamanhoTela, this);
    }
}
