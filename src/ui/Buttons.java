package ui;
import Gamestates.Gamestates;

import java.awt.*;

public interface Buttons {
    public abstract void loadImgs();
    public abstract void draw (Graphics g);
    public abstract void update();
    public abstract void initBound();
}
