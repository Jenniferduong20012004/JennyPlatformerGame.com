package Gamestates;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public interface Gamestates {
    public void resetDirBoolean();
    public void update();
    public void render(Graphics g);
    public void Mouseclick(MouseEvent e);
    public void MouseRelease(MouseEvent e);
    public void MouseMove(MouseEvent e);
    public void KeyPress(KeyEvent e);
    public void KeyRealease(KeyEvent e);
    public void mouseDrag (MouseEvent e);
}
