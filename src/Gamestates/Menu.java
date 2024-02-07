package Gamestates;

import Main.Game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Menu extends States implements Gamestates {
    public Menu(Game game) {
        super(game);
    }

    @Override
    public void resetDirBoolean() {
        return;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.drawRect (200,200,100,100);
    }

    @Override
    public void Mouseclick(MouseEvent e) {
    }

    @Override
    public void MouseRealease(MouseEvent e) {

    }

    @Override
    public void MouseMove(MouseEvent e) {

    }

    @Override
    public void KeyPress(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_0){
            game.setState(new Playing(game));
        }
    }

    @Override
    public void KeyRealease(KeyEvent e) {

    }
}
