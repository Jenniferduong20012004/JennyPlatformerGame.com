package Gamestates;

import Main.Game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class GameOver extends States implements Gamestates{
    private Playing playing;
    public GameOver(Game game, Playing playing) {
        super(game);
        this.playing =playing;
    }

    @Override
    public void resetDirBoolean() {

    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {

    }

    @Override
    public void Mouseclick(MouseEvent e) {

    }

    @Override
    public void MouseRelease(MouseEvent e) {

    }

    @Override
    public void MouseMove(MouseEvent e) {

    }

    @Override
    public void KeyPress(KeyEvent e) {
        if (e.getKeyCode()== KeyEvent.VK_ESCAPE){
            playing.resetAll();
            game.setState(new Menu(game));
        }
    }

    @Override
    public void KeyRealease(KeyEvent e) {

    }

    @Override
    public void mouseDrag(MouseEvent e) {

    }
}
