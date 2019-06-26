package com.unicamp.mc322.pacman.funcionalities;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Objects;

public class ControleBotao {
    private static HashMap<Integer, Boolean> keyPressed = new HashMap<>();
    private KeyAdapter keyAdapter;
    
	public KeyAdapter getKeyAdapter() {
		if(Objects.isNull(this.keyAdapter)) {
			keyAdapter = new KeyAdapter() {
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
	      };
		}
		return keyAdapter;
	}
	

	

	public static boolean isKeyPressed(Integer keyCode) {
		return Objects.nonNull(keyPressed.get(keyCode))?keyPressed.get(keyCode):false;
	}
	
}
