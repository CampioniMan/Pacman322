package com.unicamp.mc322.pacman;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.util.HashMap;

import com.unicamp.mc322.pacman.funcionalities.*;
import com.unicamp.mc322.pacman.posicionamento.ParOrdenado;
import com.unicamp.mc322.pacman.posicionamento.Quadrado;

public class Game implements Runnable {
	private Display display;
    private boolean running;
    private Graphics g;
    private Thread t;
    
    private final int tamanhoTela = 512;
    private final String pathProPlanoDeFundo = "/home/cc2018-ceb/ra214777/Downloads/7b000e9a5060837b7e018c42bf166486e66ed44cr1-1150-2048v2_128.jpg";
    private HashMap<Integer, Boolean> keyPressed = new HashMap<>();
    
    Imagem planoDeFundo;
    
    public synchronized void start() {
        if (running) {
        	return;
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
            render();
        }
        stop();
    }
	
	private void render() {
	    BufferStrategy bs = display.getCanvas().getBufferStrategy();

        if (bs == null) {
            System.out.println("bs is null....");
            display.getCanvas().createBufferStrategy(3);

            return;
        }


        g = display.getCanvas().getGraphics();
        display.getCanvas().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                keyPressed.put(e.getKeyCode(), true);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                keyPressed.put(e.getKeyCode(), false);
            }
        });
        planoDeFundo.draw(g);
    }
	
	private void tick() {
    	try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			System.err.println("Erro no sleep maroto");
			e.printStackTrace();
		}
    }
	
	private void init() {
		planoDeFundo = new Imagem(pathProPlanoDeFundo, new ParOrdenado(0,0), new Quadrado(new ParOrdenado(0f, 0f),
				new ParOrdenado(16f, 16f)));
        display = new Display("draw image", tamanhoTela, tamanhoTela);
    }
}
