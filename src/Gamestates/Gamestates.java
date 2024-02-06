package Gamestates;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public interface Gamestates {
    public void update();
    public void draw(Graphics g);
    public void Mouseclick(MouseEvent e);
    public void MouseRealease(MouseEvent e);
    public void MouseMove(MouseEvent e);
    public void KeyPress(KeyEvent e);
    public void KeyRealease(KeyEvent e);
}
