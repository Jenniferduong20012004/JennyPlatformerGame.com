package Inputs;

import Main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class KeyboardInputs implements KeyListener {
    private GamePanel gamePanel;
    public KeyboardInputs(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {gamePanel.getGame().getState().KeyPress(e);}

    @Override
    public void keyReleased(KeyEvent e) {
        gamePanel.getGame().getState().KeyRealease(e);
    }
}
