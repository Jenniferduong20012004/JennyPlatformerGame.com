package ui;

import Gamestates.Gamestates;
import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

import static utilz.Constant.UI.Buttons.*;

public abstract class MenuButton implements Buttons{
    protected int xPos, yPos, rowIndex, index;
    protected BufferedImage imgs[], temp;
    protected boolean mouseOver, mouseClick;
    protected Rectangle bound;
    protected int xOffsetCenter = B_WIDTH/2;
    public MenuButton (int xPos, int yPos, int rowIndex){
        this.xPos= xPos;
        this.yPos= xPos;
        this.rowIndex = rowIndex;
        loadImgs();
        initBound();
    }
    @Override
    public void initBound(){
        bound = new Rectangle(xPos-xOffsetCenter, yPos, B_WIDTH, B_HEIGHT);
    }
    @Override
    public void loadImgs() {
        imgs = new BufferedImage [3];
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(imgs[index],xPos-xOffsetCenter, yPos,B_WIDTH, B_HEIGHT, null);}

    @Override
    public void update() {
        index =0;
        if (mouseOver){
            index = 1;
        }
        if (mouseClick){
            index =2;
        }
    }
    public void setMouseOver (boolean mouseOver){
        this.mouseOver = mouseOver;
    }
    public void setMouseClick(boolean mouseClick){
        this.mouseClick = mouseClick;
    }
    public boolean getMouseOver (){return mouseOver;}
    public boolean getMouseClick (){return mouseClick;}
    public void resetBools(){
        mouseOver= false;
        mouseClick = true;
    }
    public Rectangle getBounds(){
        return bound;
    }
}
