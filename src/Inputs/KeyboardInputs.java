package Inputs;

import Main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static utilz.Constant.Directions.*;
import entities.Player;

public class KeyboardInputs implements KeyListener {
    private GamePanel gamePanel;
    public KeyboardInputs(GamePanel gamePanel){
        this. gamePanel = gamePanel;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                gamePanel.getGame().getPlayer().setDirection(UP);
                break;
            case KeyEvent.VK_DOWN:
                gamePanel.getGame().getPlayer().setDirection(DOWN);
                break;
            case KeyEvent.VK_LEFT:
                gamePanel.getGame().getPlayer().setDirection(LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                gamePanel.getGame().getPlayer().setDirection(RIGHT);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_RIGHT:
                gamePanel.getGame().getPlayer().setMoving(false);
                break;
        }
    }
}
