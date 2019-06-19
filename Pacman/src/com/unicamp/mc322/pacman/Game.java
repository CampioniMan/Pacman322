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
import com.unicamp.mc322.pacman.personagem.fantasma.FantasmaAleatorio;
import com.unicamp.mc322.pacman.pontos.PontosController;
import com.unicamp.mc322.pacman.pontos.PowerUpController;
import com.unicamp.mc322.pacman.posicionamento.ParOrdenado;
import com.unicamp.mc322.pacman.posicionamento.Quadrado;
import com.unicamp.mc322.parede.ParedeController;

public class Game implements Runnable {
	private Display display;
    private boolean running;
    private Thread t;
    private int placar = 0;
    private PontosController pontosController;
    private ParedeController paredeController;
    private PowerUpController powerupController;
    private final int tamanhoTela = 512;
    private final String pathProPlanoDeFundo = "src/sprites/background/background.jpg";
    private ControleBotao controleBotao;	
    Imagem planoDeFundo;
    private Mapa mapa = new Mapa(32,32);
    private FantasmaAleatorio fantasmaAleatorio;
    private boolean hasFinishedInit = false;
    
    
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
        	if (!hasFinishedInit) continue;
        	tick();
        	display.panel.repaint();
        }
        stop();
    }
	
	public void render(Graphics g) {
		display.panel.addKeyListener(controleBotao.getKeyAdapter());  
        display.panel.setFocusable(true);
        display.panel.requestFocusInWindow();
        planoDeFundo.draw(g);
        //mapa.desenhaMapa(g, pontosController);
        pontosController.desenhaPontos(g);
        paredeController.desenhaParede(g);
        powerupController.desenhaPowerUp(g);
        fantasmaAleatorio.calculaPosicaoNova(paredeController);
        fantasmaAleatorio.draw(g);
        
    }
	
	private void tick() {
    	try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			System.err.println("Erro no sleep maroto");
			e.printStackTrace();
		}
    }
	
	private void init() {
		planoDeFundo = new Imagem(pathProPlanoDeFundo, new ParOrdenado(0,0), new Quadrado(0, 0, 512, 512));
        
        fantasmaAleatorio = new FantasmaAleatorio(new Quadrado(16*16, 16*16,17*16,17*16));
        paredeController = new ParedeController();
        pontosController = new PontosController();
        powerupController = new PowerUpController();
        controleBotao = new ControleBotao();
        
        try {
        	mapa.getMapaAleatorio();
//        	mapa.getMapaArquivo();
        	mapa.inicializaConteudoMapa(pontosController,powerupController, paredeController);
        } catch (Exception e) {
			// TODO: handle exception
		}
        hasFinishedInit = true;
        display = new Display("PACMAN322", tamanhoTela, tamanhoTela, this);
    }
}
