package ui;

import Gamestates.Gamestates;
import utilz.Constant;
import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MenuButton implements Buttons{
    private int xPos, yPos, rowIndex, index;
    private Gamestates state;
    private BufferedImage[] imgs;
    private boolean mouseOver, mouseClick;
    public MenuButton (int xPos, int yPos, int rowIndex, Gamestates state){
        this.xPos= xPos;
        this.yPos= xPos;
        this.rowIndex = rowIndex;
        this.state = state;
        loadImgs();
    }
    @Override
    public void loadImgs() {
        imgs = new BufferedImage[3];
        BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.BUTTONS_ATLAS);
        for (int i =0; i < imgs.length; i++){
            imgs [i] = temp.getSubimage(i* Constant.UI.Buttons.B_WIDTH_DEFAULT, rowIndex*Constant.UI.Buttons.B_HEIGHT_DEFAULT,Constant.UI.Buttons.B_WIDTH_DEFAULT, Constant.UI.Buttons.B_HEIGHT_DEFAULT);

        }
    }

    @Override
    public void draw(Graphics g) {

    }

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
}
