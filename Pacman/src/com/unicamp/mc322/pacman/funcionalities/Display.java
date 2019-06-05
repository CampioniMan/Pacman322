package com.unicamp.mc322.pacman.funcionalities;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.unicamp.mc322.pacman.Game;

public class Display {
    private JFrame jframe;
    public static JPanel panel;
    private String title;
    private int width, height;
    Game game;

    public Display(String tuade, int rong, int dai, Game game) {
        this.title = tuade;
        this.width = dai;
        this.height = rong;
        this.game = game;
        initCanvas();
    }

    private void initCanvas() {
    	
        jframe = new JFrame(title);
        jframe.setSize(width, height);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setResizable(false);
        jframe.setVisible(true);
        jframe.setLocationRelativeTo(null);

        panel = new JPanel() {
        	
        	@Override
        	public void paint(Graphics g) {
        		super.paint(g);
        		game.render(g);
        	}
        };
        
        panel.setPreferredSize(new Dimension(width, height));

        jframe.add(panel);
        jframe.pack();

    }
}