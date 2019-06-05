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
import com.unicamp.mc322.pacman.posicionamento.Ponto;

public class Game implements Runnable {
	private Display display;
    private boolean running;
    private Thread t;
    
    private final int tamanhoTela = 512;
    private final String pathProPlanoDeFundo = "/home/cc2018-ceb/ra214777/Downloads/7b000e9a5060837b7e018c42bf166486e66ed44cr1-1150-2048v2_128.jpg";
    private HashMap<Integer, Boolean> keyPressed = new HashMap<>();
    
    Imagem planoDeFundo;
    private Mapa mapa = new Mapa(32,32);
    
    public synchronized void start() {
        if (running) {
        	return;
        }
        
        try {
        	mapa.geraMapa();
        	mapa.leMapa();
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
//        display.getCanvas().addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//                super.keyTyped(e);
//            }
//
//            @Override
//            public void keyPressed(KeyEvent e) {
//                super.keyPressed(e);
//                keyPressed.put(e.getKeyCode(), true);
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//                keyPressed.put(e.getKeyCode(), false);
//            }
//        });
        
        planoDeFundo.draw(g);
        mapa.desenhaMapa(g);
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
		planoDeFundo = new Imagem(pathProPlanoDeFundo, new Ponto(0,0), new Ponto(6.25f,6.25f));
        display = new Display("draw image", tamanhoTela, tamanhoTela, this);
    }
}
