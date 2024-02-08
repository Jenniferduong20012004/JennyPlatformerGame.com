package Inputs;

import Main.GamePanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInputs implements MouseListener, MouseMotionListener {
    private GamePanel gamePanel;
    public MouseInputs(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }
    @Override
    public void mouseClicked(MouseEvent e) {gamePanel.getGame().getState().Mouseclick(e);}
    @Override
    public void mousePressed(MouseEvent e) {gamePanel.getGame().getState().Mouseclick(e);}
    @Override
    public void mouseReleased(MouseEvent e) {
        gamePanel.getGame().getState().MouseRealease(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        gamePanel.getGame().getState().MouseMove(e);
    }
}
