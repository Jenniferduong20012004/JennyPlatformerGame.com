package ui;

import java.awt.*;

public abstract class PauseButton implements Buttons{
    protected int x,y,width, height;
    protected Rectangle bounds;
    public PauseButton(int x, int y, int width, int height){
        this.x = x;
        this. y = y;
        this.width = width;
        this.height = height;
        createBounds();
    }

    private void createBounds() { bounds = new Rectangle(x,y,width, height);}

    @Override
    public void loadImgs() {

    }

    @Override
    public void draw(Graphics g) {

    }

    @Override
    public void update() {

    }

    @Override
    public void initBound() {

    }
}
